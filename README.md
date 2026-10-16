# Heuristic-Sort

Heuristic Sorting Algorithm

A fast sorting algorithm that is 30 to 60 times faster than InsertSort for large lists


I came up with the idea of using a linear function (y = k * x + b) to sort dynamic arrays. Here, y is the approximate index of the element x.

For this to work, you first need to determine k and b. Since we always know two elements and their indices, it’s not difficult. The minimum index (usually 0) and the maximum index (the length of the array minus 1) are always known. For these two indices, you need to determine the smallest value in the array and find the largest value in the array.

The system of equations we need to solve looks like this:
if the minimum value in the array = Min
if the maximum value in the array = Max
if the minimum index = MinIndex
and the maximum index = MaxIndex
then

MinIndex = k * Min + b
MaxIndex = k * Max + b

To determine k and b, we use basic mathematical concepts and find that

k = ( MaxIndex – MinIndex ) / (Max – Min)

b = MinIndex – k * Min

And just like that, we can calculate an approximate index for a specific value.


Procedure


1. First, create an empty array with the same indices as the original array you want to sort. Usually, this is 0..Array.count() - 1. The new array must be initialized with a value (dump) that cannot appear in the original array, so you can tell whether a slot in the new array is already occupied or not.
2. Now we try to sort the elements from the original array into the new array by simply calculating the index for each element in the original array using the formula (Index = k * Array[i] + b) and inserting the element into the new array if the position is not yet occupied. If the position is occupied, we copy the element to a temporary array.
3. Now we need to remove the duplicate elements from the new array. As a result, we end up with a sorted array that, based on experience, contains 50–60% of the elements from the original array, and we still have a temporary array containing elements that did not fit because their index was the same as that of another element. All of this is done in just O(n) steps.
4. What remains is to sort the elements from the temporary array into the new sorted array. To do this, you can simply proceed linearly or use a modified binary search to find the correct position in the new array and insert the element.
5. In the end, we have the unsorted original array and a new sorted array. We can then continue working with these.


Empirical data

I implemented the algorithm in Kotlin because it makes it very easy to work with dynamic arrays. I generated arrays of random data and found the following:

1. The algorithm is not efficient for small arrays. It is far slower than insertion sort. Therefore, arrays with fewer than 200 elements are better sorted using conventional sorting algorithms.
2. With large arrays containing 200 or more elements, the algorithm demonstrates fascinating speed. For 300 elements, it is 2–3 times faster than insertion sort, and for 30,000 elements, for example, it is 50–60 times faster than insertion sort when using binary search.
