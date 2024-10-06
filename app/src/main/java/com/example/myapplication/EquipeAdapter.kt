package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Equipe(val nomeEquipe: String, val nomePiloto1: String, val nomePiloto2: String)

class EquipeAdapter(private val equipes: List<Equipe>, private val onDelete: (Equipe) -> Unit) :
    RecyclerView.Adapter<EquipeAdapter.EquipeViewHolder>() {

    class EquipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeEquipeTextView: TextView = itemView.findViewById(R.id.tv_nome_equipe)
        val nomePiloto1TextView: TextView = itemView.findViewById(R.id.tv_nome_piloto1)
        val nomePiloto2TextView: TextView = itemView.findViewById(R.id.tv_nome_piloto2)
        val deleteButton: Button = itemView.findViewById(R.id.btn_delete_equipe)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EquipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_listar, parent, false)
        return EquipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EquipeViewHolder, position: Int) {
        val equipe = equipes[position]
        holder.nomeEquipeTextView.text = equipe.nomeEquipe
        holder.nomePiloto1TextView.text = equipe.nomePiloto1
        holder.nomePiloto2TextView.text = equipe.nomePiloto2

        holder.deleteButton.setOnClickListener {
            onDelete(equipe)
        }
    }

    override fun getItemCount(): Int {
        return equipes.size
    }
}
