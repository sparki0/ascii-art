package UI.wrappers

import charTables.CustomCharTable
import org.scalatest.funsuite.AnyFunSuite
import workflow.ArgCollector

class CharTableWrapperTest extends AnyFunSuite {
  test("Check") {
    val args = Array[String]("--args", "value")
    val table = "12345"
    val wrapper = CharTableWrapper(new CustomCharTable(table), args)
    val collector = new ArgCollector()
    wrapper.addToCollector(collector)
    
    assert(collector.getCharTableOpt().get.isInstanceOf[CustomCharTable])
    assert(collector.getCharTableOpt().get.asInstanceOf[CustomCharTable].getTable() == table)
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
