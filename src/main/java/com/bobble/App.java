package com.bobble;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class App 
{
    public static ArrayList<ArrayList<String>> readDataLineByLine(String file)
    {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

        try {

            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
            while ((nextRecord = csvReader.readNext()) != null) {
                ArrayList<String> stringArrayList = new ArrayList<>();
                for (String cell : nextRecord) {
                    stringArrayList.add(cell);
                }
                arrayList.add(stringArrayList);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static ArrayList<String> permutationsOfDynamicArray(ArrayList<ArrayList<String>> arrayList){
        //number of arrays
        int length = arrayList.size();

        //ArrayList to store the permutations
        ArrayList<String> stringArrayList = new ArrayList<>();

        //to keep track of the next element in each of the n arrays
        int index[] = new int[length];

        while(true) {
            String resultantString = "";
            //required combination of arrays
            for (int i = 0; i < length; i++) {
                resultantString += (arrayList.get(i).get(index[i]));
            }
            //add current combination to the array-list
            stringArrayList.add(resultantString);

            //find the array from the right side that has more elements left than the current array
            int next = length -1;

            while(next >=0 && index[next] + 1 >= arrayList.get(next).size())
                next--;

            //when no more combinations are possible
            if(next< 0)
                return stringArrayList;

            //move to next element in the array
            index[next]++;

            //make all the arrays to the right to point to the first element again
            for(int i=next +1;i<length;i++)
            {
                index[i] = 0;
            }
        }
    }
    public static void main( String[] args )
    {
        ArrayList<ArrayList<String>> arrayList=readDataLineByLine("input.csv");;
        //To read the data from the CSV file and store it into a dynamic array
//        if(args.length > 0) {
//             arrayList= readDataLineByLine(args[0]);
//        }
//        else{
//             arrayList= readDataLineByLine("input.csv");
//        }
        //To find out all the possible permutations and store them into an ArrayList
         ArrayList<String> permutationsOfArrays = permutationsOfDynamicArray(arrayList);
         //Print the array list with all possible permutations
        System.out.println(permutationsOfArrays);
    }
}
