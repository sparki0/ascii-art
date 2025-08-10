package convertors.text

import converters.text.ASCIItoTextConverter
import data.images.ASCIIImage
import data.pixels.ASCIIPixel
import org.scalatest.funsuite.AnyFunSuite

class ASCIItoTextConverterTest extends AnyFunSuite {
  test("ASCII image6x2 to text test") {
    val pixels = Seq(
      Seq(ASCIIPixel('H'), ASCIIPixel('e'), ASCIIPixel('l'),ASCIIPixel('l'),ASCIIPixel('o'), ASCIIPixel(',')),
      Seq(ASCIIPixel(' '),ASCIIPixel('W'),ASCIIPixel('o'),ASCIIPixel('r'),ASCIIPixel('l'),ASCIIPixel('d'))
    )
    val asciiImage = ASCIIImage(pixels)
    val text = new ASCIItoTextConverter().convert(asciiImage)
    val textCheck = "Hello,\n World\n"

    assert(text == textCheck)
  }
}
