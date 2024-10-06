package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton // Import for ImageButton
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.repository.EquipeRepository

class ListarFragment : Fragment() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<Equipe> // Use a custom adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.list_view_equipes)

        adapter = object : ArrayAdapter<Equipe>(requireContext(), R.layout.item_equipe, EquipeRepository.equipes) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val equipe = getItem(position) // Get the Equipe object
                var itemView = convertView

                if (itemView == null) {
                    itemView = LayoutInflater.from(context).inflate(R.layout.item_equipe, parent, false)
                }

                itemView!!.findViewById<TextView>(R.id.tv_nome_equipe).text = equipe?.nome
                itemView.findViewById<TextView>(R.id.tv_piloto1).text = equipe?.piloto1
                itemView.findViewById<TextView>(R.id.tv_piloto2).text = equipe?.piloto2


                val editButton = itemView.findViewById<ImageButton>(R.id.edit_button) // Edit button
                val deleteButton = itemView.findViewById<ImageButton>(R.id.delete_button) // Delete button

                editButton.setOnClickListener {
                    // Handle Edit action here (e.g., open HelmetFragment with data to edit)
                    //  (activity as? MainActivity)?.openHelmetFragmentForEdit(equipe) //Example
                }

                deleteButton.setOnClickListener {
                    // Handle Delete action here
                    EquipeRepository.equipes.remove(equipe)
                    adapter.notifyDataSetChanged() // Update the list
                }


                return itemView
            }
        }
        listView.adapter = adapter

    }


}