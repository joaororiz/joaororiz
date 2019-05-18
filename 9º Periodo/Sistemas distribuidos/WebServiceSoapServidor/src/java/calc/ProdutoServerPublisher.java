package calc;

import javax.xml.ws.Endpoint;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ProdutoServerPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:9890/calc", new ProdutoServerImpl());
    }
}
