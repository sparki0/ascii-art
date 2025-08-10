package filters

import data.pixels.GSPixel
import filters.image.flip.GSImage.{GSFlipXImageFilter, GSFlipYImageFilter}
import org.scalatest.funsuite.AnyFunSuite

class GSFlipImageFilterTest extends AnyFunSuite {
  test("Grayscale image2x2 Flip X") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSFlipXImageFilter()
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(53)),
      Seq(GSPixel(50), GSPixel(51))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 Flip Y") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSFlipYImageFilter()
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(51), GSPixel(50)),
      Seq(GSPixel(53), GSPixel(52))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 Flip XY") {
    val image = GSImageGenerator.getGSImage2x2()
    val filterX = new GSFlipXImageFilter()
    val filterY = new GSFlipYImageFilter()
    val filteredImage = filterY.apply(filterX.apply(image))
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(52)),
      Seq(GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image2x2 Flip YX") {
    val image = GSImageGenerator.getGSImage2x2()
    val filterX = new GSFlipXImageFilter()
    val filterY = new GSFlipYImageFilter()
    val filteredImage = filterX.apply(filterY.apply(image))
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(52)),
      Seq(GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image3x2 Flip X") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSFlipXImageFilter()
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(54), GSPixel(55)),
      Seq(GSPixel(50), GSPixel(51), GSPixel(52))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }
  test("Grayscale image3x2 Flip Y") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSFlipYImageFilter()
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(51), GSPixel(50)),
      Seq(GSPixel(55), GSPixel(54), GSPixel(53))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image3x2 Flip XY") {
    val image = GSImageGenerator.getGSImage3x2()
    val filterX = new GSFlipXImageFilter()
    val filterY = new GSFlipYImageFilter()
    val filteredImage = filterY.apply(filterX.apply(image))
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(55), GSPixel(54), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image3x2 Flip YX") {
    val image = GSImageGenerator.getGSImage3x2()
    val filterX = new GSFlipXImageFilter()
    val filterY = new GSFlipYImageFilter()
    val filteredImage = filterX.apply(filterY.apply(image))
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(55), GSPixel(54), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }
}
