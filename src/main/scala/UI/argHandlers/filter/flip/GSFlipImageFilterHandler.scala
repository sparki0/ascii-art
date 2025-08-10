package UI.argHandlers.filter.flip

import UI.argHandlers.ArgHandler
import UI.wrappers.GSFilterWrapper
import data.pixels.GSPixel
import data.images.GSImage
import filters.image.flip.FlipImageFilter
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import filters.image.flip.config
import filters.image.flip.config.FlipNames

/**
 * Class for handling grayscale image flip filter argument
 * */
class GSFlipImageFilterHandler extends ArgHandler[Array[String], GSFilterWrapper]
{
  
  /**
   * Map associating flip axis names with their corresponding grayscale image filters
   * */
  private val flipFiltersMap = Map(
    FlipNames.X.name -> new GSFlipXImageFilter(),
    FlipNames.Y.name -> new GSFlipYImageFilter()
  )

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing grayscale image flip filter and remaining arguments
   * @throws Exception If argument is not provided or argument is not presented in map
   * */
  override def handle(args: Array[String]): GSFilterWrapper= {
    if(args.isEmpty)
      throw new Exception("No argument provided for flip")
    
    val axis = args(0).toLowerCase()
    val filter = flipFiltersMap.getOrElse(axis, throw new Exception("Invalid argument flip"))
    
    GSFilterWrapper(filter, args.drop(1))
  }
}
