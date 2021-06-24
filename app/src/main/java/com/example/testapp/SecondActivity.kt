package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textShowMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textShowMessage = findViewById(R.id.textShowMessage)

        var bundle: Bundle? = intent.extras
        var result = bundle!!.getString("user_message")
        textShowMessage.text = result
    }
}