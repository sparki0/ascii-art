package workflow

import charTables.DefaultCharTable
import exporters.{ConsoleExporter, TextFileExporter}
import filters.image.brightness.GSImage.GSBrightnessImageFilter
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import filters.image.invert.GSImage.GSInvertImageFilter
import filters.image.rotate.GSImage.GSRotateImageFilter
import filters.image.scale.GSImage.GSScaleImageFilter
import importers.image.fileRGBImageImporters.PNGRGBImageImporter
import importers.image.generatedRGBImageImporter.RandomRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite

import java.awt.Color
import scala.io.Source

class ArgExecutorTest extends AnyFunSuite {
  private def toGSPixelValue(value: Color): Int =
    ((0.3 * value.getRed) + (0.59 * value.getGreen) + (0.11 * value.getBlue)).toInt

  private def toASCIIChar(value: Int, table: String): Char = {
    val index = (table.length - 1) * value / 255
    table(index)
  }

  test("Multiple arguments") {
    val collector = new ArgCollector()
    val outputPath = """assets/test/outputs/arg_executor_expert_test1.txt"""
    collector.addImporter(new PNGRGBImageImporter("""assets/test/images/test2x2.png"""))
    collector.addCharTable(new DefaultCharTable())
    collector.addFilter(new GSBrightnessImageFilter(50))
    collector.addFilter(new GSScaleImageFilter(1))
    collector.addFilter(new GSFlipXImageFilter())
    collector.addFilter(new GSFlipYImageFilter())
    collector.addFilter(new GSInvertImageFilter())
    collector.addFilter(new GSRotateImageFilter(90))
    collector.addExporter(new ConsoleExporter())
    collector.addExporter(new TextFileExporter(outputPath))
    val argExecutor = new ArgExecutor(collector)
    val table = new DefaultCharTable().getTable()

    var check = Seq(
      Seq(new Color(255,0,0), new Color(0,255,0)),
      Seq(new Color(0,0,255), new Color(255,255,0))
    ).map(row => row.map(c => toGSPixelValue(c) + 50))
      .map(row => row.map(c => 255 - c))
      .map(row => row.map(c => toASCIIChar(c, table)))
    check = Seq(
      Seq(check(0)(1), check(0)(0)),
      Seq(check(1)(1), check(1)(0))
    )
    check = Seq(
      Seq(check(1)(0), check(1)(1)),
      Seq(check(0)(0), check(0)(1))
    )
    check = Seq(
      Seq(check(1)(0), check(0)(0)),
      Seq(check(1)(1), check(0)(1))
    )

    argExecutor.execute()
    val fileReader = Source.fromFile(outputPath)
    val readContent = fileReader.mkString
    val stringTest = "" + check(0)(0) + check(0)(1) + '\n' + check(1)(0) + check(1)(1) + '\n'

    assert(readContent == stringTest)
  }

  test("No importers") {
    val collector = new ArgCollector()
    collector.addCharTable(new DefaultCharTable())
    collector.addFilter(new GSScaleImageFilter(1))
    collector.addExporter(new ConsoleExporter())
    val argExecutor = new ArgExecutor(collector)

    assertThrows[Exception] {
      argExecutor.execute()
    }
  }

  test("No charTable and no filters") {
    val collector = new ArgCollector()
    val outputPath = """assets/test/outputs/arg_executor_expert_test1.txt"""
    val table = new DefaultCharTable().getTable()
    collector.addImporter(new PNGRGBImageImporter("""assets/test/images/test2x2.png"""))
    collector.addExporter(new TextFileExporter(outputPath))
    val argExecutor = new ArgExecutor(collector)
    argExecutor.execute()
    var check = Seq(
      Seq(new Color(255, 0, 0), new Color(0, 255, 0)),
      Seq(new Color(0, 0, 255), new Color(255, 255, 0))
    ).map(row => row.map(c => toGSPixelValue(c)))
      .map(row => row.map(c => toASCIIChar(c, table)))

    val fileReader = Source.fromFile(outputPath)
    val readContent = fileReader.mkString
    val stringTest = "" + check(0)(0) + check(0)(1) + '\n' + check(1)(0) + check(1)(1) + '\n'

    assert(readContent == stringTest)
  }
}
