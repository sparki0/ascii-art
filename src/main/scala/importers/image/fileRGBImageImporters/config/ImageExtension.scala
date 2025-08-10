package importers.image.fileRGBImageImporters.config

/**
 * Enum representing extension of images
 * @param extension String representation of the extension.
 */
enum ImageExtension(val extension: String) {
  case PNG extends ImageExtension("png")
  case JPG extends ImageExtension("jpg")
}