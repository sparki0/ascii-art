package importers.image.fileRGBImageImporters
import config.ImageExtension
import data.images.{Image, RGBImage}
import data.pixels.RGBPixel
import importers.utility.FileUtility

/**
 * Class for loading RGB image from JPG file
 * @param path File's path
 * */
class JPGRGBImageImporter(val path: String) extends FileRGBImageImporter {

  /**
   * Imports RGB JPG image
   * @return Imported RGB image
   * @throws Exception If file does not have JPG extension
   * */
  override def load(): RGBImage = {
    val extension = new FileUtility().getExtension(path).toLowerCase()
    if(extension != ImageExtension.JPG.extension)
      throw new Exception(s"Incorrect extension, need ${ImageExtension.JPG.extension}")
      
    super.load()
  }
}
