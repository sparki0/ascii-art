package UI.argHandlers.filter.brightness

import UI.argHandlers.ArgHandler
import UI.wrappers.GSFilterWrapper
import filters.image.brightness.GSImage.GSBrightnessImageFilter

/**
 * Class for handling grayscale image brightness filter argument
 * */
class GSBrightnessImageFilterHandler extends ArgHandler[Array[String], GSFilterWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing grayscale image brightness filter and remaining arguments
   * @throws Exception If argument is not integer type
   **/
  override def handle(args: Array[String]): GSFilterWrapper = {
    if (args.isEmpty)
      throw new Exception("No value provided for brightness")
      
    try{
      val value = args(0).toInt
      GSFilterWrapper(new GSBrightnessImageFilter(value), args.drop(1))
    }
    catch {
      case _: Exception => throw new Exception("Invalid brightness argument")
    }
  }
}
