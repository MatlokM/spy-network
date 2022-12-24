// Every element in the spy network must be a Receiver, so they can send and receive messages.
public interface Receiver {

    public void sendMessage(String msg, Receiver receiver);

    public void setMessage(String msg);

    public String getMessage();


}
