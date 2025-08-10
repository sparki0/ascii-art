package filters

/**
 * Trait for filter
 * @tparam T Type of object for filter
 * */
trait Filter[T] {
  /**
   * Filters object
   * @param src Object that need to be filtered
   * @return Filtered object
   * */
  def apply(src: T) : T
}
