import java.util.Scanner;

public class Ceaser{
    private static String text;
    private static int KEY = 5;

    // This function is doing the main work.
    // Just focus on this.
    private static int doCeaserHelper(int charValue,boolean isEncrypting, boolean isNumber){
        int enCharValue = charValue + ( isEncrypting ? KEY : (KEY*-1) );
        if( enCharValue < 0) enCharValue = (isNumber ? 10 : 26) - (Math.abs(enCharValue) % (isNumber ? 10 : 26));
        else enCharValue = enCharValue % (isNumber ? 10 : 26);
        return enCharValue;
    }

    public static String doCeaser(boolean isEncrypting){
        StringBuilder encryptedText = new StringBuilder();
        for(char c: text.toCharArray()){
            int charValue = (int) c;
            if( charValue >= 65 && charValue <= 90){
                charValue -= 65;
                charValue = doCeaserHelper(charValue, isEncrypting,false);
                charValue += 65;
                encryptedText.append( (char) charValue );
            }
            else if( charValue >= 97 && charValue <= 122){
                charValue -= 97;
                charValue = doCeaserHelper(charValue, isEncrypting,false);
                charValue += 97;
                encryptedText.append( (char) charValue );
            }
            else if( charValue >= 48 && charValue <= 57){
                charValue -= 48;
                charValue = doCeaserHelper(charValue, isEncrypting,true);
                charValue += 48;
                encryptedText.append( (char) charValue );
            }
            else {
                encryptedText.append(c);
            }
            
        }
        return encryptedText.toString();
    }

    public static void main(String params[]){
        System.out.println("Enter text: ");
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        System.out.println("Plain text: "+text);
        text = doCeaser(true);
        System.out.println("Encrypted text: "+text);
        text = doCeaser(false);
        System.out.println("Decrypted text: "+text);
        sc.close();
    }
}
