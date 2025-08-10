package charTables.config

/**
 * Enum representing character table name
 * @param name String representation of the character name
 * */
enum CharTableNames(val name: String) {
  case Default extends CharTableNames("default")
  case NonLinear extends CharTableNames("non-linear")
}