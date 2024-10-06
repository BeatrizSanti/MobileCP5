// Equipe.kt
package com.example.myapplication

data class Equipes(
    val nomeEquipe: String,
    val piloto1: String,
    val piloto2: String
) {
    override fun toString(): String {
        return "$nomeEquipe: $piloto1 e $piloto2"
    }
}
