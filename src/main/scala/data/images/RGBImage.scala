package data.images

import data.pixels.RGBPixel

/**
 * Class for RGB Image
 * @param pixels sequence of RGB pixels
 * */
case class RGBImage(protected val pixels: Seq[Seq[RGBPixel]]) extends Image[RGBPixel] {

}
