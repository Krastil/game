import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HmacAndKey {

    private String HMAC;
    private String KeyHMAC;

    public void generateHmacAndKey(String s) throws NoSuchAlgorithmException, InvalidKeyException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[16];
        secureRandom.nextBytes(bytes);
        SecretKeySpec keySpec = new SecretKeySpec(bytes, "HmacSHA3-256");
        Mac signer = Mac.getInstance("HmacSHA3-256");
        signer.init(keySpec);
        byte[] digest = signer.doFinal(s.getBytes(StandardCharsets.UTF_8));
        this.HMAC = bytesToHex(digest);
        this.KeyHMAC = bytesToHex(keySpec.getEncoded());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String getHMAC(){
        return this.HMAC;
    }

    public String getKey(){
        return this.KeyHMAC;
    }
}
