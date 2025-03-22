import java.util.*;

// This class simulates a type of encryption that moves all encodable characters to the left
// by an amount of the user's choosing.
public class CaesarShift extends Substitution{

    // Behavior: 
    //   - This method constructs a CaesarShift cipher object
    // Parameters:
    //   - shift: the amount of shifts the user wants
    // Exceptions:
    //   - if the numbers of shifts is less than or equal to 0, and IllegalArgumentException
    //   - is thrown.
    public CaesarShift(int shift){
        if(shift <= 0){
            throw new IllegalArgumentException();
        }

        String encoding = "";
        Queue<Character> queue = new LinkedList<>();

        for(int i = MIN_CHAR; i <= MAX_CHAR; i++){
            queue.add((char) i);
        }

        for(int i = 0; i < shift; i++){
            queue.add(queue.remove());
        }

        int size = queue.size();
        for(int i = 0; i < size; i++){
            encoding += queue.remove();
        }
        
        setEncoding(encoding);
    }
}



