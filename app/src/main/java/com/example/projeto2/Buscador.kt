package com.example.projeto2


import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import android.content.Intent
import android.widget.ImageView

class Buscador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscador)

        val searchViewWidget: androidx.appcompat.widget.SearchView =
            findViewById(R.id.search_view_no_layout)

        searchViewWidget.queryHint = "Buscar livros..."
        searchViewWidget.isIconified = false

        searchViewWidget.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.isNotEmpty()) {
                    Log.d("BuscadorActivity", "Layout SearchView - Busca submetida: $query")
                }
                searchViewWidget.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    Log.d("BuscadorActivity", "Layout SearchView - Texto mudou: $newText")
                }
                return true
            }
        })

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

        val btninicial = findViewById<ImageView>(R.id.imageView50)
        btninicial.setOnClickListener {
            val intent = Intent(this, Info_livro::class.java)
            startActivity(intent)
        }

        val btninicial2 = findViewById<ImageView>(R.id.imageView5)
        btninicial2.setOnClickListener {
            val intent = Intent(this, Info_livro::class.java)
            startActivity(intent)
        }
    }

}
