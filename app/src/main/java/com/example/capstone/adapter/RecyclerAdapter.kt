package com.example.capstone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.R
import com.example.capstone.databinding.ItemReportBinding
import com.example.capstone.entity.Report

class RecyclerAdapter(private val listItem: ArrayList<Report>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>()  {

    fun setData(items: ArrayList<Report>) {
        listItem.clear()
        listItem.addAll(items)
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onItemClicked(user: Report)
    }

    private lateinit var onClickListener: OnClickListener

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    class RecyclerViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemReportBinding.bind(itemView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerAdapter.RecyclerViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_report, viewGroup, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder, position: Int) {
        val item = listItem[position]

        holder.binding.priorityBox.text = item.priority.toString()
        holder.binding.assign.text = item.assign
        holder.binding.titleBox.text = item.title
        holder.binding.reportedBox.text = item.reporter
        holder.binding.reportedAtBox.text = item.date

        holder.itemView.setOnClickListener {
            onClickListener.onItemClicked(listItem[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listItem.size
}