package data.images

import data.pixels.Pixel

/**
 * Trait for image
 * @tparam T Type of image's pixel
 * @throws Exception If one of the dimension of image is 0 or image has different widths
 * */
trait Image[T <: Pixel]() {
  /**
   * Image pixels
   * */
  protected val pixels: Seq[Seq[T]]

  /**
   * Checking sequence of pixel
   * */
  if (pixels.isEmpty || pixels.head.isEmpty) {
    throw new Exception("Image dimension can't not be null")
  }

  /**
   * Image's height
   * */
  protected val height: Int = pixels.size

  /**
   * Image's width
   * */
  protected val width: Int = pixels.head.size

  /**
   * Check if all rows has same length(width)
   * */
  for(h <- 0 until height) {
    if(pixels(h).size != width) {
      throw new Exception("Image has different width")
    }
  }


  /**
   * Returns height of image
   * @return Gets height of image
   * */
  def getHeight: Int = height

  /**
   * Returns width of image
   * @return Gets width of image
   * */
  def getWidth: Int = width

  /**
   * Returns pixel at position (x,y)
   * @param x Position of pixel on X axis
   * @param y Position of pixel on Y axis
   * @return Gets pixel at position (x,y)
   * @throws Exception if x is out of range <0, width> or y is out of range <0, height>
   * */
  def getPixel(x: Int, y: Int): T = {
    if(x < 0 || x >= width)
      throw new Exception("Out of range x")
    if(y < 0 || y >= height)
      throw new Exception("Out of range y")

    pixels(y)(x)
  }
}
