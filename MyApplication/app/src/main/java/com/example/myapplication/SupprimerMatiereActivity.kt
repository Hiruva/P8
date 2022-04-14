package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SupprimerMatiereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supprimer_matiere)

        val btSupprimer: Button = findViewById(R.id.buttonSupprimer1)
        btSupprimer.setOnClickListener {

            val txtName:EditText = findViewById(R.id.supprimerName)
            val name = txtName.text.toString()

            val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)
            val row:Int = mySQLiteOpenHelper.deleteMatiere(name)
            if(row > 0){
                Toast.makeText(this, "supprimer réussite", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "supprimer false", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent()
            intent.setClass(this, MatiereActivity::class.java)
            startActivity(intent)
        }
    }
}