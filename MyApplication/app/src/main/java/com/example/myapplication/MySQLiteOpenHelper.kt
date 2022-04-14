package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, "mySQLite.db", null, 1){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("create table matiere (id integer primary key autoincrement, name text, coef text);");
        db.execSQL("create table exam (id integer primary key autoincrement, name text, date text, professeur text, note text);");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertMatiere(name: String, coef: String): Long {
        val db:SQLiteDatabase = writableDatabase

        val values: ContentValues = ContentValues()
        values.put("name", name)
        values.put("coef", coef)

        return db.insert("matiere", null, values)
    }

    fun deleteMatiere(name: String): Int {
        val db:SQLiteDatabase = writableDatabase

        return db.delete("matiere", "name like ?", arrayOf(name))
    }

    fun queryMatiere(): MutableList<String> {
        val db:SQLiteDatabase = writableDatabase

        val cursor:Cursor = db.query("matiere", null, null, null, null, null, null,)

        val matieres = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow("name"))
                val coef = getString(getColumnIndexOrThrow("coef"))
                matieres.add("matière: $name\ncoef: $coef")
            }
        }
        return matieres
        cursor.close()
    }

    fun queryMatiereName(): MutableList<String> {
        val db:SQLiteDatabase = writableDatabase

        val cursor:Cursor = db.query("matiere", null, null, null, null, null, null,)

        val matieres = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow("name"))
                matieres.add("$name")
            }
        }
        return matieres
        cursor.close()
    }

    fun insertExam(name: String, date: String, professeur: String, note: String): Long {
        val db:SQLiteDatabase = writableDatabase

        val values: ContentValues = ContentValues()
        values.put("name", name)
        values.put("date", date)
        values.put("professeur", professeur)
        values.put("note", note)

        return db.insert("exam", null, values)
    }

    fun deleteExam(name: String): Int {
        val db:SQLiteDatabase = writableDatabase

        return db.delete("exam", "name like ?", arrayOf(name))
    }

    fun queryExam(): MutableList<String>{
        val db:SQLiteDatabase = writableDatabase

        val cursor:Cursor = db.query("exam", null, null, null, null, null, null,)

        val exam = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val name = getString(getColumnIndexOrThrow("name"))
                val date = getString(getColumnIndexOrThrow("date"))
                val professeur = getString(getColumnIndexOrThrow("professeur"))
                val note = getString(getColumnIndexOrThrow("note"))
                exam.add("module: $name\ndate: $date\nprofesseur: $professeur\nnote: $note")
            }
        }
        return exam
        cursor.close()
    }

}