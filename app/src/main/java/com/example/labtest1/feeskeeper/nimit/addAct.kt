package com.example.labtest1.feeskeeper.nimit

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class addAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        title = "add Details"

        var  Name = findViewById(R.id.username) as EditText

        var  Fees = findViewById(R.id.fee) as EditText

        var  Age = findViewById(R.id.age) as EditText

        val datePicker = findViewById<DatePicker>(R.id.datePicker1)




        var  date = findViewById(R.id.date) as EditText

        var add = findViewById(R.id.add) as Button



        date.setOnClickListener{

            val today = Calendar.getInstance()
            datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)

            ) { view, year, month, day ->
                val month = month + 1
                val msg = "$day/$month/$year"
                System.out.println(msg)
                date.setText(msg)
                this.setVisible(false)
            }
        }


        add.setOnClickListener{


        }



    }


    }








