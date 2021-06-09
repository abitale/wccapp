package com.example.capstone.control

import androidx.lifecycle.ViewModel
import com.example.capstone.entity.Report

class MainViewModel : ViewModel() {

    fun getList(): List<Report>{
        return DataDummy.generateDummyReports()
    }
}