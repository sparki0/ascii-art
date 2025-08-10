package UI.argHandlers.importer

import UI.argHandlers.ArgHandler
import UI.wrappers.RGBImageImporterWrapper
import importers.image.generatedRGBImageImporter.RandomRGBImageImporter

/**
 * Class for handling random RGB image import argument
 * */
class RandomRGBImageImporterHandler extends ArgHandler[Array[String], RGBImageImporterWrapper]{

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing random RGB image importer and remaining arguments
   * */
  override def handle(args: Array[String]): RGBImageImporterWrapper = 
    RGBImageImporterWrapper(new RandomRGBImageImporter(), args)
}
