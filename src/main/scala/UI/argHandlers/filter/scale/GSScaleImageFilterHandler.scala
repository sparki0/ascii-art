package UI.argHandlers.filter.scale

import UI.argHandlers.ArgHandler
import UI.wrappers.GSFilterWrapper
import filters.image.scale.GSImage.GSScaleImageFilter

/**
 * Class for handling  grayscale image scale filter argument
 **/
class GSScaleImageFilterHandler extends ArgHandler[Array[String], GSFilterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing grayscale image scale filter and remaining arguments
   * @throws Exception If no value provided for scale
   **/
  override def handle(args: Array[String]): GSFilterWrapper = {
    if(args.isEmpty)
      throw new Exception("No argument provided for scale")
      
    val value = args(0).toDouble
    GSFilterWrapper(new GSScaleImageFilter(value), args.drop(1))
  }
}
