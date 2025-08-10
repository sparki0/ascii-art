package filters.image.scale

import data.images.Image
import data.pixels.Pixel
import filters.Filter

import scala.collection.mutable.ArrayBuffer

/**
 * Trait for scaling filter
 * @tparam P Image's pixel type
 * @tparam I Image type for filtering
 * */
trait ScaleImageFilter[P <: Pixel, I <: Image[P]] extends Filter[I] {
  /**
   * Value to scale image
   * */
  val scale: Double

  /**
   * Scales image by 0.25
   * @param src Image to scale
   * @return Scaled sequence of pixel
   * */
  protected def scaleQuarter(src: I): Seq[Seq[P]] = {
    val pixels: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
    for(h <- 0 until src.getHeight by 2) {
      val row: ArrayBuffer[P] = ArrayBuffer.empty
      for(w <- 0 until src.getWidth by 2) {
        row += src.getPixel(w, h)
      }
      pixels += row.toSeq
    }
    
    pixels.toSeq
  }

  /**
   * Scales image by 4
   *
   * @param src Image to scale
   * @return Scaled sequence of pixel
   * */
  protected def scale4X(src: Image[P]): Seq[Seq[P]] = {
    val pixels: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
    for(h <- 0 until src.getHeight) {
      val row: ArrayBuffer[P] = ArrayBuffer.empty
      for(w <- 0 until src.getWidth) {
        row += src.getPixel(w, h)
        row += src.getPixel(w, h)
      }
      pixels += row.toSeq
      pixels += row.toSeq
    }
    
    pixels.toSeq
  }
}
