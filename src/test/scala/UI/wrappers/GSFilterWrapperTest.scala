package UI.wrappers

import filters.image.rotate.GSImage.GSRotateImageFilter
import org.scalatest.funsuite.AnyFunSuite
import workflow.ArgCollector

class GSFilterWrapperTest extends AnyFunSuite {
  test("Check") {
    val args = Array[String]("--args", "value")
    val degree = 90
    val wrapper = GSFilterWrapper(new GSRotateImageFilter(degree), args)
    val collector = new ArgCollector()
    wrapper.addToCollector(collector)

    assert(collector.getGSImageFilters().size == 1)
    assert(collector.getGSImageFilters()(0).isInstanceOf[GSRotateImageFilter])
    assert(collector.getGSImageFilters()(0).asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(wrapper.getRemainingArgs().sameElements(args))
  }
}
