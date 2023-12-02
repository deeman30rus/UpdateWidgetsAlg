package com.example.updatewidgetsalg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val adapter by lazy { WidgetsAdapter(this) }
    private val widgetsRepo = WidgetsRepo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<View>(R.id.change).also { view ->
            view.setOnClickListener {
                lifecycleScope.launch { widgetsRepo.changeWidget() }
            }
        }

        findViewById<RecyclerView>(R.id.widgets).also {
            it.adapter = adapter

            subscribeToWidgets()
        }
    }

    private fun subscribeToWidgets() {
        widgetsRepo.getWidgetsFlow()
            .onEach(adapter::setWidgets)
            .launchIn(lifecycleScope)
    }
}