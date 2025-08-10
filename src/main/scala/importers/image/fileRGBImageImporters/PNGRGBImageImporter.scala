package importers.image.fileRGBImageImporters

import config.ImageExtension
import data.images.{Image, RGBImage}
import data.pixels.RGBPixel
import importers.utility.FileUtility

/**
 * Class for loading PNG image from JPG file
 *
 * @param path File's path
 * */
class PNGRGBImageImporter(val path: String) extends FileRGBImageImporter {

  /**
   * Imports RGB PNG image
   * @return Imported RGB image
   * @throws Exception If file does not have PNG extension
   * */
  override def load(): RGBImage = {
    val extension = new FileUtility().getExtension(path).toLowerCase()
    if (extension != ImageExtension.PNG.extension)
      throw new Exception(s"Incorrect extension, need ${ImageExtension.PNG.extension}")

    super.load()
  }
}
