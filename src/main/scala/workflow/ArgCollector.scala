package workflow

import charTables.CharTable
import data.images.GSImage
import exporters.Exporter
import filters.Filter
import importers.image.RGBImageImporter

import scala.collection.mutable.ArrayBuffer

/**
 * Class for collecting argument
 * */

class ArgCollector {
  
  /**
   * Optional RGB image importer
   * */
  private var rgbImageImporter: Option[RGBImageImporter] = None
  
  /**
   * Collection of grayscale image filters
   * */
  private val gsImageFilters: ArrayBuffer[Filter[GSImage]] = ArrayBuffer.empty

  /**
   * Collection of string exporters
   * */
  private val exporters: ArrayBuffer[Exporter[String]] = ArrayBuffer.empty

  /**
   * Optional character table
   * */
  private var charTable: Option[CharTable] = None

  /**
   * Adds RGB image importer
   * @param importer RGB image importer
   * @throws Exception If trying to add importer, when one already is added
   * */
  def addImporter(importer: RGBImageImporter): Unit = {
    if(rgbImageImporter.nonEmpty)
      throw new Exception("Only one import must be provided")
    rgbImageImporter = Some(importer)
  }

  /**
   * Add grayscale image filter
   * @param filter Filter to add
   * */
  def addFilter(filter: Filter[GSImage]) : Unit = gsImageFilters += filter

  /**
   * Add string exporter
   * @param exporter Exporter to add
   * */
  def addExporter(exporter: Exporter[String]) : Unit = exporters += exporter

  /**
   * Add string exporter
   * @param table Character table to add
   * @throws Exception If trying to add character table, when one already is added
   * */
  def addCharTable(table: CharTable): Unit = {
    if (charTable.nonEmpty)
      throw new Exception("Only one char table must be provided")
    charTable = Some(table)
  }

  /**
   * @return Option RGB image importer
   * */
  def getImporterOpt() : Option[RGBImageImporter] = rgbImageImporter

  /**
   * @return Collection of grayscale image filter
   * */
  def getGSImageFilters() : ArrayBuffer[Filter[GSImage]] = gsImageFilters

  /**
   * @return Collection of string exporter
   * */
  def getExporters(): ArrayBuffer[Exporter[String]] = exporters

  /**
   * @return Option character table
   * */
  def getCharTableOpt(): Option[CharTable] = charTable
}
