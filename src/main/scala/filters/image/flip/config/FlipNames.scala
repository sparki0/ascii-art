package filters.image.flip.config

/**
 * Enum representing axis for flipping an image.
 * @param name String representation of the axis.
 */
enum FlipNames(val name: String) {
  case X extends FlipNames("x")
  case Y extends FlipNames("y")
}