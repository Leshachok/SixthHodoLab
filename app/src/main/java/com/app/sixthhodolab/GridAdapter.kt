package com.app.sixthhodolab

import android.app.AlertDialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(val layoutInflater: LayoutInflater, val context: Context)
    : ListAdapter<GridItem, GridAdapter.ViewHolder>(ItemDiffCallback) {

    class ViewHolder(
        view: View
    ): RecyclerView.ViewHolder(view){
        private val numberView: TextView = view.findViewById(R.id.numberView)

        fun bind(item: GridItem){
            numberView.text = "${item.number}"
            var backGround = itemView.background as GradientDrawable
            backGround.color = ColorStateList.valueOf(item.color)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.grid_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
                .setTitle("Alert Dialog")
                .setMessage("You choose number: ${item.number}")
                .setPositiveButton("Ok", null)
                .create()
            dialog.show()
        }
    }
    
    object ItemDiffCallback : DiffUtil.ItemCallback<GridItem>() {
        override fun areItemsTheSame(
            oldItem: GridItem,
            newItem: GridItem
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: GridItem,
            newItem: GridItem
        ): Boolean = oldItem.number == newItem.number

    }
}