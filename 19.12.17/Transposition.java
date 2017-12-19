
import java.io.*;
public class Transposition {

    public static String enc(String ip,int m_row,int m_col)
    {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;
        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i2][i1]=ip.charAt(i);
            i2++;
            if(i2==m_row)
            {
                i2=0;
                i1++;
            }
        }

        System.out.println("Cipher matrix:");
        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                System.out.print(op[i1][i2]+" ");
            }
            System.out.println();
        }

        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                op2 = op2+op[i1][i2];
            }
        }
        return (op2);
    }

     public static String dec(String ip,int m_row,int m_col)
     {
        char op[][]=new char[100][100];
        int len = ip.length();
        String op2="";
        int i1,i2,i;
        for(i=0,i1=0,i2=0;i<len;i++)
        {
            op[i1][i2]=ip.charAt(i);
            i2++;
            if(i2==m_col)
            {
                i2=0;
                i1++;
            }
        }

        System.out.println("Cipher matrix");
        for(i1=0;i1<m_row;i1++)
        {
            for(i2=0;i2<m_col;i2++)
            {
                System.out.print(op[i1][i2]+" ");
            }
            System.out.println();
        }
        for(i1=0;i1<m_col;i1++)
        {
            for(i2=0;i2<m_row;i2++)
            {
                op2 = op2+op[i2][i1];
            }
        }
        return (op2);
     }

    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader (System.in));

        /* O-P matrix specification */
        int m_col;
        int m_row;

        /* */
        String ip;
        int len;
        String op2;

        System.out.println("Enter input:");
        ip = obj.readLine();
        len = ip.length();

        /*Calculate matrix*/
        System.out.println("Enter number of rows:");
        m_row = Integer.parseInt(obj.readLine());
        m_col = (int)Math.ceil((float)len/m_row);

        /* Option */
        System.out.println("What do you want to perform:\n1.Encryption\n2.Decryption");
        int ch;
        ch = Integer.parseInt(obj.readLine());

        if (ch==1)
        {
            op2 = enc(ip,m_row,m_col);
            op2 = enc(op2,m_row,m_col);
            System.out.println("Cipher text:"+ op2);
        }
        else if (ch==2)
        {
            op2 = dec(ip,m_row,m_col);
            op2 = dec(op2,m_row,m_col);
            System.out.println("Plain text:"+ op2);
        }
        else
        {
            System.out.println("Invalid Choice");
        }
    }
}
