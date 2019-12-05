package View;

import Controller.Control_Aluno;
import Controller.Control_Disciplina;
import Controller.Control_Faculdade;
import Controller.Control_Professor;
import Controller.Control_Turma;
import Model.BEANS.BEAN_Aluno;
import Model.BEANS.BEAN_Disciplina;
import Model.BEANS.BEAN_Faculdade;
import Model.BEANS.BEAN_Professor;
import Model.BEANS.BEAN_Turma;
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
public class VIEW_Turma extends javax.swing.JFrame {

    List<BEAN_Turma> listaDeTurmas;
    Control_Turma controleTurma = new Control_Turma();

    List<BEAN_Professor> listaDeProfessores;
    Control_Professor controleProfessor = new Control_Professor();

    List<BEAN_Aluno> listaDeAlunos;
    Control_Aluno controleAluno = new Control_Aluno();

    List<BEAN_Disciplina> listaDeDisciplinas;
    Control_Disciplina controleDisciplina = new Control_Disciplina();

    private boolean boolClikedTabela = true;

    public VIEW_Turma() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Tela turma");

        this.textNome.requestFocus();

        this.textDescricao.setEnabled(false);
        this.comboBoxDisciplinas.setEnabled(false);
        this.comboBoxProfessores.setEnabled(false);

        this.botaoSalvar.setEnabled(false);
        this.botaoCancelar.setEnabled(false);

        this.checkAtivos.setSelected(true);

        if (checkAtivos.isSelected()) {
            listaDeTurmas = controleTurma.listaTurmasAtivas();
        } else {
            listaDeTurmas = controleTurma.listaTurmasInativas();
        }

