package UI.wrappers
import data.images.GSImage
import filters.Filter
import workflow.ArgCollector

/**
 * Class for wrapping grayscale image filter and remaining arguments
 * @param filter Grayscale image filter add
 * @param remainingArgs Remaining arguments after handling
 * */
case class GSFilterWrapper(filter: Filter[GSImage], protected val remainingArgs: Array[String])
  extends Wrapper[Array[String]] {

  /**
   * Add filter to collector
   * @param collector Collector to which filter is added
   * */
  override def addToCollector(collector: ArgCollector): Unit = 
    collector.addFilter(filter)
}
