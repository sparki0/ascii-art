package UI.filters

import UI.argHandlers.filter.scale.GSScaleImageFilterHandler
import filters.image.scale.GSImage.GSScaleImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSScaleImageFilterHandlerTest extends AnyFunSuite {
  test("Invalid argument type") {
    val handler = new GSScaleImageFilterHandler()
    val args = Array[String]("0.25a")
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("No argument provided") {
    val handler = new GSScaleImageFilterHandler()
    val args = Array[String]()
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("Valid argument type(double)") {
    val handler = new GSScaleImageFilterHandler()
    val args = Array[String]("0.25")
    val wrapper = handler.handle(args)
    
    assert(wrapper.filter.isInstanceOf[GSScaleImageFilter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = new GSScaleImageFilterHandler()
    val args = Array[String]("0.25", "--arg", "value")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSScaleImageFilter])
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
  }
}
