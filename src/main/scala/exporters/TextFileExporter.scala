package exporters

import java.io.PrintWriter

/**
 * Class for exporting string to text file
 * @param path The file path where the text will be written
 * */
class TextFileExporter(val path: String) extends Exporter[String] {

  /**
   * Writes text to file
   * @param value Text need to be written
   * @throws Exception If output file is invalid
   * */
  override def write(value: String): Unit = {
    val writer = new PrintWriter(path)
    try{
      writer.write(value)
    }
    catch {
      case _ : Exception => throw new Exception("Invalid output file")
    }
    finally{
      writer.close()
    }
  }
}
