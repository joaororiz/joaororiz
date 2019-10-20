

import Controller.Control_Disciplina;
import Controller.Control_Faculdade;
import Model.BEANS.BEAN_Faculdade;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class MenuPrincipal extends javax.swing.JFrame {

    List<BEAN_Faculdade> listaDeFaculdades;
    Control_Faculdade controle = new Control_Faculdade();

    public MenuPrincipal() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.atualizaTabelaContatos();

        this.textApelido.setEnabled(false);
        this.textNome.setEnabled(false);
        this.textDataNasc.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);
    }

    public void atualizaTabelaContatos() throws SQLException {
        Control_Disciplina controle = new Control_Disciplina();
        listaDeFaculdades = new ArrayList();
        listaDeFaculdades = controle.listaContatos();

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Apelido", "Data nasc."}, 0);

        for (int i = 0; i < listaDeFaculdades.size(); i++) {
            modelo.addRow(new Object[]{listaDeFaculdades.get(i).getId(), listaDeFaculdades.get(i).getNome(), listaDeFaculdades.get(i).getApelido(), listaDeFaculdades.get(i).getData_nascimento()});
        }

        tabelaContatos.setModel(modelo);
        tabelaContatos.getColumnModel().getColumnCount();
        tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabelaContatos.getColumnModel().getColumn(3).setResizable(false);
        tabelaContatos.getColumnModel().getColumn(3).setPreferredWidth(15);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaContatos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabelaContatos.getColumnModel().getColumn(3).setCellRenderer(centralizado);

    }

    public static Date convert_StringToDate(String dataStr) throws SQLException {
        java.sql.Date data = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data = new java.sql.Date(format.parse(dataStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public boolean isDateValid(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textApelido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textDataNasc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContatos = new javax.swing.JTable();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Contatos"));

        jLabel1.setText("Nome");

        jLabel2.setText("Apelido");

        jLabel3.setText("Data de nascimento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(textApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(textDataNasc))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        tabelaContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Apelido", "Data nasc."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaContatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaContatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaContatos);
        if (tabelaContatos.getColumnModel().getColumnCount() > 0) {
            tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
            tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
            tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(30);
            tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
            tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaContatos.getColumnModel().getColumn(3).setResizable(false);
            tabelaContatos.getColumnModel().getColumn(3).setPreferredWidth(15);
        }

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botaoNovo)
                                .addGap(45, 45, 45)
                                .addComponent(botaoSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoExcluir)
                                .addGap(45, 45, 45)
                                .addComponent(botaoCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoNovo))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.textNome.setText("");
        this.textApelido.setText("");
        this.textDataNasc.setText("");

        this.textApelido.setEnabled(false);
        this.textNome.setEnabled(false);
        this.textDataNasc.setEnabled(false);

        this.botaoNovo.setEnabled(true);
        this.botaoExcluir.setEnabled(true);

        this.botaoSalvar.setEnabled(false);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        if (textNome.getText().isEmpty() || textApelido.getText().isEmpty() || textDataNasc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ficar vazios!", "Erro, verifique a mensagem abaixo", 0);
        } else if (!isDateValid(textDataNasc.getText())) {
            JOptionPane.showMessageDialog(null, "Favor informe uma data válida!", "Erro, verifique a mensagem abaixo", 0);
        } else {
            try {
                Control_Disciplina controle = new Control_Disciplina();
                String nome, apelido, data;
                Date datanascimento = null;

                nome = textNome.getText();
                apelido = textApelido.getText();
                data = textDataNasc.getText();
                datanascimento = convert_StringToDate(data);

                ContatosBEAN contato = new ContatosBEAN(0, nome, apelido, datanascimento);
                controle.addContato(contato);
                this.atualizaTabelaContatos();

                this.textNome.setText("");
                this.textApelido.setText("");
                this.textDataNasc.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        this.textNome.setEnabled(true);
        this.textApelido.setEnabled(true);
        this.textDataNasc.setEnabled(true);

        this.textNome.setText("");
        this.textApelido.setText("");
        this.textDataNasc.setText("");

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);

        this.botaoExcluir.setEnabled(false);
        this.botaoNovo.setEnabled(false);

    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed

        int index = tabelaContatos.getSelectedRow();

        if (index >= 0 && tabelaContatos.getSelectedRow() < listaDeFaculdades.size()) {
            ContatosBEAN contatoSelecionado = listaDeFaculdades.get(tabelaContatos.getSelectedRow());
            try {
                controle.deleteContato(contatoSelecionado);
                this.atualizaTabelaContatos();
            } catch (SQLException ex) {
                Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um contato para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaContatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaContatosMouseClicked
        int index = tabelaContatos.getSelectedRow();
        if (index >= 0 && tabelaContatos.getSelectedRow() < listaDeFaculdades.size()) {

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tabelaContatos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
            tabelaContatos.getColumnModel().getColumn(3).setCellRenderer(centralizado);

            ContatosBEAN contato = listaDeFaculdades.get(index);
            textNome.setText(contato.getNome());
            textApelido.setText(contato.getApelido());
            textDataNasc.setText(String.valueOf(contato.getData_nascimento()));

        }
    }//GEN-LAST:event_tabelaContatosMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipal().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaContatos;
    private javax.swing.JTextField textApelido;
    private javax.swing.JTextField textDataNasc;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables

}
