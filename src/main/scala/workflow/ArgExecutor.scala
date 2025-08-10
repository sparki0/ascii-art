package workflow

import charTables.{CharTable, DefaultCharTable}
import converters.image.{GStoASCIIImageConverter, RGBtoGSImageConverter}
import converters.text.ASCIItoTextConverter
import data.images.{GSImage, RGBImage}
import exporters.ConsoleExporter

/**
 * Class for executing arguments
 * @param collector That contains all argument to execute
 * */
class ArgExecutor(collector: ArgCollector) {
  
  /**
   * Executes arguments
   * */
  def execute(): Unit = {
    val rgbImage = loadImage()
    var gsImage = new RGBtoGSImageConverter().convert(rgbImage)

    val charTable = getCharTable()
    gsImage = applyFilters(gsImage)
    val asciiImage = new GStoASCIIImageConverter(charTable).convert(gsImage)
    val textImage = new ASCIItoTextConverter().convert(asciiImage)

    exportImage(textImage)
  }

  /**
   * Imports RGB image
   * @return Imported RGB image
   * @throws Exception If no importer was provided
   * */
  private def loadImage() : RGBImage =  {
    val importerOpt = collector.getImporterOpt()
    if(importerOpt.isEmpty)
      throw new Exception("No image was provided")

    importerOpt.get.load()
  }

  /**
   * Applies grayscale filters
   * @return Filtered grayscale image
   * */
  private def applyFilters(image: GSImage) : GSImage = {
    var filteredImage = image
    for(f <- collector.getGSImageFilters())
      filteredImage = f.apply(filteredImage)

    filteredImage
  }

  /**
   * Gets character table, if no was provided, then default character table selected
   * @return Character table
   * */
  private def getCharTable(): CharTable = {
    var charTable = collector.getCharTableOpt()
    if (charTable.isEmpty)
      charTable = Some(new DefaultCharTable())

    charTable.get
  }

  /**
   * Exports string, if no exporter provided, console exporter selected
   * @param imageText ASCII image represented in string
   * */
  private def exportImage(imageText: String) : Unit = {
    val exporters = collector.getExporters()
    if(exporters.isEmpty)
      exporters += new ConsoleExporter()

    for(e <- exporters)
      e.write(imageText)

  }

}
