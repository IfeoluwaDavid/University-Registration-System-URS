package server;
// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
import serverAppSide.*;
import java.io.*;
import java.util.ArrayList;
/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class URSServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
	boolean firstCom =false;
	
  final public static int DEFAULT_PORT = 5555;
  
  ServerIF serverUI;
  ConnectionToClient client;
  //ServerConsole serverconsole = new ServerConsole(DEFAULT_PORT);
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public URSServer(int port,ServerIF server) 
  {
    super(port);
    this.serverUI = server;
  }
  
  
  public void stoppedlistening()
  {
		this.stopListening();
		ServerUI.displayActivities("SERVER STOPPED LISTENING");
	}
  
  public void handleMessageFromServer(Object msg) 
  {
    serverUI.display(msg.toString());
  }
  
  public int number()
  {
		return this.getNumberOfClients();
	}
  
    public void handleMessageFromServerUI(String message) throws InterruptedException
    {
        this.sendToAllClients("SERVER MSG>"+message); 
    }
    
  //Instance methods ************************************************
  
  /*
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
    
  public void quit()
  {
	 try
	 { 
		 //ServerUI.displayActivities("something has happened");
		 this.close();
		 System.exit(1);
	 }
	 catch (IOException e)
	 {
		 //System.exit(1);
	 }
  }
  
  public void handleMessageFromClient(Object msg, ConnectionToClient client)
  {
		if(client.getInfo("isLogin")==null)
		{
			client.setInfo("ID",((String)msg).substring(6));
			client.setInfo("isLogin", "LOGGEDIN");
		}
	    
		  String infoFromClient = msg.toString();
	      StringBuilder stringbuilder = new StringBuilder();
	      stringbuilder.append(infoFromClient);
	      stringbuilder.deleteCharAt(0);
	      stringbuilder.deleteCharAt(stringbuilder.length() - 1);
	      infoFromClient = stringbuilder.toString();
	      String clientInfoArray[] = infoFromClient.split(", ");
	      
	      try
	      {
			ServerConsole.dispatchClientMessage(clientInfoArray, client);
	      } 
	      catch (IOException e) 
	      {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }
  }

  final protected void clientDisconnected(ConnectionToClient client) 
  {
	  ServerUI.displayActivities("The client "+ client.getInfo("ID")+" Is disconnected");
  }


protected void clientConnected(ConnectionToClient client) 
{
	ServerUI.displayActivities("A new client is attempting to connect to the server");
	ServerUI.displayActivities("A new client is connected.");
}
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
 protected void serverStarted()
 {
	  ServerUI.displayActivities("Server listening for connections on port " + getPort());
 }
  
 protected void serverClosed()
 {
	  ServerUI.displayActivities("The server has been closed");
 }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
 protected void serverStopped()
 {
	 ServerUI.displayActivities("Server has stopped listening for connections.");
 }
  
  synchronized protected void clientException(ConnectionToClient client, Throwable exception)
  {
	  ServerUI.displayActivities("The CLIENT : "+ client.getInfo("ID") +" disconnected");
  }
  
}

  //Class methods ***************************************************
