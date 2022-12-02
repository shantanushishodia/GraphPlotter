import java.util.Random;

/**
 * Class to implement Singleton Design Pattern. Generates a random number.
 */
public class RandomNumberGen {

    private static RandomNumberGen randomNumber = new RandomNumberGen ();

    /**
     * Creates an instance
     *
     * @return randomNumber
     */
    public static RandomNumberGen getInstance(){
        return randomNumber;
    }

    /**
     * Default Constructor
     *
     */
    private RandomNumberGen(){}

    /**
     * Generates a random number
     *
     * @return x
     */
    public int newNumber(){
        Random number = new Random();
        int x = number.nextInt(20)+1 ;
        return x;
    }
}

