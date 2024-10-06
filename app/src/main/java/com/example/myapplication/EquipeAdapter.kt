package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// EquipeAdapter.kt
class EquipeAdapter(private val equipes: List<Equipe>) : RecyclerView.Adapter<EquipeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeEquipe: TextView = itemView.findViewById(R.id.tv_nome_equipe)
        val piloto1: TextView = itemView.findViewById(R.id.tv_piloto1)
        val piloto2: TextView = itemView.findViewById(R.id.tv_piloto2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_equipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val equipe = equipes[position]
        holder.nomeEquipe.text = equipe.nomeEquipes
        holder.piloto1.text = equipe.piloto1
        holder.piloto2.text = equipe.piloto2
    }

    override fun getItemCount() = equipes.size
}

