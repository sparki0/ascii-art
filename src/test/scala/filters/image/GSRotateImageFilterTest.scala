package filters

import data.pixels.GSPixel
import filters.image.rotate.GSImage.GSRotateImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSRotateImageFilterTest extends AnyFunSuite {
  test("Invalid rotate degree 718") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(718)
    
    assertThrows[Exception] {
      val filteredImage = filter.apply(image)
    }
  }

  test("Grayscale image rotate degree 0 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(0)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(53))
    )
    
    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 90 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(90)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(50)),
      Seq(GSPixel(53), GSPixel(51))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 180 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(180)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(52)),
      Seq(GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 270 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(270)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(51), GSPixel(53)),
      Seq(GSPixel(50), GSPixel(52))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 360 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(360)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(53))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree -90 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(-90)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(51), GSPixel(53)),
      Seq(GSPixel(50), GSPixel(52))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree -180 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(-180)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(52)),
      Seq(GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree -270 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(-270)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(50)),
      Seq(GSPixel(53), GSPixel(51))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree -360 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(-360)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(53))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 14580 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(14580)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(52)),
      Seq(GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree -6930 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSRotateImageFilter(-6930)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(51), GSPixel(53)),
      Seq(GSPixel(50), GSPixel(52))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
  }

  test("Grayscale image rotate degree 0 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(0)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51), GSPixel(52)),
      Seq(GSPixel(53), GSPixel(54), GSPixel(55))
    )
    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree 90 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(90)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(53), GSPixel(50)),
      Seq(GSPixel(54), GSPixel(51)),
      Seq(GSPixel(55), GSPixel(52))
    )
    
    assert(filteredImage.getWidth == image.getHeight)
    assert(filteredImage.getHeight == image.getWidth)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
  }

  test("Grayscale image rotate degree 180 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(180)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(55), GSPixel(54), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree 270 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(270)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(55)),
      Seq(GSPixel(51), GSPixel(54)),
      Seq(GSPixel(50), GSPixel(53))
    )

    assert(filteredImage.getWidth == image.getHeight)
    assert(filteredImage.getHeight == image.getWidth)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
  }

  test("Grayscale image rotate degree 360 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(360)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51), GSPixel(52)),
      Seq(GSPixel(53), GSPixel(54), GSPixel(55))
    )
    
    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree -90 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(-90)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(55)),
      Seq(GSPixel(51), GSPixel(54)),
      Seq(GSPixel(50), GSPixel(53))
    )

    assert(filteredImage.getWidth == image.getHeight)
    assert(filteredImage.getHeight == image.getWidth)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
  }

  test("Grayscale image rotate degree -180 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(-180)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(55), GSPixel(54), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree -360 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(360)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(51), GSPixel(52)),
      Seq(GSPixel(53), GSPixel(54), GSPixel(55))
    )
    
    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree 14580 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(14580)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(55), GSPixel(54), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(51), GSPixel(50))
    )

    assert(filteredImage.getWidth == image.getWidth)
    assert(filteredImage.getHeight == image.getHeight)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }

  test("Grayscale image rotate degree -6930 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSRotateImageFilter(-6930)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(52), GSPixel(55)),
      Seq(GSPixel(51), GSPixel(54)),
      Seq(GSPixel(50), GSPixel(53))
    )

    assert(filteredImage.getWidth == image.getHeight)
    assert(filteredImage.getHeight == image.getWidth)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
  }
}
