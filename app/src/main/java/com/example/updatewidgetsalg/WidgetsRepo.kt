package com.example.updatewidgetsalg

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onSubscription
import kotlin.random.Random

class WidgetsRepo {

    private val widgetsSource = WidgetsSource()
    private val widgetsFlow = MutableSharedFlow<List<Widget>>(replay = 1)

    fun getWidgetsFlow(): SharedFlow<List<Widget>> {
        return widgetsFlow.asSharedFlow()
            .onSubscription { emit(widgetsSource.getWidgets()) }
    }

    suspend fun changeWidget() {
        widgetsSource.changeWidget(Random.nextInt(3))

        widgetsFlow.emit(widgetsSource.getWidgets())
    }
}