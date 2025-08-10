package filters.pixel.brightness

import data.pixels.GSPixel
import filters.Filter

/**
 * Class for filtering brightness of grayscale pixel
 * @param brightness Value to adjust brightness
 * */
class GSBrightnessPixelFilter(val brightness: Int) extends Filter[GSPixel]{
  /**
   * Adjust brightness of grayscale pixel
   * @param src Grayscale pixel to adjust
   * @return Grayscale pixel with adjusted brightness
   * */
  override def apply(src: GSPixel): GSPixel = {
    var newValue = src.value + brightness
    if(newValue < 0)
      newValue = 0
    else if(newValue > 255)
      newValue = 255
    
    GSPixel(newValue)
  }
}
