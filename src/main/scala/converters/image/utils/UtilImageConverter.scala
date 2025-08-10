package converters.image.utils

import converters.Converter
import data.images.{GSImage, Image}
import data.pixels.Pixel

import scala.collection.mutable.ArrayBuffer

/**
 * Util class for converting image to sequence of pixel
 * (this class helps avoiding repetitive code)
 * @tparam SP Source pixel to be converted
 * @tparam DP Destination pixel after converting
 * @tparam I Image to be converted
 * @param converter Pixel converter
 * (this class helps avoiding repetitive code)
 * */
class UtilImageConverter[SP <: Pixel, DP <: Pixel, I <: Image[SP]]
  (converter: Converter[SP,DP]) extends Converter[I,Seq[Seq[DP]]]
{
  /**
   * Converts one image's pixel  to another sequence of pixel
   * @param src Image's pixel to convert
   * @return Converted sequence of pixel rows
   * */
  override def convert(src: I): Seq[Seq[DP]] = {
    val pixels: ArrayBuffer[Seq[DP]] = ArrayBuffer.empty
    for(h <- 0 until src.getHeight) {
      val row: ArrayBuffer[DP] = ArrayBuffer.empty
      for(w <- 0 until src.getWidth) {
        row += converter.convert(src.getPixel(w, h))
      }
      pixels += row.toSeq
    }

    pixels.toSeq
  }
}
