// Template for a cypher decorator, allowing for cyphers to be stacked on each other without modifying previous code.
public abstract class CypherDecorator implements Cypher {

    protected Cypher decoratedCypher;

    public CypherDecorator(Cypher decoratedCypher){
        this.decoratedCypher = decoratedCypher;
    }

    public String encrypt(String msg, int key) {
        return decoratedCypher.encrypt(msg,key);
    }

    public String decrypt(String msg, int key) {
        return decoratedCypher.decrypt(msg,key);
    }
}
