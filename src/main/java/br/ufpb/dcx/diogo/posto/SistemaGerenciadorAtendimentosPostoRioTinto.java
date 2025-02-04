package br.ufpb.dcx.diogo.posto;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class SistemaGerenciadorAtendimentosPostoRioTinto implements
        SistemaGerenciadorDeAtendimentos {


    private Map<String, Medico> medicos;
    private Map<String, AtendimentoMedico> atendimentos;

    public SistemaGerenciadorAtendimentosPostoRioTinto() {
        this.medicos = new HashMap<>();
        this.atendimentos = new HashMap<>();
    }


    @Override
    public void cadastrarMedico(String crmMedico, String nomeMedico)
            throws MedicoJaCadastradoException {
        if (this.medicos.containsKey(crmMedico)) {
            throw new MedicoJaCadastradoException(
                    "Já existe médico com o CRM " + crmMedico);
        } else {
            this.medicos.put(crmMedico, new Medico(crmMedico, nomeMedico));
        }

    }

    @Override
    public int contaAtendimentosDeMedicoNoMes(String crmMedico, int mes, int ano) {
        //TODO
        int contAtendimentos = 0;
        for (AtendimentoMedico at: this.atendimentos.values()){
            if (at.getCrmMedico().equals(crmMedico)){
                Data dataAt = at.getDiaAtendimento();
                if (dataAt.getMes()==mes && dataAt.getAno()==ano){
                    contAtendimentos++;
                }
            }
        }
        return contAtendimentos;
    }

    @Override
    public void cadastrarAtendimento(String codigoFicha, CategoriaAtendimento categoria, String cpfPaciente,
                                     String crmMedico, Data diaAtendimento) throws MedicoNaoCadastradoException,
            AtendimentoJaCadastradoException {

        if (!this.medicos.containsKey(crmMedico)){
            throw new MedicoNaoCadastradoException("Não existe médico com o CRM "+ crmMedico+" no sistema");
        }
        if (this.atendimentos.containsKey(codigoFicha)){
            throw new AtendimentoJaCadastradoException("Já existe atendimento para a ficha "+codigoFicha);
        } else {
            this.atendimentos.put(codigoFicha, new AtendimentoMedico(codigoFicha,
                    categoria, cpfPaciente, crmMedico, diaAtendimento));
        }

    }

    @Override
    public AtendimentoMedico pesquisaAtendimento(String codigoFicha) throws AtendimentoNaoCadastradoException {
        if (this.atendimentos.containsKey(codigoFicha)){
            return this.atendimentos.get(codigoFicha);
        } else {
            throw new AtendimentoNaoCadastradoException("Não existe atendimento para a ficha "+codigoFicha);
        }
    }

    @Override
    public Collection<AtendimentoMedico> pesquisaAtendimentosDoDia(Data diaAtendimento) {
        Collection<AtendimentoMedico> atendimentosDia = new LinkedList<>();
        for (AtendimentoMedico at: this.atendimentos.values()){
            if (at.getDiaAtendimento().equals(diaAtendimento)){
                atendimentosDia.add(at);
            }
        }
        return atendimentosDia;
    }

    @Override
    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria) {
        int numAtendimentos = 0;
        for (AtendimentoMedico at: this.atendimentos.values()){
            if (at.getCategoria() == categoria){
                numAtendimentos++;
            }
        }
        return numAtendimentos;
    }
//Demais métodos da classe considerando que implementa a interface
// e que lança em seus métodos mesmas exceções dos métodos da interface.


}