import java.util.Arrays;
import java.util.Scanner;

public class Mass {
	public static void main(String[] args) {
		System.out.println("Enter the number of test case");
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
        	System.out.println("Enter the Pattern");
            String pattern = scanner.next();
            
            System.out.println("Enter the Text");
            String text = scanner.next();

            if (check(pattern, text)) {
                System.out.println("ANS:  YES");
            } else {
                System.out.println("ANS:  NO");
            }
        }
    

}
	private static boolean check(String pattern, String text) {
        int[] patternFreq = new int[26];
        int[] textFreq = new int[26];

       
        for (char c : pattern.toCharArray()) {
            patternFreq[c - 'a']++;
        }

        int wSize = pattern.length();
        
        for (int i = 0; i < wSize; i++) {
            textFreq[text.charAt(i) - 'a']++;
        }

        for (int i = wSize; i < text.length(); i++) {
            
            if (Arrays.equals(patternFreq, textFreq)) {
                return true;
            }

    
            textFreq[text.charAt(i - wSize) - 'a']--;
            textFreq[text.charAt(i) - 'a']++;
        }
        if (Arrays.equals(patternFreq, textFreq)) {
            return true;
        }

        return false;
    }
 
}
