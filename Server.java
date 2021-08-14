import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
  
public class Server
{
    public static void main(String args[]) throws IOException
    {
  
       
        ServerSocket ss = new ServerSocket(4444);
        Socket s = ss.accept();
  
       
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
  
        while (true)
        {
           
            String input = dis.readUTF();
  
            if(input.equals("end"))
                break;
  
            System.out.println("NUMBERS  :" + input);
            int result;
  
           
            StringTokenizer st1 = new StringTokenizer(input);
  
            int opr = Integer.parseInt(st1.nextToken());
            String operation = st1.nextToken();
            int opr2 = Integer.parseInt(st1.nextToken());
  
            
            if (operation.equals("+"))
            {
                solution = opr1 + opr2;
            }
  
            else if (operation.equals("-"))
            {
                solution = opr1 - opr2;
            }
            else if (operation.equals("*"))
            {
                solution = opr1 * opr2;
            }
            else
            {
                solution = opr1 / opr2;
            }
            System.out.println("solution:");
  
            // send the result back to the client.
            dos.writeUTF(Integer.toString(result));
        }
    }
}