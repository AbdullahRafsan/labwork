import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        while(true){
            System.out.print("Enter text to encrypt/decrypt ('q' to quit): ");
            Scanner sc = new Scanner(System.in);
            int shift = 5;
            String text = sc.nextLine();
            if( text.toLowerCase().equals("q")) break;
            while(true){
                System.out.print("\nEnter the amount you want shift. The default is 5.\nUse negetive number to change direction or decrypt.\nShift amount: ");
                String sh = sc.nextLine();
                if(sh.equals("")) break;
                try{
                    shift = Integer.parseInt(sh);
                    break;
                }
                catch(Exception e){
                    System.out.print("\nShift amount should be a valid integer number.");
                    break;
                }
            }
            Ceaser ceaser = new Ceaser(text,shift);
            ceaser.getEncryptedText();
        }
    }
}