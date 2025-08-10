package UI.wrappers
import charTables.CharTable
import workflow.ArgCollector

/**
 * Class for wrapping character table and remaining arguments
 * @param table Character table to add
 * @param remainingArgs Remaining arguments after handling
 * */
case class CharTableWrapper(table: CharTable, protected val remainingArgs: Array[String]) 
  extends Wrapper[Array[String]] {

  /**
   * Add character table to collector
   * @param collector Collector to which character table is added
   * */
  override def addToCollector(collector: ArgCollector): Unit = 
    collector.addCharTable(table)
}
