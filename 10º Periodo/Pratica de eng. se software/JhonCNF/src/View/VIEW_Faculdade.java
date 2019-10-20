package View;

import Controller.Control_Faculdade;
import Model.BEANS.BEAN_Faculdade;
import java.sql.SQLException;
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
public class VIEW_Faculdade extends javax.swing.JFrame {

    List<BEAN_Faculdade> listaDeFaculdades;
    Control_Faculdade controleFaculdade = new Control_Faculdade();
    private boolean boolClikedTabela = true;

    public VIEW_Faculdade() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tela faculdade");

        this.textNome.requestFocus();
        this.textDescricao.setEnabled(false);
        this.comboBoxUF.setEnabled(false);
        this.textCidade.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);

        this.checkAtivos.setSelected(true);

        if (checkAtivos.isSelected()) {
            listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
        } else {
            listaDeFaculdades = controleFaculdade.listaFaculdadesInativas();
        }

        this.atualizaTabelaFaculdades(listaDeFaculdades);
    }

    public void atualizaTabelaFaculdades(List<BEAN_Faculdade> listFaculdades) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "UF", "Cidade", "Descrição", "Status"}, 0);

        for (int i = 0; i < listFaculdades.size(); i++) {
            modelo.addRow(new Object[]{listFaculdades.get(i).getNomeFaculdade(), listFaculdades.get(i).getUFfaculdade(), listFaculdades.get(i).getCidadeFaculdade(), listFaculdades.get(i).getDescricaoFaculdade(), listFaculdades.get(i).getStatusFaculdade().equals("1") ? "Ativo" : "Inativo"});
        }

        tabelaFaculdades.setModel(modelo);
        tabelaFaculdades.getColumnModel().getColumn(0).setWidth(100);
        tabelaFaculdades.getColumnModel().getColumn(1).setWidth(5);
        tabelaFaculdades.getColumnModel().getColumn(2).setWidth(15);
        tabelaFaculdades.getColumnModel().getColumn(3).setWidth(25);
        tabelaFaculdades.getColumnModel().getColumn(4).setWidth(5);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaFaculdades.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabelaFaculdades.getColumnModel().getColumn(4).setCellRenderer(centralizado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textDescricao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textCidade = new javax.swing.JTextField();
        checkAtivos = new javax.swing.JCheckBox();
        botaoPesquisa = new javax.swing.JLabel();
        comboBoxUF = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFaculdades = new javax.swing.JTable();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Faculdade"));

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        jLabel3.setText("UF");

        jLabel4.setText("Cidade");

        checkAtivos.setText("Ativos");
        checkAtivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAtivosMouseClicked(evt);
            }
        });

        botaoPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search.png"))); // NOI18N
        botaoPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPesquisaMouseClicked(evt);
            }
        });

        comboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(270, 270, 270)
                                .addComponent(checkAtivos))
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addContainerGap())
                            .addComponent(textDescricao)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(checkAtivos))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescricao)
                    .addComponent(textCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabelaFaculdades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "UF", "Cidade", "Descrição", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFaculdades.getTableHeader().setReorderingAllowed(false);
        tabelaFaculdades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFaculdadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFaculdades);
        if (tabelaFaculdades.getColumnModel().getColumnCount() > 0) {
            tabelaFaculdades.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabelaFaculdades.getColumnModel().getColumn(1).setPreferredWidth(3);
            tabelaFaculdades.getColumnModel().getColumn(2).setPreferredWidth(15);
            tabelaFaculdades.getColumnModel().getColumn(3).setPreferredWidth(25);
            tabelaFaculdades.getColumnModel().getColumn(4).setPreferredWidth(3);
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

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
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
                        .addComponent(botaoVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(botaoNovo)
                        .addGap(35, 35, 35)
                        .addComponent(botaoSalvar)
                        .addGap(27, 27, 27)
                        .addComponent(botaoExcluir)
                        .addGap(26, 26, 26)
                        .addComponent(botaoCancelar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoNovo)
                    .addComponent(botaoVoltar))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.textNome.setText("");
        this.textDescricao.setText("");
        this.comboBoxUF.setSelectedIndex(0);
        this.textCidade.setText("");

        this.textDescricao.setEnabled(false);
        this.comboBoxUF.setEnabled(false);
        this.textCidade.setEnabled(false);

        this.botaoNovo.setEnabled(true);
        this.botaoExcluir.setEnabled(true);

        this.botaoSalvar.setEnabled(false);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        if (textNome.getText().isEmpty() || textDescricao.getText().isEmpty() || textCidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ficar vazios!", "Erro, verifique a mensagem abaixo", 0);
        } else if (comboBoxUF.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um estado!", "Erro, verifique a mensagem abaixo", 0);
        } else {
            try {
                if (!boolClikedTabela) {
                    BEAN_Faculdade faculdade = new BEAN_Faculdade(0, textNome.getText(), textDescricao.getText(), comboBoxUF.getSelectedItem().toString(), textCidade.getText(), "1");
                    controleFaculdade.addFaculdade(faculdade);

                    JOptionPane.showMessageDialog(null, "Faculdade >  " + textNome.getText() + "  < inserida com sucesso! ");

                    listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
                    this.atualizaTabelaFaculdades(listaDeFaculdades);
                    this.textNome.setText("");
                    this.textDescricao.setText("");
                    this.comboBoxUF.setSelectedIndex(0);
                    this.textCidade.setText("");
                    this.botaoCancelarActionPerformed(evt);
                } else {
                    if (tabelaFaculdades.getSelectedRow() != -1) {
                        int index = tabelaFaculdades.getSelectedRow();
                        this.listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
                        BEAN_Faculdade faculdadeSelected = listaDeFaculdades.get(index);

                        for (BEAN_Faculdade faculdades : listaDeFaculdades) {
                            if (faculdades.getIdFaculdade() == faculdadeSelected.getIdFaculdade()) {
                                faculdadeSelected.setIdFaculdade(faculdadeSelected.getIdFaculdade());
                                faculdadeSelected.setNomeFaculdade(textNome.getText());
                                faculdadeSelected.setDescricaoFaculdade(textDescricao.getText());
                                faculdadeSelected.setUFfaculdade(comboBoxUF.getSelectedItem().toString());
                                faculdadeSelected.setCidadeFaculdade(textCidade.getText());
                                faculdadeSelected.setStatusFaculdade("1");

                                controleFaculdade.updateFaculdade(faculdadeSelected);
                                JOptionPane.showMessageDialog(null, "Faculdade >  " + textNome.getText() + "  < alterada com sucesso! ");
                            }
                            listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
                            this.atualizaTabelaFaculdades(listaDeFaculdades);
                            this.textNome.setText("");
                            this.textDescricao.setText("");
                            this.comboBoxUF.setSelectedIndex(0);
                            this.textCidade.setText("");
                            this.botaoCancelarActionPerformed(evt);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed

        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxUF.setEnabled(true);
        this.textCidade.setEnabled(true);

        this.textNome.setText("");
        this.textDescricao.setText("");
        this.comboBoxUF.setSelectedIndex(0);
        this.textCidade.setText("");

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);

        this.botaoExcluir.setEnabled(false);
        this.botaoNovo.setEnabled(false);

        this.textNome.requestFocus();

        boolClikedTabela = false;
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int index = tabelaFaculdades.getSelectedRow();

        if (index >= 0 && index < listaDeFaculdades.size()) {
            BEAN_Faculdade faculdadeSelecionada = listaDeFaculdades.get(index);
            try {
                controleFaculdade.deleteFaculdade(faculdadeSelecionada);
                JOptionPane.showMessageDialog(null, "Faculdade >  " + textNome.getText() + "  < excluída com sucesso! ");

                listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
                this.atualizaTabelaFaculdades(listaDeFaculdades);
                this.botaoCancelarActionPerformed(evt);
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaFaculdadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFaculdadesMouseClicked

        this.textCidade.setEnabled(true);
        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxUF.setEnabled(true);

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoNovo.setEnabled(false);

        boolClikedTabela = true;

        if (checkAtivos.isSelected()) {
            listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
        } else {
            listaDeFaculdades = controleFaculdade.listaFaculdadesInativas();
        }

        int index = tabelaFaculdades.getSelectedRow();

        if (index >= 0 && tabelaFaculdades.getSelectedRow() < listaDeFaculdades.size()) {
            BEAN_Faculdade faculdade = listaDeFaculdades.get(index);

            textNome.setText(faculdade.getNomeFaculdade());
            textDescricao.setText(faculdade.getDescricaoFaculdade());
            comboBoxUF.setName(faculdade.getUFfaculdade());
            textCidade.setText(faculdade.getCidadeFaculdade());

            for (int i = 0; i < comboBoxUF.getItemCount(); i++) {
                if (faculdade.getUFfaculdade().equals(comboBoxUF.getItemAt(i))) {
                    comboBoxUF.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tabelaFaculdadesMouseClicked

    private void checkAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAtivosMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                this.botaoExcluir.setEnabled(true);
                listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();
            } else {
                this.botaoExcluir.setEnabled(false);
                listaDeFaculdades = controleFaculdade.listaFaculdadesInativas();
            }
            this.atualizaTabelaFaculdades(listaDeFaculdades);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkAtivosMouseClicked

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                listaDeFaculdades = controleFaculdade.listaFaculdadesAtivasByNome(textNome.getText());
            } else {
                listaDeFaculdades = controleFaculdade.listaFaculdadesInativasByNome(textNome.getText());
            }
            this.atualizaTabelaFaculdades(listaDeFaculdades);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new VIEW_Menu_principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JComboBox<String> comboBoxUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaFaculdades;
    private javax.swing.JTextField textCidade;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables

}
