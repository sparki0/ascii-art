package filters.image.flip.GSImage

import data.images.GSImage
import data.pixels.GSPixel
import filters.image.flip.FlipYImageFilter

/**
 * Class for flipping grayscale image by Y axis
 * */
class GSFlipYImageFilter extends FlipYImageFilter[GSPixel, GSImage] {

  /**
   * Flips grayscale image by Y axis
   * @param src Grayscale image to flip
   * @return Flipped grayscale image
   * */
  override def apply(src: GSImage): GSImage = GSImage(flip(src))
}
