
package combination;

import chit_chat.ChatClient;
import dictionary.DictionaryMainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tictactoy.TictacMainFrame;


public class CombinedFrame extends javax.swing.JFrame {

    public CombinedFrame() {
        
        super("Chit Chat 1.0");
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        
        chat.setToolTipText("Chat Box");  
        chat.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
               new ChatClient("127.0.0.1");
            }
        });
        
        dictionary.setToolTipText("E 2 B Dictionary");
        dictionary.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
               new DictionaryMainFrame();
            }
        });
        
        tictac.setToolTipText("Tic Tac Toy");
        tictac.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                new TictacMainFrame();
               
            }
        });
        
        exit.setToolTipText("Exit from System");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
               System.exit(0);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        chat = new javax.swing.JButton();
        dictionary = new javax.swing.JButton();
        tictac = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        chat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/combination/chat.jpeg"))); // NOI18N
        jPanel1.add(chat);
        chat.setBounds(190, 100, 70, 70);

        dictionary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/combination/dict.jpg"))); // NOI18N
        jPanel1.add(dictionary);
        dictionary.setBounds(400, 100, 70, 70);

        tictac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/combination/tictac.jpeg"))); // NOI18N
        jPanel1.add(tictac);
        tictac.setBounds(190, 300, 70, 70);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/combination/exit.jpeg"))); // NOI18N
        jPanel1.add(exit);
        exit.setBounds(400, 310, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/combination/mess2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -20, 780, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(CombinedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CombinedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CombinedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CombinedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombinedFrame();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chat;
    private javax.swing.JButton dictionary;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton tictac;
    // End of variables declaration//GEN-END:variables
}
