package com.example.projeto2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
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
            val intent = Intent(this, Configuracoes::class.java)
            startActivity(intent)
        }
        val btnPerfil = findViewById<ImageView>(R.id.buscar0000)
        btnPerfil.setOnClickListener {
            val intent = Intent(this, Perfil::class.java)
            startActivity(intent)
        }
        val textViewNomePerfil = findViewById<TextView>(R.id.textView23)
        val textViewEmailPerfil = findViewById<TextView>(R.id.textView24)
        val sharedPreferences = getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)
        val nomeSalvo = sharedPreferences.getString("NOME_USUARIO", "Usuário")
        val emailSalvo = sharedPreferences.getString("EMAIL_USUARIO", "E-mail não informado")

        textViewNomePerfil.text = nomeSalvo
        textViewEmailPerfil.text = emailSalvo
    }
}
