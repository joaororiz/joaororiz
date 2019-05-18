package calc;

/**
 *
 * @author João Otávio Mota Roriz
 */
import Beans.ListCategoria;
import Beans.ListProdutos;
import Beans.Produto;
import Dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

@WebService(endpointInterface = "calc.ProdutoServer")
public class ProdutoServerImpl implements ProdutoServer {
    
    String key = "TS255DTJJ5DT8J";

    @Override
    public ListProdutos ListarProdutosCat(String categoria, String APIKey) {
        ListProdutos lista = new ListProdutos();
   
        if(key.equals(APIKey)){
            try {
                lista.setProdutos(new ProdutoDAO().findByAllProdutosByCategoria(categoria));
                
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    @Override
    public ListProdutos ListarProdutos(String APIKey) {
        ListProdutos lista = new ListProdutos();
        
        if(key.equals(APIKey)){
            try {
                lista.setProdutos(new ProdutoDAO().findByAllProdutos());
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }

    @Override
    public Produto DadosProduto(int codigo, String APIKey) {
        if(key.equals(APIKey)){
            try {
                return new ProdutoDAO().findByProduto(codigo);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    @Override
    public ListCategoria ListarCategorias (String APIKey){
        ListCategoria lista = new ListCategoria();
        if(key.equals(APIKey)) {
            try {
                lista.setCategorias(new ProdutoDAO().findByAllCategoria());
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;
    }
}
