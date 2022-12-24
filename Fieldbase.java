// Fieldbase interface for use with Observer design patterns / for future extendability
public interface Fieldbase extends Receiver {
    public void update();

    public void register(Homebase homebase);

    public void unregister();

    public Cypher getCypher();

    public int getKey();

    public void updateSpies();

    public void registerSpy(Spy spy);

    public void killSpy(Spy spy);

}
