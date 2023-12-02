package com.example.updatewidgetsalg

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WidgetsAdapter(
    context: Context,
): RecyclerView.Adapter<WidgetsViewHolder>() {

    private val widgets = mutableListOf<Widget>()
    private val inflater = LayoutInflater.from(context)

    fun setWidgets(widgets: List<Widget>) {
        this.widgets.clear()
        this.widgets.addAll(widgets)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetsViewHolder {
        val view = inflater.inflate(R.layout.vh_widget, parent, false)

        return WidgetsViewHolder(view)
    }

    override fun onBindViewHolder(holder: WidgetsViewHolder, position: Int) {
        val widget = widgets[position]
        holder.bind(widget)
    }

    override fun getItemCount(): Int {
        return widgets.size
    }
}