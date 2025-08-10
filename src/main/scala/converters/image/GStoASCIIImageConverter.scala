package converters.image

import charTables.CharTable
import converters.Converter
import converters.image.utils.UtilImageConverter
import converters.pixel.GStoASCIIPixelConverter
import data.images.{ASCIIImage, GSImage, Image}
import data.pixels.{ASCIIPixel, GSPixel}

/**
 * Class for converting Grayscale image to ASCII image
 * @param charTable character table for converting Grayscale image to ASCII image
 * */
class GStoASCIIImageConverter (val charTable: CharTable) extends Converter[GSImage, ASCIIImage] {
  /**
   * Convert grayscale image to ASCII image
   * @param src Source grayscale image
   * @return Converted ASCII image 
   * */
  override def convert(src: GSImage): ASCIIImage = {
    val pixelConverter = new GStoASCIIPixelConverter(charTable)
    val imageSeq = new UtilImageConverter[GSPixel, ASCIIPixel, GSImage](pixelConverter).convert(src)
    
    ASCIIImage(imageSeq)
  }
}