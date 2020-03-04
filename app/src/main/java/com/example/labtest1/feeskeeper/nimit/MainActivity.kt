package com.example.labtest1.feeskeeper.nimit

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.labtest1.feeskeeper.nimit.DBConfig.AppDatabase
import com.example.labtest1.feeskeeper.nimit.DBConfig.Feedao
import com.example.labtest1.feeskeeper.nimit.DBConfig.Feedesc
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList


class MainActivity : AppCompatActivity() {


    private var db: AppDatabase? = null
    private var genderDao: Feedao? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is
            super.onCreateOptionsMenu(menu)
            menuInflater.inflate(R.menu.menu, menu)
           return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add){
            ShowaddDetails()
        }
        return super.onOptionsItemSelected(item)
    }





    private  fun  ShowaddDetails(){
        val addIntent = Intent(this , addAct::class.java)
        startActivity(addIntent)

    }



    private  fun populateDatabase(){





        Observable.fromCallable({
            db = AppDatabase.getAppDataBase(context = this)
            genderDao = db?.feedao()

            with(genderDao){

            }

            db?.feedao()?.getGenders()

        }).doOnNext({
                list ->

            var finalString = ""
            list?.map {
                finalString+= it.Cname+"\n"+it.age+"\n"+it.Cid
            }
            System.out.println(finalString)
            val animals: ArrayList<String> = ArrayList()


            finish()
        }).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()



    }


}

