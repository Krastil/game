import org.bouncycastle.jcajce.provider.digest.SHA3;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Rules {
    public void makeMove() {
        System.out.print("Enter you move: ");
        while (true) {
            String s = new Scanner(System.in).nextLine();

        }

    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public void movePC(String s) throws NoSuchAlgorithmException, InvalidKeyException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);



        SecretKeySpec keySpec = new SecretKeySpec(bytes, "HmacSHA3-256");

        int i = s.split(" ").length;
        int a = secureRandom.nextInt(i) + 1;
        String messageStr = s.split(" ")[a - 1];
        Mac signer = Mac.getInstance("HmacSHA3-256");
        signer.init(keySpec);

        byte[] digest = signer.doFinal(messageStr.getBytes(StandardCharsets.UTF_8));
        System.out.println("Message: " + messageStr);
        System.out.println("Key: " + bytesToHex(bytes));
        System.out.println("Key: " + bytesToHex(keySpec.getEncoded()));
        System.out.println("HMAC: " + bytesToHex(digest));


    }
}
