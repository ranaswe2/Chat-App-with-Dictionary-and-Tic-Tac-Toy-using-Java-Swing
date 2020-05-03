
package chit_chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatServer {
    
    private JFrame fr;
    private JTextArea textArea;
    private JTextField textField;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket serverConnection;
    private Socket connection;

    public ChatServer() {
    fr= new JFrame("Server");
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
    
    fr.add(new JScrollPane(textArea));
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setBounds(800,100,400,400);
    fr.setVisible(true);
    
    startRunning();
    
    }
    
    private void sendMessage(String message){
        try {
            output.writeObject("Server : "+message);
            output.flush();
            
            showMessage("\nServer : "+message);
        } catch (IOException ex) {
            textArea.append("\nError! You can't send message.");
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
            serverConnection= new ServerSocket(1234,100);
            
            while(true){
                waitForConnection();
                setupStreams();
                whileChatting();
                        
            }
        } catch (IOException ex) {
             showMessage("\nServer ended the connection.");
        }
        finally {
            close();
        }
    }
    
    private void waitForConnection() throws IOException{
        
        showMessage("Waiting for someone to connect...\n");
        connection= serverConnection.accept();
        showMessage("Now connected to "+connection.getInetAddress().getHostName());
        
    }
    
    private void setupStreams() throws IOException{
        
        output= new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input= new ObjectInputStream(connection.getInputStream());
        showMessage("\nStreams are now setup!\n");
        
    }
    
    private void whileChatting() throws IOException{
        
        String message=" ";
        ableToType(true);
        
        do{
            try {
                
                message= (String) input.readObject();
                showMessage("\n"+message);
                
            } catch (ClassNotFoundException ex) {
                  showMessage("\n I don't know the type of object");
            }
        } 
        while(!message.equals("Server : End"));
    }
    
    private void ableToType(final boolean t){
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
           textField.setEditable(t);
            }
        });
    }
    
    private void close(){
        try {
            showMessage("\nClosing connection...");
            ableToType(false);
            input.close();
            output.close();
            connection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        ChatServer a= new ChatServer();
        
    }
}
