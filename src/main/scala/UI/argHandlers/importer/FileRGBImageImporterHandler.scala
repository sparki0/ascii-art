package UI.argHandlers.importer

import UI.argHandlers.ArgHandler
import UI.wrappers.RGBImageImporterWrapper
import importers.image.fileRGBImageImporters.{JPGRGBImageImporter, PNGRGBImageImporter}
import importers.image.fileRGBImageImporters.FileRGBImageImporter
import importers.image.fileRGBImageImporters.config.ImageExtension
import importers.utility.FileUtility

/**
 * Class for handling RGB file import argument
 * */

class FileRGBImageImporterHandler extends ArgHandler[Array[String], RGBImageImporterWrapper] {

  /**
   * Map associating image extension names with their corresponding importer
   * */
  private val importerMap: Map[String, String => FileRGBImageImporter] = Map(
    ImageExtension.PNG.extension  -> (path => new PNGRGBImageImporter(path)),
    ImageExtension.JPG.extension -> (path => new JPGRGBImageImporter(path))
  )
  
  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing RGB file importer and remaining arguments
   * */
  override def handle(args: Array[String]): RGBImageImporterWrapper= {
    if (args.isEmpty)
      throw new Exception("No image provided for import")
    
    val path = args(0)
    val extension = new FileUtility().getExtension(path).toLowerCase()

    val importer = importerMap.getOrElse(extension, throw new Exception("Unsupported extension"))
    RGBImageImporterWrapper(importer(path), args.drop(1))
  }
}
