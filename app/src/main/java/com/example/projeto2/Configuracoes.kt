package com.example.projeto2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Configuracoes : BaseActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "AppThemePrefs"
    private val KEY_BACKGROUND_COLOR = "backgroundColor"
    private lateinit var buttonTemaRoxo: Button
    private lateinit var buttonTemaAzul: Button
    private lateinit var textViewStatusTema: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracoes)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInicio = findViewById<ImageView>(R.id.Buscar)
        btnInicio.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val btnBuscar = findViewById<ImageView>(R.id.buscar0)
        btnBuscar.setOnClickListener {
            val intent = Intent(this, Buscador::class.java)
            startActivity(intent)
        }

        val btnBiblioteca = findViewById<ImageView>(R.id.buscar00)
        btnBiblioteca.setOnClickListener {
            val intent = Intent(this, Minhabiblio::class.java)
            startActivity(intent)
        }

        val btnConfig = findViewById<ImageView>(R.id.buscar000)
        btnConfig.setOnClickListener {
        }

        val btnPerfil = findViewById<ImageView>(R.id.buscar0000)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }

        buttonTemaRoxo = findViewById(R.id.button30)
        buttonTemaAzul = findViewById(R.id.button32)
        textViewStatusTema = findViewById(R.id.textView999)

        updateButtonStates()
        updateTextViewThemeStatus()
        buttonTemaRoxo.setOnClickListener {
            saveBackgroundColor("#6A3D89")
            Toast.makeText(this, "Tema Roxo aplicado!", Toast.LENGTH_SHORT).show()
            textViewStatusTema.text = "Claro"
        }

        buttonTemaAzul.setOnClickListener {
            saveBackgroundColor("#10114B")
            Toast.makeText(this, "Tema Azul Escuro aplicado!", Toast.LENGTH_SHORT).show()
            textViewStatusTema.text = "Escuro"
        }
    }

    private fun saveBackgroundColor(colorHex: String) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_BACKGROUND_COLOR, colorHex)
        editor.apply()
        updateButtonStates()
        updateTextViewThemeStatus()
    }

    private fun updateButtonStates() {
        val currentColor = sharedPreferences.getString(KEY_BACKGROUND_COLOR, "#6A3D89")

        if (currentColor == "#6A3D89") {
            buttonTemaRoxo.text = "Ativado"
            buttonTemaAzul.text = "Ativar Tema Azul"
        } else if (currentColor == "#10114B") {
            buttonTemaAzul.text = "Ativado"
            buttonTemaRoxo.text = "Ativar Tema Roxo"
        } else {
            buttonTemaRoxo.text = "Ativar Tema Roxo"
            buttonTemaAzul.text = "Ativar Tema Azul"
        }
    }

    private fun updateTextViewThemeStatus() {
        val currentColor = sharedPreferences.getString(KEY_BACKGROUND_COLOR, "#6A3D89")

        if (currentColor == "#6A3D89") {
            textViewStatusTema.text = "Claro"
        } else if (currentColor == "#10114B") {
            textViewStatusTema.text = "Escuro"
        } else {
            textViewStatusTema.text = "Indefinido"
        }
    }
}
