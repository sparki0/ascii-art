package importers.image.generatedRGBImageImporter

import data.images.{Image, RGBImage}
import data.pixels.RGBPixel
import importers.image.RGBImageImporter

import java.awt.Color
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * Class for generating random RGB image
 * */
class RandomRGBImageImporter extends RGBImageImporter{
  /**
   * Maximal dimension of generated image
   * */
  private val maxDimension = 200

  /**
   * Minimal dimension of generated image
   * */
  private val minDimension = 70

  /**
   * Generates random RGB image
   * @return Generated RGB image
   * */
  override def load(): RGBImage = {
    val random = new Random()
    val pixels: ArrayBuffer[Seq[RGBPixel]] = ArrayBuffer.empty
    val height = minDimension + Random.nextInt((maxDimension - minDimension) + 1)
    val width = minDimension + Random.nextInt((maxDimension - minDimension) + 1)
    
    for (h <- 0 until height) {
      val row: ArrayBuffer[RGBPixel] = ArrayBuffer.empty
      for (w <- 0 until width) {
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        row += RGBPixel(new Color(red, green, blue))
      }
      pixels += row.toSeq
    }

    RGBImage(pixels.toSeq)
  }
}
