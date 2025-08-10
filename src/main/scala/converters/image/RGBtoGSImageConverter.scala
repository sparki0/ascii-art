package converters.image

import converters.Converter
import converters.image.utils.UtilImageConverter
import converters.pixel.RGBtoGSPixelConverter
import data.images.{GSImage, RGBImage}
import data.pixels.{GSPixel, RGBPixel}

/**
 * Class for converting RGB Image to Grayscale Image
 * */
class RGBtoGSImageConverter extends Converter[RGBImage, GSImage]{

  /**
   * Convert RGB image to grayscale image
   * @param src Source RGB image
   * @return Converted grayscale image
   * */
  override def convert(src: RGBImage): GSImage = {
    val pixelConverter = new RGBtoGSPixelConverter()
    val imageSeq = new UtilImageConverter[RGBPixel, GSPixel, RGBImage](pixelConverter).convert(src)

    GSImage(imageSeq)
  }
}