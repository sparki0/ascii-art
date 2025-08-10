package filters

import data.pixels.GSPixel
import filters.image.scale.GSImage.GSScaleImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSScaleImageFilterTest extends AnyFunSuite {
  test("Invalid scale value 10") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSScaleImageFilter(10)
    
    assertThrows[Exception] {
      val filteredImage = filter.apply(image)
    }
  }

  test("Invalid scale value -100") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSScaleImageFilter(-100)
    
    assertThrows[Exception] {
      val filteredImage = filter.apply(image)
    }
  }

  test("Valid scale value 0.25 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSScaleImageFilter(0.25)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50))
    )

    assert(filteredImage.getWidth == 1)
    assert(filteredImage.getHeight == 1)
    assert(filteredImage.getPixel(0,0) == check(0)(0))
  }

  test("Valid scale value 1 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSScaleImageFilter(1)
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

  test("Valid scale value 4 image2x2") {
    val image = GSImageGenerator.getGSImage2x2()
    val filter = new GSScaleImageFilter(4)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(50), GSPixel(51), GSPixel(51)),
      Seq(GSPixel(50), GSPixel(50), GSPixel(51), GSPixel(51)),
      Seq(GSPixel(52), GSPixel(52), GSPixel(53), GSPixel(53)),
      Seq(GSPixel(52), GSPixel(52), GSPixel(53), GSPixel(53)),
    )
    
    assert(filteredImage.getWidth == 4)
    assert(filteredImage.getHeight == 4)

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(3, 0) == check(0)(3))

    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
    assert(filteredImage.getPixel(3, 1) == check(1)(3))

    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
    assert(filteredImage.getPixel(2, 2) == check(2)(2))
    assert(filteredImage.getPixel(3, 2) == check(2)(3))

    assert(filteredImage.getPixel(0, 3) == check(3)(0))
    assert(filteredImage.getPixel(1, 3) == check(3)(1))
    assert(filteredImage.getPixel(2, 3) == check(3)(2))
    assert(filteredImage.getPixel(3, 3) == check(3)(3))
  }

  test("Valid scale value 0.25 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSScaleImageFilter(0.25)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(52))
    )

    assert(filteredImage.getWidth == 2)
    assert(filteredImage.getHeight == 1)
    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
  }

  test("Valid scale value 1 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSScaleImageFilter(1)
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

  test("Valid scale value 4 image3x2") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSScaleImageFilter(4)
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(50), GSPixel(50), GSPixel(51), GSPixel(51), GSPixel(52), GSPixel(52)),
      Seq(GSPixel(50), GSPixel(50), GSPixel(51), GSPixel(51), GSPixel(52), GSPixel(52)),
      Seq(GSPixel(53), GSPixel(53), GSPixel(54), GSPixel(54), GSPixel(55), GSPixel(55)),
      Seq(GSPixel(53), GSPixel(53), GSPixel(54), GSPixel(54), GSPixel(55), GSPixel(55)),
    )
    
    assert(filteredImage.getWidth == 6)
    assert(filteredImage.getHeight == 4)

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(3, 0) == check(0)(3))
    assert(filteredImage.getPixel(4, 0) == check(0)(4))
    assert(filteredImage.getPixel(5, 0) == check(0)(5))

    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
    assert(filteredImage.getPixel(3, 1) == check(1)(3))
    assert(filteredImage.getPixel(4, 1) == check(1)(4))
    assert(filteredImage.getPixel(5, 1) == check(1)(5))

    assert(filteredImage.getPixel(0, 2) == check(2)(0))
    assert(filteredImage.getPixel(1, 2) == check(2)(1))
    assert(filteredImage.getPixel(2, 2) == check(2)(2))
    assert(filteredImage.getPixel(3, 2) == check(2)(3))
    assert(filteredImage.getPixel(4, 2) == check(2)(4))
    assert(filteredImage.getPixel(5, 2) == check(2)(5))

    assert(filteredImage.getPixel(0, 3) == check(3)(0))
    assert(filteredImage.getPixel(1, 3) == check(3)(1))
    assert(filteredImage.getPixel(2, 3) == check(3)(2))
    assert(filteredImage.getPixel(3, 3) == check(3)(3))
    assert(filteredImage.getPixel(4, 3) == check(3)(4))
    assert(filteredImage.getPixel(5, 3) == check(3)(5))
  }
}
