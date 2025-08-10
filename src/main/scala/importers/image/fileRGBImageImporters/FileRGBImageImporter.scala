package importers.image.fileRGBImageImporters

import data.images.{Image, RGBImage}
import data.pixels.RGBPixel
import importers.image.RGBImageImporter

import java.awt.Color
import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import scala.collection.mutable.ArrayBuffer

/**
 * Trait for importing RGB image from file
 */
trait FileRGBImageImporter extends RGBImageImporter {
  /**
   * File's path
   * */
  val path: String

  /**
   * Imports image from file
   * @return Imported RGB image
   * @throws Exception If import fails
   * */
  
  override def load(): RGBImage = {
    val imageOpt = Option(ImageIO.read(new File(path)))
    imageOpt match {
      case Some(image) => bufferToRGBSeq(image)
      case None => throw new Exception(s"Invalid import")
    }
  }

  /**
   * Converts bufferedImage to RGB image
   * @param buffer image to convert
   * @return RGB image converted from buffer
   **/
  private def bufferToRGBSeq(buffer: BufferedImage): RGBImage = {
    val pixels: ArrayBuffer[Seq[RGBPixel]] = ArrayBuffer.empty
    for(h <- 0 until buffer.getHeight) {
      val row: ArrayBuffer[RGBPixel] = ArrayBuffer.empty
      for(w <- 0 until buffer.getWidth) {
        row += RGBPixel(new Color(buffer.getRGB(w, h)))
      }
      pixels += row.toSeq
    }
    
    RGBImage(pixels.toSeq)
  }
}
