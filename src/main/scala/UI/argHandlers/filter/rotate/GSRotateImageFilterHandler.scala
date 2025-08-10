package UI.argHandlers.filter.rotate

import UI.argHandlers.ArgHandler
import UI.wrappers.GSFilterWrapper
import filters.image.rotate.GSImage.GSRotateImageFilter

/**
 * Class for handling grayscale image rotate filter argument
 **/
class GSRotateImageFilterHandler extends ArgHandler[Array[String], GSFilterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing grayscale image rotation filter and remaining arguments
   **/
  override def handle(args: Array[String]): GSFilterWrapper = {
    if(args.isEmpty)
      throw new Exception("No degree provided for rotation")

    try {
      val degree = args(0).toInt
      GSFilterWrapper(new GSRotateImageFilter(degree), args.drop(1))
    }
    catch {
      case _: Exception => throw new Exception("Invalid rotation argument")
    }

  }
}
