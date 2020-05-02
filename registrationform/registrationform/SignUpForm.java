
package registrationform;

import combination.CombinedFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class SignUpForm extends javax.swing.JFrame {

 
    public SignUpForm() {
        super("Chit Chat 1.0");
        initComponents();
        
        /* ----------------------------------------------------------------------------- */
       
        buttonGroup1.add(male);
        buttonGroup1.add(female);
        
        
       /* ---------------------------------------------------------------------------- */
        
        fname.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(Character.isAlphabetic(ch) || ch== ' ' || ch=='\b' || ch==KeyEvent.VK_DELETE)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"<html>Only A-Z, a-z, Space character<br/> will be allowed!");
                }
            }
        });
        
        lname.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(Character.isAlphabetic(ch) || ch== ' ' || ch=='\b' || ch==KeyEvent.VK_DELETE)){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"<html>Only A-Z, a-z, Space character<br/> will be allowed!");
                }
            }
        });
        
        mail.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                /*if(!(ch >='0' && ch <='9' || (Character.isAlphabetic(ch)) || (ch==KeyEvent.VK_PERIOD) || (ch==(char)KeyEvent.VK_AT) || (ch==KeyEvent.VK_UNDERSCORE) || (ch==KeyEvent.VK_BACK_SPACE) || (ch==KeyEvent.VK_DELETE))){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Give correct email address!");
                }*/
            }
        });
        
        age.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c= e.getKeyChar();
                
                if(!( c >='0' && c <='9' || (c == KeyEvent.VK_BACK_SPACE) || (c== KeyEvent.VK_DELETE))){
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Numbers only");
                    
                }
            }
        });
        
        pass.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(ch >='0' && ch <='9' || ch==KeyEvent.VK_PERIOD || ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE || (Character.isAlphabetic(ch)))){

                    e.consume();
                    JOptionPane.showMessageDialog(null," Numbers/ characters / . only!");
                }
            }
        });
        
        repass.addKeyListener(new KeyAdapter(){
            
            public void keyTyped(KeyEvent e){
                
                char ch= e.getKeyChar();
                if(!(ch >='0' && ch <='9' || ch==KeyEvent.VK_PERIOD|| ch==KeyEvent.VK_AT|| ch==KeyEvent.VK_UNDERSCORE|| ch==KeyEvent.VK_BACK_SPACE || ch==KeyEvent.VK_DELETE || (Character.isAlphabetic(ch)))){
                    e.consume();
                    JOptionPane.showMessageDialog(null," Numbers/ characters /./_ /@ only!");
                }
            }
        });
       
        
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(fname.getText().trim().length()==0 || 
                lname.getText().trim().length()==0 ||
                mail.getText().trim().length()==0 ||
                age.getText().trim().length()==0 ||
                pass.getText().trim().length()==0 ||
                repass.getText().trim().length()==0 ||
                buttonGroup1.isSelected(null)){
            JOptionPane.showMessageDialog(null, "Fill all fields!");
        }
        else {
            try{
            int int2= Integer.parseInt(age.getText());
            age.requestFocusInWindow();
            
            if(int2>100||int2<13){
                JOptionPane.showMessageDialog(null,"Age must be within 13 to 100");
                age.setText("");
                age.requestFocusInWindow();
                return;
            }
            }catch(Exception z){
                    
                    }
                
            String firstname= fname.getText();
            String lastname= lname.getText();
            String email= mail.getText();
            String gender= null;
            
            if(male.isSelected()){
                gender= male.getText().toString();
            }
            else if(female.isSelected()){
                gender= female.getText().toString();
            }
            String ages= age.getText();
            String password= pass.getText();
            String repassword= repass.getText();
            
             String Email="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[_A-Za-z0-9-]+(\\.[_A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            if(email.matches(Email) && (password.equals(repassword))){
            //File n=new File("C:\\Users\\RS RANA\\Documents\\NetBeansProjects\\Chit Chat\\SignUpForm.txt");
                   //  n.mkdir();
            try {
                FileWriter fileOutStrm = new FileWriter("SignUpForm.txt");
		BufferedWriter bufWriter = new BufferedWriter(fileOutStrm);
		PrintWriter print = new PrintWriter(bufWriter,true);

				 print.println(firstname+" "+lastname);
				 print.println(email);
				 print.println(gender);
				 print.println(ages);
                                 print.println(password);
                                 //print.println("Repassword : "+repassword);
                print.close();
                
            } catch (Exception ex) {

            }
           JOptionPane.showMessageDialog(null,"Thanks for sign up!");
            new CombinedFrame();
            
            }
            else if(!(email.matches(Email) && (password.equals(repassword)))){
            JOptionPane.showMessageDialog(null,"Give correct E-mail address and also give same password!");
            }
            else if(!(email.matches(Email))){
                
            JOptionPane.showMessageDialog(null,"Give correct E-mail address!");    
            
            }
            else if(!(password.equals(repassword))){
            JOptionPane.showMessageDialog(null,"Passwords aren't same!");    
            }
            
                
            }
                
            }
        });
        
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                fname.setText("");
            lname.setText("");
            mail.setText("");
            age.setText("");
            pass.setText("");
            repass.setText("");
               
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        age = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        repass = new javax.swing.JPasswordField();
        reset = new javax.swing.JButton();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Woodcut", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign Up");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 10, 220, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("First Name ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 80, 160, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 130, 130, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("E-Mail");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(130, 190, 120, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 240, 90, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Age");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 290, 80, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Password");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(130, 340, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("Retype Password");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(130, 380, 180, 30);
        jPanel1.add(fname);
        fname.setBounds(400, 80, 190, 30);

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname);
        lname.setBounds(400, 130, 190, 30);

        mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailActionPerformed(evt);
            }
        });
        jPanel1.add(mail);
        mail.setBounds(400, 180, 190, 30);

        male.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel1.add(male);
        male.setBounds(400, 230, 80, 31);

        female.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel1.add(female);
        female.setBounds(500, 230, 91, 30);
        jPanel1.add(age);
        age.setBounds(400, 280, 190, 30);

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(400, 330, 190, 30);
        jPanel1.add(repass);
        repass.setBounds(400, 380, 190, 30);

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/reset1.jpeg"))); // NOI18N
        jPanel1.add(reset);
        reset.setBounds(160, 440, 70, 29);

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/submit1.jpeg"))); // NOI18N
        jPanel1.add(save);
        save.setBounds(330, 440, 90, 39);

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/cancel.png"))); // NOI18N
        jPanel1.add(cancel);
        cancel.setBounds(510, 440, 60, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/mes.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancel;
    private javax.swing.JRadioButton female;
    private javax.swing.JTextField fname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mail;
    private javax.swing.JRadioButton male;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField repass;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables

    
    }

