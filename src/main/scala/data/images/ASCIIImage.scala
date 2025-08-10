package data.images

import data.pixels.ASCIIPixel


/**
 * Class for ASCII Image
 * @param pixels sequence of ASCII pixels
 * */
case class ASCIIImage(protected val pixels: Seq[Seq[ASCIIPixel]]) extends Image[ASCIIPixel] {

}
