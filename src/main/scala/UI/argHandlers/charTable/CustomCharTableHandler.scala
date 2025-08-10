package UI.argHandlers.charTable

import UI.argHandlers.ArgHandler
import UI.wrappers.CharTableWrapper
import charTables.CustomCharTable

/**
 * Class for handling custom character table
 * */
class CustomCharTableHandler extends ArgHandler[Array[String], CharTableWrapper] {

  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing custom character table and remaining arguments
   * @throws Exception If there are no arguments
   * */
  override def handle(args: Array[String]): CharTableWrapper = {
    if(args.isEmpty) 
      throw new Exception("Table is not provided")
    
    val table = args(0)
    CharTableWrapper(new CustomCharTable(table), args.drop(1))
  }
}
