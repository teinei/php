public class FindGeneSimpleAndTest {
    public String findGeneSimple(String dna){
        String result = "";
        return result;
    }
    public void testFindGeneSimple(){
        String dna="AATGCGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        String gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna2
        dna="AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is "+dna);
        gene=findGeneSimple(dna);
        System.out.println("Gene is "+gene);
        
        //dna3
        
    }

}
