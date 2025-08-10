package UI.wrappers

import exporters.{ConsoleExporter, TextFileExporter}
import org.scalatest.funsuite.AnyFunSuite
import workflow.ArgCollector

class ExporterWrapperTest extends AnyFunSuite {
  test("Check") {
    val args = Array[String]("--args", "value")
    val path = """assets/test/outputs/exporter_wrapper_test.txt"""
    val wrapper = ExporterWrapper(new TextFileExporter(path), args)
    val collector = new ArgCollector()
    wrapper.addToCollector(collector)

    assert(collector.getExporters().size == 1)
    assert(collector.getExporters()(0).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(0).asInstanceOf[TextFileExporter].path == path)
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
