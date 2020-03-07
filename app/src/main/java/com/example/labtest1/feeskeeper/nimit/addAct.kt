package com.example.labtest1.feeskeeper.nimit

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.labtest1.feeskeeper.nimit.dbConfig.feeViewModel
import java.util.*


class addAct : AppCompatActivity() {

    private lateinit var Name: EditText

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        title = "add Details"
        Name = findViewById(R.id.username)
        var  Fees = findViewById(R.id.fee) as EditText
        var  Age = findViewById(R.id.age) as EditText
        var  date = findViewById(R.id.date) as EditText
        var add = findViewById(R.id.add) as Button


        val datePicker = findViewById<DatePicker>(R.id.datePicker1)

        datePicker.visibility = View.INVISIBLE



        date.setOnClickListener{

            closeKeyboard()
            datePicker.visibility = View.VISIBLE

            val today = Calendar.getInstance()
            datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)

            ){
                    view, year, month, day ->
                val month = month + 1
                val msg = "$day/$month/$year"
                System.out.println(msg)
                date.setText(msg)
            }


        }


            add.setOnClickListener{

                val replyIntent = Intent()
                if (TextUtils.isEmpty(Name.text)) {

                    setResult(Activity.RESULT_CANCELED, replyIntent)
                } else {
                    val word = Name.text.toString()
                    replyIntent.putExtra(EXTRA_REPLY, word)
                    setResult(Activity.RESULT_OK, replyIntent)

                }
                finish()
        }




    }

    private fun closeKeyboard() {


        val view = this.currentFocus
        if (view != null) {
            val imm =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }



}







