package com.example.projeto2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class Formulario_registro : Fragment() {
    private lateinit var nomeEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var senhaEditText: EditText
    private lateinit var confirmarSenhaEditText: EditText
    private lateinit var button4: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_formulario_registro, container, false)

        nomeEditText = view.findViewById(R.id.Nome)
        emailEditText = view.findViewById(R.id.Email)
        senhaEditText = view.findViewById(R.id.Senha)
        confirmarSenhaEditText = view.findViewById(R.id.Confirmarsenha)
        button4 = view.findViewById(R.id.button4)

        button4.isEnabled = false

        val formTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val nomeInput = nomeEditText.text.toString().trim()
                val emailInput = emailEditText.text.toString().trim()
                val senhaInput = senhaEditText.text.toString().trim()
                val confirmarSenhaInput = confirmarSenhaEditText.text.toString().trim()

                salvarNomeUsuario(nomeInput)
                salvarEmailUsuario(emailInput)

                val camposPreenchidos = nomeInput.isNotEmpty() &&
                        emailInput.isNotEmpty() &&
                        senhaInput.isNotEmpty() &&
                        confirmarSenhaInput.isNotEmpty()

                val senhasCoincidem = senhaInput == confirmarSenhaInput

                button4.isEnabled = camposPreenchidos && senhasCoincidem

                if (camposPreenchidos && !senhasCoincidem) {
                    confirmarSenhaEditText.error = "As senhas não coincidem"
                } else {
                    confirmarSenhaEditText.error = null
                }
            }
        }

        nomeEditText.addTextChangedListener(formTextWatcher)
        emailEditText.addTextChangedListener(formTextWatcher)
        senhaEditText.addTextChangedListener(formTextWatcher)
        confirmarSenhaEditText.addTextChangedListener(formTextWatcher)

        button4.setOnClickListener {
            val intent = Intent(requireContext(), Inicio::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun salvarNomeUsuario(nome: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("NOME_USUARIO", nome)
        editor.apply()
    }

    private fun salvarEmailUsuario(email: String) {
        val sharedPreferences = requireActivity().getSharedPreferences("DADOS_USUARIO", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("EMAIL_USUARIO", email)
        editor.apply()
    }
}
