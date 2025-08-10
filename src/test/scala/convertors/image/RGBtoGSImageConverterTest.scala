package convertors.image

import converters.image.RGBtoGSImageConverter
import data.images.RGBImage
import data.pixels.RGBPixel
import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color

class RGBtoGSImageConverterTest extends AnyFunSuite {
  private def toGSPixelValue(value: Color): Int =
    ((0.3 * value.getRed) + (0.59 * value.getGreen) + (0.11 * value.getBlue)).toInt

  test("RGB image4x3 to grayscale image") {
    val pixels = Seq(
      Seq(RGBPixel(new Color(255, 0, 0)), RGBPixel(new Color(0, 255, 0)), RGBPixel(new Color(0, 0, 255)), RGBPixel(new Color(41,255,10))),
      Seq(RGBPixel(new Color(0, 0, 0)), RGBPixel(new Color(100, 54, 55)), RGBPixel(new Color(59, 0, 47)), RGBPixel(new Color(78,59,255))),
      Seq(RGBPixel(new Color(255, 255, 255)), RGBPixel(new Color(255, 255, 0)), RGBPixel(new Color(255, 0, 255)), RGBPixel(new Color(0,255,255))
    ))
    val rgbImage = RGBImage(pixels)
    val gsImage = new RGBtoGSImageConverter().convert(rgbImage)
    val gsValuesCheck = pixels.map(row => row.map(v => v.value)).map(row => row.map(toGSPixelValue))

    assert(gsImage.getWidth == 4)
    assert(gsImage.getHeight == 3)
    assert(gsImage.getPixel(0,0).value == gsValuesCheck(0)(0))
    assert(gsImage.getPixel(1,0).value == gsValuesCheck(0)(1))
    assert(gsImage.getPixel(2,0).value == gsValuesCheck(0)(2))
    assert(gsImage.getPixel(3,0).value == gsValuesCheck(0)(3))
    assert(gsImage.getPixel(0,1).value == gsValuesCheck(1)(0))
    assert(gsImage.getPixel(1,1).value == gsValuesCheck(1)(1))
    assert(gsImage.getPixel(2,1).value == gsValuesCheck(1)(2))
    assert(gsImage.getPixel(3,1).value == gsValuesCheck(1)(3))
    assert(gsImage.getPixel(0, 2).value == gsValuesCheck(2)(0))
    assert(gsImage.getPixel(1, 2).value == gsValuesCheck(2)(1))
    assert(gsImage.getPixel(2, 2).value == gsValuesCheck(2)(2))
    assert(gsImage.getPixel(3, 2).value == gsValuesCheck(2)(3))
  }
}
