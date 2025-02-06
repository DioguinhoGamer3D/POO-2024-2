package br.ufpb.dcx.diogo.sisprof;

public class Horario {
    private int horaInicio;
    private int horaFim;
    private DiaDaSemana dia;

    public Horario(DiaDaSemana dia, int horaInicio,int horaFim){
        this.dia = dia;
        this.horaInicio=horaInicio;
        this.horaFim=horaFim;

    }

    public int getHoraInicio() {
        return this.horaInicio;
    }

    public int getHoraFim() {
        return this.horaFim;
    }

    public DiaDaSemana getDia() {
        return this.dia;
    }
}
