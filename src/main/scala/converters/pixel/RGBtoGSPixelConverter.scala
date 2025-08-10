package converters.pixel

import data.pixels.GSPixel
import data.pixels.RGBPixel
import converters.Converter

/**
 * Class for converting RGB pixel to grayscale pixel
 * */
class RGBtoGSPixelConverter extends Converter[RGBPixel, GSPixel]{
  /**
   * Convert RGB pixel to grayscale pixel
   * @param src Source RGB pixel
   * @return Converted grayscale pixel
   * */
  override def convert(src: RGBPixel): GSPixel = {
    val value = src.value
    val greyscale = ((0.3 * value.getRed) + (0.59 * value.getGreen) + (0.11 * value.getBlue)).toInt
    
    GSPixel(greyscale)
  }
}
