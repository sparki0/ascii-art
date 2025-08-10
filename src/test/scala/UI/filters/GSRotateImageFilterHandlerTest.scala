package UI.filters

import UI.argHandlers.filter.rotate.GSRotateImageFilterHandler
import filters.image.rotate.GSImage.GSRotateImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSRotateImageFilterHandlerTest extends AnyFunSuite{
  test("Invalid argument type(double)") {
    val handler = new GSRotateImageFilterHandler()
    val args = Array[String]("90.1")
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("No argument provided") {
    val handler = new GSRotateImageFilterHandler()
    val args = Array[String]()
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("Valid positive argument type") {
    val handler = new GSRotateImageFilterHandler()
    val degree = 90
    val args = Array[String](degree.toString)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSRotateImageFilter])
    assert(wrapper.filter.asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Valid negative argument type") {
    val handler = new GSRotateImageFilterHandler()
    val degree = -90
    val args = Array[String](degree.toString)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSRotateImageFilter])
    assert(wrapper.filter.asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Valid argument type 0") {
    val handler = new GSRotateImageFilterHandler()
    val degree = 0
    val args = Array[String](degree.toString)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSRotateImageFilter])
    assert(wrapper.filter.asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = new GSRotateImageFilterHandler()
    val degree = 0
    val args = Array[String](degree.toString, "--arg", "value")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSRotateImageFilter])
    assert(wrapper.filter.asInstanceOf[GSRotateImageFilter].degree == degree)
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
  }
  
}
