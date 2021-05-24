package ar.edu.unahur.obj2.refactors

open class EstadoPokemon {
    open fun puedeAtacar() = true
    open fun obtenerAtacado(atacante: Pokemon, atacado: Pokemon) = atacado

    object Normal : EstadoPokemon()
    object Confundido : EstadoPokemon() {
        override fun obtenerAtacado(atacante: Pokemon, atacado: Pokemon) = atacante
    }
    object Dormido : EstadoPokemon() {
        override fun puedeAtacar() = false
    }
}