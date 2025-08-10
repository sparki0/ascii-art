package data.images

import data.pixels.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color

class RGBImageTest extends AnyFunSuite {
  test("Invalid RGB image0x0") {
    val pixels = Seq()

    assertThrows[Exception] {
      val rgbImage = RGBImage(pixels)
    }
  }

  test("Invalid RGB image1x0") {
    val pixels = Seq(Seq())

    assertThrows[Exception] {
      val rgbImage = RGBImage(pixels)
    }
  }
 
  test("Invalid RGB image different width") {
    val pixels = Seq(
      Seq(RGBPixel(new Color(255, 0, 0)), RGBPixel(new Color(0, 255, 0)), RGBPixel(new Color(0, 0, 255)), RGBPixel(new Color(41, 255, 10))),
      Seq(RGBPixel(new Color(0, 0, 0)), RGBPixel(new Color(100, 54, 55)), RGBPixel(new Color(59, 0, 47)), RGBPixel(new Color(78, 59, 255))),
      Seq(RGBPixel(new Color(255, 255, 255)), RGBPixel(new Color(255, 255, 0))
      ))

    assertThrows[Exception] {
      val rgbImage = RGBImage(pixels)
    }
  }

  test("Valid RGB image4x3") {
    val pixels = Seq(
      Seq(RGBPixel(new Color(255, 0, 0)), RGBPixel(new Color(0, 255, 0)), RGBPixel(new Color(0, 0, 255)), RGBPixel(new Color(41, 255, 10))),
      Seq(RGBPixel(new Color(0, 0, 0)), RGBPixel(new Color(100, 54, 55)), RGBPixel(new Color(59, 0, 47)), RGBPixel(new Color(78, 59, 255))),
      Seq(RGBPixel(new Color(255, 255, 255)), RGBPixel(new Color(255, 255, 0)), RGBPixel(new Color(255, 0, 255)), RGBPixel(new Color(0, 255, 255))
      ))
    val rgbImage = RGBImage(pixels)
    
    assert(rgbImage.getWidth == 4)
    assert(rgbImage.getHeight == 3)
    assert(rgbImage.getPixel(0, 0).value == pixels(0)(0).value)
    assert(rgbImage.getPixel(1, 0).value == pixels(0)(1).value)
    assert(rgbImage.getPixel(2, 0).value == pixels(0)(2).value)
    assert(rgbImage.getPixel(3, 0).value == pixels(0)(3).value)
    assert(rgbImage.getPixel(0, 1).value == pixels(1)(0).value)
    assert(rgbImage.getPixel(1, 1).value == pixels(1)(1).value)
    assert(rgbImage.getPixel(2, 1).value == pixels(1)(2).value)
    assert(rgbImage.getPixel(3, 1).value == pixels(1)(3).value)
    assert(rgbImage.getPixel(0, 2).value == pixels(2)(0).value)
    assert(rgbImage.getPixel(1, 2).value == pixels(2)(1).value)
    assert(rgbImage.getPixel(2, 2).value == pixels(2)(2).value)
    assert(rgbImage.getPixel(3, 2).value == pixels(2)(3).value)
  }
}
