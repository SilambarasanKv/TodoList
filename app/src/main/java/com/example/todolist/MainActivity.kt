package com.example.todolist

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todolist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val name: String = etName.text.toString()
            val password: String = etPassword.text.toString()

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString("NAME", name)
            editor.putString("PASSWORD", password)
            editor.apply()

            if (name.equals("Simbu") && password.equals("Simbu123")) {

                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                finish()
            }

            else {
                Toast.makeText(this, "Wrong name or password", Toast.LENGTH_SHORT).show()
            }


        }

    }
}