package ar.edu.unahur.obj2.refactors

class Pokemon(
    var vidaMaxima: Int,
    var ataqueBase: Double = 1.0
) {
    var vida = vidaMaxima
    var estado = EstadoPokemon.NORMAL

    fun estaDebilitado() = vida <= 0

    fun atacar(nombreAtaque: String, otro: Pokemon) {
        AtaqueManager.resolverAtaque(nombreAtaque, this, otro)
    }
}
