package filters.image.scale.GSImage

import data.images.GSImage
import data.pixels.GSPixel
import filters.image.scale.ScaleImageFilter
import filters.image.scale.config.ScaleValues

/**
 * Class for scaling grayscale image
 * @param scale Value by which to scale the image.
 * */

class GSScaleImageFilter(val scale: Double) extends ScaleImageFilter[GSPixel, GSImage]{
  /**
   * Map associating scale value with their corresponding scaled grayscale image
   * */
  private val scaleMap: Map[Double, (GSImage) => GSImage] = Map(
    ScaleValues.Quarter.value -> (src => GSImage(scaleQuarter(src))),
    ScaleValues.One.value -> (src => src),
    ScaleValues.Four.value -> (src => GSImage(scale4X(src)))
  )

  /**
   * Scales grayscale image
   * @param src Grayscale image to scale
   * @return Scaled grayscale image
   * */
  override def apply(src: GSImage): GSImage = {
    val scaleFunc = scaleMap.getOrElse(scale, throw new Exception("Invalid scale number"))

    scaleFunc(src)
  }
}

