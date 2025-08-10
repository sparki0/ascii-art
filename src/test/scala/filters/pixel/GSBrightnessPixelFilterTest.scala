package filters.pixel

import data.pixels.GSPixel
import filters.pixel.brightness.GSBrightnessPixelFilter
import org.scalatest.funsuite.AnyFunSuite

class GSBrightnessPixelFilterTest extends AnyFunSuite {
  test("Grayscale brightness value -1000") {
    val filter = new GSBrightnessPixelFilter(-1000)
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 0)
  }

  test("Grayscale brightness value +1000") {
    val filter = new GSBrightnessPixelFilter(1000)
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 255)
  }

  test("Grayscale brightness value 0") {
    val filter = new GSBrightnessPixelFilter(0)
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 100)
  }

  test("Grayscale brightness value 27") {
    val filter = new GSBrightnessPixelFilter(27)
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 127)
  }

  test("Grayscale brightness value -33") {
    val filter = new GSBrightnessPixelFilter(-33)
    val gsPixel = GSPixel(100)
    val filteredPixel = filter.apply(gsPixel)

    assert(filteredPixel.value == 67)
  }
}
