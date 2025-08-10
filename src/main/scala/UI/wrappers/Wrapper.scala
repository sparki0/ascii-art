package UI.wrappers

import workflow.ArgCollector

/**
 * Trait for handling arguments during parsing.
 * @tparam R Type of the collection representing the arguments.
 **/
trait Wrapper[R] {
  /**
   * The remaining arguments after processing
   **/
  protected val remainingArgs: R

  /**
   * Adds wrapped data to the argument collector.
   * @param collector Argument collector to which data will be added.
   **/
  def addToCollector(collector: ArgCollector): Unit

  /**
   * Retrieves remaining arguments.
   * @return Remaining arguments
   **/
  def getRemainingArgs(): R = remainingArgs
}
