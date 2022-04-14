package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R.*

class MainActivity() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val btMatiere: Button = findViewById(id.btMatiere)
        btMatiere.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MatiereActivity::class.java)
            startActivity(intent)
        }

        val btCreate: Button = findViewById(id.btCreate)
        btCreate.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, CreateActivity::class.java)
            startActivity(intent)
        }

        val btListe: Button = findViewById(id.btListe)
        btListe.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, ListeActivity::class.java)
            startActivity(intent)
        }

        val btExit: Button = findViewById(id.btExit)
        btExit.setOnClickListener {
            android.os.Process.killProcess(android.os.Process.myPid())
        }

    }
}