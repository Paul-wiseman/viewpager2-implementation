package com.sriyank.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sriyank.paul.viewpager2.R



class MyAdapter(val context: Context, val itemList: List<Item>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.item_page, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {

        myViewHolder.setData(itemList[position])
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(item: Item) {

            itemView.findViewById<TextView>(R.id.txvItemNumber).text = item.itemNumber

            val color = ContextCompat.getColor(context, item.colorId)
            itemView.findViewById<CardView>(R.id.rootCardView).setCardBackgroundColor(color)
        }
    }
}
