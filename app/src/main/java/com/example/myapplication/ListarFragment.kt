package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListarFragment : Fragment() {
    private lateinit var equipeAdapter: EquipeAdapter
    private lateinit var equipeList: MutableList<Equipe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate o layout do fragment
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_listagem_equipes)

        equipeList = mutableListOf() // Carregar os dados cadastrados aqui

        equipeAdapter = EquipeAdapter(equipeList) { equipe ->
            // Lógica para deletar a equipe
            equipeList.remove(equipe)
            equipeAdapter.notifyDataSetChanged()
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = equipeAdapter
    }
}