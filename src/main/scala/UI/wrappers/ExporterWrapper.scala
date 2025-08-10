package UI.wrappers

import exporters.Exporter
import workflow.ArgCollector

/**
 * Class for wrapping exporter and remaining arguments
 * @param exporter Image exporter add
 * @param remainingArgs Remaining arguments after handling
 * */
case class ExporterWrapper(exporter: Exporter[String], protected val remainingArgs: Array[String]) extends Wrapper[Array[String]] {

  /**
   * Add exporter to collector
   * @param collector Collector to which exporter is added
   * */
  override def addToCollector(collector: ArgCollector): Unit = 
    collector.addExporter(exporter)
}
