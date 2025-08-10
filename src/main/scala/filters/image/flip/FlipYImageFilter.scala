package filters.image.flip

import data.images.Image
import data.pixels.Pixel

import scala.collection.mutable.ArrayBuffer

/**
 * Trait for flipping image by Y axis
 * @tparam P Image's pixel type
 * @tparam I Image type for flipping
 * */

trait FlipYImageFilter [P <: Pixel, I <: Image[P]] extends FlipImageFilter[P,I]{

  /**
   * Flips image by Y axis
   * @param src Image to flip
   * @return Flipped sequence of pixel rows
   * */
  override protected def flip(src: I): Seq[Seq[P]] = {
    val pixels: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
      for(h <- 0 until src.getHeight) {
        val row: ArrayBuffer[P] = ArrayBuffer.empty
        for(w <- (src.getWidth - 1) to 0 by -1) {
          row += src.getPixel(w, h)
        }
        pixels += row.toSeq
      }
    
      pixels.toSeq
  }
}
