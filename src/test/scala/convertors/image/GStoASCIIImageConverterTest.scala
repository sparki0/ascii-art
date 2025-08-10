package convertors.image

import charTables.CustomCharTable
import converters.image.GStoASCIIImageConverter
import data.images.GSImage
import data.pixels.{ASCIIPixel, GSPixel}
import org.scalatest.funsuite.AnyFunSuite

class GStoASCIIImageConverterTest extends AnyFunSuite {
  private val table = "123456"
  private val charTable = new CustomCharTable(table)
  private def toASCIIChar(value: Int): Char = {
    val index = (table.length - 1) * value / 255
    table(index)
  }

  test("Grayscale image4x3 to ASCII image") {
    val pixels = Seq(
      Seq(GSPixel(0), GSPixel(255), GSPixel(10), GSPixel(59)),
      Seq(GSPixel(100), GSPixel(150), GSPixel(70), GSPixel(205)),
      Seq(GSPixel(15), GSPixel(21), GSPixel(4), GSPixel(33))
    )
    val gsImage = GSImage(pixels)
    val asciiImage = new GStoASCIIImageConverter(charTable).convert(gsImage)
    val asciiCheckValues = pixels.map(row => row.map(v => v.value)).map(row => row.map(toASCIIChar))

    assert(asciiImage.getWidth == 4)
    assert(asciiImage.getHeight == 3)
    assert(asciiImage.getPixel(0,0).value == asciiCheckValues(0)(0))
    assert(asciiImage.getPixel(1,0).value == asciiCheckValues(0)(1))
    assert(asciiImage.getPixel(2,0).value == asciiCheckValues(0)(2))
    assert(asciiImage.getPixel(3,0).value == asciiCheckValues(0)(3))
    assert(asciiImage.getPixel(0,1).value == asciiCheckValues(1)(0))
    assert(asciiImage.getPixel(1,1).value == asciiCheckValues(1)(1))
    assert(asciiImage.getPixel(2,1).value == asciiCheckValues(1)(2))
    assert(asciiImage.getPixel(3,1).value == asciiCheckValues(1)(3))
    assert(asciiImage.getPixel(0,2).value == asciiCheckValues(2)(0))
    assert(asciiImage.getPixel(1,2).value == asciiCheckValues(2)(1))
    assert(asciiImage.getPixel(2,2).value == asciiCheckValues(2)(2))
    assert(asciiImage.getPixel(3,2).value == asciiCheckValues(2)(3))
  }
  
}
