// Razeen Samir 
// 1/22/2025
// CSE 123 
// P0: Ciphers
// TA: Isaiyah

import java.util.*;

// This class is the most basic cipher, so it extends the cipher class. It provides a way to
// encrypt and decrypt text by using a simple substitution method.
public class Substitution extends Cipher {
    private String encoding;
    private Map<Character, Character> map;

    // Behavior: 
    //   - This method constructs an empty Substitution cypher object
    public Substitution(){
        encoding = null;
        map = new TreeMap<>();
    }

    // Behavior: 
    //   - This method constructs a Substitution object with a provided encoding.
    // Parameters:
    //   - encoding: the given encoding
    // Exceptions:
    //   - if encoding isn't valid then an IllegalArgumentException is thrown. An encoding isn't
    //   - valid if it has characters that aren't in the encodable range, null, the length isn't
    //   - equal to the total characters in the encodable range, or has duplicates.
    public Substitution(String encoding){
        setEncoding(encoding);
    }

    // Behavior: 
    //   - This method allows the user to provide an encoding, changing the pairings of the
    //   - characters.
    // Parameters:
    //   - encoding: the encoding the user wants to use
    // Exceptions:
    //   - if the encoding isn't valid, then an IllegalArgumentException is thrown.
    public void setEncoding(String encoding){
        if(!isEncodingValid(encoding)){
            throw new IllegalArgumentException();
        }
        this.encoding = encoding;
        populateMap();
    }

    // Behavior: 
    //   - This method encrypts the input provided by the user according to the pairings between
    //   - characters, as long as the word contains characters within the encodable range.
    //   - Otherwise, the encrypting won't be able to occur properly.
    // Parameters:
    //   - input: the word the user wants to encrypt. If the input contains characters that are not
    //   - within the encodabe range of the minimum and maximum characters (inclusive), then it's
    //   - not possible to encrypt it.
    // Returns:
    //   - String: the encrypted word
    // Exceptions:
    //   - if the given input is null, an IllegalArgumentException is thrown.
    //   - if the encoding isn't valid, an IllegalStateException is thrown
    public String encrypt(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }
        if(!isEncodingValid(encoding)){
            throw new IllegalStateException();
        }
        String answer = "";
        for(int i = 0; i < input.length(); i++){
            answer += map.get(input.charAt(i));
        }
        return answer;
    }

    // Behavior: 
    //   - This method decrypts the word the user provides according to the pairings between
    //   - characters, as long as it contains words within the encodable range; otherwise it will
    //   - not decrypt properly.
    // Parameters:
    //   - input: the word the user wants to decrypt. If the input contains characters that are not
    //   - within the encodabe range of the minimum and maximum characters (inclusive), then it's
    //   - not possible to decrypt it.
    // Returns:
    //   - String: the decrypted word.
    // Exceptions:
    //   - if the given input is null, an IllegalArgumentException is thrown.
    //   - if the encoding isn't valid, an IllegalStateException is thrown.
    public String decrypt(String input){
        if(input == null){
            throw new IllegalArgumentException();
        }
        if(!isEncodingValid(encoding)){
            throw new IllegalStateException();
        }
        String answer = "";
        for(int i = 0; i < input.length(); i++){
            for(char key : map.keySet()){
                if(input.charAt(i) == map.get(key)){
                    answer += key;
                }
            }
        }
        return answer;
    }

    // Behavior: 
    //   - This method determines if the mapping of characters is valid. It checks to see if it
    //   - has any characters that aren't in the encodable range, is null, the length isn't
    //   - equal to to the total characters in the encodable range, or has duplicates.
    // Parameters:
    //   - String: the encoding
    // Returns:
    //   - Boolean: false if any of the above cases are present; true otherwise
    private Boolean isEncodingValid(String encoding){
        if(encoding == null || encoding.length() != TOTAL_CHARS){
            return false;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < encoding.length(); i++){
            char character = encoding.charAt(i);
            if(character < MIN_CHAR || character > MAX_CHAR){
                return false;
            }
            set.add(character);
        }
        if(set.size() != encoding.length()){
            return false;
        }
        return true;
    }
    
    // Behavior: 
    //   - This method maps the characters to new characters based on the rules of the cipher.
    private void populateMap(){
        map = new TreeMap<>();
        int index = 0;
        for(int i = MIN_CHAR; i <= MAX_CHAR; i++){
            map.put((char)i, encoding.charAt(index));
            index++;
        }
    }
}