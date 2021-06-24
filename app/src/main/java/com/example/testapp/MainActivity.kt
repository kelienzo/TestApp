package com.example.testapp

import android.content.Intent
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.TextUtils
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    lateinit var btnNextPage: Button
    lateinit var etEnterMessage: EditText
    lateinit var btnShareMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNextPage = findViewById(R.id.btnNextPage)
        etEnterMessage = findViewById(R.id.etEnterMessage)
        btnShareMessage = findViewById(R.id.btnShareMessage)

        btnNextPage.setOnClickListener {
            openNextPage()
        }

        btnShareMessage.setOnClickListener {
            shareMessage()
        }
    }

    private fun openNextPage() {
        val message: String = etEnterMessage.text.toString()
        if (message == "") {
            Toast.makeText(this, "Message required!", Toast.LENGTH_LONG).show()
        } else {
            val intent: Intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_message", message)
            startActivity(intent)
        }
    }

    private fun shareMessage() {
        val message: String = etEnterMessage.text.toString()
        if (isEmpty(message)) {
            Toast.makeText(this, "Message required!", Toast.LENGTH_LONG).show()
        } else {
            val intent: Intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Select App"))
        }
    }
}