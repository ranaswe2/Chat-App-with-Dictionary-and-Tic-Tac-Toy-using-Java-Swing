
package chit_chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatClient {
    
    private JTextField textField;
    private JTextArea textArea;
    private ObjectOutputStream output; //put
    private ObjectInputStream input;
    private Socket connection;
    private JFrame fr;
    
    private String message= "";
    private String serverIP;

    public ChatClient(String host) {
        
    fr= new JFrame("Client");
    serverIP= host;
    textField= new JTextField();
    textField.setEditable(false);
    textField.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
    
            sendMessage(ae.getActionCommand());
            textField.setText(" ");
            
        }
    });
    
    fr.add(textField,BorderLayout.SOUTH);
    
    textArea= new JTextArea();
    
    fr.add(new JScrollPane(textArea),BorderLayout.CENTER);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setBounds(200,100,400,400);
    fr.setVisible(true);
    fr.setResizable(false);
    
     startRunning();
    
    }
    
    private void sendMessage(String message){
       
        try {
            
            output.writeObject("Client : "+message);
            output.flush();
            showMessage("\nClient : "+message);
            
        } catch (IOException ex) {
            textArea.append("\nSomething went wrong while sending message.");
        }
   }
    
    private void showMessage(final String text){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
           textArea.append(text);
            }
        });
    }
    
    public void startRunning(){
        try {
            
            connectToServer();
            setupStreams();
            whileChatting();
            
        }catch (EOFException x) {
            showMessage("\nClient terminated the connection.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            close();
        }
        
    }
    
    public void connectToServer() throws UnknownHostException, IOException{
        
        showMessage("Connecting...\n");
        
        connection= new Socket(InetAddress.getByName(serverIP),30001);
        
        showMessage("Connected to "+connection.getInetAddress().getHostName());
        
    }
    
    private void setupStreams() throws IOException{
        
        output= new ObjectOutputStream(connection.getOutputStream());
        
        output.flush();
        
        input= new ObjectInputStream(connection.getInputStream());
        
        showMessage("\nYour streams are connected!");
        
    }
    
    private void whileChatting() throws IOException, ClassNotFoundException{
        
        ableToType(true);
        
     do{
         
         message= (String) input.readObject();
         showMessage("\n"+message);
         
     }   while(!message.equals("Server : End"));
    }
    
    private void close(){
        
            showMessage("\nClosing the Stream and Sockets");
            ableToType(false);
            
            try {
                
            output.close();
            input.close();
            connection.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void ableToType(final boolean bool){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
           textField.setEditable(bool);
            }
        });
    }
    
    public static void main(String[] args) {
        ChatClient a= new ChatClient("127.0.0.5");
    }
}
