public class Ceaser{
    private String text;
    private int KEY;

    public Ceaser(String text){
        this.text = text;
        this.KEY = 5;
    }

    public Ceaser(String text, int key){
        this.text = text;
        this.KEY = key;
    }

    // This function is doing all the work.
    // Just focus on this.
    private String doCeaser(boolean isEncrypting){
        StringBuilder encryptedText = new StringBuilder();
        for(char c: text.toCharArray()){
            int charValue = (int) c;
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
            int enCharValue = charValue + ( isEncrypting ? KEY : (KEY*-1) );
            if( enCharValue < 0) enCharValue = 26 - (Math.abs(enCharValue) % 26);
            else enCharValue = enCharValue % 26;
            encryptedText.append((char) (enCharValue + ((c >= 'A' && c <= 'Z') ? 65 : 97)) );
        }
        return encryptedText.toString();
    }

    public void getEncryptedText(){
        System.out.println(doCeaser(true));
    }
    public void getDecryptedText(){
        System.out.println(doCeaser(false));
    }
}
