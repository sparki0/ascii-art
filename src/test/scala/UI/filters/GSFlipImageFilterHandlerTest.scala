package UI.filters

import UI.argHandlers.filter.flip.GSFlipImageFilterHandler
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import org.scalatest.funsuite.AnyFunSuite

class GSFlipImageFilterHandlerTest extends AnyFunSuite{
  test("Flip no argument") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]()

    assertThrows[Exception] {
      val wrapper = handler.handle(args)
    }
  }

  test("Flip invalid argument") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("hi")

    assertThrows[Exception] {
      val wrapper = handler.handle(args)
    }
  }

  test("Flip X argument") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("X")
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSFlipXImageFilter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Flip Y argument") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("Y")
    val wrapper = handler.handle(args)

    assert(wrapper.filter.isInstanceOf[GSFlipYImageFilter])
    assert(wrapper.getRemainingArgs().isEmpty)
  }

  test("Flip XY arguments") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("X", "Y")
    val wrapperX = handler.handle(args)

    assert(wrapperX.filter.isInstanceOf[GSFlipXImageFilter])
    assert(wrapperX.getRemainingArgs().length == 1)
    assert(wrapperX.getRemainingArgs()(0) == "Y")

    val wrapperY = handler.handle(wrapperX.getRemainingArgs())

    assert(wrapperY.filter.isInstanceOf[GSFlipYImageFilter])
    assert(wrapperY.getRemainingArgs().isEmpty)
  }

  test("Flip YX arguments") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("Y", "X")
    val wrapperY = handler.handle(args)

    assert(wrapperY.filter.isInstanceOf[GSFlipYImageFilter])
    assert(wrapperY.getRemainingArgs().length == 1)
    assert(wrapperY.getRemainingArgs()(0) == "X")

    val wrapperX = handler.handle(wrapperY.getRemainingArgs())

    assert(wrapperX.filter.isInstanceOf[GSFlipXImageFilter])
    assert(wrapperX.getRemainingArgs().isEmpty)
  }

  test("Handler takes one argument and ignores others") {
    val handler = new GSFlipImageFilterHandler()
    val args = Array[String]("X", "--args", "value")
    val checkArgs = args.drop(1)
    val wrapperX = handler.handle(args)

    assert(wrapperX.filter.isInstanceOf[GSFlipXImageFilter])
    assert(wrapperX.getRemainingArgs().sameElements(checkArgs))
  }
}
