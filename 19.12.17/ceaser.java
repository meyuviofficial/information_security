//A Java Program to illustrate Caesar Cipher Technique
import java.util.Scanner;
class CaesarCipher
{
    // Encrypts text using a shift od s
    public static StringBuffer encrypt(StringBuffer text, int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
            if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 65) % 26 + 65);
                //System.out.println("--"+(int)text.charAt(i)+"--");
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                                  s - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted \n");
        StringBuffer text = new StringBuffer();
        text.append(sc.nextLine());
        System.out.println("Enter the shift");
        int s = sc.nextInt();
        System.out.println("Text  : " + text);
        System.out.println("Shift : " + s);
        StringBuffer result1 = encrypt(text, s);
        System.out.println("Cipher: " + encrypt(text, s));
        System.out.println("Decrypted text is: "+encrypt(result1 ,26-s));
    }
}
