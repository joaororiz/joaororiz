package View;

import Dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class Login extends javax.swing.JFrame {

    public Login() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);

        UsuarioDAO usuariosDao = new UsuarioDAO();
        int cont = 0;
        while (cont < usuariosDao.findByEmails().size()) {
            comboBoxUsers.addItem(usuariosDao.findByEmails().get(cont));
            cont++;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l = new javax.swing.JPanel();
        labelImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        botaoSair = new javax.swing.JButton();
        botaoEntrar = new javax.swing.JButton();
        comboBoxUsers = new javax.swing.JComboBox<>();
        botaoCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/consulta_cidadao2.png"))); // NOI18N

        jLabel2.setText("Usuário:");

        jLabel3.setText("CPF:");

        try{
            javax.swing.text.MaskFormatter cpf= new javax.swing.text.MaskFormatter("###.###.###-##");
            textCPF = new javax.swing.JFormattedTextField(cpf);
        } catch (Exception e){ }

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoEntrar.setText("Entrar");
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        botaoEntrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                botaoEntrarKeyPressed(evt);
            }
        });

        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Não possiu cadastro?");

        javax.swing.GroupLayout lLayout = new javax.swing.GroupLayout(l);
        l.setLayout(lLayout);
        lLayout.setHorizontalGroup(
            lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lLayout.createSequentialGroup()
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lLayout.createSequentialGroup()
                                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textCPF)
                                    .addComponent(comboBoxUsers, 0, 241, Short.MAX_VALUE)))
                            .addComponent(labelImage)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, lLayout.createSequentialGroup()
                                .addComponent(botaoSair)
                                .addGap(182, 182, 182)
                                .addComponent(botaoEntrar))))
                    .addGroup(lLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(lLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(botaoCadastrar)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        lLayout.setVerticalGroup(
            lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lLayout.createSequentialGroup()
                .addComponent(labelImage)
                .addGap(27, 27, 27)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSair)
                    .addComponent(botaoEntrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        if (comboBoxUsers.getSelectedIndex() < 0 || comboBoxUsers.getSelectedIndex() > comboBoxUsers.getMaximumRowCount()) {
            JOptionPane.showMessageDialog(null, "Usuário selecionado inválido");
        }
        try {
            UsuarioDAO usuariodao = new UsuarioDAO();
            String emailSelected = String.valueOf(comboBoxUsers.getSelectedItem());
            
            if (usuariodao.isExistsCPF(emailSelected, textCPF.getText())) {
                Menu menu = new Menu();
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "CPF informado está inválido!");
                textCPF.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void botaoEntrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_botaoEntrarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoEntrarKeyPressed

    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed
        new NovoFuncionario().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JComboBox<String> comboBoxUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel l;
    private javax.swing.JLabel labelImage;
    private javax.swing.JTextField textCPF;
    // End of variables declaration//GEN-END:variables

}
