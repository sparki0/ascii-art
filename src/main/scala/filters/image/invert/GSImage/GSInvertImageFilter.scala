package filters.image.invert.GSImage

import data.images.GSImage
import data.pixels.GSPixel
import filters.Filter
import filters.image.utilities.UtilityImageFilter
import filters.pixel.invert.GSInvertPixelFilter

/**
 * Class for inverter grayscale image
 * */
class GSInvertImageFilter extends Filter[GSImage] {

  /**
   * Inverts grayscale image
   * @param src Grayscale image to invert
   * @return Inverted grayscale image
   * */
  override def apply(src: GSImage): GSImage = {
    val pixelFilter = new GSInvertPixelFilter
    val pixels = new UtilityImageFilter[GSPixel,GSImage](pixelFilter).apply(src)
    GSImage(pixels)
  }
}
