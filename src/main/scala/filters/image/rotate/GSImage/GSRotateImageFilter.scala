package filters.image.rotate.GSImage

import data.images.{GSImage, Image}
import data.pixels.{GSPixel, Pixel}
import filters.Filter
import filters.image.rotate.RotateImageFilter

import scala.collection.mutable.ArrayBuffer

/**
 * Class for rotating grayscale image
 * @param degree Rotation degree
 * */
class GSRotateImageFilter(val degree: Int) extends RotateImageFilter[GSPixel, GSImage] {

  /**
   * Rotates grayscale image by specific degree
   * @param src Grayscale image to rotate
   * @return Rotated grayscale image
   * */
  override def apply(src: GSImage): GSImage = {
    GSImage(rotate(src))
  }
}
