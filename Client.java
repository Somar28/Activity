// A Java program for a EchoClient
import java.net.*;
import java.io.*;
public class Client
{
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 5000);
    }
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected To Server"); 
            System.out.println("Please Enter Message: ");
             // takes input from user
            input  = new DataInputStream(System.in);
            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        // string to read message from input
        String line = "";
        // keep reading until "Exit" is input by the client
        while (!line.equalsIgnoreCase("Exit"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
                // To verify client message is sent
                System.out.println("Server Echoes: "+line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        // close the connection after the "exit" is input
        try
        {
        	System.out.println("Disconnected to Server");
     
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}