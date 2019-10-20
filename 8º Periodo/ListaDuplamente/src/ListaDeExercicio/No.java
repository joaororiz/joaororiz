package ListaDeExercicio;

import listaduplamente.*;

/**
 *
 * @author Joao Otávio Mota Roriz
 */
public class No {
    private No ant, prox;
    private Object info;
    
    public No(No ant, No prox, Object info) {
        this.ant = ant;
        this.prox = prox;
        this.info = info;
    }
    
    public No getAnt() {
        return ant;
    }

    public No getProx() {
        return prox;
    }

    public void setAnt(No p_ant) {
        ant = p_ant;
    }

    public void setProx(No p_prox) {
        prox = p_prox;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object elemento) {
        info = elemento;
    }
}