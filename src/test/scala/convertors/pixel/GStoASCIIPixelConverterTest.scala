package convertors.pixel

import charTables.CustomCharTable
import converters.pixel.GStoASCIIPixelConverter
import data.pixels.GSPixel
import org.scalatest.funsuite.AnyFunSuite

class GStoASCIIPixelConverterTest extends AnyFunSuite {
  private val table = "123456"
  private val charTable = new CustomCharTable(table)
  private def toASCIIChar(value: Int): Char = {
    val index = (table.length - 1) * value / 255
    table(index)
  }

  test("Grayscale pixel 0 toASCII pixel") {
    val gsPixel = GSPixel(0)
    val asciiPixel = new GStoASCIIPixelConverter(charTable).convert(gsPixel)
    val valueCheck = toASCIIChar(gsPixel.value)

    assert(asciiPixel.value == valueCheck)
  }

  test("Grayscale pixel 255 toASCII pixel") {
    val gsPixel = GSPixel(255)
    val asciiPixel = new GStoASCIIPixelConverter(charTable).convert(gsPixel)
    val valueCheck = toASCIIChar(gsPixel.value)

    assert(asciiPixel.value == valueCheck)
  }

  test("Grayscale pixel 100 toASCII pixel") {
    val gsPixel = GSPixel(100)
    val asciiPixel = new GStoASCIIPixelConverter(charTable).convert(gsPixel)
    val valueCheck = toASCIIChar(gsPixel.value)

    assert(asciiPixel.value == valueCheck)
  }

  test("Grayscale pixel 202 toASCII pixel") {
    val gsPixel = GSPixel(202)
    val asciiPixel = new GStoASCIIPixelConverter(charTable).convert(gsPixel)
    val valueCheck = toASCIIChar(gsPixel.value)

    assert(asciiPixel.value == valueCheck)
  }

  test("Grayscale pixel 21 toASCII pixel") {
    val gsPixel = GSPixel(21)
    val asciiPixel = new GStoASCIIPixelConverter(charTable).convert(gsPixel)
    val valueCheck = toASCIIChar(gsPixel.value)

    assert(asciiPixel.value == valueCheck)
  }

}
