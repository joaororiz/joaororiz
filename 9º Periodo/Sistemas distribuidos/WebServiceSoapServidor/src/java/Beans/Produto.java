package Beans;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class Produto {
        
        private Integer codigo;
        private String codigo_de_barras;
        private String descricao;
        private float preco;
        private float custo;
        private Integer estoque_atual;
        private Integer limite_max_estoque;
        private Integer limite_mim_estoque;
        private String categoria;
        private String unidade_medida;
        private String fornecedor;
        private String caminhoImagem;

    public Produto() {
    }

    public Produto(Integer codigo, String codigo_de_barras, String descricao, float preco, float custo, Integer estoque_atual, Integer limite_max_estoque, Integer limite_mim_estoque, String categoria, String unidade_medida, String fornecedor, String caminhoImagem) {
        this.codigo = codigo;
        this.codigo_de_barras = codigo_de_barras;
        this.descricao = descricao;
        this.preco = preco;
        this.custo = custo;
        this.estoque_atual = estoque_atual;
        this.limite_max_estoque = limite_max_estoque;
        this.limite_mim_estoque = limite_mim_estoque;
        this.categoria = categoria;
        this.unidade_medida = unidade_medida;
        this.fornecedor = fornecedor;
        this.caminhoImagem = caminhoImagem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_de_barras() {
        return codigo_de_barras;
    }

    public void setCodigo_de_barras(String codigo_de_barras) {
        this.codigo_de_barras = codigo_de_barras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public Integer getEstoque_atual() {
        return estoque_atual;
    }

    public void setEstoque_atual(Integer estoque_atual) {
        this.estoque_atual = estoque_atual;
    }

    public Integer getLimite_max_estoque() {
        return limite_max_estoque;
    }

    public void setLimite_max_estoque(Integer limite_max_estoque) {
        this.limite_max_estoque = limite_max_estoque;
    }

    public Integer getLimite_mim_estoque() {
        return limite_mim_estoque;
    }

    public void setLimite_mim_estoque(Integer limite_mim_estoque) {
        this.limite_mim_estoque = limite_mim_estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }
}
