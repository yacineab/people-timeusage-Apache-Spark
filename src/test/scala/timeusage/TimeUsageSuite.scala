package timeusage

import org.apache.spark.sql.types.{DoubleType, StringType}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterAll, FunSuite}
import timeusage.TimeUsage.read

@RunWith(classOf[JUnitRunner])
class TimeUsageSuite extends FunSuite with BeforeAndAfterAll {
  val (columns, initDf) = read("/timeusage/atussum2.csv")
  // val (primaryNeedsColumns, workColumns, otherColumns) = classifiedColumns(columns)
  // val summaryDf = timeUsageSummary(primaryNeedsColumns, workColumns, otherColumns, initDf)
  // val finalDf = timeUsageGrouped(summaryDf)

  test("dfSchema") {

    val dfS = TimeUsage.dfSchema(List("Eating", "Sleeping"))

    assert(dfS.fields(0).name === "Eating")
    assert(!dfS.fields(0).nullable)
    assert(dfS.fields(0).dataType === StringType)
    assert(dfS.fields(1).name === "Sleeping")
    assert(!dfS.fields(1).nullable)
    assert(dfS.fields(1).dataType === DoubleType)
  }

  test("Row") {
    val rw = TimeUsage.row(List("working","00", "12"))
    assert(rw(0).getClass.getName === "java.lang.String")
    assert(rw(1).getClass.getName === "java.lang.Double")
  }


}
