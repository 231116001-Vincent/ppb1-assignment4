package com.vharya.assignment4

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOpen = findViewById<Button>(R.id.btnOpen)
        btnOpen.setOnClickListener {
            displayToast("You have clicked the Open button")
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            displayToast("You have clicked the Save button")
        }

        val checkBox = findViewById<CheckBox>(R.id.chkAutoSave)
        checkBox.setOnClickListener { v ->
            if ((v as CheckBox).isChecked) {
                displayToast("Checkbox is checked")
            } else {
                displayToast("Checkbox is unchecked")
            }
        }

        val radioGroup = findViewById<RadioGroup>(R.id.rdGp1)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val rb1 = findViewById<RadioButton>(R.id.rdb1)
            if (rb1.isChecked) {
                displayToast("Option 1 is checked")
            } else {
                displayToast("Option 2 is checked")
            }
        }

        val toggleButton = findViewById<ToggleButton>(R.id.toggle1)
        toggleButton.setOnClickListener { v ->
            if ((v as ToggleButton).isChecked) {
                displayToast("Toggle button is On")
            } else {
                displayToast("Toggle button is Off")
            }
        }
    }

    private fun displayToast(msg: String) {
        Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
    }
}