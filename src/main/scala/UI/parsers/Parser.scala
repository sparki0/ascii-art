package UI.parsers

/**
 * Trait for parser
 * @tparam T Type of argument collection
 * */
trait Parser[T] {
  /**
   * Parses arguments
   * @param args Arguments to parse
   * */
  def parse(args: T): Unit
}
