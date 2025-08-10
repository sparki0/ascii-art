package converters

/**
 *  Trait for converting object type S to type D
 * @tparam S Source type to be converted
 * @tparam D Destination type after converting
 * */
trait Converter[S,D] {
  /**
   * Converts object type S type D
   * @param src Source object to be converted.
   * @return Converted object of type D
   */
  def convert(src: S): D
}
