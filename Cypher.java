// Interface for a Cypher, to ensure all added cyphers have a decrypt and encrypt function.
public interface Cypher {
    public String encrypt(String msg, int key);
    public String decrypt(String msg, int key);
}
