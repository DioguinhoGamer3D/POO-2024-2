package br.ufpb.dcx.diogo.posto;

public class AtendimentoMedico {
    private String codigoFicha;
    private CategoriaAtendimento categoria;
    private String cpfPaciente;
    private String crmMedico;
    private Data diaAtendimento;

    public AtendimentoMedico(String codigoFicha, CategoriaAtendimento categoria,
                             String cpfPaciente, String crmMedico, Data diaAtendimento) {
        this.codigoFicha = codigoFicha;
        this.categoria = categoria;
        this.cpfPaciente = cpfPaciente;
        this.crmMedico = crmMedico;
        this.diaAtendimento = diaAtendimento;
    }

    public AtendimentoMedico() {
        this("",CategoriaAtendimento.INDEFINIDO, "","",new Data());
    }
//Demais métodos da classe por aqui …


    public String getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(String codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public CategoriaAtendimento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAtendimento categoria) {
        this.categoria = categoria;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public Data getDiaAtendimento() {
        return diaAtendimento;
    }

    public void setDiaAtendimento(Data diaAtendimento) {
        this.diaAtendimento = diaAtendimento;
    }

    @Override
    public String toString() {
        return "AtendimentoMedico{" +
                "codigoFicha='" + codigoFicha + '\'' +
                ", categoria=" + categoria +
                ", cpfPaciente='" + cpfPaciente + '\'' +
                ", crmMedico='" + crmMedico + '\'' +
                ", diaAtendimento=" + diaAtendimento +
                '}';
    }
}

