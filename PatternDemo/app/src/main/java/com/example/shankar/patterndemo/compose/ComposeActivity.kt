package com.example.shankar.patterndemo.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme

class ComposeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {  MyApp() }
    }

    @Composable
    fun MyApp() {
        MaterialTheme { Counter(CounterModel()) }
    }
    @Composable
    fun Counter(counterModel: CounterModel) {
        Column {
            CounterHeader(counterModel)
            AddSubtractButtons(counterModel)
            CounterLabel(counterModel)
        }
    }

    @Composable
    fun CounterHeader(counterModel: CounterModel) {
        Text(text = counterModel.header)
    }

    @Composable
    fun AddSubtractButtons(counterModel: CounterModel) {
        Button(
                text = "Add",
                onClick = { counterModel.add() })
        Button(
                text = "Subtract",
                onClick = { counterModel.subtract() })
    }

    @Composable
    fun CounterLabel(counterModel: CounterModel) {
        Text(text = "Clicks: ${counterModel.counter}")
    }

    @Model
    class CounterModel {
        var counter: Int = 0
        var header = "Counter demo"

        fun add() { counter++ }

        fun subtract() { counter-- }
    }
}