package charTables

/**
 * Class for default character table
 */
class DefaultCharTable extends CharTable {
  private val DEFAULT_TABLE = " .:-=+*#%@"
  
  override def getTable(): String = DEFAULT_TABLE
}
