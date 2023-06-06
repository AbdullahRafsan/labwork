import java.util.Scanner;

var KEY = 5;

// This function is doing all the work.
// Just focus on this.
fun doCeaser(text:String, isEncrypting:Boolean):String{
    val encryptedText = StringBuilder();
    for(c in text.toCharArray()){
        var charValue = c.code;
        if( charValue >= 65 && charValue <= 90){
            charValue -= 65;
        }
        else if( charValue >= 97 && charValue <= 122){
            charValue -= 97;
        }
        else {
            encryptedText.append(c);
            continue;
        }
        var enCharValue = charValue + ( if(isEncrypting) KEY else (KEY*-1) );
        if( enCharValue < 0) enCharValue = 26 - (Math.abs(enCharValue) % 26);
        else enCharValue = enCharValue % 26;
        encryptedText.append( (enCharValue + (if(c >= 'A' && c <= 'Z') 65 else 97)).toChar() );
    }
    return encryptedText.toString();
}

fun main(){
    var isEnc = false;
    while(true){
            print("Enter text to encrypt/decrypt ('q' to quit): ");
            var text:String = readLine() ?: "";
            if( text.lowercase().equals("q")) System.exit(0);
            while(true){
                print("\nWhat do you want to do ?\n(E) ncrypt.\n(D) ecrypt.\nTry (A) nother text.\n(Q) uit.\nEnter an option: ");
                var sh = readLine() ?: "";
                if(sh.equals("")) continue;
                when(sh.lowercase()){
                    "e" -> {
                        isEnc = true;
                    }
                    "d" -> {
                        isEnc = false;
                    }
                    "a" -> {
                        break;
                    }
                    "q" -> {
                        System.exit(0);
                    }
                }
                while(true){
                    print("\nEnter the amount you want shift. The default is 5.\nUse negetive number to change direction or decrypt.\nShift amount: ");
                    sh = readLine() ?: "";
                    if(sh.equals("")) break;
                    try{
                        KEY = Integer.parseInt(sh);
                        break;
                    }
                    catch(e: Exception){
                        print("\nShift amount should be a valid integer number.");
                        continue;
                    }
                }
                text = doCeaser(text,isEnc);
                println( text );
            }
        }
}