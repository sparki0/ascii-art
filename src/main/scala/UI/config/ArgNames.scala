package UI.config

/**
 * Enum representing arguments
 * @param name String representation of the argument
 */
enum ArgNames(val name: String) {
  case Image extends ArgNames("--image")
  case ImageRandom extends ArgNames("--image-random")
  case Table extends ArgNames ("--table")
  case CustomTable extends ArgNames("--custom-table")
  case Rotate extends ArgNames("--rotate")
  case Scale extends ArgNames("--scale")
  case Invert extends ArgNames("--invert")
  case Brightness extends ArgNames("--brightness")
  case Flip extends ArgNames("--flip")
  case OutputFile extends ArgNames("--output-file")
  case OutputConsole extends ArgNames("--output-console")
}