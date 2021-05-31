package com.example.capstone.db

import android.provider.BaseColumns

internal class DatabaseContract {
    internal class ReportColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "reports"
            const val _ID = "_id"
            const val ASSIGN = "assign"
            const val TITLE = "title"
            const val REPORTER = "reporter"
            const val PRIORITY = "priority"
            const val DATE = "date"
        }
    }
}