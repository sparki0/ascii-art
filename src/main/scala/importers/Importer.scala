package importers
/**
 * Trait for importing
 * @tparam T Type of imported object
 **/
trait Importer[T] {
  
  /**
   * Imports object
   * @return Imported object
   * */
  def load(): T
}
