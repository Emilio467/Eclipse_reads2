package com.example.projeto2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.ImageView

class log0regis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.log0regis)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val button3 = findViewById<Button>(R.id.button3)
        val button9 = findViewById<Button>(R.id.button9)






        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.form_placeholder, Formulario_login())
                .commit()
        }

        button3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.form_placeholder, Formulario_login())
                .commit()
        }

        button9.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.form_placeholder, Formulario_registro())
                .commit()
        }
// ...


    }
}