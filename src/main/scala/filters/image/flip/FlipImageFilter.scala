package filters.image.flip

import data.images.Image
import data.pixels.Pixel
import filters.Filter

import scala.collection.mutable.ArrayBuffer

/**
 * Trait for flipping image
 * @tparam P Image's pixel type
 * @tparam I Image type for flipping
 * */
trait FlipImageFilter[P <: Pixel, I <: Image[P]] extends Filter[I]{

  /**
   * Flips image
   * @param src Image to flip
   * @return Flipped sequence of pixel rows
   * */
  protected def flip(src: I): Seq[Seq[P]]
}
