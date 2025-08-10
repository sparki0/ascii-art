package exporters

/**
 * Class for exporting text to console
 * */
class ConsoleExporter extends Exporter[String] {
  /**
   * Write text to console
   * @param value text need to be written
   * */
  override def write(value: String): Unit = println(value)
}
