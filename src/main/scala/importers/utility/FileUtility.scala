package importers.utility

/**
 * Class for getting file extension
 * */
class FileUtility() {
  
  /**
   * Gets file extension
   * @param path File's path
   * @return String representing file's extension
   * @throws Exception If file does not have extension
   * */
  def getExtension(path: String): String = {
    val pos = path.lastIndexOf(".")
    if (pos < 0 || pos >= path.length)
      throw new Exception("Invalid path or file")

    path.substring(pos + 1)
  }
}
