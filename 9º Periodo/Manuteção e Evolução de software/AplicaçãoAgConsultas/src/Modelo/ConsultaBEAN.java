package Modelo;

/**
 *
 * @author João Otávio Mota Roriz
 */
public class ConsultaBEAN {

    private Integer id;
    private String paciente;
    private String medico;
    private String dataconsulta;
    private String descrisao;

    public ConsultaBEAN() {
    }

    public ConsultaBEAN(Integer id, String paciente, String medico, String dataconsulta, String descrisao) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataconsulta = dataconsulta;
        this.descrisao = descrisao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(String dataconsulta) {
        this.dataconsulta = dataconsulta;
    }

    public String getDescrisao() {
        return descrisao;
    }

    public void setDescrisao(String descrisao) {
        this.descrisao = descrisao;
    }
}
