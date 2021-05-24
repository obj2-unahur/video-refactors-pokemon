package ar.edu.unahur.obj2.refactors

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PokemonTest : DescribeSpec({
  describe("Pokemon") {
    it("ANDA TODO") {
      val pikachu = Pokemon(200, 1.0)
      val blastoise = Pokemon(300, 2.0)

      blastoise.atacar("pistola de agua", pikachu)
      pikachu.vida shouldBe 180
    }
  }
})