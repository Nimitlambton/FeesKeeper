package com.example.labtest1.feeskeeper.nimit



import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.labtest1.feeskeeper.nimit.dbConfig.Fee
import com.example.labtest1.feeskeeper.nimit.dbConfig.feeViewModel



private lateinit var wordViewModel: feeViewModel

class MainActivity : AppCompatActivity() {



    private val newWordActivityRequestCode = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = FeeListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        wordViewModel = ViewModelProvider(this).get(feeViewModel::class.java)

        wordViewModel.allfee.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            words?.let {
                adapter.setWords(it)

            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {


        // Inflate the menu; this adds items to the action bar if it is
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add) {
            ShowaddDetails()
        }


        return super.onOptionsItemSelected(item)
    }

    private fun ShowaddDetails() {


        val intent = Intent(this@MainActivity, addAct::class.java)

        startActivityForResult(intent, newWordActivityRequestCode)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {



        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {


            data?.getStringExtra(addAct.EXTRA_REPLY)?.let {


            }


        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}














