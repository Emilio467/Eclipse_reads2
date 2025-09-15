package com.example.projeto2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnInicio = findViewById<Button>(R.id.nav_inicio_button)
        btnInicio.setOnClickListener {
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
        }

        val btnBuscar = findViewById<Button>(R.id.nav_Buscar_button)
        btnBuscar.setOnClickListener {
            val intent = Intent(this, Buscador::class.java)
            startActivity(intent)
        }

        val btnBiblioteca = findViewById<Button>(R.id.nav_Biblioteca_button)
        btnBiblioteca.setOnClickListener {
            val intent = Intent(this, Minhabiblio::class.java)
            startActivity(intent)
        }

        val btnConfig = findViewById<Button>(R.id.nav_Configurações_button)
        btnConfig.setOnClickListener {
            val intent = Intent(this, Configuracoes::class.java)
            startActivity(intent)
        }

        val btnPerfil = findViewById<Button>(R.id.nav_Perfil_button)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
    }
}