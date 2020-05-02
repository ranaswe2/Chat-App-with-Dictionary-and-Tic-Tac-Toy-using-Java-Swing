
package registrationform;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.swing.*;

public class SignUp implements ActionListener{
    
    private JFrame frame= new JFrame();
    private JPanel panel1= new JPanel();
    
    private JLabel nameLbl= new JLabel("Name :");
    private JLabel idLbl= new JLabel("ID :");
    private JLabel ageLbl= new JLabel("Age :");
    
    private JRadioButton malerb= new JRadioButton("Male");
    private JRadioButton femalerb= new JRadioButton("Female");
    
    private ButtonGroup bg= new ButtonGroup();
    
    private JTextField nameTxt= new JTextField(10);
    private JTextField idtxt= new JTextField(10);
    private JTextField ageTxt= new JTextField(0);
    
    private JPanel panel4= new JPanel();
    
    private JButton save= new JButton("Save");
    private JButton cancel= new JButton("Cancel");
    private JButton reset= new JButton("Reset");        

    public SignUp() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400,100,500,400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(6,2));
        frame.setVisible(true);
        frame.add(panel1);
        frame.add(panel4);
        
        panel1.setLayout(new GridLayout(4,2));
        panel1.add(nameLbl);
        panel1.add(nameTxt);
        nameTxt.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(Character.isAlphabetic(ch) || ch== ' ' || ch=='\b' || ch==KeyEvent.VK_DELETE)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"<html>Only A-Z, a-z, Space character<br/> will be allowed!");
                }
            }
        });
        
        panel1.add(idLbl);
        panel1.add(idtxt);
        idtxt.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(ch >='0' && ch <='9' || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE || (Character.isAlphabetic(ch)))){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Only Numbers and characters");
                }
            }
        });
        
        
        panel1.add(ageLbl);
        
        panel1.add(ageTxt);
        ageTxt.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                
                if(!( c >='0' && c <='9' || (c == KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE))){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Numbers only");
                    
                }
            }
        });
        
        bg.add(malerb);
        bg.add(femalerb);
        panel1.add(malerb);
        panel1.add(femalerb);
        panel1.setBounds(20,20,400,300);
        
        panel4.setLayout(new FlowLayout());
        panel4.add(save);
        panel4.add(reset);
        panel4.add(cancel);
        save.addActionListener(this);
        cancel.addActionListener(this);
        reset.addActionListener(this);
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Save")){
        if(nameTxt.getText().trim().length()==0 || 
                idtxt.getText().trim().length()==0||
                ageTxt.getText().trim().length()==0||
                bg.isSelected(null)){
            JOptionPane.showMessageDialog(null, "Fill all fields!");
        }
        else {
            try{
            int int2= Integer.parseInt(ageTxt.getText());
            ageTxt.requestFocusInWindow();
            
            if(int2>100||int2<13){
                JOptionPane.showMessageDialog(null,"Age must be within 13 to 100");
                ageTxt.setText("");
                ageTxt.requestFocusInWindow();
                return;
            }
            }catch(Exception z){
                    
                    }
                
            String name= nameTxt.getText();
            String id= idtxt.getText();
            String gender= null;
            
            if(malerb.isSelected()){
                gender= malerb.getText().toString();
            }
            else if(femalerb.isSelected()){
                gender= femalerb.getText().toString();
            }
            String age= ageTxt.getText();
            
            
            //File n=new File("C:\\Users\\RS RANA\\Documents\\NetBeansProjects\\Chit Chat\\SignUpForm.txt");
                   //  n.mkdir();
            try {
                FileWriter fileOutStrm = new FileWriter("SignUpForm.txt");
		BufferedWriter bufWriter = new BufferedWriter(fileOutStrm);
		PrintWriter print = new PrintWriter(bufWriter,true);

				 print.println(nameLbl.getText()+"= "+name);
				 print.println(idLbl.getText()+"= "+id);
				 print.println("GENDER: = "+ gender);
				 print.println(ageLbl.getText()+"= "+age);
                print.close();
                
            } catch (Exception ex) {

            }
            
            JOptionPane.showMessageDialog(null,"Saved Successfully!");
                
            }
        
        }
        
        else if(ae.getActionCommand().equals("Cancel")){
            int option= JOptionPane.showConfirmDialog(null,"R u sure to close this window?","Please Confirm",JOptionPane.YES_NO_OPTION);
                   if(option == JOptionPane.YES_OPTION){
                       System.exit(0);
                   }     else{
                       //Go ahed....
                   }
        }
        
        else if(ae.getActionCommand().equals("Reset")){
            nameTxt.setText("");
            idtxt.setText("");
            ageTxt.setText("");
            
        }
    }
    
    public static void main(String[] args) {
        SignUp a=new SignUp();
    }
    
}
