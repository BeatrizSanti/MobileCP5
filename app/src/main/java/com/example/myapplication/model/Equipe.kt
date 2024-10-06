package com.example.myapplication.model

data class Equipes(
    val nomeEquipe: String,
    val piloto1: String,
    val numeroPiloto1: String,
    val piloto2: String,
    val numeroPiloto2: String,
) {
    override fun toString(): String {
        return "$nomeEquipe: $piloto1 e $piloto2"
    }
}
