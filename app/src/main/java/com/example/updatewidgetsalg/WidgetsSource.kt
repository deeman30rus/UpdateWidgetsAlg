package com.example.updatewidgetsalg

import java.text.FieldPosition

class WidgetsSource {

    private var counter = 0
    private val widgets = mutableListOf<Widget>()

    init {
        addWidget()
        addWidget()
        addWidget()
    }

    fun getWidgets(): List<Widget> {
        return widgets.toList()
    }

    fun changeWidget(position: Int) {
        val newWidget = Widget("widget #$counter")
        ++counter
        widgets[position] = newWidget
    }

    private fun addWidget() {
        widgets.add(Widget("widget #$counter"))
        counter++
    }
}