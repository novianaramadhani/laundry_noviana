package com.example.laundry.Profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.laundry.Order.LaundryListActivity
import com.example.laundry.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button: Button = findViewById(R.id.loginButton)

        button.setOnClickListener {
            val intent = Intent(this@LoginActivity, LaundryListActivity::class.java)
            startActivity(intent)
        }
    }
}