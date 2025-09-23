package com.example.projeto2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Formulario_login : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view = inflater.inflate(R.layout.activity_formulario_login, container, false)


        val btnInicio452 = view.findViewById<Button>(R.id.button2)
        btnInicio452.setOnClickListener {
            val intent = Intent(requireContext(), Inicio::class.java) // Use requireContext()
            startActivity(intent)
        }
        return view
    }

}
