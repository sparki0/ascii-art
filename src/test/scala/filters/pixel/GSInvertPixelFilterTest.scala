package filters.pixel

import data.pixels.GSPixel
import filters.pixel.invert.GSInvertPixelFilter
import org.scalatest.funsuite.AnyFunSuite

class GSInvertPixelFilterTest extends AnyFunSuite {
  test("Grayscale pixel 0") {
    val filter = new GSInvertPixelFilter()
    val gsPixel = GSPixel(0)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 255)
  }

  test("Grayscale pixel 255") {
    val filter = new GSInvertPixelFilter()
    val gsPixel = GSPixel(255)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 0)
  }

  test("Grayscale pixel 100") {
    val filter = new GSInvertPixelFilter()
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 155)
  }

  test("Grayscale pixel 27") {
    val filter = new GSInvertPixelFilter()
    val gsPixel = GSPixel(27)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 228)
  }
}
