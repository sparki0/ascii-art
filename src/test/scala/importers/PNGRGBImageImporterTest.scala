package importers

import importers.image.fileRGBImageImporters.PNGRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color

class PNGRGBImageImporterTest extends AnyFunSuite{
  test("Loading incorrect extension") {
    val path = """assets/test/images/test3x1.jpg"""
    val importer = new PNGRGBImageImporter(path)
    
    assertThrows[Exception]{
      val image = importer.load()
    }
  }

  test("Valid png3x1 load") {
    val path = """assets/test/images/test3x1.png"""
    val importer = new PNGRGBImageImporter(path)
    val image = importer.load()

    assert(image.getHeight == 1)
    assert(image.getWidth == 3)

    assert(image.getPixel(0,0).value == new Color(255,0,0))
    assert(image.getPixel(1,0).value == new Color(0,255,0))
    assert(image.getPixel(2,0).value == new Color(0,0,255))
  }
}
