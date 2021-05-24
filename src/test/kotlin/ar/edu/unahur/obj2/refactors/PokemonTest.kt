package ar.edu.unahur.obj2.refactors

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PokemonTest : DescribeSpec({
  describe("Pokemon") {
    val atacado = Pokemon(200, 1.0)
    val atacante = Pokemon(300, 2.0)

    describe("Ataques") {
      it("Pistola de agua le baja 10 * ataqueBase") {
        atacante.atacar("pistola de agua", atacado)
        atacado.vida shouldBe 180
      }

      it("Derribo le baja 25 * ataqueBase, y además le hace perder 5 al atacante") {
        atacante.atacar("derribo", atacado)
        atacado.vida shouldBe 150
        atacante.vida shouldBe 295
      }

      it("Descanso cambia el estado del que ataca a dormido, y lo cura") {
        atacante.vida = 3
        atacante.atacar("descanso", atacado)
        atacante.estado shouldBe EstadoPokemon.DORMIDO
        atacante.vida shouldBe 300
      }

      it("Rayo confuso confunde al enemigo") {
        atacante.atacar("rayo confuso", atacado)
        atacado.estado shouldBe EstadoPokemon.CONFUNDIDO
      }
    }

    describe("Puede atacar") {
      it("Si el atacante está sin vida, no puede atacar") {
        atacante.vida = 0
        atacante.atacar("pistola de agua", atacado)
        atacado.vida shouldBe 200
      }

      it("Si el atacado no tiene vida, no puede volver a ser atacado") {
        atacado.vida = 0
        atacante.atacar("pistola de agua", atacado)
        atacado.vida shouldBe 0
      }
    }

    describe("Estados") {
      it("Un pokemon dormido no puede atacar") {
        atacante.estado = EstadoPokemon.DORMIDO
        atacante.atacar("pistola de agua", atacado)
        atacado.vida shouldBe 200
      }

      it("Un pokemon confundido se daña a sí mismo") {
        atacante.estado = EstadoPokemon.CONFUNDIDO
        atacante.atacar("pistola de agua", atacado)
        atacante.vida shouldBe 280
      }
    }
  }
})