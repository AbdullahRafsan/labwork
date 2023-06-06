import java.util.Scanner;

public class Ceaser{
    private static String text;
    private static int KEY = 5;
    private static boolean isEncrypting;

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

    public static void main(String[] params){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter text to encrypt/decrypt ('q' to quit): ");
            text = sc.nextLine();
            if( text.equals("") ) continue ;
            if( text.toLowerCase().equals("q") ) break;
            action:
            while(true){
                System.out.print("\nWhat do you want to do ?\n(E) ncrypt.\n(D) ecrypt.\nTry (A) nother text.\n(Q) uit.\nEnter an option: ");
                String sh = sc.nextLine();
                switch(sh.toLowerCase()){
                    case "e":
                        isEncrypting = true;
                        break;
                    case "d":
                        isEncrypting = false;
                        break;
                    case "a":
                        break action;
                    case "q":
                        System.exit(0);
                    default:
                        continue;
                }
                while(true){
                    System.out.print("\nEnter the amount you want shift. The default is 5.\nUse negetive number to change direction or decrypt.\nShift amount: ");
                    sh = sc.nextLine();
                    if(sh.equals("")) break;
                    try{
                        KEY = Integer.parseInt(sh);
                        break;
                    }
                    catch(Exception e){
                        System.out.print("\nShift amount should be a valid integer number.");
                        continue;
                    }
                }
                text = doCeaser(isEncrypting);
                System.out.println(text);
            }
        }
        sc.close();
    }
}
