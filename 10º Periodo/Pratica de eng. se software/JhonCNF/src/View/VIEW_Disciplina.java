package View;

import Controller.Control_Disciplina;
import Controller.Control_Faculdade;
import Model.BEANS.BEAN_Disciplina;
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
public class VIEW_Disciplina extends javax.swing.JFrame {

    List<BEAN_Faculdade> listaDeFaculdades;
    Control_Faculdade controleFaculdade = new Control_Faculdade();

    List<BEAN_Disciplina> listaDeDisciplinas;
    Control_Disciplina controleDisciplina = new Control_Disciplina();
    private boolean boolClikedTabela = true;

    public VIEW_Disciplina() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tela disciplina");

        this.textNome.requestFocus();

        this.textDescricao.setEnabled(false);
        this.comboBoxFaculdade.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);

        this.checkAtivos.setSelected(true);

        if (checkAtivos.isSelected()) {
            listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
        } else {
            listaDeDisciplinas = controleDisciplina.listaDisciplinasInativas();
        }

        listaDeFaculdades = controleFaculdade.listaFaculdadesAtivas();

        this.atualizaTabelaDisciplinas(listaDeDisciplinas);
        this.atualizaComboBoxfaculdades(listaDeFaculdades);
    }

    public void atualizaComboBoxfaculdades(List<BEAN_Faculdade> listFaculdades) {

        int cont = 0;
        while (cont < listaDeFaculdades.size()) {
            comboBoxFaculdade.addItem(listaDeFaculdades.get(cont).getNomeFaculdade());
            cont++;
        }
    }

    public void atualizaTabelaDisciplinas(List<BEAN_Disciplina> listDisciplinas) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "Descrição", "Faculdade", "Status"}, 0);

        for (int i = 0; i < listDisciplinas.size(); i++) {
            String nomefaculdade = null;
            for (BEAN_Faculdade faculdade : listaDeFaculdades) {
                if (faculdade.getIdFaculdade() == listDisciplinas.get(i).getIdFaculdade()) {
                    nomefaculdade = faculdade.getNomeFaculdade();
                }
            }
            modelo.addRow(new Object[]{
                listDisciplinas.get(i).getNomeDisciplina(),
                listDisciplinas.get(i).getDescricaoDisciplina(),
                (nomefaculdade != null ? nomefaculdade : "Inativo"),
                listDisciplinas.get(i).getStatusDisciplina().equals("1") ? "Ativo" : "Inativa"});
        }

        tabelaDisciplinas.setModel(modelo);
        tabelaDisciplinas.getColumnModel().getColumn(0).setWidth(100);
        tabelaDisciplinas.getColumnModel().getColumn(1).setWidth(20);
        tabelaDisciplinas.getColumnModel().getColumn(2).setWidth(10);
        tabelaDisciplinas.getColumnModel().getColumn(3).setWidth(10);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaDisciplinas.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabelaDisciplinas.getColumnModel().getColumn(3).setCellRenderer(centralizado);
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
        checkAtivos = new javax.swing.JCheckBox();
        botaoPesquisa = new javax.swing.JLabel();
        comboBoxFaculdade = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplinas = new javax.swing.JTable();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Disciplinas"));

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        jLabel3.setText("Faculdade");

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
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxFaculdade, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDescricao)
                    .addComponent(comboBoxFaculdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tabelaDisciplinas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Faculdade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        tabelaDisciplinas.getTableHeader().setReorderingAllowed(false);
        tabelaDisciplinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDisciplinasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDisciplinas);
        if (tabelaDisciplinas.getColumnModel().getColumnCount() > 0) {
            tabelaDisciplinas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabelaDisciplinas.getColumnModel().getColumn(1).setPreferredWidth(25);
            tabelaDisciplinas.getColumnModel().getColumn(2).setPreferredWidth(3);
            tabelaDisciplinas.getColumnModel().getColumn(3).setPreferredWidth(3);
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
        this.comboBoxFaculdade.setSelectedIndex(0);

        this.textDescricao.setEnabled(false);
        this.comboBoxFaculdade.setEnabled(false);

        this.botaoNovo.setEnabled(true);
        this.botaoExcluir.setEnabled(true);

        this.botaoSalvar.setEnabled(false);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        if (textNome.getText().isEmpty() || textDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ficar vazios!", "Erro, verifique a mensagem abaixo", 0);
        } else if (comboBoxFaculdade.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma faculdade!", "Erro, verifique a mensagem abaixo", 0);
        } else {
            try {
                if (!boolClikedTabela) {
                    int idFaculdade = 0;

                    for (BEAN_Faculdade faculdades : listaDeFaculdades) {
                        if (faculdades.getNomeFaculdade().equals(comboBoxFaculdade.getSelectedItem().toString())) {
                            idFaculdade = faculdades.getIdFaculdade();
                        }
                    }

                    BEAN_Disciplina disciplina = new BEAN_Disciplina(0, textNome.getText(), textDescricao.getText(), idFaculdade, "1");
                    controleDisciplina.addDisciplina(disciplina);

                    JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < inserida com sucesso! ");

                    listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
                    this.atualizaTabelaDisciplinas(listaDeDisciplinas);
                    this.textNome.setText("");
                    this.textDescricao.setText("");
                    this.comboBoxFaculdade.setSelectedIndex(0);
                    this.botaoCancelarActionPerformed(evt);
                } else {
                    if (tabelaDisciplinas.getSelectedRow() != -1) {
                        int index = tabelaDisciplinas.getSelectedRow();
                        this.listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
                        BEAN_Disciplina disciplinaSelected = listaDeDisciplinas.get(index);

                        for (BEAN_Disciplina disciplinas : listaDeDisciplinas) {
                            if (disciplinas.getIdDisciplina() == disciplinaSelected.getIdDisciplina()) {
                                int idFaculdade = 0;

                                for (BEAN_Faculdade faculdades : listaDeFaculdades) {
                                    if (faculdades.getNomeFaculdade().equals(comboBoxFaculdade.getSelectedItem().toString())) {
                                        idFaculdade = faculdades.getIdFaculdade();
                                    }
                                }
                                disciplinaSelected.setIdDisciplina(disciplinas.getIdDisciplina());
                                disciplinaSelected.setNomeDisciplina(textNome.getText());
                                disciplinaSelected.setDescricaoDisciplina(textDescricao.getText());
                                disciplinaSelected.setIdFaculdade(idFaculdade);
                                disciplinaSelected.setStatusDisciplina("1");

                                controleDisciplina.updateDisciplina(disciplinaSelected);
                                JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < alterada com sucesso! ");
                            }
                            listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
                            this.atualizaTabelaDisciplinas(listaDeDisciplinas);
                            this.textNome.setText("");
                            this.textDescricao.setText("");
                            this.comboBoxFaculdade.setSelectedIndex(0);
                            this.botaoCancelarActionPerformed(evt);
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed

        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxFaculdade.setEnabled(true);

        this.textNome.setText("");
        this.textDescricao.setText("");

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);

        this.botaoExcluir.setEnabled(false);
        this.botaoNovo.setEnabled(false);

        this.textNome.requestFocus();

        boolClikedTabela = false;
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int index = tabelaDisciplinas.getSelectedRow();

        if (index >= 0 && index < listaDeDisciplinas.size()) {
            BEAN_Disciplina disciplinaSelecionada = listaDeDisciplinas.get(tabelaDisciplinas.getSelectedRow());
            try {
                controleDisciplina.deleteDisciplina(disciplinaSelecionada);
                JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < excluída com sucesso! ");

                this.listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
                this.atualizaTabelaDisciplinas(listaDeDisciplinas);
                this.botaoCancelarActionPerformed(evt);
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaDisciplinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinasMouseClicked

        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxFaculdade.setEnabled(true);

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoNovo.setEnabled(false);

        this.boolClikedTabela = true;

        if (checkAtivos.isSelected()) {
            listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
        } else {
            listaDeDisciplinas = controleDisciplina.listaDisciplinasInativas();
        }

        int index = tabelaDisciplinas.getSelectedRow();

        if (index >= 0 && tabelaDisciplinas.getSelectedRow() < listaDeDisciplinas.size()) {
            BEAN_Disciplina disciplina = listaDeDisciplinas.get(index);

            this.textNome.setText(disciplina.getNomeDisciplina());
            this.textDescricao.setText(disciplina.getDescricaoDisciplina());
            this.comboBoxFaculdade.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tabelaDisciplinasMouseClicked

    private void checkAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAtivosMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                this.botaoExcluir.setEnabled(true);
                this.listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
            } else {
                this.botaoExcluir.setEnabled(false);
                this.listaDeDisciplinas = controleDisciplina.listaDisciplinasInativas();
            }
            this.atualizaTabelaDisciplinas(listaDeDisciplinas);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkAtivosMouseClicked

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivasByNome(textNome.getText());
            } else {
                listaDeDisciplinas = controleDisciplina.listaDisciplinasInativasByNome(textNome.getText());
            }
            this.atualizaTabelaDisciplinas(listaDeDisciplinas);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Disciplina.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> comboBoxFaculdade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaDisciplinas;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables

}
