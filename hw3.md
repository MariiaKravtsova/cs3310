CS 3310
Homework 3
Mariia Kravtsova

Problem: Create an efficient iterative solution of merge sort.

Solution: For this solution I have a bottom up merge sort. Create small subarrays then merge them in pairs. Theoretically the bottom up merge sort uses between 1/2nlogn and nlogn accesses to sort an array of length n. This sort seems to work well for linked list since we start with smaller chunks of data and it is easier to compare linked list on a smaller scale.

MergeSort() {
  for (size = 1; size < length; size += size)
    for (index = 0; index < length-size; index += size+size)
      merge(array, index, index+size-1, minimum(index+size+size-1, length-1));
}

merge(array, low, mid, high) {  
     i = low
     j = mid+1
    while (i < low.length || j < high.length) {
        if (i < low.length && j < high.length) {
            if (low[i] <= high[j]) {
                array[k++] = low[i++];
            } else {
                array[k++] = high[j++];
            }
        } else if (i < low.length) {
            array[k++] = low[i++];
        } else if (j < high.length) {
            array[k++] = high[j++];
        }
    }  
}

Problem: Write an algorithm of an iterative or recursive merge sort that will sort an array A[0…n-1] with n elements using n threads.

Solution: After trying the iterative approach I was able to chunk the array and start a thread for each. However after encountering a problem with merge I switched to the idea of using recursive merge sort but with my previous solution. Now instead of chunking data, I am chunking the threads. So I create to threads low and high, and from each of those I create another thread from low and high. This lets my merge run smoother than in the iterative approach.

Main() {
  Array = [0 ... n]
  int size = length(Array)
  numberOfThreads = x * 2 // x is the desired number of cores, grows by 2

  for (i = 1; i <= numberOfThreads; i++) {
    ParallelMergeSort(Array, x, size)
  }
}

ParallelMergeSort(Array, x, size) {
  middle = size / 2
  if x == 0 {
    mergeSort(Array)
  }
  // chunk data
  lowArray = Arrays.copy(0, middle) // copy from 0 to middle of the original Array
  highArray = Arrays.copy(middle, size) // copy from middle to end of the original Array

  // Create lowThread and high thread that run MergeSort
  lowThread = Thread(RunnableMergeSort(lowArray, x / 2))
  highThread = Thread(RunnableMergeSort(highArray, x / 2))

  // Start the threads
  lowThread.start()
  highThread.start()

  // Wait for all of them to finish
  lowThread.join()
  highThread.join()

  // Merge the arrays
  merge(low, high, Array, size)
}

// Runnable runs the ParallelMergeSort which repeats the division
// This creates layers of parallel threads
RunnableMergeSort (Array, threadLevel) {
  ParallelMergeSort(Array, threadLevel)
}

Merge(low, high, Array, size) {
  for (i = 0; i < size; i++) {
    if b >= length(high)
      Array[i] = low[a]
      a++
    if a < length(low) and low[a] < high[b]
      Array[i] = low[a]
      a++
    else
      Array[i] = high[b]
      b++
  }
}


// Below is a less working solution for iterative approach

Main() {
  Array = [0 ... n]
  tempArray
  size = length(Array)

  chunk_size = array.length / threadNumber;
  for (start = 0; start < array.length ; start+=chunk_size) {
    tempArray = Arrays.copy(start, start + chunk_size);
    Thread NameThread = new Thread(new MergeSort(tempArray)
  }
}

MergeSort(tempArray) {
  for (size = 1; size < length; size += size)
    for (index = 0; index < length-size; index += size+size)
      merge(tempArray, index, index+size-1, minimum(index+size+size-1, length-1));
}


merge(array, low, mid, high) {  
     i = low
     j = mid+1
     // Copy low to high
     for (k = low; k <= high; k++)  
        temp[k] = array[k]

     // Merge array low to high
     for (k = low; k <= high; k++)  
        if      (i > mid)              
          array[k] = temp[j++]
        else if (j > high )              
          array[k] = temp[i++]
        else if (temp[j] < temp[i])
          array[k] = temp[j++]
        else                           
          array[k] = temp[i++]
}
