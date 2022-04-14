package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        var module: String = ""
        var date: String = ""
        var prof: String = ""
        var note: String = ""

        val mySQLiteOpenHelper: MySQLiteOpenHelper = MySQLiteOpenHelper(this)
        val matieres = mySQLiteOpenHelper.queryMatiereName()

        val spinner: Spinner = findViewById(R.id.spinner7)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, matieres)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                module = matieres[p2]
                Toast.makeText(applicationContext, module, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        val calendarView: CalendarView = findViewById(R.id.calendarView)
        calendarView.setOnDateChangeListener { calendarView, i, i2, i3 ->
            var annee = i
            var mois = i2 + 1
            var jour = i3
            date = "$jour-$mois-$annee"
            Toast.makeText(this, date, Toast.LENGTH_SHORT).show()
        }

        val btAjouterExam: Button = findViewById(R.id.buttonAjouterExam)
        btAjouterExam.setOnClickListener{
            val textProf: EditText = findViewById(R.id.Prof)
            val textNote: EditText = findViewById(R.id.Note)
            prof = textProf.text.toString()
            note = textNote.text.toString()

            val rowId:Long = mySQLiteOpenHelper.insertExam(module, date, prof, note)
            if(rowId != (-1).toLong()){
                Toast.makeText(this, "insert réussite", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "insert false", Toast.LENGTH_SHORT).show()
            }
        }

        val btSupprimerExam: Button = findViewById(R.id.buttonSupprimerExam)
        btSupprimerExam.setOnClickListener{
            val row:Int = mySQLiteOpenHelper.deleteExam(module)
            if(row > 0){
                Toast.makeText(this, "supprimer réussite", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "supprimer false", Toast.LENGTH_SHORT).show()
            }
        }

    }
}


