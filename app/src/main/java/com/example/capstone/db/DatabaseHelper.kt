package com.example.capstone.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.ASSIGN
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.DATE
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.PRIORITY
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.REPORTER
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.TABLE_NAME
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.TITLE
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion._ID

internal class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "wccapp"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_TABLE_REPORTS = "CREATE TABLE $TABLE_NAME" +
                " (${_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                " (${ASSIGN} TEXT NOT NULL,"+
                " (${TITLE} TEXT NOT NULL," +
                " (${REPORTER} TEXT NOT NULL," +
                " (${PRIORITY} INTEGER NOT NULL," +
                " (${DATE} TEXT NOT NULL)"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_TABLE_REPORTS)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}