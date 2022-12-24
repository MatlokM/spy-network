// Slightly modified caesar cypher for the purposes of testing swapping cyphers out
public class caesar2 implements Cypher {

    public static final String alp = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String msg, int key) {
        int i;
        System.out.println("Encrypting:" + msg);
        msg = msg.toLowerCase(); // converts the message string to all uppercase
        String encryptedString = ""; // to store the the encrypted message

        for (i = 0; i < msg.length(); i++) {

            // gives us the position of each character of msg in alp
            int current = alp.indexOf(msg.charAt(i));
            // get the encryption of each letter in msg
            int En = (current + key*2) % 26;
            char encryptedLetter = alp.charAt(En);

            // add each encrypted letter to the string 
            encryptedString = encryptedString + encryptedLetter;
        }


        //returns the encrypted string in all lower case 
        return encryptedString;

    }

    public String decrypt(String msg, int key) {
        int i;
        System.out.println("Decrypting:" + msg);
        msg = msg.toLowerCase(); // converts the message string to all uppercase
        String decryptedString = ""; // to store the the decrypted message

        for (i = 0; i < msg.length(); i++) {

            // gives us the position of each character of msg in alp
            int current = alp.indexOf(msg.charAt(i));

            //decryption  of each letter in msg
            int Dn = (current - key*2) % 26;

            // if the position of the decrypted character is negative , it subtracts itself 
            // from the total letters in the alphabet string which is 26
            if (Dn < 0) {
                Dn = alp.length() + Dn;
            }

            char decryptedLetter = alp.charAt(Dn);

            // add each decypted letter to the string
            decryptedString = decryptedString + decryptedLetter;

        }

        decryptedString = decryptedString.replace('z', ' ');

        return decryptedString;
    }
}
