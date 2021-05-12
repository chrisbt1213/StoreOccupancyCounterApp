package com.timercountercs4080

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

private const val COUNTER = "Counter"

class MainActivity : AppCompatActivity() {


    private lateinit var enteringButton: Button
    private lateinit var exitingButton: Button
    private lateinit var resetButton: Button
    private lateinit var counterText: TextView

    private val counterViewModel: CounterViewModel by lazy {
        ViewModelProviders.of(this).get(CounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enteringButton = findViewById(R.id.bt_counter)
        exitingButton = findViewById(R.id.bt_decrement)
        resetButton = findViewById(R.id.bt_reset)
        counterText = findViewById(R.id.tv_counter)

        enteringButton.setOnClickListener {
            counterViewModel.increment()
            updateCounter()
        }

        exitingButton.setOnClickListener {
            counterViewModel.decrement()
            updateCounter()
            if (counterViewModel.tvCounter == 0){
                Toast.makeText(this,
                        "Cannot be less than 0", Toast.LENGTH_SHORT).show()
            }
        }

        resetButton.setOnClickListener {
            counterViewModel.reset()
            updateCounter()
        }

    }

    private fun updateCounter(){
        counterText.text = counterViewModel.tvCounter.toString()
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(COUNTER,  counterViewModel.tvCounter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val counterInt = savedInstanceState.getInt(COUNTER, counterViewModel.tvCounter)
        counterText.text = counterInt.toString()
    }

}