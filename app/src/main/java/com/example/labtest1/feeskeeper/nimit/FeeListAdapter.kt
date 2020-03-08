package com.example.labtest1.feeskeeper.nimit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labtest1.feeskeeper.nimit.dbConfig.Fee

 class FeeListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<FeeListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var fee = emptyList<Fee>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val wordItemView: TextView = itemView.findViewById(R.id.textView)

    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = fee[position]
        holder.wordItemView.text = "Username ="+current.user_name + "\n " +
                                    "user_Id = " +current.u_id +
                                    "\n Amount ="+ current.feeamount +
                                      "\nAge ="+current.user_age +
                                     "\nDate ="+current.date


    }

    internal fun setWords(fee: List<Fee>) {
        this.fee = fee
        notifyDataSetChanged()
    }

    override fun getItemCount() = fee.size
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {

         val itemView = inflater.inflate(R.layout.list_item, parent, false)
         return WordViewHolder(itemView)
     }
 }