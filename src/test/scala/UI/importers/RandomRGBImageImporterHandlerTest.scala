package UI.importers

import UI.argHandlers.importer.RandomRGBImageImporterHandler
import importers.image.generatedRGBImageImporter.RandomRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite

class RandomRGBImageImporterHandlerTest extends AnyFunSuite{
  test("RandomRGBImporter check") {
    val handler = new RandomRGBImageImporterHandler()
    val args = Array[String]()
    val wrapper = handler.handle(args)

    assert(wrapper.importer.isInstanceOf[RandomRGBImageImporter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }
  
  test("Ignores arguments") {
    val handler = new RandomRGBImageImporterHandler()
    val args = Array[String]("--arg", "value")
    val wrapper = handler.handle(args)

    assert(wrapper.importer.isInstanceOf[RandomRGBImageImporter])
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
