package ar.edu.unahur.obj2.refactors

// clase que representa a un Pokemon
class Pokemon(
    var vidaMaxima: Int, // la vida máxima es un Int
    var ataqueBase: Double = 1.0
) {
    var vida = vidaMaxima
    var estado = EstadoPokemon.NORMAL
    var experiencia = 0

    fun atacar(nombreAtaque: String, otro: Pokemon) {
        AtaqueManager.resolverAtaque(nombreAtaque, this, otro)
    }
}
