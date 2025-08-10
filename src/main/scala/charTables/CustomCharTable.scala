package charTables

/**
 * Class for user character table
 * @param table user's character table
 * */

class CustomCharTable(private val table: String) extends CharTable {
  if(table.isEmpty) 
    throw new Exception("Table must not be empty")
  
  override def getTable(): String = table
}
