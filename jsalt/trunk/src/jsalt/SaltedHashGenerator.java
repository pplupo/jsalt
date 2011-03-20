package jsalt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class aims to provide a simple API to generate salted hash encryptions for plain text passwords.
 * @author Peter P. Lupo
 */
public class SaltedHashGenerator {
	
    private final boolean encodeHashAsBase64;
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final MessageDigest messageDigest;
    
    /**
     * Sets the digest algorithm to use.
     * All the named <a href="http://download.oracle.com/javase/6/docs/technotes/guides/security/SunProviders.html">
     * Message Digest Algorithms</a> present in JSE are supported plus external providers in the same way
     * MessageDigester does.
     *
     * @param algorithm The algorihtm key name.
     * @throws IllegalArgumentException If a corresponding algorithm could not be found.
     */
    public SaltedHashGenerator(String algorithm) throws IllegalArgumentException {
        this(algorithm, false);
    }
    
    /**
     * All the named <a href="http://download.oracle.com/javase/6/docs/technotes/guides/security/SunProviders.html">
     * Message Digest Algorithms</a> present in JSE are supported by the use of the enum StandardJSEAlgorithms.
     * 
     * @param algorithm The algorithm to use.
     */
    public SaltedHashGenerator(StandardJSEAlgorithms algorithm) {
        this(algorithm.getName());
    }
    
    /**
     * This constructor works as {@link #SaltedHashGenerator(String)} and provides a
     * convenient way to set if the generated passwords should be encoded as Base64.
     *
     * @param algorithm The algorithm key name.
     * @param encodeHashAsBase64 true If the generated key should be encoded as Base64. Default is false.
     * @throws IllegalArgumentException If a corresponding algorithm could not be found.
     */
    public SaltedHashGenerator(String algorithm, boolean encodeHashAsBase64) throws IllegalArgumentException {
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No algorithm \"" + algorithm + "\" could be found.");
        }
        this.encodeHashAsBase64 = encodeHashAsBase64;
    }
    
    /**
     * This constructor works as {@link #SaltedHashGenerator(StandardJSEAlgorithms)} and provides a
     * convenient way to set if the generated passwords should be encoded as Base64.
     *
     * @param algorithm The algorithm to use.
     * @param encodeHashAsBase64 true If the generated key should be encoded as Base64. Default is false.
     */
    public SaltedHashGenerator(StandardJSEAlgorithms algorithm, boolean encodeHashAsBase64) {
    	this(algorithm.getName(), encodeHashAsBase64);
    }
    
    /**
     * Encodes the password merged with the salt before encoding.
     *
     * @param password The plain text password to be encrypted.
     * @param salt The salt to be merged.
     * @return Hex or base64 encoded string of password digest.
     */
    public String encodePassword(String password, Object salt) {
        if (password == null) {
            password = "";
        }
        
        String saltedPass;
        if ((salt == null) || "".equals(salt)) {
        	saltedPass = password;
        } else {
        	saltedPass = password + "{" + salt.toString() + "}";
        }

        try {
        	byte[] digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
            if (encodeHashAsBase64) {
                return Base64.encodeBytes(digest);
            } else {
                int l = digest.length;
                char[] hexEncoded = new char[l << 1];
                for (int i = 0, j = 0; i < l; i++) {
                    hexEncoded[j++] = hexDigits[(0xF0 & digest[i]) >>> 4];
                    hexEncoded[j++] = hexDigits[0x0F & digest[i]];
                }
                return new String(hexEncoded);
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }

    }
    
}
