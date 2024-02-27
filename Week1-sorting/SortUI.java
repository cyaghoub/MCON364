package sortingHw;

import java.util.List;
import java.util.Scanner;

public class SortUI {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        char choice;
        List<Student> studentList;

        System.out.println("Generate a random list of grades? Enter Y or N:");
        choice = scanner.next().toUpperCase().charAt(0);

        while (choice != 'Y' && choice != 'N') 
        {
            System.out.println("Incorrect Input. Enter Y or N:");
            choice = scanner.next().toUpperCase().charAt(0);
        }

        if (choice == 'Y') 
        {
            studentList = getRandList();
        } else 
        {
            studentList = getUserList(scanner);
        }
        
        System.out.println("\nYour List:");
        printStudentList(studentList);

        System.out.println("\nChoose sorting algorithm - Enter 1 for QuickSort or 2 for MergeSort:");
        int alg = scanner.nextInt();

        while (alg != 1 && alg != 2) {
            System.out.println("Incorrect Input. Enter 1 or 2:");
            alg = scanner.nextInt();
        }

        sort(studentList, alg);
        
        if (Sort.isSorted(studentList)) {
            System.out.println("\nSorting successful!");
        } else {
            System.out.println("\nSorting failed!");
        }


    }

    private static void sort(List<Student> studentList, int alg) 
    {
        switch (alg) 
        {
            case 1:
                System.out.println("Sorting using QuickSort...");
                Sort.quickSort(studentList, 0, studentList.size() - 1);
                break;
            case 2:
                System.out.println("Sorting using MergeSort...");
                Sort.mergeSort(studentList);
                break;
            default:
                System.out.println("Error - invalid choice.");
        }

        // Print the sorted list
        System.out.println("\nSorted List:");
        printStudentList(studentList);
    }

    private static void printStudentList(List<Student> studentList) 
    {
        for (Student student : studentList) 
        {
            System.out.println("\t" + student.name + " - " + student.grade);
        }
    }

    private static List<Student> getUserList(Scanner scanner) 
    {
        List<Student> studentList = new java.util.ArrayList<>();
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) 
        {
            System.out.println("Enter name for Student " + (i + 1) + ": ");
            String name = scanner.next();

            System.out.println("Enter grade for Student " + (i + 1) + ": ");
            int grade = scanner.nextInt();

            studentList.add(new Student(name, grade));
        }

        return studentList;
    }

    // creates 10 student list with random grades 0-100
    private static List<Student> getRandList() 
    {
        java.util.Random rand = new java.util.Random();
        List<Student> studentList = new java.util.ArrayList<>();

        for (int i = 0; i < 10; i++) 
        {
            String name = "Student " + (i + 1);
            int grade = rand.nextInt(101);
            studentList.add(new Student(name, grade));
        }
        return studentList;
    }
}
