package client;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 



//import ocsf.client.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import clientAppSide.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */

public class URSClient extends AbstractClient
{
	//public static int id = 234;
	private String logID;
	  
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI; 
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  
  public URSClient(String id,String host, int port, ChatIF clientUI) throws IOException
  //public ChatClient(String host, int port, ChatIF clientUI)  
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    
    logID=id;
    setId(id);
    openConnection();
    
    //System.out.println("Client ID : "+logID+"   Started");
    this.sendToServer("#Login"+id); //pour 51
  }

  //Instance methods ************************************************
    
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  
  
  public void handleMessageFromServer(Object msg) 
  {
	  //clientUI.display(msg.toString());
	  ClientConsole.dispatchServerMessage(msg);  
  }
  
  
  
  public String getID(){
	  return logID;
  }
  
  public void setId(String i)
  {
	  logID=i;
  }
  
  /*
   Fonction qui redifini celle dans AbstractClient
   */
  
  protected void connectionClosed() 
  {
      System.out.println("Connection closed");
      //try{closeConnection();}
      //catch(IOException e){}
  }
  
  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  
  public void handleMessageFromClientUI(ArrayList<String> message)
  {
	    try
	    {	
	    	//if(this.isConnected())
	    	sendToServer(message);
	    }
	    catch(IOException e)
	    {
	    	clientUI.display("Could not send message to server. Terminating client.");
	    }
  }
  
  protected void connectionException(Exception exception) 
  {
      	//connectionClosed();
      	//System.out.println("WARNING - The server has stopped listening for connections");
		//System.out.println("SERVER SHUTTING DOWN! DISCONNECTING!");
		//System.out.println("Abnormal termination of connection.");
	  
		//System.out.println("Terminating client...");
		//System.exit(1);
  }
  
  /**
   * This method terminates the client.
   */
  public void quit() //51
  {
    try
    {
      closeConnection();  
    }
    catch(IOException e) {}
    System.exit(0);
  }
}
//End of ChatClient class
