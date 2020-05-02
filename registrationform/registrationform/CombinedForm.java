
package registrationform;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CombinedForm extends javax.swing.JFrame {

    public CombinedForm() {
        
        super("Chit Chat 1.0");
        initComponents();
        
        signup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new SignUpForm();
            }
            
        });
        
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new LoginForm();
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
        signup = new javax.swing.JButton();
        login = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        signup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/signup1.jpeg"))); // NOI18N
        jPanel1.add(signup);
        signup.setBounds(290, 90, 190, 59);

        login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/login2.jpeg"))); // NOI18N
        jPanel1.add(login);
        login.setBounds(290, 230, 190, 75);

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/cancel1.png"))); // NOI18N
        jPanel1.add(cancel);
        cancel.setBounds(290, 380, 190, 90);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Welcome to Chit Chat ! To enjoy all facilities, sign up if first.");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 30, 550, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrationform/mess2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 530);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CombinedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CombinedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CombinedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CombinedForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombinedForm();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
