package com.example.projeto2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.ImageView


class Configuracoes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_configuracoes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInicio = findViewById<ImageView>(R.id.inicio0)
        btnInicio.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val btnBuscar = findViewById<ImageView>(R.id.buscar0)
        btnBuscar.setOnClickListener {
            val intent = Intent(this, Buscador::class.java)
            startActivity(intent)
        }

        val btnBiblioteca = findViewById<ImageView>(R.id.Biblioteca0)
        btnBiblioteca.setOnClickListener {
            val intent = Intent(this, Minhabiblio::class.java)
            startActivity(intent)
        }

        val btnConfig = findViewById<ImageView>(R.id.Configurações0)
        btnConfig.setOnClickListener {
            val intent = Intent(this, Configuracoes::class.java)
            startActivity(intent)
        }

        val btnPerfil = findViewById<ImageView>(R.id.Perfil0)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
    }
}