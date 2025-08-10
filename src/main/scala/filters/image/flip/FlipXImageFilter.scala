package filters.image.flip

import data.images.Image
import data.pixels.Pixel

import scala.collection.mutable.ArrayBuffer

/**
 * Trait for flipping image by X axis
 * @tparam P Image's pixel type
 * @tparam I Image type for flipping
 * */
trait FlipXImageFilter[P <: Pixel, I <: Image[P]] extends FlipImageFilter[P,I] {

  /**
   * Flips image by X axis
   * @param src Image to flip
   * @return Flipped sequence of pixel rows
   * */
  override protected def flip(src: I): Seq[Seq[P]] = {
    val pixels: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
      for(h <- (src.getHeight - 1) to 0 by -1) {
        val row: ArrayBuffer[P] = ArrayBuffer.empty
        for(w <- 0 until src.getWidth) {
          row += src.getPixel(w, h)
        }
        pixels += row.toSeq
      }
    
      pixels.toSeq
  }
}
