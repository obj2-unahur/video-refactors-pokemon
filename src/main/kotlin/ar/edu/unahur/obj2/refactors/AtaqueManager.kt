package ar.edu.unahur.obj2.refactors

import kotlin.math.roundToInt

object AtaqueManager {
    // Pistola de agua: Saca 10 * ataqueBase
    // Derribo: Saca 25 * ataqueBase, pero el atacante pierde 5 de vida
    // Descanso: Se duerme pero recupera el 100% de la vida
    // Rayo confuso: Confunde al enemigo
    var nombreAtaques = mutableListOf("derribo", "descanso", "pistola de agua", "rayo confuso")

    var potenciaAtaques = mutableListOf(25, 0, 10, 0) // la potencia de cada ataque
    // NOTA: sí o sí tiene que tener la misma longitud que `nombreAtaques`

    fun resolverAtaque(nombreAtaque: String, atacante: Pokemon, atacado: Pokemon) {
        // Validar ataque
        val indiceAtaque = nombreAtaques.indexOf(nombreAtaque)
        if (indiceAtaque == -1)
            error("No conozco ese nombre de ataque")

        // Puede atacar?
        if (atacante.estado == EstadoPokemon.DORMIDO || atacante.vida <= 0 || atacado.vida <= 0)
            return

        // Bajar vida necesaria
        if (atacante.estado == EstadoPokemon.CONFUNDIDO)
            atacante.vida -= (potenciaAtaques[indiceAtaque] * atacante.ataqueBase).roundToInt()
        else
            atacado.vida -= (potenciaAtaques[indiceAtaque] * atacante.ataqueBase).roundToInt()

        if (nombreAtaque == "derribo")
            atacante.vida -= 5

        // Procesar cambios de estados
        if (nombreAtaque == "rayo confuso")
            atacado.estado = EstadoPokemon.CONFUNDIDO
        else if (nombreAtaque == "descanso") {
            atacante.estado = EstadoPokemon.DORMIDO
            atacante.vida = atacante.vidaMaxima
        }
    }
}