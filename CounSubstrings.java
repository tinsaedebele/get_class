import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * 
 * 
 * 
 * @author  Tinsae Debele
 * @student Nuuber: 101034827
 */


public class CounSubstrings {


    /*
     * Returns the lowest index at which substring pattern begins in text (or else
     * -1).
     */

    private static int findBrute(List<Character> text, List<Character> pattern) {
        int n = text.size();
        int m = pattern.size();
        for (int i = 0; i <= n - m; i++) { // try every starting index
            // within text
            int k = 0; // k is index into pattern
            while (k < m && text.get(i + k) == pattern.get(k))
                // kth character of pattern matches
                k++;
            if (k == m) // if we reach the end of the pattern,
                return i; // substring text[i..i+m-1] is a match
        }
        return -1; // search failed
    }







    public static void main(String[] args) throws FileNotFoundException, IOException {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the path for the input file: ");
        String fileInput = scanner.nextLine();
        System.out.print("Enter the pattern to look for: ");
        String patin = scanner.nextLine();
        scanner.close();
        FileReader file = new FileReader(fileInput);
        BufferedReader br = new BufferedReader(file);
        String line = br.readLine();
        ArrayList<String> arrFile = new ArrayList<String>();
        LinkedList<String> linkedFile = new LinkedList<String>();
        /**
         * Reads the text file
         * and coverst each line of string and store it in the arrayList and LikedList
         * 
         */

        while (line != null) {

            String temp = "";

            for (int i = 0; i < line.length(); i++) {
                
                if (line.charAt(i) == ' ') {
                    temp +="";          
 		            arrFile.add(temp);
                    linkedFile.add(temp);
                   
                    temp = "";
                } else if (i == line.length() - 1) {
                    
                    temp += line.charAt(i);
                    temp +=""; 
                    arrFile.add(temp);
                    linkedFile.add(temp);
                    temp = "";

                } else {
                    temp += line.charAt(i);
                }
            }

            line = br.readLine();
        }

        /**
         * change the word looking for from staring to a array of characters 
         * 
         */
        br.close();  		 		
        ArrayList<Character> countWord = new ArrayList<Character>();

        for (int i = 0; i < patin.length(); i++) {
            countWord.add(patin.charAt(i));
        }
        /**
         * converst array of straing to a array of charactor 
         * pass the List to the findBrute and count the number of word match from the arrayList 
         * 
         */

        int count = 0;
        long arrStart = System.currentTimeMillis();   // start timing the process for array
    
        for (String str: arrFile) {
            ArrayList<Character> strPass = new ArrayList<Character>();
            for (int i = 0; i < str.length(); i++) {
                strPass.add(str.charAt(i));
            }
            if (findBrute(strPass, countWord) != -1) {
                count++;
            }
        }
        long arrEnd = System.currentTimeMillis();  // stop the timef for the arrayList 
        System.out.println("Using ArrayLists: " + count + " matches, derived in " + ( arrEnd - arrStart) + " milliseconds.");
        // ArrayList Search Ends

        /**
         * Linked Search Starts here 
         * 
         * change the the LikedList string into LikedList charactor 
         * pass the likedList charactor to the function of findBrute
         * calculate the number of word match in the list 
         */

        count = 0;
        long linkedStart = System.currentTimeMillis();  //Start the timer for Likedlist 
        for (String strl: linkedFile) {
            LinkedList<Character> linPass = new LinkedList<Character>();
            for (int i = 0; i < strl.length(); i++) {
                linPass.add(strl.charAt(i));
            }
            if (findBrute(linPass, countWord) != -1) {
                count++;
            }
        }
        long linkedTime = System.currentTimeMillis(); // stop the timer for likedList 
        System.out.println("Using LinkedLists: " + count + " matches, derived in " + (linkedTime - linkedStart) + " milliseconds.");
    }

}
