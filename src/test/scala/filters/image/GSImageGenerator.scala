package filters

import data.images.{GSImage, Image}
import data.pixels.GSPixel

object GSImageGenerator {
  def getGSImage2x2(): GSImage = {
    val pixels: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(53))
    )
    GSImage(pixels)
  }

  def getGSImage3x2(): GSImage = {
    val pixels: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51), GSPixel(52)),
      Seq(GSPixel(53), GSPixel(54), GSPixel(55))
    )
    GSImage(pixels)
  }
}
