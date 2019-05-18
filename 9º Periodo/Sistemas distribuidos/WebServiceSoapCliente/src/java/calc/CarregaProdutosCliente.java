package calc;

import Beans.ListCategoria;
import Beans.ListProdutos;
import Beans.Produto;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class CarregaProdutosCliente extends javax.swing.JFrame {

    String APIKey = "TS255DTJJ5DT8J";
    URL url = new URL("http://127.0.0.1:9890/calc?wsdl");
    QName qname = new QName("http://calc/", "ProdutoServerImplService");
    Service ws = Service.create(url, qname);
    ProdutoServer calc = ws.getPort(ProdutoServer.class);

    ListProdutos listaDeProdutos = new ListProdutos();

    public CarregaProdutosCliente() throws MalformedURLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.carregarTabelaAllProdutos();
        this.carregaComboBoxCategoria();

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
    }

    public void carregarTabelaAllProdutos() throws MalformedURLException {

        listaDeProdutos = calc.ListarProdutos(APIKey);
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Descrição", "Categoria"}, 0);

        for (int i = 0; i < listaDeProdutos.getProdutos().size(); i++) {
            modelo.addRow(new Object[]{listaDeProdutos.getProdutos().get(i).getCodigo(), listaDeProdutos.getProdutos().get(i).getDescricao(), listaDeProdutos.getProdutos().get(i).getCategoria()});
        }

        tabela_produtos.setModel(modelo);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tabela_produtos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabela_produtos.getColumnModel().getColumn(2).setCellRenderer(centralizado);

        tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(5);
        tabela_produtos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabela_produtos.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    public void carregaComboBoxCategoria() {
        ListCategoria listaDeCategoria = new ListCategoria();

        listaDeCategoria = calc.ListarCategorias(APIKey);

        combo_box_categoria.addItem("Todas categorias");

        for (int i = 0; i < listaDeCategoria.getCategorias().size(); i++) {
            combo_box_categoria.addItem(listaDeCategoria.getCategorias().get(i).toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_principal = new javax.swing.JPanel();
        combo_box_categoria = new javax.swing.JComboBox<>();
        botao_pesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        imagem_produto = new javax.swing.JLabel();
        texto_codigo = new javax.swing.JTextField();
        texto_descricao = new javax.swing.JTextField();
        texto_valores = new javax.swing.JTextField();
        texto_qtd_estoque = new javax.swing.JTextField();
        texto_categoria = new javax.swing.JTextField();
        texto_unidade_medida = new javax.swing.JTextField();
        texto_fornecedor = new javax.swing.JTextField();
        label_icon_code = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painel_principal.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de produtos"));

        combo_box_categoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        botao_pesquisar.setText("Pesquisar");
        botao_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_pesquisarActionPerformed(evt);
            }
        });

        tabela_produtos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_produtos.getTableHeader().setReorderingAllowed(false);
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        tabela_produtos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tabela_produtosComponentMoved(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_produtos);
        if (tabela_produtos.getColumnModel().getColumnCount() > 0) {
            tabela_produtos.getColumnModel().getColumn(0).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabela_produtos.getColumnModel().getColumn(1).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabela_produtos.getColumnModel().getColumn(2).setResizable(false);
            tabela_produtos.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes do produto"));

        imagem_produto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_codigo.setEditable(false);
        texto_codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_descricao.setEditable(false);
        texto_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_valores.setEditable(false);
        texto_valores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_qtd_estoque.setEditable(false);
        texto_qtd_estoque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_categoria.setEditable(false);
        texto_categoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_unidade_medida.setEditable(false);
        texto_unidade_medida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        texto_fornecedor.setEditable(false);
        texto_fornecedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_icon_code.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/codigo.png"))); // NOI18N
        label_icon_code.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagem_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(texto_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_unidade_medida))
                    .addComponent(texto_qtd_estoque, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(texto_valores, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_icon_code)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 274, Short.MAX_VALUE))
                    .addComponent(texto_fornecedor)
                    .addComponent(texto_descricao, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagem_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label_icon_code, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(texto_codigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_valores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_qtd_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto_unidade_medida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texto_fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout painel_principalLayout = new javax.swing.GroupLayout(painel_principal);
        painel_principal.setLayout(painel_principalLayout);
        painel_principalLayout.setHorizontalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_principalLayout.createSequentialGroup()
                                .addComponent(combo_box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botao_pesquisar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        painel_principalLayout.setVerticalGroup(
            painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_box_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_pesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_pesquisarActionPerformed
        if (combo_box_categoria.getSelectedIndex() == 0) {
            try {
                this.carregarTabelaAllProdutos();
            } catch (MalformedURLException ex) {
                Logger.getLogger(CarregaProdutosCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (tabela_produtos.getColumnModel().getColumnCount() > 0) {
                listaDeProdutos = calc.ListarProdutosCat(combo_box_categoria.getSelectedItem().toString(), APIKey);
                DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Código", "Descrição", "Categoria"}, 0);

                for (int i = 0; i < listaDeProdutos.getProdutos().size(); i++) {
                    modelo.addRow(new Object[]{listaDeProdutos.getProdutos().get(i).getCodigo(), listaDeProdutos.getProdutos().get(i).getDescricao(), listaDeProdutos.getProdutos().get(i).getCategoria()});
                }

                tabela_produtos.setModel(modelo);

                DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
                centralizado.setHorizontalAlignment(SwingConstants.CENTER);
                tabela_produtos.getColumnModel().getColumn(0).setCellRenderer(centralizado);
                tabela_produtos.getColumnModel().getColumn(2).setCellRenderer(centralizado);

                tabela_produtos.getColumnModel().getColumn(0).setPreferredWidth(5);
                tabela_produtos.getColumnModel().getColumn(1).setPreferredWidth(100);
                tabela_produtos.getColumnModel().getColumn(2).setPreferredWidth(20);
            }
        }


    }//GEN-LAST:event_botao_pesquisarActionPerformed

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        int index = tabela_produtos.getSelectedRow();

        if (index >= 0 && tabela_produtos.getSelectedRow() < listaDeProdutos.getProdutos().size()) {

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            tabela_produtos.getColumnModel().getColumn(0).setCellRenderer(centralizado);

            Produto produto = listaDeProdutos.getProdutos().get(index);
            Produto produtoFindAll = calc.DadosProduto(produto.getCodigo(), APIKey);

            float lucro = ((produtoFindAll.getPreco() - produtoFindAll.getCusto()) / produtoFindAll.getPreco()) * 100;
            NumberFormat numberFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
            numberFormat.setMaximumFractionDigits(2);

            texto_codigo.setText(produtoFindAll.getCodigo_de_barras());
            texto_descricao.setText("Descrição: " + produtoFindAll.getDescricao().toUpperCase());
            texto_valores.setText("Preço de venda: R$ " + String.valueOf(produtoFindAll.getPreco()).replace('.', ',') + "  (Lucro " + String.valueOf(numberFormat.format(lucro)).replace('.', ',') + "%) \t\t\t Custo: R$ " + String.valueOf(produtoFindAll.getCusto()).replace('.', ','));
            texto_qtd_estoque.setText("Estoque Atual: " + String.valueOf(produtoFindAll.getEstoque_atual()) + "\t\t Limites de Estoque: mim=" + produtoFindAll.getLimite_mim_estoque() + ", max=" + produtoFindAll.getLimite_max_estoque());
            texto_categoria.setText("Categoria: " + produtoFindAll.getCategoria().toUpperCase());
            texto_unidade_medida.setText("Unidade de Medida: " + produtoFindAll.getUnidade_medida().toUpperCase());
            texto_fornecedor.setText("Fornecedor: " + produtoFindAll.getFornecedor().toUpperCase());

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(produtoFindAll.getCaminhoImagem()).getImage().getScaledInstance(157, 165, Image.SCALE_DEFAULT));
            imagem_produto.setIcon(imageIcon);
            
        }
    }//GEN-LAST:event_tabela_produtosMouseClicked

    
    
    private void tabela_produtosComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabela_produtosComponentMoved
    }//GEN-LAST:event_tabela_produtosComponentMoved

    public static void main(String args[]) throws MalformedURLException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CarregaProdutosCliente().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CarregaProdutosCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /* -------------------------------Mudar desing JFrame-------------------------------------------------------------
            //SkyBlue()
        //BrownSugar()
        // DarkStar()  
        //DesertGreen()
        //Silver()
        //ExperienceRoyale()
//        try {
//            PlasticLookAndFeel.setPlasticTheme(new DarkStar());
//            try {
//                UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
//            } catch (InstantiationException ex) {
//                Logger.getLogger(CarregaProdutosCliente.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(CarregaProdutosCliente.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(CarregaProdutosCliente.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        SwingUtilities.updateComponentTreeUI(this);
//
//        painel_principal.setBackground(SystemColor.BLACK);

     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_pesquisar;
    private javax.swing.JComboBox<String> combo_box_categoria;
    private javax.swing.JLabel imagem_produto;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_icon_code;
    private javax.swing.JPanel painel_principal;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JTextField texto_categoria;
    private javax.swing.JTextField texto_codigo;
    private javax.swing.JTextField texto_descricao;
    private javax.swing.JTextField texto_fornecedor;
    private javax.swing.JTextField texto_qtd_estoque;
    private javax.swing.JTextField texto_unidade_medida;
    private javax.swing.JTextField texto_valores;
    // End of variables declaration//GEN-END:variables
}
