package com.example.workoutapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import kotlin.coroutines.coroutineContext

abstract class sqlitehelper(context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "workoutapp.db"
        const val TABLENAME="HISTORYTABLE"
        const val COLLUMNID="_id"
        const val BMIVALUE="BMIVALUE"
        const val CALCULATEDDATE="date"
        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLENAME}"
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${TABLENAME} (" +
                    "${BMIVALUE} TEXT," +
                    "${CALCULATEDDATE} TEXT)"
    }


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    fun insert(x:bmidataclass) {

        val db=this.writableDatabase
        val cv=ContentValues()

        cv.put(BMIVALUE,x.bmivalue)
        cv.put(CALCULATEDDATE,x.date)

        db.insert(TABLENAME,null,cv)

        db.close()



    }


}