
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany (String a, String b) {
        int startIndex = 0;
        int count = 0;
        int currIndex = 0;
        while (currIndex != -1) {
            currIndex = b.indexOf (a, startIndex);
            startIndex = currIndex + a.length();
            ++count;
        }
        return count-1;
    }
    
    public void testHowMany(){
    String b = "AATGAACGAATTGAATC";
    String a = "AA";
    int find = howMany(a,b);
    System.out.println("Number of occurrence of AA is " + find);
    }
     
}
