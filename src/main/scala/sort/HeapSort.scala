package sort

import myheap.HeapUtils

class HeapSort extends Sorter {
  override def sort(a: Array[Int]): Unit = {
    HeapUtils.buildMaxHeap(a)

    for (n <- a.length - 1 to 1 by -1) {
      swap(a, 0, n)
      HeapUtils.maxHeapify(a, 0, heapSize = n)
    }

  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(j)
    arr(j) = arr(i)
    arr(i) = temp
  }
}
