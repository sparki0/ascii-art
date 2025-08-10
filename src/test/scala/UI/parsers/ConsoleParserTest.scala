package UI.parsers

import UI.argHandlers.charTable.CustomCharTableHandler
import UI.config.ArgNames
import UI.parsers.ConsoleParser
import charTables.{CustomCharTable, DefaultCharTable, NonLinearCharTable}
import exporters.{ConsoleExporter, TextFileExporter}
import filters.image.brightness.GSImage.GSBrightnessImageFilter
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import filters.image.invert.GSImage.GSInvertImageFilter
import filters.image.rotate.GSImage.GSRotateImageFilter
import filters.image.scale.GSImage.GSScaleImageFilter
import importers.image.fileRGBImageImporters.PNGRGBImageImporter
import importers.image.generatedRGBImageImporter.RandomRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite
import workflow.ArgCollector

class ConsoleParserTest extends AnyFunSuite{
  test("Image png argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path = """assets/test/images/test3x1.png"""
    val args = Array[String](ArgNames.Image.name, path)
    parser.parse(args)

    assert(collector.getImporterOpt().get.isInstanceOf[PNGRGBImageImporter])
    assert(collector.getImporterOpt().get.asInstanceOf[PNGRGBImageImporter].path == path)
  }

  test("Image jpg argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path = """assets/test/images/test3x1.png"""
    val args = Array[String](ArgNames.Image.name, path)
    parser.parse(args)

    assert(collector.getImporterOpt().get.isInstanceOf[PNGRGBImageImporter])
    assert(collector.getImporterOpt().get.asInstanceOf[PNGRGBImageImporter].path == path)
  }
  
  test("Image argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Image.name)
    
    assertThrows[Exception]{
      parser.parse(args)
    }
  }
  
  test("Image argument unsupported file") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path = """assets/test/images/unsupported.bmp"""
    val args = Array[String](ArgNames.Image.name, path)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Image random argument") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.ImageRandom.name)
    parser.parse(args)

    assert(collector.getImporterOpt().get.isInstanceOf[RandomRGBImageImporter])
  }

  test("Multiple importers (invalid)") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path = """assets/test/images/test3x1.jpg"""
    val args = Array[String](
      ArgNames.ImageRandom.name,
      ArgNames.Image.name, path)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Table argument default") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Table.name, "default")
    parser.parse(args)

    assert(collector.getCharTableOpt().get.isInstanceOf[DefaultCharTable])
  }

  test("Table argument non-linear") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Table.name, "non-linear")
    parser.parse(args)

    assert(collector.getCharTableOpt().get.isInstanceOf[NonLinearCharTable])
  }

  test("Table argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Table.name)
    
    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Table argument invalid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Table.name, "hmm")

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("CustomTable argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val table = "123456789"
    val args = Array[String](ArgNames.CustomTable.name, table)
    parser.parse(args)

    assert(collector.getCharTableOpt().get.isInstanceOf[CustomCharTable])
    assert(collector.getCharTableOpt().get.asInstanceOf[CustomCharTable].getTable() == table)
  }

  test("CustomTable argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.CustomTable.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Multiple table (invalid)") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](
      ArgNames.Table.name, "default",
      ArgNames.CustomTable.name, "123"
    )

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Brightness argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val brightnessValue = 52
    val args = Array[String](ArgNames.Brightness.name, brightnessValue.toString)
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSBrightnessImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSBrightnessImageFilter].brightness == brightnessValue)
  }

  test("Brightness argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Brightness.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Brightness argument invalid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Brightness.name, "haha")

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Invert argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Invert.name)
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSInvertImageFilter])
  }

  test("Rotate argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val degree = 180
    val args = Array[String](ArgNames.Rotate.name, degree.toString)
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSRotateImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSRotateImageFilter].degree == degree)
  }

  test("Rotate argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Rotate.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Rotate argument invalid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Rotate.name, "invalid")

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Scale argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val value = 0.25
    val args = Array[String](ArgNames.Scale.name, value.toString)
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSScaleImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSScaleImageFilter].scale == value)
  }

  test("Scale argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Scale.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Scale argument invalid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Scale.name, "invalid")

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Flip X argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Flip.name, "X")
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSFlipXImageFilter])
  }

  test("Flip Y argument valid") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Flip.name, "Y")
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSFlipYImageFilter])
  }

  test("Flip argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Flip.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Flip invalid argument") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.Flip.name, "---")

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Multiple filters") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val degree = 90
    val brightness = 52
    val scale = 0.25
    val args = Array[String](
      ArgNames.Rotate.name, degree.toString,
      ArgNames.Scale.name, scale.toString,
      ArgNames.Brightness.name, brightness.toString,
      ArgNames.Invert.name,
      ArgNames.Flip.name, "X",
      ArgNames.Flip.name, "Y",
    )
    parser.parse(args)

    assert(collector.getGSImageFilters()(0).isInstanceOf[GSRotateImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(collector.getGSImageFilters()(1).isInstanceOf[GSScaleImageFilter])
    assert(collector.getGSImageFilters()(1).asInstanceOf[GSScaleImageFilter].scale == scale)
    assert(collector.getGSImageFilters()(2).isInstanceOf[GSBrightnessImageFilter])
    assert(collector.getGSImageFilters()(2).asInstanceOf[GSBrightnessImageFilter].brightness == brightness)
    assert(collector.getGSImageFilters()(3).isInstanceOf[GSInvertImageFilter])
    assert(collector.getGSImageFilters()(4).isInstanceOf[GSFlipXImageFilter])
    assert(collector.getGSImageFilters()(5).isInstanceOf[GSFlipYImageFilter])
  }

  test("Output-file argument") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path = """assets/outputs/parser_export_test1.txt"""
    val args = Array[String](ArgNames.OutputFile.name, path)
    parser.parse(args)

    assert(collector.getExporters()(0).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(0).asInstanceOf[TextFileExporter].path == path)
  }

  test("Output-file argument missing") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.OutputFile.name)

    assertThrows[Exception] {
      parser.parse(args)
    }
  }

  test("Output-console argument") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val args = Array[String](ArgNames.OutputConsole.name)
    parser.parse(args)

    assert(collector.getExporters()(0).isInstanceOf[ConsoleExporter])
  }

  test("Multiple exporter") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val path1 = """assets/test/outputs/output-file1.txt"""
    val path2 = """assets/test/outputs/output-file2.txt"""
    val args = Array[String](
      ArgNames.OutputConsole.name,
      ArgNames.OutputFile.name, path1,
      ArgNames.OutputFile.name, path2
    )
    parser.parse(args)

    assert(collector.getExporters()(0).isInstanceOf[ConsoleExporter])
    assert(collector.getExporters()(1).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(1).asInstanceOf[TextFileExporter].path == path1)
    assert(collector.getExporters()(2).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(2).asInstanceOf[TextFileExporter].path == path2)
  }

  test("Multiple arguments") {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    val imagePath = """assets/test/images/test3x1.png"""
    val outputPath = """assets/outputs/parser_export_test2.txt"""
    val degree = 90
    val brightness = 52
    val scale = 0.25
    val customTable = "123456789"
    val args = Array[String](
      ArgNames.Image.name, imagePath,
      ArgNames.CustomTable.name, customTable,
      ArgNames.Rotate.name, degree.toString,
      ArgNames.Scale.name, scale.toString,
      ArgNames.Brightness.name, brightness.toString,
      ArgNames.Invert.name,
      ArgNames.Flip.name, "X",
      ArgNames.Flip.name, "Y",
      ArgNames.OutputConsole.name,
      ArgNames.OutputFile.name, outputPath
    )

    parser.parse(args)

    assert(collector.getImporterOpt().get.isInstanceOf[PNGRGBImageImporter])
    assert(collector.getCharTableOpt().get.isInstanceOf[CustomCharTable])
    assert(collector.getCharTableOpt().get.asInstanceOf[CustomCharTable].getTable() == customTable)
    assert(collector.getGSImageFilters().length == 6)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSRotateImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(collector.getGSImageFilters()(1).isInstanceOf[GSScaleImageFilter])
    assert(collector.getGSImageFilters()(1).asInstanceOf[GSScaleImageFilter].scale == scale)
    assert(collector.getGSImageFilters()(2).isInstanceOf[GSBrightnessImageFilter])
    assert(collector.getGSImageFilters()(2).asInstanceOf[GSBrightnessImageFilter].brightness == brightness)
    assert(collector.getGSImageFilters()(3).isInstanceOf[GSInvertImageFilter])
    assert(collector.getGSImageFilters()(4).isInstanceOf[GSFlipXImageFilter])
    assert(collector.getGSImageFilters()(5).isInstanceOf[GSFlipYImageFilter])
    assert(collector.getExporters().length == 2)
    assert(collector.getExporters()(0).isInstanceOf[ConsoleExporter])
    assert(collector.getExporters()(1).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(1).asInstanceOf[TextFileExporter].path == outputPath)
  }
}
