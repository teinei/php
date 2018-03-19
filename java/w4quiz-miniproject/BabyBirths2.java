import edu.duke.*;
import java.io.*;
import org.apache.commons.csv.*;

public class BabyBirths2 {

/**
 * Print the number of unique girls names , 
 * the number of unique boys names and the total names in the file.
 */
 
 public void totalBirths(CSVParser parser) {
        int totalboy = 0;
        int totalgirl = 0;
        int total = 0;
        int totaluniqueboy = 0;
        int totaluniquegirl = 0;
        int totalunique = 0;
        for (CSVRecord record: parser) {
            if (record.get(1).equals("F")) {
                total = total + 1;
                totalgirl = totalgirl + Integer.parseInt(record.get(2));
                totaluniquegirl = totaluniquegirl + 1;
                totalunique = totalunique + 1;
            }
            if (record.get(1).equals("M")) {
                total = total + 1;
                totalboy = totalboy + Integer.parseInt(record.get(2));
                totaluniqueboy = totaluniqueboy + 1;
                totalunique = totalunique + 1;
            }
            
        }
        System.out.println("Total number boy: "+totalboy);
        System.out.println("Total number girl: "+totalgirl);
        System.out.println("Total number: "+total);
        System.out.println("Total unique number boy: "+totaluniqueboy);
        System.out.println("Total unique number girl: "+totaluniquegirl);
        System.out.println("Total unique number: "+totalunique);
    }
    
    public void testtotalBirths() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        totalBirths(parser);
    }
    
/**
 * Write the method named getRank that has three parameters: an integer named year, 
 * a string named name, and a string named gender (F for female and M for male). 
 * This method returns the rank of the name in the file for the given gender, 
 * where rank 1 is the name with the largest number of births. If the name is not in the file, then -1 is returned. 
 */
 
 public int getRank(int year, String name, String gender) {
        String na = "./babynamedata/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(na);
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        int number = 0;
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                rank = rank + 1;
                if (record.get(0).equals(name)) {
                    number = 1;
                    break;
                }
            }
        }
        if (number == 1) return rank;
        else return -1;
    }
    
    public void testgetRank() {
        int rank = getRank(1960, "Emily", "F");//q3
        //q4
        rank = getRank(1971, "Frank", "M");
        System.out.println(rank);
    }
    
/**
 * Write the method named getName that has three parameters: an integer named year, 
 * an integer named rank, and a string named gender (F for female and M for male). 
 * This method returns the name of the person in the file at this rank, for the given gender, 
 * where rank 1 is the name with the largest number of births. If the rank does not exist in the file, then “NO NAME” is returned.
 */
 
 public String getName(int year, int rank, String gender) {
        String na = "./babynamedata/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(na);
        CSVParser parser = fr.getCSVParser(false);
        int number = 0;
        int find = 0;
        String finalname = null;
        for (CSVRecord record: parser) {
            if (record.get(1).equals(gender)) {
                number += 1;
                if (number == rank) {
                    finalname = record.get(0);
                    find = 1;
                }
            }
        }
        if (find == 1) return finalname;
        else return "NO NAME";
    }
    //5. Question 5
    //What is the girl’s name of rank 350 in 1980?
    public void testgetName() {
        //q6 What is the boy’s name of rank 450 in 1982?
        String name = getName(1982, 450, "M");//M F
        System.out.println(name);
    }
    
/**
 * What would your name be if you were born in a different year? 
 * Write the void method named whatIsNameInYear that has four parameters: a string name, 
 * an integer named year representing the year that name was born, an integer named newYear and a string named gender (F for female and M for male). 
 * This method determines what name would have been named if they were born in a different year, 
 * based on the same popularity. That is, you should determine the rank of name in the year they were born, 
 * and then print the name born in newYear that is at the same rank and same gender.
 */
 
 public void whatisNameInYear(String name, int year, int newyear, String gender) {
        String nameyear = "yob" + year + "short.csv";
        FileResource fr = new FileResource(nameyear);
        CSVParser parserold = fr.getCSVParser(false);
        
        String namenewyear = "yob" + newyear + "short.csv";
        FileResource fr1 = new FileResource(namenewyear);
        CSVParser parsernew = fr1.getCSVParser(false);
        
        int rank = 0;
        int find = 0;
        for (CSVRecord record: parserold) {
            if (record.get(1).equals(gender)) {
                rank += 1;
                if (record.get(0).equals(name)) {
                    find = 1;
                    break;
                }
            }
        }
        
        int ranknew = 0;
        int findnew = 0;
        if (find == 0) System.out.println("NO NAME!") ;
        else {
            for (CSVRecord record: parsernew) {
                if (record.get(1).equals(gender)) {
                    ranknew += 1;
                    if (ranknew == rank) {
                        findnew = 1;
                        System.out.println(name + " born in " + year + " would be " + record.get(0) + " if she/he was born in "+ newyear);
                    }
                    
                }
            }
            if (findnew == 0) System.out.println("No such rank in year "+newyear);
        }
    }
    
    public void testwhatisNameInYear() {
        whatisNameInYear("Isabella", 2012, 2014, "F");
    }
    
