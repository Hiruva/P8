package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MatiereActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matiere)
        val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)

        val btAjouter: Button = findViewById(R.id.buttonAjouter)
        btAjouter.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, AjouterMatiereActivity::class.java)
            startActivity(intent)
        }

        val btSupprimer: Button = findViewById(R.id.buttonSupprimer)
        btSupprimer.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SupprimerMatiereActivity::class.java)
            startActivity(intent)
        }

        val btAct: Button = findViewById(R.id.buttonActualiser)
        btAct.setOnClickListener {
            val listView = findViewById<ListView>(R.id.listview1)

            val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)
            val matieres = mySQLiteOpenHelper.queryMatiere()

            val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, matieres)
            listView.adapter = arrayAdapter
        }

    }
}