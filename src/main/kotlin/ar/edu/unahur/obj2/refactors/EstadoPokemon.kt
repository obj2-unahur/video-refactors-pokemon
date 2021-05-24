package ar.edu.unahur.obj2.refactors

enum class EstadoPokemon {
    NORMAL,
    CONFUNDIDO, // al estar confundido, siempre se ataca a sí mismo
    DORMIDO // dormido no se puede atacar
}