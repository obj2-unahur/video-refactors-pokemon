package ar.edu.unahur.obj2.refactors

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PokemonTest : DescribeSpec({
  describe("Pokemon") {
    val atacado = Pokemon(200, 1.0)
    val atacante = Pokemon(300, 2.0)

    describe("Ataques") {
      it("Pistola de agua le baja 10 * ataqueBase") {
        atacante.atacar(PistolaDeAgua, atacado)
        atacado.vida shouldBe 180
      }

      it("Derribo le baja 25 * ataqueBase, y además le hace perder 5 al atacante") {
        atacante.atacar(Derribo, atacado)
        atacado.vida shouldBe 150
        atacante.vida shouldBe 295
      }

      it("Descanso cambia el estado del que ataca a dormido, y lo cura") {
        atacante.vida = 3
        atacante.atacar(Descanso, atacado)
        atacante.estado shouldBe EstadoPokemon.Dormido
        atacante.vida shouldBe 300
      }

      it("Rayo confuso confunde al enemigo") {
        atacante.atacar(RayoConfuso, atacado)
        atacado.estado shouldBe EstadoPokemon.Confundido
      }
    }

    describe("Puede atacar") {
      it("Si el atacante está sin vida, no puede atacar") {
        atacante.vida = 0
        atacante.atacar(PistolaDeAgua, atacado)
        atacado.vida shouldBe 200
      }

      it("Si el atacado no tiene vida, no puede volver a ser atacado") {
        atacado.vida = 0
        atacante.atacar(PistolaDeAgua, atacado)
        atacado.vida shouldBe 0
      }
    }

    describe("Estados") {
      it("Un pokemon dormido no puede atacar") {
        atacante.estado = EstadoPokemon.Dormido
        atacante.atacar(PistolaDeAgua, atacado)
        atacado.vida shouldBe 200
      }

      it("Un pokemon confundido se daña a sí mismo") {
        atacante.estado = EstadoPokemon.Confundido
        atacante.atacar(PistolaDeAgua, atacado)
        atacante.vida shouldBe 280
      }
    }
  }
})