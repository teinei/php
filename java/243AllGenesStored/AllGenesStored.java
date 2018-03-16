import edu.duke.*;
/**
 * 243 week 2 section 4 lecture 3
 * Write a description of AllGenesStored here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AllGenesStored {
    //
    public StorageResource getAllGenes(String dna){
        //
        StorageResource geneList=new StorageResource();
        int startIndex=0;
        //System.out.println("startIndex is "+startIndex);
        //      
        int i=0;
        //
        while(true){
            //System.out.println("1)i is "+i);
            //System.out.println("2)dna is "+dna);
            //System.out.println("3)startIndex is "+startIndex);
            String currentGene=findGene(dna,startIndex);
            //
            //System.out.println("4)currentGene is "+currentGene);
            if(currentGene.isEmpty()){
                //leave this loop
                break;
            }
            //
            geneList.add(currentGene);
            //System.out.println(currentGene);
            //System.out.println();
            startIndex=dna.indexOf(currentGene,startIndex)+
                       currentGene.length();
                       //index of currentGene from startIndex
            //System.out.println("5)new startIndex "+startIndex);  
            //
            //i++;
            //System.out.println("6)new i "+i);
            //System.out.println("-------");
        }
        //System.out.println("========");
        return geneList;
    }
    public void testOn(String dna){
        System.out.println("testing printAllGenes on "+dna);
        StorageResource genes = getAllGenes(dna);
        for(String g:genes.data()){
            System.out.println(g);
        }
    }
    public void test(){
        testOn("ATGATCTAAXXXYYY");
        testOn("ATGATCTAATTTATGCTGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    //code from previous
     public int findStopCodon(String dnaStr, 
                             int startIndex, 
                             String stopCodon){
        int currIndex=dnaStr.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){           
            //
            int diff=currIndex-startIndex;
            if(diff%3==0){
                return currIndex;
            }
            else{
                //
                currIndex=dnaStr.indexOf(stopCodon,currIndex+1);
            }
        }
        return -1;
    }
    //code from previous
    public String findGene(String dna,int where){
        int startIndex=dna.indexOf("ATG",where);
        if(startIndex==-1){
            return "";
        }
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        //int temp=Math.min(taaIndex,tagIndex);
        //int minIndex=Math.min(temp ,tgaIndex);
        //
        int minIndex=0;
        if(taaIndex==-1||
        (tgaIndex!=-1&&tgaIndex<taaIndex)){
            minIndex=tgaIndex;
        }else{
            minIndex=taaIndex;
        }
        //
        if(minIndex==-1|| 
        (tgaIndex!=-1&&tgaIndex<minIndex)){
            minIndex=tgaIndex;
        }
        //
        //
        //
        if(minIndex==dna.length()){
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }
}
