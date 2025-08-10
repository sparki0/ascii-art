package importers

import importers.utility.FileUtility
import org.scalatest.funsuite.AnyFunSuite

class FileUtilityTest extends AnyFunSuite {
  test("No extension") {
    val path = "Some/path/without/extension"
    val fileUtility = new FileUtility()

    assertThrows[Exception] {
      fileUtility.getExtension(path)
    }
  }

  test("Has extension") {
    val path = "Some/path/with/extension.png"
    val fileUtility = new FileUtility()
    val extension = fileUtility.getExtension(path)

    assert(extension == "png")
  }
}
