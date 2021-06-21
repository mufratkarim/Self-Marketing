package com.mkalegend.selfmarketing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerValues: Array<String> =
            arrayOf("Android Wizard", "Android Engineer", "Android Developer")
        val spinnerAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinnerPositions.adapter = spinnerAdapter


        buttonMessage.setOnClickListener {
            clickedPreview()
        }
    }

    private fun clickedPreview() {

        val storedMessage = PreviewMessage(
            editTextContName.text.toString(),
            editTextContNumber.text.toString(),
            editTextDisplayName.text.toString(),
            editTextAvailableDate.text?.toString(),
            checkBoxJunior.isChecked,
            checkboxStart.isChecked,
            spinnerPositions.selectedItem?.toString()
        )

        val previewMessageIntent = Intent(this, PreviewMessageActivity::class.java)
        previewMessageIntent.putExtra("Message", storedMessage)
        startActivity(previewMessageIntent)


    }
}