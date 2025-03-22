// Razeen Samir 
// 1/22/2025
// CSE 123 
// P0: Ciphers
// TA: Isaiyah

import java.util.*;

// This class allows for the storage of a variety of different ciphers (substitution, caesarkey
// , caesarshift) to be performed on a word
public class MultiCipher extends Cipher{
    private List<Cipher> ciphers;

    // Behavior: 
    //   - This method constructs a MultiCipher object.
    // Parameters:
    //   - ciphers: the list of ciphers to be performed
    // Exceptions:
    //   - if ciphers is null, an IllegalArgumentException is thrown
    public MultiCipher(List<Cipher> ciphers){
        if(ciphers == null){
            throw new IllegalArgumentException();
        }
        this.ciphers = ciphers;
    }

    // Behavior: 
    //   - This method encrypts the input provided by the user according to the pairings between
    //   - characters for each specific cipher. This will work as intended as long as the provided
    //   - word has characters within the encodable range. Otherwise it won't encrypt properly.
    // Parameters:
    //   - input: the word the user wants to encrypt
    // Returns:
    //   - String: the encrypted word
    // Exceptions:
    //   - if the given input is null, an IllegalArgumentException is thrown.
    public String encrypt(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }
        String answer = "";
        for(int i = 0; i < ciphers.size(); i++){
            answer = ciphers.get(i).encrypt(input);
            input = answer;
        }
        return answer;
    }

    // Behavior: 
    //   - This method decrypts the word the user provides according to the pairings between
    //   - characters for each cipher. This will work as intended as long as the provided
    //   - word has characters within the encodable range. Otherwise it won't encrypt properly.
    // Parameters:
    //   - input: the word the user wants to decrypt
    // Returns:
    //   - String: the decrypted word.
    // Exceptions:
    //   - if the given input is null, an IllegalArgumentException is thrown.
    public String decrypt(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }
        String answer = "";
        for(int i = ciphers.size() - 1; i >= 0; i--){
            answer = ciphers.get(i).decrypt(input);
            input = answer;
        }
        return answer;
    }
}
