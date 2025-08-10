package UI.wrappers

import importers.image.fileRGBImageImporters.PNGRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite
import workflow.ArgCollector

class RGBImageImporterWrapperTest extends AnyFunSuite {
  test("Check") {
    val args = Array[String]("--args", "value")
    val path = """assets/test/images/test2x2.png"""
    val wrapper = RGBImageImporterWrapper(new PNGRGBImageImporter(path), args)
    val collector = new ArgCollector()
    wrapper.addToCollector(collector)
    
    assert(collector.getImporterOpt().get.isInstanceOf[PNGRGBImageImporter])
    assert(collector.getImporterOpt().get.asInstanceOf[PNGRGBImageImporter].path == path)
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
