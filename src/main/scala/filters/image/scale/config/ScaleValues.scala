package filters.image.scale.config

/**
 * Enum representing scale values
 * @param value Scale value in double
 * */
enum ScaleValues(val value: Double){
  case Quarter extends ScaleValues(0.25)
  case One extends ScaleValues(1)
  case Four extends ScaleValues(4)
}