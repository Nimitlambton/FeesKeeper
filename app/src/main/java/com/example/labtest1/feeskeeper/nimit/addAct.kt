package com.example.labtest1.feeskeeper.nimit

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.labtest1.feeskeeper.nimit.DBConfig.AppDatabase
import com.example.labtest1.feeskeeper.nimit.DBConfig.Feedao
import com.example.labtest1.feeskeeper.nimit.DBConfig.Feedesc
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*


class addAct : AppCompatActivity() {

    private var db: AppDatabase? = null
    private var genderDao: Feedao? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        title = "add Details"
        var  Name = findViewById(R.id.username) as EditText
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

                Observable.fromCallable({
                    db = AppDatabase.getAppDataBase(context = this)
                    genderDao = db?.feedao()


                    var gender1 = Feedesc(0,"nimit",9)

                    with(genderDao){

                        this?.insertdesc(gender1) }

                    db?.feedao()?.getGenders()

                }).doOnNext({
                        list ->

                    var finalString = ""
                    list?.map { finalString+= it.Cname+" - " }
                    System.out.println(finalString)
                    finish()
                }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()


        }







//
//        Observable.From  ({
//
//            db = AppDatabase.getAppDataBase(context = this)
//
//            genderDao = db?.feedao()
//
//
//            var gender1 = Feedesc(0,"nimit",9)
//            var gender2 = Feedesc(1,"amit",7)
//
//            with(genderDao){
//
//                this?.insertdesc(gender1)
//                //this?.insertGender(gender2)
//            }
//            db?.genderDao()?.getGenders()
//        }).doOnNext({ list ->
//            var finalString = ""
//            list?.map { finalString+= it.name+" - " }
//            tv_message.text = finalString
//
//        }).subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe()







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







