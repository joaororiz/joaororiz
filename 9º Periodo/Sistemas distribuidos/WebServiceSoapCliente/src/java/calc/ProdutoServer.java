package calc;

/**
 *
 * @author João Otávio Mota Roriz
 */
import Beans.ListCategoria;
import Beans.ListProdutos;
import Beans.Produto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProdutoServer {

    @WebMethod
    ListProdutos ListarProdutosCat(String categoria, String APIKey);

    @WebMethod
    ListProdutos ListarProdutos(String APIKey);

    @WebMethod
    Produto DadosProduto(int codigo, String APIKey);
        
    @WebMethod
   ListCategoria ListarCategorias (String APIKey);
}
