package UI.charTables

import UI.argHandlers.charTable.CustomCharTableHandler
import charTables.CustomCharTable
import org.scalatest.funsuite.AnyFunSuite

class CustomCharTableHandlerTest extends AnyFunSuite{
  test("No custom table provided") {
    val handler = CustomCharTableHandler()
    val args = Array[String]()
    assertThrows[Exception]{
      val wrapper = handler.handle(args)
    }
  }
  
  test("Custom table provided") {
    val handler = CustomCharTableHandler()
    val table = "12345678"
    val args = Array[String](table)
    val wrapper = handler.handle(args)

    assert(wrapper.table.isInstanceOf[CustomCharTable])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = CustomCharTableHandler()
    val table = "12345678"
    val args = Array[String](table, "hello", "world")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.table.isInstanceOf[CustomCharTable])
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
    
  }
}
