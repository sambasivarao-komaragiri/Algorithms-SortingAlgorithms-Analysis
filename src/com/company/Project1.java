package com.company;



import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Project1 {

    Integer arrayList[] = null;
   // Boolean isMedianOfThree=false;


    public Integer[] insertionSort(Integer a[]) {

        // write your code here

        // insert code here...
        final long startTime = System.nanoTime();
       // Integer a[] = arrayList;
        //int xyz[]=
        int i, j;
        int key;
        for (i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }

        final long endTime = System.nanoTime();
        System.out.println("\nSorting time for insertion sort: " + (endTime - startTime)+ " nanoseconds");
        return a;
    }

    public void displayArray(Integer a[]) {

        for (int value : a) {
            System.out.print(value + "\t");
        }
    }

    public Integer[] generateRandArray(int arraySize, int arrayType) {

        Random rand = new Random();
        Integer[] randArray = new Integer[arraySize];
        for (int index = 0; index < arraySize; index++) {
            randArray[index] = rand.nextInt(2147483647);
        }

        if (arrayType == Integer.MIN_VALUE) {
            Arrays.sort(randArray);
        } else if (arrayType == Integer.MAX_VALUE) {
            Arrays.sort(randArray,Collections.reverseOrder());

        }

        return randArray;
    }

    public Integer[] mergeSort(Integer arrayList[]) {


       // Integer arrayList[] = {5,1,2,6,3};

        final long startTime = System.nanoTime();
        mDivide(0, arrayList.length-1, arrayList);
        final long endTime = System.nanoTime();
        System.out.println("\nSorting time for merge sort: " + (endTime - startTime)+ " nanoseconds");
        return arrayList;
    }

    public Integer[] inPlaceQuickSort(Integer arrayList[]) {


        final long startTime = System.nanoTime();
        this.arrayList = arrayList;
        qSort(0,arrayList.length-1);

        final long endTime = System.nanoTime();
        System.out.println("\nSorting time for inplace quick sort: " + (endTime - startTime)+ " nanoseconds");
        return arrayList;
    }

    public void qSort(int p, int r){

        if(p<r){

           int q=qPartition(p,r);
           qSort(p,q-1);
           qSort(q+1,r);

        }
    }

    public int qPartition(int p,int r){

       int index = new Random().nextInt((r - p) + 1) + p;
       int pivotvalue = arrayList[index];
       int lastvalue = arrayList[r];
       arrayList[index] = lastvalue;
       arrayList[r] = pivotvalue;

       int pivot=arrayList[r];

            int i=p-1;int j;
            for(j=p;j<r;j++){
                if(arrayList[j]<=pivot){
                    i=i+1;
                    int temp = arrayList[i];
                    arrayList[i]=arrayList[j];
                    arrayList[j]=temp;
                }
            }

            int temp=arrayList[r];
        arrayList[r]=arrayList[i+1];
        arrayList[i+1]=temp;

            return i+1;
    }

    public Integer[] modifiedQuickSort(Integer arrayList[]) {


        final long startTime = System.nanoTime();
        this.arrayList = arrayList;
        modifiedQuickSort(0,arrayList.length-1);

        final long endTime = System.nanoTime();
        System.out.println("\nSorting time for inplace quick sort: " + (endTime - startTime)+ " nanoseconds");
        return arrayList;
    }

    public int quickSortMedianOfThreePartition(int p,int r){


        int firstValue = arrayList[p];
        int lastValue = arrayList[r];

        int midPivotValue = (p+r)/2;
        int midvalue = arrayList[midPivotValue];
        int median = p;


        if((firstValue<lastValue && firstValue>midvalue)||(firstValue>lastValue && firstValue<midvalue)){
            median =p;
        }else if((lastValue<firstValue && lastValue>midvalue)||(lastValue>firstValue && lastValue<midvalue)){
            median =r;
        }else{
            median = midPivotValue;
        }

        arrayList[median] = lastValue;
        arrayList[r] = midvalue;

        int pivot=arrayList[r];

        int i=p-1;int j;
        for(j=p;j<r;j++){
            if(arrayList[j]<=pivot){
                i=i+1;
                int temp = arrayList[i];
                arrayList[i]=arrayList[j];
                arrayList[j]=temp;
            }
        }

        int temp=arrayList[r];
        arrayList[r]=arrayList[i+1];
        arrayList[i+1]=temp;

        return i+1;
    }

    public void modifiedQuickSort(int start, int end){

        if(start<end){

            int partitionIndex =quickSortMedianOfThreePartition(start,end);
            modifiedQuickSort(start,partitionIndex-1);
            modifiedQuickSort(partitionIndex+1,end);

        }
    }


    public static void mDivide(int startIndex, int endIndex, Integer[] a ) {

        if (startIndex < endIndex) {

            int mid = (startIndex + endIndex) / 2;

            mDivide(startIndex, mid, a);
            mDivide(mid + 1, endIndex, a);

            //merge(a,startIndex, mid, endIndex);   //2 3 4 6 7 8 11 11 22 77
            mSort(startIndex, mid, endIndex, a); //2 3 4 6 7 8 11 11 22 77
        }
    }

    private static void mSort(int start,int mid, int end, Integer[] a) {

            int leftArraySize = mid-start+1;
            int rightArraySize = end-mid;

            Integer[] leftArray = new Integer[leftArraySize];
            Integer[] rightArray = new Integer[rightArraySize];
            int xstart = start;
            int xmid = mid;

            for(int i=0;i<leftArray.length;i++) {
                leftArray[i] = a[xstart];
                xstart++;
            }

            for (int i=0;i<rightArray.length;i++) {
                rightArray[i] = a[xmid+1];
                xmid++;
            }

            int k= start;

            for(int i=0,j=0;i<leftArray.length || j<rightArray.length;) {

                if(i<leftArray.length && j<rightArray.length) {
                    if(leftArray[i]<rightArray[j]) {
                        a[k] = leftArray[i];
                        k++;
                        i++;
                    }else {
                        a[k] = rightArray[j];
                        k++;
                        j++;
                    }
                }else {

                    if(i<leftArray.length) {
                        a[k] = leftArray[i];
                        k++;
                        i++;
                    }

                    if(j<rightArray.length) {
                        a[k] = rightArray[j];
                        k++;
                        j++;
                    }

                }

            }

        }


}
