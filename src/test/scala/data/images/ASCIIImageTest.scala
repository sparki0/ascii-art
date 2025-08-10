package data.images

import data.pixels.ASCIIPixel
import org.scalatest.funsuite.AnyFunSuite

class ASCIIImageTest extends AnyFunSuite {
  test("Invalid ASCII image0x0") {
    val pixels = Seq()

    assertThrows[Exception] {
      val asciiImage = ASCIIImage(pixels)
    }
  }

  test("Invalid ASCII image1x0") {
    val pixels = Seq(Seq())

    assertThrows[Exception] {
      val asciiImage = ASCIIImage(pixels)
    }
  }

  test("Invalid ASCII image different width") {
    val pixels = Seq(
      Seq(ASCIIPixel('H'), ASCIIPixel('e'), ASCIIPixel('l'), ASCIIPixel('l')),
      Seq(ASCIIPixel('o'), ASCIIPixel(','), ASCIIPixel(' '), ASCIIPixel('W')),
      Seq(ASCIIPixel('o'))
    )
    assertThrows[Exception] {
      val asciiImage = ASCIIImage(pixels)
    }
  }
 
  test("Valid ASCII image4x3") {
    val pixels = Seq(
      Seq(ASCIIPixel('H'), ASCIIPixel('e'), ASCIIPixel('l'), ASCIIPixel('l')),
      Seq(ASCIIPixel('o'), ASCIIPixel(','), ASCIIPixel(' '), ASCIIPixel('W')),
      Seq(ASCIIPixel('o'), ASCIIPixel('r'), ASCIIPixel('l'), ASCIIPixel('d'))
    )
    val asciiImage = ASCIIImage(pixels)
    
    assert(asciiImage.getWidth == 4)
    assert(asciiImage.getHeight == 3)
    assert(asciiImage.getPixel(0, 0).value == pixels(0)(0).value)
    assert(asciiImage.getPixel(1, 0).value == pixels(0)(1).value)
    assert(asciiImage.getPixel(2, 0).value == pixels(0)(2).value)
    assert(asciiImage.getPixel(3, 0).value == pixels(0)(3).value)
    assert(asciiImage.getPixel(0, 1).value == pixels(1)(0).value)
    assert(asciiImage.getPixel(1, 1).value == pixels(1)(1).value)
    assert(asciiImage.getPixel(2, 1).value == pixels(1)(2).value)
    assert(asciiImage.getPixel(3, 1).value == pixels(1)(3).value)
    assert(asciiImage.getPixel(0, 2).value == pixels(2)(0).value)
    assert(asciiImage.getPixel(1, 2).value == pixels(2)(1).value)
    assert(asciiImage.getPixel(2, 2).value == pixels(2)(2).value)
    assert(asciiImage.getPixel(3, 2).value == pixels(2)(3).value)
  }
}
