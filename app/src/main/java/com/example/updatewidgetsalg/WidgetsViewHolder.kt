package com.example.updatewidgetsalg

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WidgetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tv = itemView as TextView
    fun bind(widget: Widget) {

        tv.text = widget.name
    }
}