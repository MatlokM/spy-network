// Spy. Capable of registering to a fieldbase, and sending messages to everything in the network.
public class ConcreteSpy implements Spy{

    // LOCAL VARIABLES
    private String message = "";
    private Cypher cypher;
    private int key = 0;
    private Fieldbase fieldbase;

    // OBSERVER METHODS
    // Updates personal cypher and key. Trigged by Fieldbase sending update.
    public void update() {
        this.cypher = fieldbase.getCypher();
        this.key = fieldbase.getKey();
    }

    // Registers spy to a fieldbase
    public void register(Fieldbase fieldbase) {
        this.fieldbase = fieldbase;
        this.fieldbase.registerSpy(this);
    }

    // Unregisters spy from fieldbase. Fieldbase handles "dying" logic.
    public void die() {
        this.fieldbase.killSpy(this);
    }

    // GENERAL METHODS
    // Gets currently stored message
    public String getMessage(){
        return this.message;
    }

    // Encrypts and sends message to chosen Receiver
    @Override
    public void sendMessage(String msg, Receiver receiver) {
        msg = cypher.encrypt(msg, this.key);
        receiver.setMessage(msg);
    }

    // Used by other Receivers. Decodes message and saves it to this.message.
    @Override
    public void setMessage(String msg) {
        msg = cypher.decrypt(msg, this.key);
        this.message = msg;
    }
}
