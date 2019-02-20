package myheap

class HeapUtils {

}

object HeapUtils {
  def maxHeapify(arr: Array[Int], i: Int, heapSize: Int = -1): Unit = {

    val _heapSize = if (heapSize < 0) arr.length else heapSize

    val l = (i << 1) + 1
    val r = (i << 1) + 2
    var largest = i

    if (l < _heapSize && arr(l) > arr(i))
      largest = l

    if (r < _heapSize && arr(r) > arr(largest)) {
      largest = r
    }

    if (largest != i) {
      swap(arr, i, largest)
      maxHeapify(arr, largest, heapSize=heapSize)
    }
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    val temp = arr(j)
    arr(j) = arr(i)
    arr(i) = temp
  }

  def buildMaxHeap(arr: Array[Int]): Unit = {
    val L = arr.length
    val N = L / 2
    N to 0 by -1 foreach {
      i => maxHeapify(arr, i)
    }
  }
}

