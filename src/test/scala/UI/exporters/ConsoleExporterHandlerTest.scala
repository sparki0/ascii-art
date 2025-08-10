package UI.exporters

import UI.argHandlers.exporter.ConsoleExporterHandler
import exporters.ConsoleExporter
import org.scalatest.funsuite.AnyFunSuite


class ConsoleExporterHandlerTest extends AnyFunSuite{
  test("No argument") {
    val handler = ConsoleExporterHandler()
    val args = Array[String]()
    val wrapper = handler.handle(args)

    assert(wrapper.exporter.isInstanceOf[ConsoleExporter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }
  
  test("Handler ignores argument") {
    val handler = ConsoleExporterHandler()
    val args = Array[String]("--args", "1")
    val wrapper = handler.handle(args)

    assert(wrapper.exporter.isInstanceOf[ConsoleExporter])
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
