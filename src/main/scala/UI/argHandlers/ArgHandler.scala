package UI.argHandlers

import UI.wrappers.Wrapper

/**
 * Trait for handling arguments during parsing
 * @tparam A Collection of argument
 * @tparam W Wrapper type
 * */
trait ArgHandler[A, W <: Wrapper[A]] {
  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing wrapped data and remaining arguments
   * */
  def handle(args: A): W
}
