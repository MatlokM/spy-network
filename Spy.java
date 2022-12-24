// Interface for spy, for Observer pattern and extendability
public interface Spy extends Receiver{
    public void update();

    public void register(Fieldbase fieldbase);

    public void die();
}
