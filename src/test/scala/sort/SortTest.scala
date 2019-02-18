package sort

import org.scalatest.FunSuite

class SortTest extends FunSuite {

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }

  def assertAscending(a: Array[Int]):Unit =
    for (i <- 1 until a.length)
      assert(a(i) >= a(i-1))

  test("Test Bubble sort - assending") {
    val arr = (1 to 10000).toArray
    val sorter = new BubbleSort()
    time {
      sorter.sort(arr)
    }
    assertAscending(arr)
  }

  test("Test Bubble sort - descending") {
    val arr = (10000 to 1 by -1).toArray
    val sorter = new BubbleSort()

    time {
      sorter.sort(arr)
    }
    assertAscending(arr)
  }

  test("MergeSort") {
    val arr = (10000 to 1 by -1).toArray
    val sorter = new InsertionSort()

    time {
      sorter.sort(arr)
    }
    assertAscending(arr)
  }
}
