/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author marco
 */
public class GrupoContasBEAN {
    
    private int idGrupoContas;
    private String descrição;

    public GrupoContasBEAN(int idGrupoContas, String descrição) {
        this.idGrupoContas = idGrupoContas;
        this.descrição = descrição;
    }
    
    public GrupoContasBEAN() {
    }

    public int getIdGrupoContas() {
        return idGrupoContas;
    }

    public void setIdGrupoContas(int idGrupoContas) {
        this.idGrupoContas = idGrupoContas;
    }

    public String getDescricao() {
        return descrição;
    }

    public void setDescricao(String descrição) {
        this.descrição = descrição;
    }
    
}
