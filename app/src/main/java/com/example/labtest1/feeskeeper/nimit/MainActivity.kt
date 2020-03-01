package com.example.labtest1.feeskeeper.nimit

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem


class MainActivity : AppCompatActivity() {


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



}

