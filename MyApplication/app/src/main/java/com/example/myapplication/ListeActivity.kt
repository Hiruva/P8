package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class ListeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)

        val btAct1: Button = findViewById(R.id.buttonAct)
        btAct1.setOnClickListener{
            val listView = findViewById<ListView>(R.id.listExam)

            val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)
            val exam = mySQLiteOpenHelper.queryExam()

            val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, exam)
            listView.adapter = arrayAdapter
        }

    }
}