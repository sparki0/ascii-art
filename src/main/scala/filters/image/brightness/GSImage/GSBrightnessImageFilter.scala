package filters.image.brightness.GSImage

import data.images.{GSImage, Image}
import data.pixels.GSPixel
import filters.Filter
import filters.image.utilities.UtilityImageFilter
import filters.pixel.brightness.GSBrightnessPixelFilter

/**
 * Class for filtering brightness of grayscale image
 * @param brightness Value to adjust brightness
 * */
class GSBrightnessImageFilter(val brightness: Int) extends Filter[GSImage] {
  
  /**
   * Adjust brightness of grayscale image
   * @param src Grayscale image to adjust
   * @return Grayscale image with adjusted brightness
   * */
  override def apply(src: GSImage): GSImage = {
    val pixelFilter = new GSBrightnessPixelFilter(brightness)
    val pixels = new UtilityImageFilter[GSPixel, GSImage](pixelFilter).apply(src)
    
    GSImage(pixels)
  }
}
