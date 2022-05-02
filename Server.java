// A Java program for a EchoServer
import java.net.*;
import java.io.*;
public class Server
{
	 public static void main(String args[])
	    {
	        Server server = new Server(5000);
	    }
    //initialize socket and input stream
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a Client ...");
            socket = server.accept();
            System.out.println("Client accepted");          
            // takes input from the Client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            // reads message from client until "Exit" is sent
            while (!line.equalsIgnoreCase("Exit"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println("Client`s Message: "+line);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            } 
            // close connection after the "exit" is input
            System.out.println("Client Disconnected");
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}