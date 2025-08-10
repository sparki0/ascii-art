package UI.argHandlers.exporter

import UI.argHandlers.ArgHandler
import UI.wrappers.ExporterWrapper
import exporters.ConsoleExporter

/**
 * Class for handling console export argument
 **/
class ConsoleExporterHandler extends ArgHandler[Array[String], ExporterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing console exporter and remaining arguments
   * */
  override def handle(args: Array[String]): ExporterWrapper =
    ExporterWrapper(new ConsoleExporter(), args)
}
