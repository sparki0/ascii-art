package filters

import data.pixels.GSPixel
import filters.image.invert.GSImage.GSInvertImageFilter
import org.scalatest.funsuite.AnyFunSuite

class GSInvertImageFilterTest extends AnyFunSuite {
  test("Grayscale image3x2 invert") {
    val image = GSImageGenerator.getGSImage3x2()
    val filter = new GSInvertImageFilter()
    val filteredImage = filter.apply(image)
    val check: Seq[Seq[GSPixel]] = Seq(
      Seq(GSPixel(205), GSPixel(204), GSPixel(203)),
      Seq(GSPixel(202), GSPixel(201), GSPixel(200))
    )

    assert(filteredImage.getPixel(0, 0) == check(0)(0))
    assert(filteredImage.getPixel(1, 0) == check(0)(1))
    assert(filteredImage.getPixel(2, 0) == check(0)(2))
    assert(filteredImage.getPixel(0, 1) == check(1)(0))
    assert(filteredImage.getPixel(1, 1) == check(1)(1))
    assert(filteredImage.getPixel(2, 1) == check(1)(2))
  }
}
