package Main

import UI.parsers.ConsoleParser
import workflow.{ArgCollector, ArgExecutor}

object Main{
  def main(args: Array[String]): Unit = {
    val collector = new ArgCollector()
    val parser = new ConsoleParser(collector)
    parser.parse(args)
    val executor = new ArgExecutor(collector)
    executor.execute()
  }
}