package workflow

import UI.parsers.ConsoleParser
import charTables.{CustomCharTable, DefaultCharTable, NonLinearCharTable}
import exporters.{ConsoleExporter, TextFileExporter}
import filters.image.brightness.GSImage.GSBrightnessImageFilter
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import filters.image.invert.GSImage.GSInvertImageFilter
import filters.image.rotate.GSImage.GSRotateImageFilter
import filters.image.scale.GSImage.GSScaleImageFilter
import importers.image.fileRGBImageImporters.{JPGRGBImageImporter, PNGRGBImageImporter}
import importers.image.generatedRGBImageImporter.RandomRGBImageImporter
import org.scalatest.funsuite.AnyFunSuite

class AreCollectorTest extends AnyFunSuite {
  test("Add importer png") {
    val collector = new ArgCollector()
    val path = """assets/test/images/test3x1.png"""
    collector.addImporter(new PNGRGBImageImporter(path))

    assert(collector.getImporterOpt().get.isInstanceOf[PNGRGBImageImporter])
    assert(collector.getImporterOpt().get.asInstanceOf[PNGRGBImageImporter].path == path)
  }

  test("Add importer jpg") {
    val collector = new ArgCollector()
    val path = """assets/test/images/test3x1.jpg"""
    collector.addImporter(new JPGRGBImageImporter(path))

    assert(collector.getImporterOpt().get.isInstanceOf[JPGRGBImageImporter])
    assert(collector.getImporterOpt().get.asInstanceOf[JPGRGBImageImporter].path == path)
  }

  test("Add importer random") {
    val collector = new ArgCollector()
    collector.addImporter(new RandomRGBImageImporter())

    assert(collector.getImporterOpt().get.isInstanceOf[RandomRGBImageImporter])
  }

  test("Check more than one importer") {
    val collector = new ArgCollector()
    collector.addImporter(new RandomRGBImageImporter())
    val path = """assets/test/images/test3x1.jpg"""

    assertThrows[Exception] {
      collector.addImporter(new JPGRGBImageImporter(path))
    }
  }

  test("Add exporter console") {
    val collector = new ArgCollector()
    collector.addExporter(new ConsoleExporter())

    assert(collector.getExporters().length == 1)
    assert(collector.getExporters()(0).isInstanceOf[ConsoleExporter])
  }

  test("Add exporter text file") {
    val collector = new ArgCollector()
    val path = """assets/test/outputs/arg_collector_export1.txt"""
    collector.addExporter(new TextFileExporter(path))

    assert(collector.getExporters().length == 1)
    assert(collector.getExporters()(0).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(0).asInstanceOf[TextFileExporter].path == path)
  }

  test("Add grayscale brightness filter"){
    val collector = new ArgCollector()
    val brightness = 50
    collector.addFilter(new GSBrightnessImageFilter(brightness))

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSBrightnessImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSBrightnessImageFilter].brightness == brightness)
  }

  test("Add grayscale flip X filter") {
    val collector = new ArgCollector()
    collector.addFilter(new GSFlipXImageFilter())

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSFlipXImageFilter])
  }

  test("Add grayscale flip Y filter") {
    val collector = new ArgCollector()
    collector.addFilter(new GSFlipYImageFilter())

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSFlipYImageFilter])
  }

  test("Add grayscale invert filter") {
    val collector = new ArgCollector()
    collector.addFilter(new GSInvertImageFilter())

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSInvertImageFilter])
  }

  test("Add grayscale rotate filter") {
    val collector = new ArgCollector()
    val degree = 90
    collector.addFilter(new GSRotateImageFilter(degree))

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSRotateImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSRotateImageFilter].degree == degree)
  }

  test("Add grayscale scale filter") {
    val collector = new ArgCollector()
    val scale = 1
    collector.addFilter(new GSScaleImageFilter(scale))

    assert(collector.getGSImageFilters().length == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSScaleImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSScaleImageFilter].scale == scale)
  }

  test("Add charTable default") {
    val collector = new ArgCollector()
    collector.addCharTable(new DefaultCharTable())

    assert(collector.getCharTableOpt().get.isInstanceOf[DefaultCharTable])
  }

  test("Add charTable NonLinear") {
    val collector = new ArgCollector()
    collector.addCharTable(new NonLinearCharTable())

    assert(collector.getCharTableOpt().get.isInstanceOf[NonLinearCharTable])
  }

  test("Add charTable userCharTable") {
    val collector = new ArgCollector()
    val table = "123456789"
    collector.addCharTable(new CustomCharTable(table))

    assert(collector.getCharTableOpt().get.isInstanceOf[CustomCharTable])
    assert(collector.getCharTableOpt().get.asInstanceOf[CustomCharTable].getTable() == table)
  }

  test("Add more than one charTable") {
    val collector = new ArgCollector()
    collector.addCharTable(new DefaultCharTable())

    assert(collector.getCharTableOpt().get.isInstanceOf[DefaultCharTable])
    assertThrows[Exception] {
      assert(collector.getCharTableOpt().get.isInstanceOf[NonLinearCharTable])
    }
  }

  test("Add console exporter"){
    val collector = new ArgCollector()
    collector.addExporter(new ConsoleExporter())

    assert(collector.getExporters().length == 1)
    assert(collector.getExporters()(0).isInstanceOf[ConsoleExporter])
  }

  test("Add text file exporter") {
    val collector = new ArgCollector()
    val path = """assets/test/outputs/arg_collector_export2.txt"""
    collector.addExporter(new TextFileExporter(path))

    assert(collector.getExporters().length == 1)
    assert(collector.getExporters()(0).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(0).asInstanceOf[TextFileExporter].path == path)
  }

  test("Add multiple file exporter") {
    val collector = new ArgCollector()
    val path = """assets/test/outputs/arg_collector_export3.txt"""
    collector.addExporter(new TextFileExporter(path))
    collector.addExporter(new ConsoleExporter())

    assert(collector.getExporters().length == 2)
    assert(collector.getExporters()(0).isInstanceOf[TextFileExporter])
    assert(collector.getExporters()(0).asInstanceOf[TextFileExporter].path == path)
    assert(collector.getExporters()(1).isInstanceOf[ConsoleExporter])
  }

  test("Add multiple arguments") {
    val collector = new ArgCollector()
    val imagePath = """assets/test/images/test3x1.png"""
    val outputPath = """assets/test/outputs/arg_collector_test4.txt"""
    val degree = 90
    val brightness = 52
    val scale = 0.25
    val customTable = "123456789"
    collector.addImporter(new PNGRGBImageImporter(imagePath))
    collector.addCharTable(new CustomCharTable(customTable))
    collector.addFilter(new GSRotateImageFilter(degree))
    collector.addFilter(new GSScaleImageFilter(scale))
    collector.addFilter(new GSBrightnessImageFilter(brightness))
    collector.addFilter(new GSInvertImageFilter())
    collector.addFilter(new GSFlipXImageFilter())
    collector.addFilter(new GSFlipYImageFilter())
    collector.addExporter(new ConsoleExporter())
    collector.addExporter(new TextFileExporter(outputPath))

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
