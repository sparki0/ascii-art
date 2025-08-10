package data.images

import data.pixels.GSPixel
import org.scalatest.funsuite.AnyFunSuite

class GSImageTest extends AnyFunSuite{
  test("Invalid grayscale image0x0") {
    val pixels = Seq()
    
    assertThrows[Exception] {
      val gsImage = GSImage(pixels)
    }
  }

  test("Invalid grayscale image1x0") {
    val pixels = Seq(Seq())

    assertThrows[Exception] {
      val gsImage = GSImage(pixels)
    }
  }

  test("Invalid grayscale image different width") {
    val pixels = Seq(
      Seq(GSPixel(0), GSPixel(255), GSPixel(10), GSPixel(59)),
      Seq(GSPixel(100), GSPixel(150), GSPixel(70), GSPixel(205)),
      Seq(GSPixel(15), GSPixel(21))
    )

    assertThrows[Exception] {
      val gsImage = GSImage(pixels)
    }
  }
  
  test("Valid grayscale image image4x3") {
    val pixels = Seq(
      Seq(GSPixel(0), GSPixel(255), GSPixel(10), GSPixel(59)),
      Seq(GSPixel(100), GSPixel(150), GSPixel(70), GSPixel(205)),
      Seq(GSPixel(15), GSPixel(21), GSPixel(4), GSPixel(33))
    )
    val gsImage = GSImage(pixels)
    
    assert(gsImage.getWidth == 4)
    assert(gsImage.getHeight == 3)
    assert(gsImage.getPixel(0, 0).value == pixels(0)(0).value)
    assert(gsImage.getPixel(1, 0).value == pixels(0)(1).value)
    assert(gsImage.getPixel(2, 0).value == pixels(0)(2).value)
    assert(gsImage.getPixel(3, 0).value == pixels(0)(3).value)
    assert(gsImage.getPixel(0, 1).value == pixels(1)(0).value)
    assert(gsImage.getPixel(1, 1).value == pixels(1)(1).value)
    assert(gsImage.getPixel(2, 1).value == pixels(1)(2).value)
    assert(gsImage.getPixel(3, 1).value == pixels(1)(3).value)
    assert(gsImage.getPixel(0, 2).value == pixels(2)(0).value)
    assert(gsImage.getPixel(1, 2).value == pixels(2)(1).value)
    assert(gsImage.getPixel(2, 2).value == pixels(2)(2).value)
    assert(gsImage.getPixel(3, 2).value == pixels(2)(3).value)
  }
}
