package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
// HelmetFragment.kt
class HelmetFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_helmet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomeEquipeEditText = view.findViewById<EditText>(R.id.et_nome_equipe)
        val nomePiloto1EditText = view.findViewById<EditText>(R.id.et_nome_piloto1)
        val nomePiloto2EditText = view.findViewById<EditText>(R.id.et_nome_piloto2)
        val salvarButton = view.findViewById<Button>(R.id.btn_salvar_equipe)

        salvarButton.setOnClickListener {
            val nomeEquipe = nomeEquipeEditText.text.toString()
            val nomePiloto1 = nomePiloto1EditText.text.toString()
            val nomePiloto2 = nomePiloto2EditText.text.toString()

            if (nomeEquipe.isNotEmpty() && nomePiloto1.isNotEmpty() && nomePiloto2.isNotEmpty()) {
                salvarEquipe(nomeEquipe, nomePiloto1, nomePiloto2)
            } else {
                Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun salvarEquipe(nomeEquipe: String, nomePiloto1: String, nomePiloto2: String) {
        val novaEquipe = Equipe(nomeEquipe, nomePiloto1, nomePiloto2)
        EquipeRepository.equipes.add(novaEquipe) // Adiciona à lista
        Toast.makeText(context, "Equipe $nomeEquipe salva!", Toast.LENGTH_SHORT).show()
    }
}

