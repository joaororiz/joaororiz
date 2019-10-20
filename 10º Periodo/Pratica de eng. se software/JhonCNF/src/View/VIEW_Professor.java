package View;

import Controller.Control_Professor;
import Model.BEANS.BEAN_Professor;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class VIEW_Professor extends javax.swing.JFrame {

    List<BEAN_Professor> listaDeProfessores;
    Control_Professor controleProfessor = new Control_Professor();
    private boolean boolClikedTabela = true;

    public VIEW_Professor() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tela professor");

        this.textNome.requestFocus();

        this.textEmail.setEnabled(false);
        this.textDataNasc.setEnabled(false);
        this.textSenha.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);

        this.checkAtivos.setSelected(true);

        if (checkAtivos.isSelected()) {
            listaDeProfessores = controleProfessor.listaProfessoresAtivos();
        } else {
            listaDeProfessores = controleProfessor.listaProfessoresInativos();
        }

        this.atualizaTabelaProfessores(listaDeProfessores);
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

    public static boolean validarEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public static boolean ValidarSenhaForte(String senha) {
        if (senha.length() < 4) {
            return false;
        }

        boolean achouNumero = false;
        boolean achouMaiuscula = false;
        for (char caracter : senha.toCharArray()) {
            if (caracter >= '0' && caracter <= '9') {
                achouNumero = true;
            } else if (caracter >= 'A' && caracter <= 'Z') {
                achouMaiuscula = true;
            }
        }
        return achouNumero && achouMaiuscula;
    }

    public void atualizaTabelaProfessores(List<BEAN_Professor> listProfessores) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "Data Nasc.", "E-mail", "Status"}, 0);

        for (int i = 0; i < listProfessores.size(); i++) {
            modelo.addRow(new Object[]{listProfessores.get(i).getNomeProfessor(), new SimpleDateFormat("dd/MM/yyyy").format(listProfessores.get(i).getDataNascimentoProfessor()), listProfessores.get(i).getUsuarioProfessor(), listProfessores.get(i).getStatusProfessor().equals("1") ? "Ativo" : "Inativo", listProfessores.get(i).getIdProfessor()});
        }

        tabelaProfessores.setModel(modelo);
        tabelaProfessores.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaProfessores.getColumnModel().getColumn(1).setPreferredWidth(20);
        tabelaProfessores.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelaProfessores.getColumnModel().getColumn(3).setPreferredWidth(10);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaProfessores.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        tabelaProfessores.getColumnModel().getColumn(3).setCellRenderer(centralizado);
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
        textEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textDataNasc = new javax.swing.JTextField();
        textSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        checkAtivos = new javax.swing.JCheckBox();
        botaoPesquisa = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de professor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Novo professor"));

        jLabel3.setText("Nome");

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("E-mail");

        jLabel6.setText("Senha");

        textDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDataNascActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 8)); // NOI18N
        jLabel2.setText("Senha: 4 caracteres, números e maiúcula");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkAtivos))
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDataNasc)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textSenha)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(checkAtivos)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(textDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(botaoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(3, 3, 3))
        );

        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data Nasc.", "E-mail", "Status", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        tabelaProfessores.getTableHeader().setReorderingAllowed(false);
        tabelaProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProfessoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProfessores);
        if (tabelaProfessores.getColumnModel().getColumnCount() > 0) {
            tabelaProfessores.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaProfessores.getColumnModel().getColumn(1).setPreferredWidth(20);
            tabelaProfessores.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaProfessores.getColumnModel().getColumn(3).setPreferredWidth(10);
            tabelaProfessores.getColumnModel().getColumn(4).setMinWidth(0);
            tabelaProfessores.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabelaProfessores.getColumnModel().getColumn(4).setMaxWidth(0);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoVoltar)
                                .addGap(50, 50, 50)
                                .addComponent(botaoNovo)
                                .addGap(53, 53, 53)
                                .addComponent(botaoSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoExcluir)
                                .addGap(29, 29, 29)
                                .addComponent(botaoCancelar)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
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
        this.textEmail.setText("");
        this.textDataNasc.setText("");
        this.textSenha.setText("");

        this.textDataNasc.setEnabled(false);
        this.textEmail.setEnabled(false);
        this.textSenha.setEnabled(false);

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
        this.textEmail.setEnabled(true);
        this.textSenha.setEnabled(true);

        this.textNome.setText("");
        this.textDataNasc.setText("");
        this.textEmail.setText("");
        this.textSenha.setText("");

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
                this.botaoExcluir.setEnabled(true);
                listaDeProfessores = controleProfessor.listaProfessoresAtivos();
            } else {
                this.botaoExcluir.setEnabled(false);
                listaDeProfessores = controleProfessor.listaProfessoresInativos();
            }
            this.atualizaTabelaProfessores(listaDeProfessores);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkAtivosMouseClicked

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                listaDeProfessores = controleProfessor.listaProfessoresAtivosByNome(textNome.getText());
            } else {
                listaDeProfessores = controleProfessor.listaProfessoresInativosByNome(textNome.getText());
            }
            this.atualizaTabelaProfessores(listaDeProfessores);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        // fazendo a validação dos dados
        if ((textNome.getText().isEmpty()) || (textDataNasc.getText().isEmpty()) || (textEmail.getText().isEmpty()) || (textSenha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Os campos não podem estar vázios");
        } else if (validarEmail(textEmail.getText().toString())) {
            if (ValidarSenhaForte(textSenha.getText())) {
                try {
                    Date dataNascimento = null;
                    dataNascimento = convert_StringToDate(textDataNasc.getText());
                    if (!boolClikedTabela) {
                        BEAN_Professor professor = new BEAN_Professor(0, textNome.getText(), dataNascimento, textEmail.getText(), textSenha.getText(), "1");
                        controleProfessor.addProfessor(professor);

                        JOptionPane.showMessageDialog(null, "Professor >  " + textNome.getText() + "  < inserido com sucesso! ");

                        listaDeProfessores = controleProfessor.listaProfessoresAtivos();
                        this.atualizaTabelaProfessores(listaDeProfessores);
                        this.textNome.setText("");
                        this.textDataNasc.setText("");
                        this.textEmail.setText("");
                        this.textSenha.setText("");
                        this.botaoCancelarActionPerformed(evt);
                    } else {
                        if (tabelaProfessores.getSelectedRow() != -1) {
                            int index = tabelaProfessores.getSelectedRow();
                            listaDeProfessores = controleProfessor.listaProfessoresAtivos();
                            BEAN_Professor professorSelected = listaDeProfessores.get(index);

                            for (BEAN_Professor professores : listaDeProfessores) {
                                if (professores.getIdProfessor() == professorSelected.getIdProfessor()) {
                                    professorSelected.setIdProfessor(professorSelected.getIdProfessor());
                                    professorSelected.setNomeProfessor(textNome.getText());
                                    professorSelected.setDataNascimentoProfessor(dataNascimento);
                                    professorSelected.setUsuarioProfessor(textEmail.getText());
                                    professorSelected.setSenhaProfessor(textSenha.getText());
                                    professorSelected.setStatusProfessor("1");

                                    controleProfessor.updateProfessor(professorSelected);
                                    JOptionPane.showMessageDialog(null, "Professor (a) >  " + textNome.getText() + "  < alterado com sucesso! ");
                                }
                                listaDeProfessores = controleProfessor.listaProfessoresAtivos();
                                this.atualizaTabelaProfessores(listaDeProfessores);
                                this.textNome.setText("");
                                this.textDataNasc.setText("");
                                this.textEmail.setText("");
                                this.textSenha.setText("");
                                this.botaoCancelarActionPerformed(evt);
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VIEW_Professor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senha deve conter letras maiúsculas, minúscula e número!");
                textSenha.setText("");
                textNome.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe um endereço de E-mail válido!");
            textEmail.setText("");
            textEmail.requestFocus();
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        int index = tabelaProfessores.getSelectedRow();

        if (index >= 0 && index < listaDeProfessores.size()) {
            BEAN_Professor professorSelecionado = listaDeProfessores.get(tabelaProfessores.getSelectedRow());
            try {
                controleProfessor.deleteProfessor(professorSelecionado);
                JOptionPane.showMessageDialog(null, "Professor >  " + textNome.getText() + "  < excluído com sucesso! ");

                this.listaDeProfessores = controleProfessor.listaProfessoresAtivos();
                this.atualizaTabelaProfessores(listaDeProfessores);
                this.botaoCancelarActionPerformed(evt);
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Faculdade.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProfessoresMouseClicked

        this.textDataNasc.setEnabled(true);
        this.textNome.setEnabled(true);
        this.textEmail.setEnabled(true);
        this.textSenha.setEnabled(true);

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoNovo.setEnabled(false);

        boolClikedTabela = true;

        if (checkAtivos.isSelected()) {
            this.botaoExcluir.setEnabled(true);
            this.listaDeProfessores = controleProfessor.listaProfessoresAtivos();
        } else {
            this.botaoExcluir.setEnabled(false);
            this.listaDeProfessores = controleProfessor.listaProfessoresInativos();
        }

        int index = tabelaProfessores.getSelectedRow();

        if (index >= 0 && tabelaProfessores.getSelectedRow() < listaDeProfessores.size()) {
            BEAN_Professor professor = listaDeProfessores.get(index);

            this.textNome.setText(professor.getNomeProfessor());
            this.textEmail.setText(professor.getUsuarioProfessor());
            this.textSenha.setName(professor.getSenhaProfessor());
            this.textDataNasc.setText(new SimpleDateFormat("dd/MM/yyyy").format(professor.getDataNascimentoProfessor()));
        }
    }//GEN-LAST:event_tabelaProfessoresMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTextField textDataNasc;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    private javax.swing.JPasswordField textSenha;
    // End of variables declaration//GEN-END:variables
}
