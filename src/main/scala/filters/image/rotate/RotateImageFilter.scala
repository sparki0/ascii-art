package filters.image.rotate

import data.images.Image
import data.pixels.Pixel
import filters.Filter

import scala.collection.mutable.ArrayBuffer

/**
 * Trait for rotation filter
 * @tparam P Image's pixel type
 * @tparam I Image type for filtering
 * */

trait RotateImageFilter[P <: Pixel, I <: Image[P]] extends Filter[I]{
  /**
   * Rotation degree
   * */
  val degree: Int

  /**
   * Rotates image by specific degree
   * @param src Image to rotate
   * @return Rotated sequence of pixel rows
   * @throws Exception If degree is not a multiple of 90.
   * */
  protected def rotate(src: I): Seq[Seq[P]] = {
    if((degree % 90) != 0)
      throw new Exception(s"Degree $degree is not supported")
    
    var degreeNormal = ((degree % 360) + 360) % 360

    var rotatedPixels: ArrayBuffer[ArrayBuffer[P]] = ArrayBuffer.empty
    for(h <- 0 until src.getHeight) {
      val row: ArrayBuffer[P] = ArrayBuffer.empty
       for (w <- 0 until src.getWidth){
        row += src.getPixel(w, h)
      }
      rotatedPixels += row
    }

    while (degreeNormal > 0) {
      rotatedPixels = rightRotation90(rotatedPixels)
      degreeNormal -= 90
    }

    val res: ArrayBuffer[Seq[P]] = ArrayBuffer.empty
    for(row <- rotatedPixels) {
      res += row.toSeq
    }

    res.toSeq
  }

  /**
   * Rotates image by 90 degree to right
   * @param src Sequence of pixel rows to rotate
   * @return Rotated sequence of pixel rows
   * */
  private def rightRotation90(src:  ArrayBuffer[ArrayBuffer[P]]):  ArrayBuffer[ArrayBuffer[P]] = {
    val rotatedPixels: ArrayBuffer[ArrayBuffer[P]] = ArrayBuffer.empty
    for (h <- src.head.indices) {
      val row: ArrayBuffer[P] = ArrayBuffer.empty
      for (w <- src.indices) {
        row += src(src.size - w - 1)(h)
      }
      rotatedPixels += row
    }

    rotatedPixels
  }
}
