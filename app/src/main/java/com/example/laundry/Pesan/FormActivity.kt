package com.example.laundry.Pesan

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.example.laundry.Adapter.Laundry
import com.example.laundry.Order.LaundryListActivity
import com.example.laundry.R
import java.util.Calendar

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        val quantitySpinner: Spinner = findViewById(R.id.quantitySpinner)
        val customerNameEditText: EditText = findViewById(R.id.customerNameEditText)
        val addressEditText: EditText = findViewById(R.id.addressEditText)
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        val calendarButton: ImageButton = findViewById(R.id.calendarButton)
        val submitBtn: Button = findViewById(R.id.submitBtn)

        val quantityOptions = resources.getStringArray(R.array.laundry_types)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, quantityOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        quantitySpinner.adapter = adapter

        // Set initial date in TextView
        val initialDay = 1
        val initialMonth = 1
        val initialYear = 2023
        dateTextView.text = "$initialDay/$initialMonth/$initialYear"

        // Handle calendar button click
        calendarButton.setOnClickListener {
            showDatePickerDialog(dateTextView)
        }

        submitBtn.setOnClickListener {
            val quantity = quantitySpinner.selectedItem.toString()
            val customerName = customerNameEditText.text.toString()
            val address = addressEditText.text.toString()

            val day = 1 // Set a default value for day, as DatePickerDialog will set it
            val month = 1 // Set a default value for month, as DatePickerDialog will set it
            val year = 2023 // Set a default value for year, as DatePickerDialog will set it
            val orderDate = "$day/$month/$year"

            // Create LaundryOrder object
            val laundryOrder = LaundryOrder(customerName, address, quantity, orderDate)

            Toast.makeText(this, "Pesanan Laundry Diterima", Toast.LENGTH_SHORT).show()
        }
    }

    // Function to show DatePickerDialog
    private fun showDatePickerDialog(dateTextView: TextView) {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                dateTextView.text = selectedDate
            },
            currentYear,
            currentMonth,
            currentDay
        )

        datePickerDialog.show()

        val submitBtn: Button = findViewById(R.id.submitBtn)
        submitBtn.setOnClickListener {
            // Panggil fungsi ketika tombol diklik
            submitOrder()
        }
    }

    private fun submitOrder() {
        val intent = Intent(this, LaundryListActivity::class.java)
        startActivity(intent)
    }
    }



