package com.example.capstone.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion.TABLE_NAME
import com.example.capstone.db.DatabaseContract.ReportColumns.Companion._ID
import java.sql.SQLException

class ReportsHelper(context: Context) {
    private var dataBaseHelper: DatabaseHelper = DatabaseHelper(context)
    private lateinit var database: SQLiteDatabase

    companion object {
        private const val DATABASE_TABLE = TABLE_NAME

        private var INSTANCE: ReportsHelper? = null
        fun getInstance(context: Context): ReportsHelper =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ReportsHelper(context)
            }
    }

    @Throws(SQLException::class)
    fun open() {
        database = dataBaseHelper.writableDatabase
    }

    fun close() {
        dataBaseHelper.close()

        if (database.isOpen)
            database.close()
    }

    fun queryAll(): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            null,
            null,
            null,
            null,
            "$_ID ASC"
        )
    }

    fun queryById(id: String): Cursor {
        return database.query(
            DATABASE_TABLE,
            null,
            "$_ID = ?",
            arrayOf(id),
            null,
            null,
            null,
            null
        )
    }

    fun insert(values: ContentValues?): Long {
        return database.insert(DATABASE_TABLE, null, values)
    }

    fun update(id: String, values: ContentValues?): Int {
        return database.update(DATABASE_TABLE,values, "$_ID = ?", arrayOf(id))
    }

    fun deleteById(id:String): Int {
        return database.delete(DATABASE_TABLE, "$_ID = '$id'", null)
    }
}