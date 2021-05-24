package ar.edu.unahur.obj2.refactors

import kotlin.math.roundToInt

class Pokemon(
    var vidaMaxima: Int,
    var ataqueBase: Double = 1.0
) {
    var vida = vidaMaxima
    var estado: EstadoPokemon = EstadoPokemon.Normal

    fun curar() {
        vida = vidaMaxima
    }

    fun estaDebilitado() = vida <= 0
    fun dañoPara(potencia: Int) = (potencia * ataqueBase).roundToInt()

    fun atacar(ataque: Ataque, otro: Pokemon) {
        AtaqueManager.resolverAtaque(ataque, this, otro)
    }
}
