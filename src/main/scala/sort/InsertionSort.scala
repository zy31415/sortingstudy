package sort

class InsertionSort extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    val L = a.length
    for (n <- 1 until L) {
      val key = a(n)
      var i = n - 1
      while (i >= 0 && a(i) > key) {
        a(i+1) = a(i)
        i -= 1
      }
      a(i+1) = key
    }
  }
}
