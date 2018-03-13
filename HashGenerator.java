import java.io.*;
import java.util.*;
import java.security.*;

public class HashGenerator {
 
    public static void main(String[] args) {
        try {
			Scanner e=new Scanner(System.in);
			System.out.println("enter the input string:");
            String inputString = e.nextLine();
            System.out.println("Input String: " + inputString);
 
            String md5Hash = HashGeneratorUtils.generateMD5(inputString);
            System.out.println("MD5 Hash: " + md5Hash);
 
            String sha1Hash = HashGeneratorUtils.generateSHA1(inputString);
            System.out.println("SHA-1 Hash: " + sha1Hash);
 
            String sha256Hash = HashGeneratorUtils.generateSHA256(inputString);
            System.out.println("SHA-256 Hash: " + sha256Hash);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
}
class HashGeneratorUtils {
    HashGeneratorUtils() {
 
    }
 
    public static String generateMD5(String message) throws Exception 
	{
        return hashString(message, "MD5");
    }
 
    public static String generateSHA1(String message) throws Exception 
	{
        return hashString(message, "SHA-1");
    }
 
    public static String generateSHA256(String message) throws Exception 
	{
        return hashString(message, "SHA-256");
    }
 
    public static String hashString(String message, String algorithm)
           throws Exception 
	 {
 
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            byte[] hashedBytes = digest.digest(message.getBytes("UTF-8"));
 
            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
          throw new Exception("Could not generate",ex);
		}
    }
 
    public static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}