package UI.charTables

import UI.argHandlers.charTable.CharTableHandler
import UI.wrappers.CharTableWrapper
import charTables.{DefaultCharTable, NonLinearCharTable}
import org.scalatest.funsuite.AnyFunSuite

class CharTableHandlerTest extends AnyFunSuite {

  test("Invalid table name") {
    val handler = CharTableHandler()
    val args = Array[String]("718")
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("Default table") {
    val handler = CharTableHandler()
    val args = Array[String]("default")
    val wrapper = handler.handle(args)
    
    assert(wrapper.table.isInstanceOf[DefaultCharTable])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Non-linear table") {
    val handler = CharTableHandler()
    val args = Array[String]("non-linear")
    val wrapper = handler.handle(args)
    
    assert(wrapper.table.isInstanceOf[NonLinearCharTable])
    assert(wrapper.getRemainingArgs().isEmpty)
  }
  
  test("Handler takes one argument and ignores others") {
    val handler = CharTableHandler()
    val args = Array[String]("default", "--nameArg", "argValue")
    val checkArg = args.drop(1)
    val wrapper = handler.handle(args)
    
    assert(wrapper.table.isInstanceOf[DefaultCharTable])
    assert(wrapper.getRemainingArgs().sameElements(checkArg))
  }
}
