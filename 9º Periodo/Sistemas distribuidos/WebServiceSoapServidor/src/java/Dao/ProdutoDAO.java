package Dao;

import Beans.Produto;
import Conexao.MySQLDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ProdutoDAO {

    private Connection connection;
    public ProdutoDAO() {
        this.connection = new MySQLDAO().getConnection();
    }
    
    public List<Produto> findByAllProdutos() throws SQLException {
        String sql = "SELECT codigo, descricao, categoria FROM produto ORDER BY descricao;";
        List<Produto> listProdutos = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setCodigo(Integer.parseInt(rs.getString(1)));
            produto.setDescricao(rs.getString(2));
            produto.setCategoria(rs.getString(3));
            listProdutos.add(produto);
        }
        rs.close();
        return listProdutos;
    }

    public List<Produto> findByAllProdutosByCategoria(String categoria) throws SQLException {
        String sql = "SELECT codigo, descricao, categoria FROM produto WHERE categoria = '" + categoria + "' ORDER BY descricao;";
        List<Produto> listProdutos = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setCodigo(Integer.parseInt(rs.getString(1)));
            produto.setDescricao(rs.getString(2));
            produto.setCategoria(rs.getString(3));
            listProdutos.add(produto);
        }
        rs.close();
        return listProdutos;
    }

    public Produto findByProduto(int codigo) throws SQLException {
        String sql = "SELECT * FROM produto WHERE codigo = " + codigo + ";";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        Produto produto = new Produto();
        while (rs.next()) {
            produto.setCodigo(Integer.parseInt(rs.getString(1)));
            produto.setCodigo_de_barras(rs.getString(2));
            produto.setDescricao(rs.getString(3));
            produto.setPreco(Float.valueOf(rs.getString(4)));
            produto.setCusto(Float.valueOf(rs.getString(5)));
            produto.setEstoque_atual(Integer.parseInt(rs.getString(6)));
            produto.setLimite_max_estoque(Integer.parseInt(rs.getString(7)));
            produto.setLimite_mim_estoque(Integer.parseInt(rs.getString(8)));
            produto.setCategoria(rs.getString(9));
            produto.setUnidade_medida(rs.getString(10));
            produto.setFornecedor(rs.getString(11));
            produto.setCaminhoImagem(rs.getString(12));
        }
        rs.close();
        return produto;
    }
    
    public List<String> findByAllCategoria() throws SQLException{
        
        String sql = "SELECT DISTINCT(categoria) FROM produto Order BY 1;";
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<String> listString = new ArrayList<>();
        while(rs.next()){
            listString.add(rs.getString(1));
        }
        rs.close();
        return listString;
    }
}
