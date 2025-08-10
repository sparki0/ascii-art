package UI.exporters

import UI.argHandlers.exporter.TextFileExporterHandler
import exporters.TextFileExporter
import org.scalatest.funsuite.AnyFunSuite

class TextFileExporterHandlerTest extends AnyFunSuite{
  test("No argument provided") {
    val handler = TextFileExporterHandler()
    val args = Array[String]()

    assertThrows[Exception] {
      val wrapper = handler.handle(args)
    }
  }

  test("One argument") {
    val handler = TextFileExporterHandler()
    val path = """assets/outputs/ui_test_export.txt"""
    val args = Array[String](path)
    val wrapper = handler.handle(args)

    assert(wrapper.exporter.isInstanceOf[TextFileExporter])
    assert(wrapper.exporter.asInstanceOf[TextFileExporter].path == path)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = TextFileExporterHandler()
    val path = """assets/outputs/ui_test_export.txt"""
    val args = Array[String](path, "--args", "value")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.exporter.isInstanceOf[TextFileExporter])
    assert(wrapper.exporter.asInstanceOf[TextFileExporter].path == path)
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
  }
}
