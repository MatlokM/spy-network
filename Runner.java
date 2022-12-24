public class Runner {
    public static void main(String[] args) {

        // Creates bases, spies, and cyphers
        Homebase homebase = Homebase.getInstance();
        Fieldbase testfb = new ConcreteFB();
        Spy testspy = new ConcreteSpy();
        Cypher caesar = new caesar();
        Cypher caesar2 = new caesar2();

        // Registers everything to each other
        testfb.register(homebase);
        testspy.register(testfb);

        // Sets cypher (Should update for all)
        homebase.setCypher(caesar);
        homebase.setKey(5);

        // If cypher and key were successfully updated, messages should be sent and decoded
        homebase.sendMessage("Test One", testfb);
        System.out.println(testfb.getMessage());

        homebase.sendMessage("Test Two", testspy);
        System.out.println(testspy.getMessage());

        // Creates a layered cypher to test
        Cypher caesar3 = new CaesarDecorator(new caesar2());
        homebase.setCypher(caesar3);
        homebase.setKey(3);

        // If decorator worked, messages should be sent and decoded.
        homebase.sendMessage("Test Three", testfb);
        System.out.println(testfb.getMessage());

        homebase.sendMessage("Test Four", testspy);
        System.out.println(testspy.getMessage());

        // Unregisters fb and kills spy
        testfb.unregister();
        testspy.die();

        // Sets a new cypher and key in homebase. This should NOT update cypher and key of testfb and testspy.
        homebase.setCypher(caesar2);
        homebase.setKey(10);

        // If working properly, messages should be gibberish.
        homebase.sendMessage("Test Five", testfb);
        System.out.println(testfb.getMessage());

        homebase.sendMessage("Test Six", testspy);
        System.out.println(testspy.getMessage());

        // Attempts to re-register the spy. This should return an error message.
        testspy.register(testfb);
    }
}