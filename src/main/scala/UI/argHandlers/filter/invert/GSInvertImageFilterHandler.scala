package UI.argHandlers.filter.invert

import UI.argHandlers.ArgHandler
import UI.wrappers.GSFilterWrapper
import filters.image.invert.GSImage.GSInvertImageFilter

/**
 * Class for handling grayscale image invert filter argument 
 * */
class GSInvertImageFilterHandler extends ArgHandler[Array[String], GSFilterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing grayscale image invert filter and remaining arguments
   * */
  override def handle(args: Array[String]): GSFilterWrapper =
    GSFilterWrapper(new GSInvertImageFilter(), args)
}