        this.atualizaTabelaTurmas(listaDeTurmas);
        this.atualizaComboBoxDisciplinas(controleDisciplina.listaDisciplinasAtivas());
        this.atualizaComboBoxProfesores(controleProfessor.listaProfessoresAtivos());
        this.atualizaTabelaTodosAlunos(controleAluno.listaAlunoesAtivos());
    }

    public void atualizaComboBoxDisciplinas(List<BEAN_Disciplina> listaDisciplinas) {

        int cont = 0;
        while (cont < listaDisciplinas.size()) {
            comboBoxDisciplinas.addItem(listaDisciplinas.get(cont).getNomeDisciplina());
            cont++;
        }
    }

    public void atualizaComboBoxProfesores(List<BEAN_Professor> listaProfessores) {

        int cont = 0;
        while (cont < listaProfessores.size()) {
            comboBoxProfessores.addItem(listaProfessores.get(cont).getNomeProfessor());
            cont++;
        }
    }

    public void atualizaTabelaTodosAlunos(List<BEAN_Aluno> listAlunos) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome"}, 0);

        for (int i = 0; i < listAlunos.size(); i++) {
            modelo.addRow(new Object[]{listAlunos.get(i).getNomeAluno(),});
        }

        tabelaTodosAlunos.setModel(modelo);
    }

    public void atualizaTabelaTurmas(List<BEAN_Turma> listTurmas) throws SQLException {

        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Nome", "Descrição", "Disciplina", "Professor", "Status"}, 0);

        for (int i = 0; i < listTurmas.size(); i++) {
            String nomedisciplina = null;
            String nomeprofessor = null;
            
            listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
            for (BEAN_Disciplina disciplinas : listaDeDisciplinas) {
                if (disciplinas.getIdDisciplina()== listTurmas.get(i).getIdDisciplina()) {
                    nomedisciplina = disciplinas.getNomeDisciplina();
                }
            }
            
            listaDeProfessores = controleProfessor.listaProfessoresAtivos();
            for (BEAN_Professor professores : listaDeProfessores) {
                if (professores.getIdProfessor()== listTurmas.get(i).getIdProfessor()) {
                    nomeprofessor = professores.getNomeProfessor();
                }
            }

            modelo.addRow(new Object[]{listTurmas.get(i).getNomeTurma(),
                listTurmas.get(i).getDescricaoTurma(),
                nomedisciplina,
                nomeprofessor,
                listTurmas.get(i).getStatusTurma().equals("1") ? "Ativo" : "Inativa"});
        }

        tabelaTurmas.setModel(modelo);
        tabelaTurmas.getColumnModel().getColumn(0).setWidth(100);
        tabelaTurmas.getColumnModel().getColumn(1).setWidth(20);
        tabelaTurmas.getColumnModel().getColumn(2).setWidth(10);
        tabelaTurmas.getColumnModel().getColumn(3).setWidth(10);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabelaTurmas.getColumnModel().getColumn(4).setCellRenderer(centralizado);
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
        comboBoxDisciplinas = new javax.swing.JComboBox<>();
        comboBoxProfessores = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTurmas = new javax.swing.JTable();
        botaoVoltar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoSalvar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAlunosDaTurma = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTodosAlunos = new javax.swing.JTable();
        botaoRemoveDaTurma = new javax.swing.JButton();
        botaoAddNaTurma = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Turmas"));

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        jLabel3.setText("Disciplina");

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

        jLabel4.setText("Professor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(270, 270, 270)
                                .addComponent(checkAtivos))
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDescricao)
                        .addContainerGap())))
        );

        tabelaTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Disciplina", "Professor", "Status"
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
        tabelaTurmas.getTableHeader().setReorderingAllowed(false);
        tabelaTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaTurmas);
        if (tabelaTurmas.getColumnModel().getColumnCount() > 0) {
            tabelaTurmas.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabelaTurmas.getColumnModel().getColumn(1).setPreferredWidth(25);
            tabelaTurmas.getColumnModel().getColumn(2).setPreferredWidth(20);
            tabelaTurmas.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelaTurmas.getColumnModel().getColumn(4).setPreferredWidth(3);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addContainerGap(14, Short.MAX_VALUE))
        );

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Alunos"));

        tabelaAlunosDaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaAlunosDaTurma);

        tabelaTodosAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaTodosAlunos);
        if (tabelaTodosAlunos.getColumnModel().getColumnCount() > 0) {
            tabelaTodosAlunos.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        botaoRemoveDaTurma.setText("<<");
        botaoRemoveDaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoveDaTurmaActionPerformed(evt);
            }
        });

        botaoAddNaTurma.setText(">>");
        botaoAddNaTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddNaTurmaActionPerformed(evt);
            }
        });

        jLabel5.setText("Todos os alunos");

        jLabel6.setText("Alunos da turma");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoRemoveDaTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoAddNaTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(186, 186, 186))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(botaoAddNaTurma)
                        .addGap(18, 18, 18)
                        .addComponent(botaoRemoveDaTurma))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoVoltar)
                        .addGap(38, 38, 38)
                        .addComponent(botaoNovo)
                        .addGap(56, 56, 56)
                        .addComponent(botaoSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoExcluir)
                        .addGap(41, 41, 41)
                        .addComponent(botaoCancelar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoExcluir)
                    .addComponent(botaoNovo)
                    .addComponent(botaoVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.textNome.setText("");
        this.textDescricao.setText("");
        this.comboBoxDisciplinas.setSelectedIndex(0);
        this.comboBoxProfessores.setSelectedIndex(0);

        this.textDescricao.setEnabled(false);
        this.comboBoxDisciplinas.setEnabled(false);
        this.comboBoxProfessores.setEnabled(false);

        this.botaoNovo.setEnabled(true);
        this.botaoExcluir.setEnabled(true);

        this.botaoSalvar.setEnabled(false);
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        if (textNome.getText().isEmpty() || textDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Os campos não podem ficar vazios!", "Erro, verifique a mensagem abaixo", 0);
        } else if (comboBoxDisciplinas.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma disciplina!", "Erro, verifique a mensagem abaixo", 0);
        } else if (comboBoxProfessores.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um profesor!", "Erro, verifique a mensagem abaixo", 0);
        } else {
            try {
                if (!boolClikedTabela) {
                    int idProfessor = 0;
                    int idDisciplina = 0;

                    listaDeProfessores = controleProfessor.listaProfessoresAtivos();
                    for (BEAN_Professor professores : listaDeProfessores) {
                        if (professores.getNomeProfessor().equals(comboBoxProfessores.getSelectedItem().toString())) {
                            idProfessor = professores.getIdProfessor();
                        }
                    }
                    
                    listaDeDisciplinas = controleDisciplina.listaDisciplinasAtivas();
                    for (BEAN_Disciplina disciplinas : listaDeDisciplinas) {
                        if (disciplinas.getNomeDisciplina().equals(comboBoxDisciplinas.getSelectedItem().toString())) {
                            idDisciplina = disciplinas.getIdFaculdade();
                        }
                    }
                    
                    BEAN_Turma turma = new BEAN_Turma(0, textNome.getText(), textDescricao.getText(), idDisciplina, idProfessor, "1");
                    controleTurma.addTurma(turma);

                    JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < inserida com sucesso! ");

                    listaDeTurmas = controleTurma.listaTurmasAtivas();
                    this.atualizaTabelaTurmas(listaDeTurmas);
                    this.textNome.setText("");
                    this.textDescricao.setText("");
                    this.comboBoxDisciplinas.setSelectedIndex(0);
                    this.comboBoxProfessores.setSelectedIndex(0);
                    this.botaoCancelarActionPerformed(evt);
                } else {
//                    if (tabelaTurmas.getSelectedRow() != -1) {
//                        int index = tabelaTurmas.getSelectedRow();
//                        this.listaDeTurmas = controleTurma.listaTurmasAtivas();
//                        BEAN_Turma turmaSelected = listaDeTurmas.get(index);
//
//                        for (BEAN_Turma turmas : listaDeTurmas) {
//                            if (turmas.getIdDisciplina() == turmaSelected.getIdDisciplina()) {
//                                int idFaculdade = 0;
//
//                                turmaSelected.setIdDisciplina(turmas.getIdDisciplina());
//                                turmaSelected.setNomeDisciplina(textNome.getText());
//                                turmaSelected.setDescricaoDisciplina(textDescricao.getText());
//                                turmaSelected.setIdFaculdade(idFaculdade);
//                                turmaSelected.setStatusDisciplina("1");
//
//                                controleTurma.updateTurma(turmaSelected);
//                                JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < alterada com sucesso! ");
//
//                                listaDeTurmas = controleTurma.listaTurmasAtivas();
//                                this.atualizaTabelaTurmas(listaDeTurmas);
//                                this.textNome.setText("");
//                                this.textDescricao.setText("");
//                                this.comboBoxDisciplinas.setSelectedIndex(0);
//                                this.botaoCancelarActionPerformed(evt);
//                            }
//                        }
//                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Turma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed

        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxDisciplinas.setEnabled(true);
        this.comboBoxProfessores.setEnabled(true);

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
        int index = tabelaTurmas.getSelectedRow();

        if (index >= 0 && index < listaDeTurmas.size()) {
            try {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir: " + textNome.getText() + "?", "Excluir", JOptionPane.YES_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    BEAN_Turma turmaSelecionada = listaDeTurmas.get(tabelaTurmas.getSelectedRow());
                    controleTurma.deleteTurma(turmaSelecionada);
                    JOptionPane.showMessageDialog(null, "Disciplina >  " + textNome.getText() + "  < excluída com sucesso! ");

                    this.listaDeTurmas = controleTurma.listaTurmasAtivas();
                    this.atualizaTabelaTurmas(listaDeTurmas);
                    this.botaoCancelarActionPerformed(evt);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VIEW_Turma.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir.");
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTurmasMouseClicked

        this.textNome.setEnabled(true);
        this.textDescricao.setEnabled(true);
        this.comboBoxDisciplinas.setEnabled(true);
        this.comboBoxProfessores.setEnabled(true);

        this.botaoSalvar.setEnabled(true);
        this.botaoCancelar.setEnabled(true);
        this.botaoNovo.setEnabled(false);

        this.boolClikedTabela = true;

        if (checkAtivos.isSelected()) {
            listaDeTurmas = controleTurma.listaTurmasAtivas();
        } else {
            listaDeTurmas = controleTurma.listaTurmasInativas();
        }

        int index = tabelaTurmas.getSelectedRow();

        if (index >= 0 && tabelaTurmas.getSelectedRow() < listaDeTurmas.size()) {
            BEAN_Turma turma = listaDeTurmas.get(index);

            this.textNome.setText(turma.getNomeTurma());
            this.textDescricao.setText(turma.getDescricaoTurma());
            this.comboBoxDisciplinas.setSelectedIndex(0);
            this.comboBoxProfessores.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tabelaTurmasMouseClicked

    private void checkAtivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAtivosMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                this.textNome.setText("");
                this.textDescricao.setText("");
                this.comboBoxDisciplinas.setSelectedIndex(0);
                this.botaoExcluir.setEnabled(true);
                this.listaDeTurmas = controleTurma.listaTurmasAtivas();
            } else {
                this.textNome.setText("");
                this.textDescricao.setText("");
                this.comboBoxDisciplinas.setSelectedIndex(0);
                this.comboBoxProfessores.setSelectedIndex(0);
                this.botaoExcluir.setEnabled(false);
                this.listaDeTurmas = controleTurma.listaTurmasAtivas();
            }
            this.atualizaTabelaTurmas(listaDeTurmas);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Turma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkAtivosMouseClicked

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        try {
            if (checkAtivos.isSelected()) {
                listaDeTurmas = controleTurma.listaTurmasAtivasByNome(textNome.getText());
            } else {
                listaDeTurmas = controleTurma.listaTurmasInativasByNome(textNome.getText());
            }
            this.atualizaTabelaTurmas(listaDeTurmas);
            this.textNome.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Turma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new VIEW_Menu_principal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoRemoveDaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoveDaTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoRemoveDaTurmaActionPerformed

    private void botaoAddNaTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddNaTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAddNaTurmaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAddNaTurma;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JButton botaoRemoveDaTurma;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JCheckBox checkAtivos;
    private javax.swing.JComboBox<String> comboBoxDisciplinas;
    private javax.swing.JComboBox<String> comboBoxProfessores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tabelaAlunosDaTurma;
    private javax.swing.JTable tabelaTodosAlunos;
    private javax.swing.JTable tabelaTurmas;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables

}
