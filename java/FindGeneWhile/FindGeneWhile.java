//2205 coding while loop
//week2 section2 video 05
public class FindGeneWhile {
    public String findGene(String dna){
        //
        int startIndex=dna.indexOf("ATG");
        int currIndex=dna.indexOf("TAA",startIndex+3);
        while(currIndex!=-1){
            //
            if((currIndex-startIndex)%3==0){
                return dna.substring(startIndex,currIndex+3);
            }else{
                currIndex=dna.indexOf("TAA",currIndex+1);
            }
        }
        return "";
    }
    public void testFindGeneSimple(){
        String dna="";
        String gene="";
        
        dna="AATGCGTAATTAATCG";
        //dna="CGATGGTTGATAAGCCTAAGCTATAA";
        //dna="CGATGGTTGATAAGCCTAAGCTAAA";
        //dna="";
        System.out.println("DNA IS "+dna);
        gene=findGene(dna);
        System.out.println("Gene is "+gene);
        
        /*
        dna="CGATGGTTGATAAGCCTAAGCTATAA";
        //dna="CGATGGTTGATAAGCCTAAGCTAAA";
        //dna="";
        System.out.println("DNA IS "+dna);
        gene=findGene(dna);
        System.out.println("Gene is "+gene);
        
        dna="CGATGGTTGATAAGCCTAAGCTAAA";
        //dna="";
        System.out.println("DNA IS "+dna);
        gene=findGene(dna);
        System.out.println("Gene is "+gene);
        */
    }
}
