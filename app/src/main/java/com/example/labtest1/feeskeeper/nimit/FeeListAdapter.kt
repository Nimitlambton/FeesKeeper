package com.example.labtest1.feeskeeper.nimit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.labtest1.feeskeeper.nimit.dbConfig.Fee


class FeeListAdapter internal constructor(context: Context , var bo : onfeeclick ) : RecyclerView.Adapter<FeeListAdapter.WordViewHolder>() {


    private var feel = emptyList<Fee>() // Cached copy of words

     class WordViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView) {

         val wordItemView: TextView = itemView.findViewById(R.id.textView)


         fun initizliaze(bc: Fee , action: onfeeclick ){


             wordItemView.text = "Username ="+bc.user_name + "\n " +
                     "user_Id = " +bc.u_id +
                     "\n Amount ="+ bc.feeamount +
                     "\nAge ="+bc.user_age +
                     "\nDate ="+bc.date

            itemView.setOnClickListener{

                 action.onitemclick(bc,adapterPosition)

             }

         }


    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {

        val current = feel[position]
       holder.initizliaze(current,bo)



    }

    internal fun setWords(fee: List<Fee>) {
        this.feel = fee
        notifyDataSetChanged()
    }

    override fun getItemCount() = feel.size

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {



         return WordViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))



     }



}







interface onfeeclick{

fun  onitemclick(item:Fee , position: Int)

}


