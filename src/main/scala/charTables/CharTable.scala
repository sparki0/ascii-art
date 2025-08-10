package charTables

/**
 * Trait for a character table, that will be used for converting Grayscale to ascii symbol
 * */
trait CharTable {
  /**
   * @return returns character table in string
   * */
  def getTable(): String
}
