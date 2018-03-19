/**
 * MiniProject: Parsing the national US baby names data
 * 
 * @version February 16, 2016
 */

 

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("The total names: " + totalBirths);
        System.out.println("The number of unique girls names: " + totalGirls);
        System.out.println("The number of unique boys names: " + totalBoys);
    }

    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("babynamedata/us_babynames_by_year/yob1900.csv");
        totalBirths(fr);
    }
    
    public static int getRank (int year, String name, String gender) {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("babynamedata/us_babynames_by_year/yob" + String.valueOf(year) +".csv");
        int pivot = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                pivot++;
                if(rec.get(0).equals(name)) 
                    return pivot;
            }
        }
        return 0;
    }
    
    public static String getName(int year, int rank, String gender) {
        
        //get the file
        FileResource fr = new FileResource("babynamedata/us_babynames_test/yob" + String.valueOf(year) +"short.csv");
        
        int pivot = 0;
        //get the CSV file
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(1).equals(gender)){ 
                
                pivot ++;
                if(pivot == rank) return rec.get(0);
            }
        }//end for CSV record loop;
        
        System.out.println("The rank: " + rank + "... The last one rank " + pivot + ".");
        return "NO NAME";
        
    }//end getName() method;

    public static void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        //System.out.println(name + " ranks " + rank + " at year " + year1);
        String equalName = getName(newYear, rank, gender);
        
        if (gender == "F"){
            System.out.println( name + " born in " + year + " would be " + equalName + " if she was born in " + newYear);
        }
        else if (gender == "M"){
        //Isabella born in 2012 would be Sophia if she was born in 2014.
        System.out.println( name + " born in " + year + " would be " + equalName + " if he was born in " + newYear);
        }
    }//end whatIsNameInYear() method;
    
    public static int yearOfHighestRank(String name, String gender) {
        //initial year and rank;
        int rank = 1000000;
        int yearHigh = 0;
        
        //get the directory:
        DirectoryResource dr = new DirectoryResource();
        
        //get the files
        for(File fi : dr.selectedFiles()){
            
            //get the name of the file, which contains the year
            String fileName = fi.getName();
            
            //get the year integer from the name of the file
            int year = Integer.parseInt(fileName.replaceAll("[\\D]", ""));
            
            //get the FileResource
            FileResource fr = new FileResource(fi);
            int currRank = -1;
            int pivot = 0;
            for(CSVRecord record : fr.getCSVParser(false)){
                
                if(record.get(1).equals(gender)) {
                    
                    pivot++;
                                
                    if(record.get(0).equals(name)) {
                        currRank = pivot;
                        break;
                    }
                    
                }
                
            }//end for loop;
            
            //int currRank = getRank(year, name, gender);
        //  System.out.println("  At year " + year + " name " + name + " gender " + gender + " ranks " + currRank + ". ");
            
            if(currRank != -1 && currRank < rank){
                rank = currRank;
                yearHigh = year;
            }//end if condition;
        
        }//end for File fi loop;
        
        return yearHigh;
    }
    
    public static double getAverageRank(String name, String gender) {
        //get director
        DirectoryResource dr = new DirectoryResource();
        int fileNum = 0;
        int totalRank = 0;
        
        for(File fi : dr.selectedFiles()){
            fileNum++;
            
            //get the file resource
            FileResource fr = new FileResource(fi);
        
            int pivot = 0;
            int currRank = 0;
            for(CSVRecord record : fr.getCSVParser(false) ){
                if(record.get(1).equals(gender)) {
                    pivot++;
                    if(record.get(0).equals(name)) {
                        currRank = pivot;
                        break;
                    } //end if record.equals name condition;
                }
            }//end for Record loop;
            totalRank += currRank;
        }//end for file loop;
        if(totalRank == 0) return -1;
        else return (double)(totalRank)/fileNum;
    }//end getAverageRank() method;

    public static int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("babynamedata/us_babynames_by_year/yob" + String.valueOf(year) +".csv");
        
        int sum = 0;
        for(CSVRecord record : fr.getCSVParser(false)){
            
            if(record.get(1).equals(gender)){
                
                if(record.get(0).equals(name)) 
                    return sum;
                
                sum += Integer.parseInt(record.get(2));
                                
            }//end if record euqals gender condition;
            
        }//end for CSV record record;
        
        return sum;
    }//end getTotalBirthsRankedHigher() method;
    
    public static void getRankTest() {
        //What is the rank of the boy’s name “Frank” in 1971?
        System.out.println("Frank 1971, q4, "+getRank(1971, "Frank", "M"));
        System.out.println(getRank(2012, "Mason", "F"));
    }
    
    public static void whatIsNameInYearTest() {
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }
    
    public static void yearOfHighestRankTest() {
        /*q9
         * In which year from 1880 to 2014 
         * does the girl’s name "Genevieve" have the highest rank 
         * (over all the data files)?

         * If there is more than one year with the highest rank, 
         * choose the earliest one.

           */
          /*
           * In which year from 1880 to 2014 does 
           * the boy’s name "Mich" have the highest rank 
           * (over all the data files)?


           * If there is more than one year with the highest rank, 
           * choose the earliest one.
             
             */
            System.out.println(yearOfHighestRank("Mich", "M"));//"F"
    }
    
    public static void getAverageRankTest() {
        //the average rank of the girl’s name "Susan" over all ,q11
        //q12,  boy's name "Robert" 
        System.out.println(getAverageRank("Rober", "M"));
    }
    
    public static void getTotalBirthsRankedHigherTest(){
        // "Drew" in 1990
    System.out.println(getTotalBirthsRankedHigher(1990, "Drew", "M"));
    }
    
    // test
    public static void main(String[] args) {
        //getRankTest();
        //whatIsNameInYearTest();
        //yearOfHighestRankTest();//q9
        getAverageRankTest();//11
        //getTotalBirthsRankedHigherTest();
        /*
         * What is the total number of girls born in 1990 

         * with names ranked higher than the girl's name "Emily" in 1990?
           */
          //Emily 1990
    }
}
