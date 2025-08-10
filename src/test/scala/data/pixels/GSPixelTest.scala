package data.pixels

import org.scalatest.funsuite.AnyFunSuite

class GSPixelTest extends AnyFunSuite {
  test("Grayscale pixel invalid value < 0") {
    assertThrows[Exception] {
      GSPixel(-1)
    }
  }

  test("Grayscale pixel invalid value > 255") {
    assertThrows[Exception] {
      GSPixel(256)
    }
  }

  test("Grayscale pixel valid value = 0") {
    val gsPixel = GSPixel(0)
    assert(gsPixel.value == 0)
  }

  test("Grayscale pixel valid value = 255") {
    val gsPixel = GSPixel(255)
    assert(gsPixel.value == 255)
  }

  test("Grayscale pixel valid value = 170") {
    val gsPixel = GSPixel(170)
    assert(gsPixel.value == 170)
  }

  test("Grayscale pixel valid value = 52") {
    val gsPixel = GSPixel(52)
    assert(gsPixel.value == 52)
  }
}
