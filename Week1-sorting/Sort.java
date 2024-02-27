package sortingHw;

import java.util.ArrayList;
import java.util.List;

public class Sort 
{

    // QUICKSORT:

    // if first is less than last, partitions, does recursive qs on left and right subarrays
    public static <T extends Comparable<T>> void quickSort(List<T> values, int firstIndex, int lastIndex) 
    {

        if (firstIndex < lastIndex) 
        {
            int pivot = partition(values, firstIndex, lastIndex);
            System.out.println("Pivot: " + "at index: " + pivot);
            quickSort(values, firstIndex, pivot - 1);
            quickSort(values, pivot + 1, lastIndex);
        }
    }

    // selects pivot, iterates thru and places elements less than to the left and
    // greater than to the right
    // swaps along the way, returns pivot index int
    private static <T extends Comparable<T>> int partition(List<T> values, int firstIndex, int lastIndex) 
    {
        T splitVal = values.get(firstIndex);
        int firstVal = firstIndex;
        boolean onCorrectSide;

        firstIndex++;

        do {
            onCorrectSide = true;
            while (onCorrectSide) 
            {
                if (splitVal.compareTo(values.get(firstIndex)) < 0) 
                {
                    onCorrectSide = false;
                } else 
                {
                    firstIndex++;
                    onCorrectSide = (firstIndex <= lastIndex)
                            && (splitVal.compareTo(values.get(firstIndex)) >= 0);
                }
            }

            onCorrectSide = (firstIndex <= lastIndex);

            while (onCorrectSide) 
            {
                if (splitVal.compareTo(values.get(lastIndex)) >= 0) 
                {
                    onCorrectSide = false;
                } else {
                    lastIndex--;
                    onCorrectSide = (firstIndex <= lastIndex)
                            && (splitVal.compareTo(values.get(lastIndex)) < 0);
                }
            }

            if (firstIndex < lastIndex) 
            {
                swap(values, firstIndex, lastIndex);
                firstIndex++;
                lastIndex--;
            }
        } while (firstIndex <= lastIndex);

        swap(values, firstVal, lastIndex);

        return lastIndex;
    }

    // swaps 2 elements in array
    private static <T> void swap(List<T> values, int index1, int index2) 
    {
        T temp = values.get(index1);
        values.set(index1, values.get(index2));
        values.set(index2, temp);
    }

    
    
    // MERGESORT:

    public static <T extends Comparable<T>> void mergeSort(List<T> values) 
    {
        if (values == null || values.size() <= 1) 
        {
            return;
        }

        mergeSort(values, 0, values.size() - 1);
    }

    // private recursive merge sort: finds middle point, sorts both halves and
    // merges them
    private static <T extends Comparable<T>> void mergeSort(List<T> values, int left, int right) 
    {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(values, left, middle);
            mergeSort(values, middle + 1, right);

            merge(values, left, middle, right);
        }
    }

    // merges two sorted halves into one sorted array
    private static <T extends Comparable<T>> void merge(List<T> values, int left, int middle, int right) 
    {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;
        
        System.out.println("Merging indices " + left + " through " + middle + " and " + (middle + 1) + " through " + right);

        List<T> leftList = new ArrayList<>(values.subList(left, left + leftSize));
        List<T> rightList = new ArrayList<>(values.subList(middle + 1, middle + 1 + rightSize));

        int i = 0, j = 0, k = left;
        


        while (i < leftSize && j < rightSize) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) 
            {
                values.set(k++, leftList.get(i++));
            } else 
            {
                values.set(k++, rightList.get(j++));
            }
        }

        while (i < leftSize) 
        {
            values.set(k++, leftList.get(i++));
        }

        while (j < rightSize) 
        {
            values.set(k++, rightList.get(j++));
        }
        
    }
    
    public static <T extends Comparable<T>> boolean isSorted(List<T> values) 
    {
        for (int i = 1; i < values.size(); i++) 
        {
            if (values.get(i - 1).compareTo(values.get(i)) > 0) 
            {
                return false;
            }
        }
        return true;
    }
}
