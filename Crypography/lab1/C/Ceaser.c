#include <stdio.h>
#include <math.h>

int KEY = 5;

char doCeaser(char ch, int isEncrypting){
    ch += ( isEncrypting == 1 ? KEY : KEY*-1);
    if(ch < 0) ch = (26 - (abs(ch) % 26));
    else ch %= 26;
}

char* doCeaserHelper(char* text,int isEncrypting){
    int c = 0;
    while(1){
        if(text[c] == 0) break;
        if( text[c] >= 65 && text[c] <= 90){
            text[c] -= 65;
            text[c] = doCeaser(text[c],isEncrypting);
            text[0] += 65;
        }
        else if(text[c] >= 97 && text[c] <= 122){
            text[c] -= 97;
            text[c] = doCeaser(text[c],isEncrypting);
            text[0] += 97;
        }
        else {

        }
    }
    return text;
}

int main(int argc, char** argv){
    char* text;
    int shift;
    while(1){
        printf("Enter text to encrypt/decrypt ('q' to quit): ");
        scanf("%s\n",text);
        if(text[0] == 'q' || text[0] == 'Q') break;
        while(1){
            printf("\nEnter the amount you want shift. The default is 5.\nUse negetive number to change direction or decrypt.\nShift amount: ");
            if(scanf("%d",&shift) != 1) {
                printf("\nShift amount should be a valid integer number.");
            }
        }
        doCeaserHelper(text,shift);
    }
}