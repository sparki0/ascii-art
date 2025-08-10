package exporters

/**
 * Trait for exporting
 * @tparam T The type of object to be exported.
 * */
trait Exporter[T] {
  /**
   * Exports object
   * @param value Object to export
   * */
  def write(value: T): Unit
}
