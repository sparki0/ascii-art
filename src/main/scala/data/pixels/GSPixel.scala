package data.pixels

/**
 * Class for grayscale pixel
 * @param value Value of grayscale pixel
 * @throws Exception If value it outside of range <0,255>
 * */
case class GSPixel(value: Int) extends Pixel{
  if (value < 0 || value > 255)
    throw new Exception("Greyscale value must be in interval of integer <0, 255>")
}