/**
 * Write the method yearOfHighestRank that has two parameters: a string name, 
 * and a string named gender (F for female and M for male). 
 * This method selects a range of files to process and returns an integer, 
 * the year with the highest rank for the name and gender. 
 * If the name and gender are not in any of the selected files, it should return -1.
 */
 
 public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int ranktonow = 0;
        int findall = 0;
        for (File f: dr.selectedFiles()) {
            int rank = 0;
            int find = 0;
            String fname = f.getName();
            FileResource fr = new FileResource(fname);
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record: parser) {
                if (record.get(1).equals(gender)) {
                    rank += 1;
                    if (record.get(0).equals(name)) {
                        find = 1;
                        break;
                    }
                }
            }
            if (find == 1) {
                findall = 1;
                if (ranktonow == 0) ranktonow = rank;
                else if (ranktonow > rank) ranktonow = rank;
            }
             
        }
        
        if (findall == 0) return -1;
        else return ranktonow;
    }
    
    public void testyearOfHighestRank() {
        //int ranktonow = yearOfHighestRank("Mason", "M");
        int ranktonow=yearOfHighestRank("Genevieve","F");
        System.out.println("Highest rank is "+ranktonow);
    }
    

 /**
 * Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
 * This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
 * It should return -1.0 if the name is not ranked in any of the selected files.
 */
 
 public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double ranktonow = 0;
        int findall = 0;
        for (File f: dr.selectedFiles()) {
            int rank = 0;
            int find = 0;
            String fname = f.getName();
            FileResource fr = new FileResource(fname);
            CSVParser parser = fr.getCSVParser(false);
            for (CSVRecord record: parser) {
                if (record.get(1).equals(gender)) {
                    rank += 1;
                    if (record.get(0).equals(name)) {
                        find = 1;
                        break;
                    }
                }
            }
            if (find == 1) {
                findall += 1;
                ranktonow += rank;
            }
             
        }
        
        if (findall == 0) return -1;
        else return ranktonow/findall;
    }
    
    public void testgetAverageRank() {
        double average = getAverageRank("Jacob", "M");
        System.out.println("Average rank is "+average);
    }
    
 /**
 * Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year, 
 * a string named name, and a string named gender (F for female and M for male). 
 * This method returns an integer, the total number of births of those names with the same gender 
 * and same year who are ranked higher than name. 
 */
 
 public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        //String nameyear = "yob" + year + ".csv";
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int find = 0;
        int sum = 0;
        for (CSVRecord record: parser) {
            if (record.get(1).equals(gender)) {
                if (record.get(0).equals(name)) {
                    find = 1;
                    break;
                }
                sum += Integer.parseInt(record.get(2));
            }
        }
        if (find == 1) return sum;
        else return -1;
    }
    
    public void testgetTotalBirthsRankedHigher() {
        /*
         * What is the total number of girls born in 1990 

         * with names ranked higher than the girl's name "Emily" in 1990?
           */
          //Emily 1990
        //int sum = getTotalBirthsRankedHigher(1960, "Emily", "F");//q3
        /*q14

         * What is the total number of boys born in 1990 

         * with names ranked higher than the boy's name "Drew" in 1990?

         * Give the answer without any commas or decimal points.

         */
        int sum=getTotalBirthsRankedHigher(1990,"Drew","M");
        System.out.println("The total briths higher is "+sum);
    }
    /*q7
    Suppose Susan was born in 1972. 
    Based on her name's rank in 1972, 
    what would her name be if she were born in 2014 
    (that is, what name in 2014 had the same rank that "Susan" had in 1972)?
    */
    public void q7q8(){
        //susan f born 1972, get rank in 1972
        int r=getRank(1972,"Susan","F");
        r=getRank(1974,"Owen","M");
        //if she were born in 2014
        //get name based on rank and year
        String s=getName(2014,r,"F");
        s=getName(2014,r,"M");
        System.out.println(s);
        /*
           Suppose Owen was born in 1974. 
           Based on his name's rank in 1974, 
           what would his name be if he were born in 2014 
           (that is, what name in 2014 had the same rank that "Owen" had in 1974)?
           */
          /*
           * What is the total number of girls born in 1990 

           * with names ranked higher than the girl's name "Emily" in 1990?
           */
    }
}
    
    
 
