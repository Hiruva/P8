package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AjouterMatiereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_matiere)

        val btAjouter: Button = findViewById(R.id.buttonAjouter1)
        btAjouter.setOnClickListener {
            val txtName:EditText = findViewById(R.id.ajouterName)
            val txtCoef:EditText = findViewById(R.id.ajouterCoef)
            val name = txtName.text.toString()
            val coef = txtCoef.text.toString()

            val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)
            val rowId:Long = mySQLiteOpenHelper.insertMatiere(name, coef)
            if(rowId != (-1).toLong()){
                Toast.makeText(this, "insert réussite", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "insert false", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent()
            intent.setClass(this, MatiereActivity::class.java)
            startActivity(intent)
        }
    }
}