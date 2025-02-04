package br.ufpb.dcx.diogo.posto;

public class Medico {
    private String crmMedico;
    private String nomeMedico;

    public Medico(String crmMedico, String nomeMedico) {
        this.crmMedico = crmMedico;
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    @Override
    public String toString() {
        return "Médico de CRM "
                 + crmMedico +
                " e que se chama " + nomeMedico;
    }
}
