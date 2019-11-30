package View;

import Controller.Control_Aluno;
import Model.BEANS.BEAN_Aluno;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.sql.Date;
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
public class VIEW_Aluno extends javax.swing.JFrame {

    List<BEAN_Aluno> listaDeAlunos;
    Control_Aluno controleAluno = new Control_Aluno();
    private boolean boolClikedTabela = true;

    public VIEW_Aluno() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tela aluno");

        this.textNome.requestFocus();

        this.textCPF.setEnabled(false);
        this.textDataNasc.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);

        this.checkAtivos.setSelected(true);

        if (checkAtivos.isSelected()) {
            listaDeAlunos = controleAluno.listaAlunoesAtivos();
        } else {
            listaDeAlunos = controleAluno.listaAlunoesInativos();
        }

        this.atualizaTabelaAlunoes(listaDeAlunos);
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

    public boolean ValidarData(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void atualizaTabelaAlunoes(List<BEAN_Aluno> listAlunoes) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "CPF", "Data Nasc.", "Status"}, 0);

        for (int i = 0; i < listAlunoes.size(); i++) {
            modelo.addRow(new Object[]{listAlunoes.get(i).getNomeAluno(), listAlunoes.get(i).getCPFAluno(), new SimpleDateFormat("dd/MM/yyyy").format(listAlunoes.get(i).getDataNascimentoAluno()), listAlunoes.get(i).getStatusAluno().equals("1") ? "Ativo" : "Inativo", listAlunoes.get(i).getIdAluno()});
        }

        tabelaAlunos.setModel(modelo);
        tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(20);
        tabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelaAlunos.getColumnModel().getColumn(3).setPreferredWidth(10);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaAlunos.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabelaAlunos.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        tabelaAlunos.getColumnModel().getColumn(3).setCellRenderer(centralizado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textCPF = new javax.swing.JTextField();
        textDataNasc = new javax.swing.JTextField();
        checkAtivos = new javax.swing.JCheckBox();
        botaoPesquisa = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de aluno");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo aluno"));

        jLabel3.setText("Nome");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("CPF");

        textDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataNascActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(298, 298, 298)
                            .addComponent(checkAtivos))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(372, 372, 372)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(checkAtivos)
                                .addGap(4, 4, 4)))
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoPesquisa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "CPF", "Data Nasc.", "Status", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        tabelaAlunos.getTableHeader().setReorderingAllowed(false);
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlunos);
        if (tabelaAlunos.getColumnModel().getColumnCount() > 0) {
            tabelaAlunos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaAlunos.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelaAlunos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaAlunos.getColumnModel().getColumn(3).setPreferredWidth(15);
            tabelaAlunos.getColumnModel().getColumn(4).setMinWidth(0);
            tabelaAlunos.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabelaAlunos.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoVoltar)
                                .addGap(27, 27, 27)
                                .addComponent(botaoNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoSalvar)
                                .addGap(33, 33, 33)
                                .addComponent(botaoExcluir)
                                .addGap(29, 29, 29)
                                .addComponent(botaoCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoNovo)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.textNome.setText("");
        this.textCPF.setText("");
        this.textDataNasc.setText("");

        this.textDataNasc.setEnabled(false);
        this.textCPF.setEnabled(false);

        this.botaoNovo.setEnabled(true);
        this.botaoExcluir.setEnabled(true);

        this.botaoSalvar.setEnabled(false);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new VIEW_Menu_principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed

        this.textNome.setEnabled(true);
        this.textDataNasc.setEnabled(true);
        this.textCPF.setEnabled(true);

        this.textNome.setText("");
        this.textDataNasc.setText("");
        this.textCPF.setText("");

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);

        this.botaoExcluir.setEnabled(false);
        this.botaoNovo.setEnabled(false);

        this.textNome.requestFocus();

        boolClikedTabela = false;
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void textDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDataNascActionPerformed
    }//GEN-LAST:event_textDataNascActionPerformed

    private void checkAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAtivosMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                this.textNome.setText("");
                this.textCPF.setText("");
                this.textDataNasc.setText("");
                this.botaoExcluir.setEnabled(true);
                listaDeAlunos = controleAluno.listaAlunoesAtivos();
            } else {
                this.textNome.setText("");
                this.textCPF.setText("");
                this.textDataNasc.setText("");
                this.botaoExcluir.setEnabled(false);
                listaDeAlunos = controleAluno.listaAlunoesInativos();
            }
            this.atualizaTabelaAlunoes(listaDeAlunos);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkAtivosMouseClicked

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                listaDeAlunos = controleAluno.listaAlunoesAtivosByNome(textNome.getText());
            } else {
                listaDeAlunos = controleAluno.listaAlunoesInativosByNome(textNome.getText());
            }
            this.atualizaTabelaAlunoes(listaDeAlunos);
            this.textNome.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // fazendo a validação dos dados
        if ((textNome.getText().isEmpty()) || (textDataNasc.getText().isEmpty()) || (textCPF.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vázios");
        } else {
            if (ValidarData(textDataNasc.getText())) {
                try {
                    Date dataNascimento = null;
                    dataNascimento = convert_StringToDate(textDataNasc.getText());
                    if (!boolClikedTabela) {
                        BEAN_Aluno aluno = new BEAN_Aluno(0, textNome.getText(), textCPF.getText(), dataNascimento, "1");
                        controleAluno.addAluno(aluno);

                        JOptionPane.showMessageDialog(null, "Aluno >  " + textNome.getText() + "  < inserido com sucesso! ");

                        listaDeAlunos = controleAluno.listaAlunoesAtivos();
                        this.atualizaTabelaAlunoes(listaDeAlunos);
                        this.textNome.setText("");
                        this.textDataNasc.setText("");
                        this.textCPF.setText("");
                        this.botaoCancelarActionPerformed(evt);
                    } else {
                        if (tabelaAlunos.getSelectedRow() != -1) {
                            int index = tabelaAlunos.getSelectedRow();
                            listaDeAlunos = controleAluno.listaAlunoesAtivos();
                            BEAN_Aluno alunoSelected = listaDeAlunos.get(index);

                            for (BEAN_Aluno alunos : listaDeAlunos) {
                                if (alunos.getIdAluno() == alunoSelected.getIdAluno()) {
                                    alunoSelected.setIdAluno(alunoSelected.getIdAluno());
                                    alunoSelected.setNomeAluno(textNome.getText());
                                    alunoSelected.setCPFAluno(textCPF.getText());
                                    alunoSelected.setDataNascimentoAluno(dataNascimento);
                                    alunoSelected.setStatusAluno("1");

                                    controleAluno.updateAluno(alunoSelected);
                                    JOptionPane.showMessageDialog(null, "Aluno (a) >  " + textNome.getText() + "  < alterado com sucesso! ");
                                    listaDeAlunos = controleAluno.listaAlunoesAtivos();
                                    this.atualizaTabelaAlunoes(listaDeAlunos);
                                    this.textNome.setText("");
                                    this.textDataNasc.setText("");
                                    this.textCPF.setText("");
                                    this.botaoCancelarActionPerformed(evt);
                                }
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VIEW_Aluno.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data de nascimento inválida!");
                textDataNasc.setText("");
                textDataNasc.requestFocus();
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int index = tabelaAlunos.getSelectedRow();

        if (index >= 0 && index < listaDeAlunos.size()) {
            try {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir: " + textNome.getText() + "?", "Excluir", JOptionPane.YES_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    BEAN_Aluno alunoSelecionado = listaDeAlunos.get(tabelaAlunos.getSelectedRow());
                    controleAluno.deleteAluno(alunoSelecionado);
                    JOptionPane.showMessageDialog(null, "Aluno >  " + textNome.getText() + "  < excluído com sucesso! ");

                    this.listaDeAlunos = controleAluno.listaAlunoesAtivos();
                    this.atualizaTabelaAlunoes(listaDeAlunos);
                    this.botaoCancelarActionPerformed(evt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked

        this.textDataNasc.setEnabled(true);
        this.textNome.setEnabled(true);
        this.textCPF.setEnabled(true);

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoNovo.setEnabled(false);

        boolClikedTabela = true;

        if (checkAtivos.isSelected()) {
            this.botaoExcluir.setEnabled(true);
            this.listaDeAlunos = controleAluno.listaAlunoesAtivos();
        } else {
            this.botaoExcluir.setEnabled(false);
            this.listaDeAlunos = controleAluno.listaAlunoesInativos();
        }

        int index = tabelaAlunos.getSelectedRow();

        if (index >= 0 && tabelaAlunos.getSelectedRow() < listaDeAlunos.size()) {
            BEAN_Aluno aluno = listaDeAlunos.get(index);

            this.textNome.setText(aluno.getNomeAluno());
            this.textCPF.setText(aluno.getCPFAluno());
            this.textDataNasc.setText(new SimpleDateFormat("dd/MM/yyyy").format(aluno.getDataNascimentoAluno()));
        }
    }//GEN-LAST:event_tabelaAlunosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textDataNasc;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
