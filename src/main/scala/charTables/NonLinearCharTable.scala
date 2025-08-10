package charTables

import scala.util.Random

/**
 * Class for non-linear character table
 */

class NonLinearCharTable extends CharTable {
  override def getTable(): String = generate()
  
  /**
   * Characters for generating non-linear table
   * */
  private var str = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. "

  /**
   * Generates non-linear table
   * */
  private def generate(): String = {
    var table: String = ""
    table += pickRandomChar(70)
    table += pickRandomChar(50)
    table += pickRandomChar(20)
    table += str

    table
  }

  /**
   * Picks random char from str and make from that string of specific length
   * @param repeatCnt Length of string
   * */
  private def pickRandomChar(repeatCnt: Int): String = {
    val random = new Random()
    val randomInd = random.nextInt(str.length)
    val res = str(randomInd).toString.repeat(repeatCnt)
    str = str.replace(str(randomInd).toString, "")
    res
  }
}
