package exporters

import exporters.TextFileExporter
import org.scalatest.funsuite.AnyFunSuite

import scala.io.Source

class TextFileExporterTest extends AnyFunSuite {
  test("Valid path") {
    val contentToWrite = "Some content123"
    val path = """assets/test/outputs/export_test.txt"""
    val textFileExporter = new TextFileExporter(path)
    textFileExporter.write(contentToWrite)

    val fileReader = Source.fromFile(path)
    val readContent = fileReader.mkString
    fileReader.close()

    assert(contentToWrite == readContent)
  }

  test("Invalid path") {
    val contentToWrite = "Some content"
    val path = """assets/invalid_path/export_test.txt"""
    val textFileExporter = new TextFileExporter(path)
    assertThrows[Exception] {
      textFileExporter.write(contentToWrite)
    }
  }
}

