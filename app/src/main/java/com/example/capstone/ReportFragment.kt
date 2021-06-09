package com.example.capstone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstone.adapter.RecyclerAdapter
import com.example.capstone.adapter.ReportAdapter
import com.example.capstone.control.MainViewModel
import com.example.capstone.databinding.FragmentReportBinding
import com.example.capstone.entity.Report

class ReportFragment : Fragment() {

    private var binding: FragmentReportBinding? = null
    private var listReport: ArrayList<Report> = arrayListOf()
    private lateinit var adapter: RecyclerAdapter
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentReportBinding.bind(view)

        adapter = RecyclerAdapter(listReport)
        adapter.notifyDataSetChanged()

        binding?.recyclerview?.layoutManager = LinearLayoutManager(activity)
        binding?.recyclerview?.adapter = adapter

        viewModel = ViewModelProvider(
            this,
        ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        val list = viewModel.getList()
        adapter.setData(list)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReportBinding.inflate(inflater,container,false)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}