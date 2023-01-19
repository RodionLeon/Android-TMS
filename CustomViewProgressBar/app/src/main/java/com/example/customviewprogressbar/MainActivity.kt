package com.example.customviewprogressbar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val verticalProgressBar = findViewById<VerticalProgressBar>(R.id.verticalProgressBar)

        val calculate = findViewById<Button>(R.id.CalculateValue)
        val min = findViewById<EditText>(R.id.MinValue)
        val max = findViewById<EditText>(R.id.MaxValue)
        val current = findViewById<EditText>(R.id.Current)
        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)

        calculate.setOnClickListener {
            verticalProgressBar.minValue = min.text.toString().toInt()
            verticalProgressBar.maxValue = max.text.toString().toInt()
            verticalProgressBar.currentValue = current.text.toString().toInt()

        }

        plus.setOnClickListener {
            if (plus.isEnabled) {
                verticalProgressBar.currentValue += 1
            }

        }

        minus.setOnClickListener {
            if (minus.isEnabled) {
                verticalProgressBar.currentValue -= 1
            }
        }
    }
}