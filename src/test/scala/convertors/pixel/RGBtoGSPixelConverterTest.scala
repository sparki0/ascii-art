package convertors.pixel

import converters.pixel.RGBtoGSPixelConverter
import data.pixels.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color

class RGBtoGSPixelConverterTest extends AnyFunSuite {
  private def toGSPixelValue(value: Color): Int =
    ((0.3 * value.getRed) + (0.59 * value.getGreen) + (0.11 * value.getBlue)).toInt

  test("RGB pixel(0,0,0) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(0,0,0))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(255,0,0) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(255, 0, 0))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(0,255,0) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(0, 255, 0))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(0,0,255) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(0, 0, 255))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(255,255,55) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(255, 255, 255))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(255,255,0) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(255,255,0))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(255,0,255) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(255, 0, 255))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(0,255,255) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(0, 255, 255))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(147,42,145) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(147,42,145))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }

  test("RGB pixel(255,10,19) to grayscale pixel") {
    val rgbPixel = RGBPixel(new Color(255, 10, 19))
    val gsPixel = new RGBtoGSPixelConverter().convert(rgbPixel)
    val checkValue = toGSPixelValue(rgbPixel.value)

    assert(gsPixel.value == checkValue)
  }
}
