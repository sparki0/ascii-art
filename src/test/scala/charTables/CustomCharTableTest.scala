package charTables

import charTables.CustomCharTable
import org.scalatest.funsuite.AnyFunSuite

class CustomCharTableTest extends AnyFunSuite {
  test("Empty table") {
    assertThrows[Exception] {
      new CustomCharTable("")
    }
  }

  test("Non-empty table") {
    val table = "123456"
    val charTable = new  CustomCharTable(table)
    assert(charTable.getTable() == table)
  }
}
