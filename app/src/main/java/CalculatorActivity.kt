package com.example.ap3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val number1EditText: EditText = findViewById(R.id.number1EditText)
        val number2EditText: EditText = findViewById(R.id.number2EditText)
        val operationSpinner: Spinner = findViewById(R.id.operationSpinner)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val number2 = number2EditText.text.toString().toDoubleOrNull() ?: 0.0
            val operation = operationSpinner.selectedItem.toString()

            val result = when (operation) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> if (number2 != 0.0) number1 / number2 else "Error"
                else -> "Invalid Operation"
            }
            resultTextView.text = result.toString()
        }
    }
}
