package View;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class VIEW_Menu_principal extends javax.swing.JFrame {

    public VIEW_Menu_principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu principal");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        painelProfessor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        painelAluno = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        painelFaculdade = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        painelDisciplina = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Menu principal");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        painelProfessor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelProfessorMouseClicked(evt);
            }
        });

        jLabel2.setText("Professor");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/professor.png"))); // NOI18N

        javax.swing.GroupLayout painelProfessorLayout = new javax.swing.GroupLayout(painelProfessor);
        painelProfessor.setLayout(painelProfessorLayout);
        painelProfessorLayout.setHorizontalGroup(
            painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelProfessorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelProfessorLayout.setVerticalGroup(
            painelProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelProfessorLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        painelAluno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelAlunoMouseClicked(evt);
            }
        });

        jLabel10.setText("Aluno");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/aluno.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painelAlunoLayout = new javax.swing.GroupLayout(painelAluno);
        painelAluno.setLayout(painelAlunoLayout);
        painelAlunoLayout.setHorizontalGroup(
            painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlunoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(24, 24, 24))
        );
        painelAlunoLayout.setVerticalGroup(
            painelAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelAlunoLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelFaculdade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelFaculdade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelFaculdadeMouseClicked(evt);
            }
        });

        jLabel6.setText("Faculdade");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/faculdade.png"))); // NOI18N

        javax.swing.GroupLayout painelFaculdadeLayout = new javax.swing.GroupLayout(painelFaculdade);
        painelFaculdade.setLayout(painelFaculdadeLayout);
        painelFaculdadeLayout.setHorizontalGroup(
            painelFaculdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFaculdadeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFaculdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFaculdadeLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelFaculdadeLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        painelFaculdadeLayout.setVerticalGroup(
            painelFaculdadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelFaculdadeLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        painelDisciplina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painelDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelDisciplinaMouseClicked(evt);
            }
        });

        jLabel8.setText("Disciplina");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/disciplina.png"))); // NOI18N

        javax.swing.GroupLayout painelDisciplinaLayout = new javax.swing.GroupLayout(painelDisciplina);
        painelDisciplina.setLayout(painelDisciplinaLayout);
        painelDisciplinaLayout.setHorizontalGroup(
            painelDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDisciplinaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelDisciplinaLayout.setVerticalGroup(
            painelDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDisciplinaLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(painelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(painelFaculdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(painelDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
            .addComponent(painelDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
            .addComponent(painelFaculdade, javax.swing.GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
            .addComponent(painelAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 83, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void painelProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProfessorMouseClicked
        try {
            new VIEW_Professor().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_painelProfessorMouseClicked

    private void painelFaculdadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelFaculdadeMouseClicked
        try {
            new VIEW_Faculdade().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_painelFaculdadeMouseClicked

    private void painelDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelDisciplinaMouseClicked
        try {
            new VIEW_Disciplina().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_painelDisciplinaMouseClicked

    private void painelAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelAlunoMouseClicked
        try {
            new VIEW_Aluno().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VIEW_Menu_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_painelAlunoMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painelAluno;
    private javax.swing.JPanel painelDisciplina;
    private javax.swing.JPanel painelFaculdade;
    private javax.swing.JPanel painelProfessor;
    // End of variables declaration//GEN-END:variables

}
