package com.example.projeto2

import android.R.id.button2
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


class Formulario_login : Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view = inflater.inflate(R.layout.activity_formulario_login, container, false)


        val btnInicio452 = view.findViewById<Button>(R.id.button2)
        btnInicio452.setOnClickListener {
            val intent = Intent(requireContext(), Inicio::class.java)
            startActivity(intent)
        }

        val emailEditText = view.findViewById<EditText>(R.id.Email00)
        val senhaEditText = view.findViewById<EditText>(R.id.senha00)
        val entrarButton = view.findViewById<Button>(R.id.button2)


        entrarButton.isEnabled = false


        val textWatcher = object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: android.text.Editable?) {
                val emailInput = emailEditText.text.toString().trim()
                val senhaInput = senhaEditText.text.toString().trim()
                entrarButton.isEnabled = emailInput.isNotEmpty() && senhaInput.isNotEmpty()
            }
        }
        emailEditText.addTextChangedListener(textWatcher)
        senhaEditText.addTextChangedListener(textWatcher)









        return view
    }

}


