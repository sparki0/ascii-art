package UI.filters

import UI.argHandlers.filter.invert.GSInvertImageFilterHandler
import filters.image.invert.GSImage.GSInvertImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSInvertImageFilterHandlerTest extends AnyFunSuite{
  test("No argument provided") {
    val handler = new GSInvertImageFilterHandler()
    val args = Array[String]()
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSInvertImageFilter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler ignores arguments") {
    val handler = new GSInvertImageFilterHandler()
    val args = Array[String]("--args", "value")
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSInvertImageFilter])
    assert(wrapper.getRemainingArgs().sameElements(args))
  }

}
