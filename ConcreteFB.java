import java.util.ArrayList;
import java.util.List;

// Fieldbase. Capable of registering to a homebase, and having spies register to it. Can send messages to all.
public class ConcreteFB implements Fieldbase {

    // LOCAL VARIABLES
    private String message = "";
    private Cypher cypher;
    private int key = 0;
    private Homebase homebase;
    private List<Spy> spies = new ArrayList<Spy>();
    private List<Spy> deadSpies = new ArrayList<Spy>();

    // OBSERVER (HB->FB) METHODS
    // Registers itself to the homebase
    public void register(Homebase homebase){
        this.homebase = homebase;
        this.homebase.registerFB(this);
    }

    // Unregisters itself from the homebase
    public void unregister() {
        this.homebase.unregisterFB(this);
    }

    // Updates current cypher and key; Triggered by homebase calling update.
    public void update() {
        this.cypher = homebase.getCypher();
        this.key = homebase.getKey();
        updateSpies();
    }

    // OBSERVER (FB-SPY) METHODS
    // Gets cypher from Subject
    public Cypher getCypher(){
        return this.cypher;
    }

    // Gets key from Subject
    public int getKey(){
        return this.key;
    }

    // Adds a new spy. Checks to see if spy is dead first.
    public void registerSpy(Spy spy) {
        if (deadSpies.contains(spy) == true){
            System.out.println("Spy is dead. Cannot be added to field base.");
        }
        else {
            spies.add(spy);
        }
    }

    // Adds a spy to the dead list and removes from the fieldbase.
    public void killSpy(Spy spy) {
        deadSpies.add(spy);
        spies.remove(spy);
    }

    // Updates all attached spies
    public void updateSpies() {
        for (Spy spy : spies){
            spy.update();
        }
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
