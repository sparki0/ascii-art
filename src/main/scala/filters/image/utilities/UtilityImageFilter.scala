package filters.image.utilities

import data.images.Image
import filters.Filter
import data.pixels.Pixel

import scala.collection.mutable.ArrayBuffer

/**
 * Util Class for filtering image's pixels
 * @tparam P Image's pixel type
 * @tparam I Image type for filtering
 * @param pixelFilter filter for pixel
 * (this class helps avoiding repetitive code)
 * */
class UtilityImageFilter[P <: Pixel, I <: Image[P]](pixelFilter: Filter[P]) {

  /**
   * Applies filter to image
   * @param src Image's pixel to filter
   * @return Filtered sequence of pixel rows
   * */
  def apply(src: I): Seq[Seq[P]] = {
    val pixels: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
    for(h <- 0 until src.getHeight) {
      val row: ArrayBuffer[P] = ArrayBuffer.empty
      for(w <- 0 until src.getWidth) {
        row += pixelFilter.apply(src.getPixel(w, h))
      }
      pixels += row.toSeq
    }
    
    pixels.toSeq
  }
}