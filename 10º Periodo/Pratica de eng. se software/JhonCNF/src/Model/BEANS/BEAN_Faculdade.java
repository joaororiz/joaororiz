package Model.BEANS;

public class BEAN_Faculdade {

    private int idFaculdade;
    private String nomeFaculdade;
    private String descricaoFaculdade;
    private String UFfaculdade;
    private String cidadeFaculdade;
    private String statusFaculdade;

    public BEAN_Faculdade() {
    }

    public BEAN_Faculdade(int idFaculdade, String nomeFaculdade, String descricaoFaculdade, String UFfaculdade, String cidadeFaculdade, String statusFaculdade) {
        this.idFaculdade = idFaculdade;
        this.nomeFaculdade = nomeFaculdade;
        this.descricaoFaculdade = descricaoFaculdade;
        this.UFfaculdade = UFfaculdade;
        this.cidadeFaculdade = cidadeFaculdade;
        this.statusFaculdade = statusFaculdade;
    }

    public int getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(int idFaculdade) {
        this.idFaculdade = idFaculdade;
    }

    public String getNomeFaculdade() {
        return nomeFaculdade;
    }

    public void setNomeFaculdade(String nomeFaculdade) {
        this.nomeFaculdade = nomeFaculdade;
    }

    public String getDescricaoFaculdade() {
        return descricaoFaculdade;
    }

    public void setDescricaoFaculdade(String descricaoFaculdade) {
        this.descricaoFaculdade = descricaoFaculdade;
    }

    public String getUFfaculdade() {
        return UFfaculdade;
    }

    public void setUFfaculdade(String UFfaculdade) {
        this.UFfaculdade = UFfaculdade;
    }

    public String getCidadeFaculdade() {
        return cidadeFaculdade;
    }

    public void setCidadeFaculdade(String cidadeFaculdade) {
        this.cidadeFaculdade = cidadeFaculdade;
    }

    public String getStatusFaculdade() {
        return statusFaculdade;
    }

    public void setStatusFaculdade(String statusFaculdade) {
        this.statusFaculdade = statusFaculdade;
    }
}