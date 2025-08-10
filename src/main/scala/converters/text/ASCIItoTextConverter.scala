package converters.text

import converters.Converter
import data.images.{ASCIIImage, Image}
import data.pixels.ASCIIPixel

/**
 * Class for converting ASCII image to text
 * */
class ASCIItoTextConverter extends Converter[ASCIIImage, String]{
  /**
   * Convert ASCII image to string
   * @param src Source ASCII image
   * @return String representing ASCII image
   * */
  override def convert(src: ASCIIImage): String = {
    var res = ""
    for(h <- 0 until src.getHeight) {
      var row = ""
      for(w <- 0 until src.getWidth) {
        row += src.getPixel(w, h).value
      }
      res += row + "\n"
    }
    
    res
  }
}