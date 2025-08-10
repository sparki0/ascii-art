package converters.pixel

import charTables.CharTable
import converters.Converter
import data.pixels.{ASCIIPixel, GSPixel}

/**
 * Class for converting Grayscale pixel to ASCII pixel
 * @param charTable character table for converting grayscale pixel to ASCII pixel
 * */
class GStoASCIIPixelConverter(val charTable: CharTable) extends Converter[GSPixel, ASCIIPixel]{
  /**
   * Convert grayscale pixel to ASCII pixel
   * @param src Source grayscale pixel
   * @return Converted ASCII pixel
   * */
  override def convert(src: GSPixel): ASCIIPixel = {
    val index = (charTable.getTable().length - 1) * src.value / 255
    
    ASCIIPixel(charTable.getTable()(index))
  }
}
