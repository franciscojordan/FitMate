package com.example.fitmate.database;

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DatabaseAPP(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    private val createUsersTable = "CREATE TABLE Users" +
                                    "(ID INT PRIMARY KEY," +
                                    "USERNAME TEXT," +
                                    "PASSWORD TEXT)"
    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}
