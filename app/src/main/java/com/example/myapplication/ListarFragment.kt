package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.myapplication.repository.EquipeRepository


// ListarFragment.kt
class ListarFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<Equipe>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.list_view_equipes)
        adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            EquipeRepository.equipes
        )
        listView.adapter = adapter

//        listView.setOnItemClickListener { parent, view, position, id,  ->
//
//            view.findViewById(R.layout.fragment_helmet)
//        }
    }


}

