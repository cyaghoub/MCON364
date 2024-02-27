package sortingHw;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest 
{

    @Test
    public void testQuickSort() 
    {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("John", 75),
                new Student("Alice", 90),
                new Student("Bob", 80),
                new Student("Charlie", 65)
        ));

        Sort.quickSort(students, 0, students.size() - 1);

        assertTrue(Sort.isSorted(students));
    }

    @Test
    public void testMergeSort() {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("John", 75),
                new Student("Alice", 90),
                new Student("Bob", 80),
                new Student("Charlie", 65)
        ));

        Sort.mergeSort(students);

        assertTrue(Sort.isSorted(students));
    }

    @Test
    public void testEmptyList() {
        List<Student> students = new ArrayList<>();

        Sort.quickSort(students, 0, students.size() - 1);

        assertTrue(Sort.isSorted(students));
    }

    @Test
    public void testSingleElementList() {
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("John", 75)));

        Sort.mergeSort(students);

        assertTrue(Sort.isSorted(students));
    }
}
