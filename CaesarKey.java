// Razeen Samir 
// 1/22/2025
// CSE 123 
// P0: Ciphers
// TA: Isaiyah

import java.util.*;

// This class simulates a type of encryption similar to the one done by a substitution encryption
// except it takes in a key. The key's characters are put at the beginning of the encoding sequence
// and then the rest of the characters in the encodable range that aren't already added are added
// to the sequence in order.
public class CaesarKey extends Substitution{
    // Behavior: 
    //   - This method constructs a CaesarKey cipher object.
    // Parameters:
    //   - key: the key given by the user
    // Exceptions:
    //   - if the key is null, an IllegalArgumentException is thrown
    //   - if the key is empty, an IllegalArgumentException is thrown.
    //   - if any of the characters in the key are out of the encodable range, an
    //   - IllegalArgumentException is thrown
    //   - if the key contains duplicate characters, an IllegalArgumentException is thrown
    public CaesarKey(String key){
        if(key == null || key.equals("")){
            throw new IllegalArgumentException();
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < key.length(); i++){
            if(key.charAt(i) < MIN_CHAR || key.charAt(i) > MAX_CHAR){
                throw new IllegalArgumentException();
            }
            set.add(key.charAt(i));
        }
        if(key.length() != set.size()){
            throw new IllegalArgumentException();
        }

        String encoding = key;

        for(int i = MIN_CHAR; i <= MAX_CHAR; i++){
            if(!set.contains((char) i)){
                encoding += (char) i;
            }
        }

        setEncoding(encoding);
    }
}
