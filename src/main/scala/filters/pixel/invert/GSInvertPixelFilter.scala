package filters.pixel.invert

import data.pixels.GSPixel
import filters.Filter

/**
 * Class for invertering grayscale pixel
 * */
class GSInvertPixelFilter extends Filter[GSPixel]{
  /**
   * Grayscale pixel maximum value
   * */
  private val WhiteValue = 255
  
  /**
   * Inverts grayscale pixel
   * @param src Grayscale pixel to invert
   * @return Inverted grayscale pixel
   * */
  override def apply(src: GSPixel): GSPixel = {
    val invertedValue = WhiteValue - src.value
    GSPixel(invertedValue)
  }
}
