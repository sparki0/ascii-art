package UI.wrappers
import importers.image.RGBImageImporter
import workflow.ArgCollector

/**
 * Class for wrapping RGB image importer and remaining arguments
 * @param importer RGB image importer to add
 * @param remainingArgs Remaining arguments after handling
 * */
case class RGBImageImporterWrapper(importer: RGBImageImporter, protected val remainingArgs: Array[String])
  extends Wrapper[Array[String]] {

  /**
   * Add importer to collector
   * @param collector Collector to which importer is added
   * */
  override def addToCollector(collector: ArgCollector): Unit =
    collector.addImporter(importer)
}
