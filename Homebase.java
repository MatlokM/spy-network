import java.util.ArrayList;
import java.util.List;

// Homebase. Only one can be instantiated, and can have fieldbases register to it to receive keys / cyphers. Can send
// messages to all elements in the network
public class Homebase implements Receiver {

    // LOCAL VARIABLES
    private String message = "";
    private List<Fieldbase> fieldbases = new ArrayList<Fieldbase>();
    private Cypher cypher;
    private int key = 0;

    // SINGLETON METHODS
    // Singleton Instantiation
    private static Homebase instance = new Homebase();

    // Singleton Privatisation
    private Homebase(){}

    // Singleton Accessing
    public static Homebase getInstance(){
        return instance;
    }


    // STRATEGY METHODS
    // Sets cypher to use and updates fieldbases.
    public void setCypher(Cypher cypher) {
        this.cypher = cypher;
        updateFieldbases();
    }


    // OBSERVER METHODS
    // Sets key to use and updates fieldbases.
    public void setKey(int key){
        this.key = key;
        updateFieldbases();
    }
    // Gets cypher from Subject
    public Cypher getCypher(){
        return this.cypher;
    }

    // Gets key from Subject
    public int getKey(){
        return this.key;
    }

    // Adds a new fieldbase
    public void registerFB(Fieldbase fieldbase){
        fieldbases.add(fieldbase);
    }

    // Removes a new fieldbase
    public void unregisterFB(Fieldbase fieldbase){
        fieldbases.remove(fieldbase);
    }

    // Updates all attached Homebases
    public void updateFieldbases(){
        for (Fieldbase fieldbase : fieldbases){
            fieldbase.update();
        }
    }


    // GENERAL METHODS
    // Gets currently stored message
    public String getMessage(){
        return this.message;
    }

    // Encrypts and sends message to a chosen receiver
    @Override
    public void sendMessage(String msg, Receiver receiver) {
        msg = cypher.encrypt(msg, this.key);
        receiver.setMessage(msg);
    }

    // Used by other Receivers. Decodes message and saves it to this.message.
    @Override
    public void setMessage(String msg){
        msg = cypher.decrypt(msg, this.key);
        this.message = msg;
    }
}
