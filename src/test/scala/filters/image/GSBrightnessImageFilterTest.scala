package filters

import data.pixels.GSPixel
import filters.image.brightness.GSImage.GSBrightnessImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSBrightnessImageFilterTest extends AnyFunSuite {
  test("Grayscale image2x2 brightness value 15") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSBrightnessImageFilter(15)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(65), GSPixel(66)),
      Seq(GSPixel(67), GSPixel(68))
    )

    assert(filteredImage.getPixel(0,0) == check(0)(0))
    assert(filteredImage.getPixel(1,0) == check(0)(1))
    assert(filteredImage.getPixel(0,1) == check(1)(0))
    assert(filteredImage.getPixel(1,1) == check(1)(1))
  }

  test("Grayscale image2x2 brightness value -15") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSBrightnessImageFilter(-15)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(35), GSPixel(36)),
      Seq(GSPixel(37), GSPixel(38))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 brightness value +1000"){
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSBrightnessImageFilter(1000)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(255), GSPixel(255)),
      Seq(GSPixel(255), GSPixel(255))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 brightness value -1000") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSBrightnessImageFilter(-1000)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(0), GSPixel(0)),
      Seq(GSPixel(0), GSPixel(0))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 brightness value 0") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSBrightnessImageFilter(0)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(53))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }
}
