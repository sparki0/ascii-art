package UI.filters

import UI.argHandlers.exporter.ConsoleExporterHandler
import UI.argHandlers.filter.brightness.GSBrightnessImageFilterHandler
import filters.image.brightness.GSImage.GSBrightnessImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSBrightnessImageFilterHandlerTest extends AnyFunSuite{
  test("No argument") {
    val handler = new GSBrightnessImageFilterHandler()
    val args = Array[String]()

    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("Invalid type argument") {
    val handler = new GSBrightnessImageFilterHandler()
    val args = Array[String]("hi")
    
    assertThrows[Exception] {
      handler.handle(args)
    }
  }
  
  test("Valid type argument(int)") {
    val handler = new GSBrightnessImageFilterHandler()
    val brightnessValue = 50
    val args = Array[String](brightnessValue.toString)
    val wrapper = handler.handle(args)
    
    assert(wrapper.filter.isInstanceOf[GSBrightnessImageFilter])
    assert(wrapper.filter.asInstanceOf[GSBrightnessImageFilter].brightness == brightnessValue)
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = new GSBrightnessImageFilterHandler()
    val brightnessValue = 150
    val args = Array[String](brightnessValue.toString, "--args", "value")
    val checkArgs = args.drop(1)
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSBrightnessImageFilter])
    assert(wrapper.filter.asInstanceOf[GSBrightnessImageFilter].brightness == brightnessValue)
    assert(wrapper.getRemainingArgs().sameElements(checkArgs))
  }

}
