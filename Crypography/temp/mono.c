#include <stdio.h>
#include <stdlib.h>

int get_index(char* str, char ch){
    for(int i = 0; i < 62; i++){
        if(str[i] == ch) return i;
    }
    return -1;
}

char* do_mono(char* message){ 
    char* ciphertext = (char*) malloc(1200);
    char* original_alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char* scrambled_alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM4368591702";
    while(1){
        if(plaintext[plaintext_character_index] == '\n') break;
        int alphabet_index = isEncrypting ? get_index(original_alphabet,plaintext[plaintext_character_index]) : get_index(scrambled_alphabet,plaintext[plaintext_character_index]);
        ciphertext[plaintext_character_index] = alphabet_index == -1 ? plaintext[plaintext_character_index] : (isEncrypting ? scrambled_alphabet[alphabet_index] : original_alphabet[alphabet_index]);
        plaintext_character_index++;
    }
    ciphertext[plaintext_character_index] = '\0';
}

int main(int argc, char** argv){
    char* plaintext = (char*) malloc(1200);
    char* choice = (char*) malloc(5);
    int plaintext_character_index = 0;
    int isEncrypting = 1;

    printf("Enter a text: ");
    fgets(plaintext,1199,stdin);
    printf("Encrypt ([Y]es/[N]o): ");
    
    if(fgets(choice,3,stdin)) isEncrypting = choice[0] == 'Y' ? 1 : 0;
    
    printf("Result: %s",ciphertext);
}
