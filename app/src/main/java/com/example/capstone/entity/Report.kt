package com.example.capstone.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Report (
    var id: Int,
    var assign: String = "Unassigned",
    var title: String,
    var reporter: String,
    var priority: Int,
    var date: String
    ) : Parcelable