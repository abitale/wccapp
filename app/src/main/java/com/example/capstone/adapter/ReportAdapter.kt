package com.example.capstone.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import com.example.capstone.databinding.ItemReportBinding
import com.example.capstone.entity.Report

class ReportAdapter(private val activity: Activity?) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>()  {

    private lateinit var onClickListener: OnClickListener

    var listReports = ArrayList<Report>()
        set(listReports) {
            if (listReports.size > 0) {
                this.listReports.clear()
            }
            this.listReports.addAll(listReports)
            notifyDataSetChanged()
        }

    fun addItem(report: Report) {
        this.listReports.add(report)
        notifyItemInserted(this.listReports.size-1)
    }

    fun updateItem(position: Int, report: Report) {
        this.listReports[position] = report
        notifyItemChanged(position, report)
    }

    fun removeItem(position: Int){
        this.listReports.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, this.listReports.size)
    }

    interface OnClickListener {
        fun onItemClicked(user: Report)
    }

    class ReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemReportBinding.bind(itemView)
        fun bind(report: Report) {
            binding.priorityBox.text = report.priority.toString()
            binding.assign.text = report.assign
            binding.titleBox.text = report.title
            binding.reportedBox.text = report.reporter
            binding.reportedAtBox.text = report.date

        }

    }


    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ReportAdapter.ReportViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_report, viewGroup, false)
        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportAdapter.ReportViewHolder, position: Int) {
        holder.bind(listReports[position])
    }

    override fun getItemCount(): Int = this.listReports.size
}