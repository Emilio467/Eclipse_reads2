package com.example.projeto2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.compose.ui.layout.layout


class Formulario_registro : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_formulario_registro, container, false)



        val btnInicio0 = view.findViewById<Button>(R.id.button4)
        btnInicio0.setOnClickListener {
            val intent = Intent(requireContext(), Inicio::class.java)
            startActivity(intent)
        }
        return view
    }
}
