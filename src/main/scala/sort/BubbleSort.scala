package sort

class BubbleSort extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    val L = a.length
    for (sortTo <- L - 1 to 1 by -1) {
      var hasSorted = true
      for (n <- 1 to sortTo)
        if (a(n) < a(n - 1)) {
          swap(a, n, n - 1)
          hasSorted = false
        }
      if (hasSorted)
        return
    }
  }

  private def swap(a: Array[Int], i: Int, j: Int): Unit = {
    val temp = a(j)
    a(j) = a(i)
    a(i) = temp
  }
}