package UI.parsers

import UI.argHandlers.charTable.{CharTableHandler, CustomCharTableHandler}
import UI.argHandlers.exporter.{ConsoleExporterHandler, TextFileExporterHandler}
import UI.argHandlers.filter.brightness.GSBrightnessImageFilterHandler
import UI.argHandlers.filter.invert.GSInvertImageFilterHandler
import UI.argHandlers.filter.rotate.GSRotateImageFilterHandler
import UI.argHandlers.filter.scale.GSScaleImageFilterHandler
import UI.argHandlers.filter.flip.GSFlipImageFilterHandler
import UI.argHandlers.importer.{FileRGBImageImporterHandler, RandomRGBImageImporterHandler}
import UI.config.ArgNames
import workflow.ArgCollector

/**
 * Class for console parsing
 * @param collector Object where arguments will be collected 
 * */

class ConsoleParser(collector: ArgCollector) extends Parser[Array[String]]{
  /**
   * Map associating argument names with their corresponding handler
   * */
  private val handlerMap = Map(
    ArgNames.Image.name -> new FileRGBImageImporterHandler(),
    ArgNames.ImageRandom.name -> new RandomRGBImageImporterHandler(),
    ArgNames.Table.name -> new CharTableHandler(),
    ArgNames.CustomTable.name -> new CustomCharTableHandler(),
    ArgNames.Brightness.name -> new GSBrightnessImageFilterHandler(),
    ArgNames.Invert.name -> new GSInvertImageFilterHandler(),
    ArgNames.Rotate.name -> new GSRotateImageFilterHandler(),
    ArgNames.Scale.name -> new GSScaleImageFilterHandler(),
    ArgNames.Flip.name -> new GSFlipImageFilterHandler(),
    ArgNames.OutputFile.name -> new TextFileExporterHandler(),
    ArgNames.OutputConsole.name -> new ConsoleExporterHandler()
  )

  /**
   * Parses arguments
   * @param args Arguments to parse
   * @throws Exception If argument is not presented in map
   * */
  override def parse(args: Array[String]): Unit = {
    if(args.isEmpty)
      throw new Exception("No argument provided")

    var remainingArgs = args
    while(remainingArgs.nonEmpty) {
      val argName = remainingArgs(0).toLowerCase()
      val handler = handlerMap.getOrElse(argName, throw new Exception(s"Invalid argument name: ${argName}"))
      val wrapper = handler.handle(remainingArgs.drop(1))
      wrapper.addToCollector(collector)
      remainingArgs = wrapper.getRemainingArgs()
    }
  }
}
