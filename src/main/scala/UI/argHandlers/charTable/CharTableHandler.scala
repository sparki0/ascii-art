package UI.argHandlers.charTable

import UI.argHandlers.ArgHandler
import UI.wrappers.CharTableWrapper
import charTables.{CharTable, DefaultCharTable, NonLinearCharTable}
import charTables.config.CharTableNames

/**
 * Class for handling character table argument
 * */
class CharTableHandler extends ArgHandler[Array[String], CharTableWrapper] {

  /**
   * Map associating table names with their corresponding character table
   * */
  private val tableMap = Map(
    CharTableNames.Default.name -> (() => new DefaultCharTable()),
    CharTableNames.NonLinear.name -> (() => new NonLinearCharTable())
  )
  
  /**
   * Handles arguments
   * @param args Arguments to handle
   * @return Wrapper representing character table and remaining arguments
   * @throws Exception If table name is not presented
   * */
  override def handle(args: Array[String]): CharTableWrapper = {
    if(args.isEmpty)
      throw new Exception("No name provided for char table")

    val name = args(0).toLowerCase()
    val tableFunc = tableMap.getOrElse(name, throw new Exception("Invalid table name argument"))

    CharTableWrapper(tableFunc(), args.drop(1))
  }
}
