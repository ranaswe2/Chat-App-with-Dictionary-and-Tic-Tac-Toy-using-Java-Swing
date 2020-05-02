/*b
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrationform;

import combination.CombinedFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RS RANA
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        
        super("Chit Chat 1.0");
        initComponents();
        
        mail.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                /*if(!(ch >='0' && ch <='9' || (Character.isAlphabetic(ch)) || (ch==KeyEvent.VK_PERIOD) || (ch==(char)KeyEvent.VK_AT) || (ch==KeyEvent.VK_UNDERSCORE) || (ch==KeyEvent.VK_BACK_SPACE) || (ch==KeyEvent.VK_DELETE))){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Give correct email address!");
                }*/
            }
        });
        
        password.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(ch >='0' && ch <='9' || ch==KeyEvent.VK_PERIOD || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE || (Character.isAlphabetic(ch)))){

                    e.consume();
                    JOptionPane.showMessageDialog(null," Numbers/ characters / . only!");
                }
            }
        });
        
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
               if( mail.getText().trim().length()==0 ||
               
                password.getText().trim().length()==0 
              ){
            JOptionPane.showMessageDialog(null, "Fill all fields!");
        }
          
            try {
               File f= new File("C:\\Users\\RS RANA\\Documents\\NetBeansProjects\\Chit Chat\\SignUpForm.txt");
                Scanner collect= new Scanner(f);
                String email= mail.getText();
                String pass= password.getText();
                while(collect.hasNext()){
                    String fname= collect.next();
                    String lname= collect.next();
                    String gmail= collect.next();
                    String gender= collect.next();
                    String age= collect.next();
                    String repass= collect.next();
                 if(email.equals(gmail) && pass.equals(repass))  {
                     new CombinedFrame();
                 }
                 
                 else if(!(email.equals(gmail) && pass.equals(repass))) {
                     JOptionPane.showMessageDialog(null,"Incorrect E-Mail or Password!");
                 }
                }
                collect.close();
            } catch (Exception ex) {

            }
           
           
            }
        });
        
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
            mail.setText("");
            password.setText("");
               
            }
        });
        
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
             int option= JOptionPane.showConfirmDialog(null,"R u sure to close this window?","Please Confirm",JOptionPane.YES_NO_OPTION);
                   if(option == JOptionPane.YES_OPTION){
                       System.exit(0);
                   }     else{
                       //Go ahed....
                   }
            
            }
        });
        
        this.setVisible(true);
        this.setResizable(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        reset = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Woodcut", 1, 48)); // NOI18N
        jLabel2.setText("Login");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 40, 270, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("E-Mail");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(160, 170, 140, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(160, 230, 120, 40);

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        jPanel1.add(mail);
        mail.setBounds(360, 170, 170, 30);

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password);
        password.setBounds(360, 240, 170, 30);

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/reset1.jpeg"))); // NOI18N
        jPanel1.add(reset);
        reset.setBounds(130, 380, 70, 29);

        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/submit1.jpeg"))); // NOI18N
        jPanel1.add(submit);
        submit.setBounds(310, 370, 90, 40);

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/cancel.png"))); // NOI18N
        jPanel1.add(cancel);
        cancel.setBounds(510, 380, 60, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/msn.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -10, 720, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
