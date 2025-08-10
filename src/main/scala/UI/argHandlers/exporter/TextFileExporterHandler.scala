package UI.argHandlers.exporter

import UI.argHandlers.ArgHandler
import UI.wrappers.ExporterWrapper
import exporters.TextFileExporter

/**
 * Class for handling text file export argument
 **/
class TextFileExporterHandler extends ArgHandler[Array[String], ExporterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing text file exporter and remaining arguments
   * @throws Exception If there are no arguments
   * */
  override def handle(args: Array[String]): ExporterWrapper = {
    if (args.isEmpty)
      throw new Exception("No file provided for export")
    
    val path = args(0)
    ExporterWrapper(new TextFileExporter(path), args.drop(1))
  }
}
