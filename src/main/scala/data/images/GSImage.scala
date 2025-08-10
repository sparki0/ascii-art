package data.images

import data.pixels.GSPixel

/**
 * Class for grayscale Image
 * @param pixels sequence of Grayscale pixels
 * */
case class GSImage(protected val pixels: Seq[Seq[GSPixel]]) extends Image[GSPixel] {

}