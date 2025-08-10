package UI.importers

import UI.argHandlers.importer.FileRGBImageImporterHandler
import importers.image.fileRGBImageImporters.{JPGRGBImageImporter, PNGRGBImageImporter}
import org.scalatest.funsuite.AnyFunSuite

class FileRGBImageImporterHandlerTest extends AnyFunSuite{
  test("Not supported extension") {
    val handler = new FileRGBImageImporterHandler()
    val path = """assets/images/unsupported.bmp"""
    val args = Array[String](path)

    assertThrows[Exception] {
      handler.handle(args)
    }
  }

  test("No argument provided") {
    val handler = new FileRGBImageImporterHandler()
    val args = Array[String]()

    assertThrows[Exception] {
      handler.handle(args)
    }
  }


  test("Importer PNG handle") {
    val handler = new FileRGBImageImporterHandler()
    val path = """assets/images/test3x1.png"""
    val args = Array[String](path)
    val wrapper = handler.handle(args)

    assert(wrapper.importer.isInstanceOf[PNGRGBImageImporter])
    assert(wrapper.importer.asInstanceOf[PNGRGBImageImporter].path == path)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Importer JPG handle") {
    val handler = new FileRGBImageImporterHandler()
    val path = """assets/images/test3x1.jpg"""
    val args = Array[String](path)
    val wrapper = handler.handle(args)

    assert(wrapper.importer.isInstanceOf[JPGRGBImageImporter])
    assert(wrapper.importer.asInstanceOf[JPGRGBImageImporter].path == path)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = new FileRGBImageImporterHandler()
    val path = """assets/images/test3x1.png"""
    val args = Array[String](path, "--arg", "value")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.importer.isInstanceOf[PNGRGBImageImporter])
    assert(wrapper.importer.asInstanceOf[PNGRGBImageImporter].path == path)
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
  }
}
