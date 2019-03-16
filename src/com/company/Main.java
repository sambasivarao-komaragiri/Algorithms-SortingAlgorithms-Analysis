package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int option=-1,arrayType=-1,arrayLength=-1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length");
        arrayLength=Integer.parseInt(scanner.nextLine());
        System.out.println("Choose array type\n\n1.Run sorting algorithm on unsorted list\n\n2.Run sorting algorithm on sorted list\n\n3.Run sorting algorithm on reverse sorted list");
        option=Integer.parseInt(scanner.nextLine());

        switch (option){
            //  Generate random array
            case 1: arrayType=0;
            break;
            //  Generate sorted array
            case 2: arrayType=Integer.MIN_VALUE;
            break;
            //  Generate reverse sorted array
            case 3: arrayType=Integer.MAX_VALUE;
        }
        Project1 project1 = new Project1();
        Integer randArray[]=project1.generateRandArray(arrayLength,arrayType);
        Integer[] insertionInputArray = randArray.clone();
        Integer[] quickSortInputArray = randArray.clone();
        Integer[] mergeSortInputArray = randArray.clone();
        Integer[] modifiedQuickSortInputArray = randArray.clone();

        System.out.println("Elements to be sorted: ");
        project1.displayArray(randArray);
        System.out.println("\n\nInsertion Sort: ");

        Integer insertionSorted[]=project1.insertionSort(insertionInputArray);
       // project1.displayArray(insertionSorted);
        System.out.println("\n\nMerge Sort: ");

        Integer MergeSortedArray[]=project1.mergeSort(
                mergeSortInputArray);
       // project1.displayArray(MergeSortedArray);

        System.out.println("\n\nInplace Quick Sort: ");
        Integer inPlaceQuickArray[]=project1.inPlaceQuickSort(quickSortInputArray);
       // project1.displayArray(inPlaceQuickArray);

        System.out.println("\n\nModified Quick Sort: ");
        Integer modifiedQuickSortArray[]=project1.modifiedQuickSort(modifiedQuickSortInputArray);
      //  project1.displayArray(modifiedQuickSortArray);

    }

}
