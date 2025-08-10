package filters.image.flip.GSImage

import data.images.GSImage
import data.pixels.GSPixel
import filters.image.flip.FlipXImageFilter

/**
 * Class for flipping grayscale image by X axis
 * */
class GSFlipXImageFilter extends FlipXImageFilter[GSPixel, GSImage]{

  /**
   * Flips grayscale image by X axis
   * @param src Grayscale image to flip
   * @return Flipped grayscale image
   * */
  override def apply(src: GSImage): GSImage = GSImage(flip(src))
}
