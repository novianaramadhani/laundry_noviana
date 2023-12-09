package com.example.laundry.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laundry.R

class LaundryAdapter (private val laundryList: List<Laundry>):
    RecyclerView.Adapter<LaundryAdapter.LaundryViewHolder>(){

    inner class LaundryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewLaundry)
        val textViewName: TextView = itemView.findViewById(R.id.textViewLaundryName)
        val orderButton: Button = itemView.findViewById(R.id.orderButton)


    }
    interface OnOrderClickListener {
        fun onOrderClick(position: Int)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LaundryAdapter.LaundryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_laundry, parent, false)
        return LaundryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LaundryAdapter.LaundryViewHolder, position: Int) {
        val currentLaundry = laundryList[position]
        holder.imageView.setImageResource(currentLaundry.imageResId)
        holder.textViewName.text = currentLaundry.name



    }

    override fun getItemCount(): Int {
        return laundryList.size
    }


}