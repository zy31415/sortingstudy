package run

import java.io.File

import scopt.OParser
import sort.BubbleSort

object Run {
  val usage =
    """
      |Run a sort algorithm and report performance.
      |
      |Usage: -a algorithm filename
      |
    """.stripMargin

  def main(args: Array[String]): Unit = {
    val builder = OParser.builder[Config]
    val parser1 = {
      import builder.{programName, head, opt, help, arg, note}
      OParser.sequence(
        programName("sortrun"),
        head("sortrun", "0.1"),
        opt[String]('a', "algorithm")
          .action((x, c) => c.copy(algorithm = x))
          .text("Algorithm chosen to run"),
        help("help").text("prints this usage text"),
        arg[File]("file")
          .unbounded()
          .required()
          .action((x, c) => c.copy(file = x))
          .text("required unbounded args"),
        note("some notes." + sys.props("line.separator"))
      )
    }

    // OParser.parse returns Option[Config]
    OParser.parse(parser1, args, Config()) match {
      case Some(config) =>
      // do something
      case _ =>
      // arguments are bad, error message will have been displayed
    }

    val sorter = new BubbleSort()

    val arr = Array(1, 2, 3, 4, 5)

    sorter.sort(arr)
  }

  private def checkSorted(a: Array[Int]): Boolean = {
    val L = a.length
    for (i <- 1 until L) {
      if (a(i) < a(i-1))
        return false
    }
    true
  }
}
