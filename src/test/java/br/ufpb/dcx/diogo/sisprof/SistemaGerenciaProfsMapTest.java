package br.ufpb.dcx.diogo.sisprof;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaGerenciaProfsMapTest {

    @Test
    public void testaCadastroProfs(){
        SistemaGerenciaProfsMap sistema = new SistemaGerenciaProfsMap();
        try {
            //i)
            sistema.cadastraProfessor(111, "José");
            //ii)
            List<String> disciplinasDeJose = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertTrue(disciplinasDeJose.size()==0);
            assertEquals(0, disciplinasDeJose.size());
            //iii)
            List<Horario> horariosDisciplina = new LinkedList<>();
            Horario horarioAula1 = new Horario(DiaDaSemana.TERCA, 10, 12);
            horariosDisciplina.add(horarioAula1);
            Horario horarioAula2 = new Horario(DiaDaSemana.TERCA, 13, 15);
            horariosDisciplina.add(horarioAula2);
            sistema.cadastraDisciplina("POO", 22, 111, horariosDisciplina);

            //iv)
            List<String> disciplinasDeJoseDepois = sistema.consultaNomesDisciplinasDoProfessor(111);
            assertEquals(1, disciplinasDeJoseDepois.size());
            assertTrue(disciplinasDeJoseDepois.get(0).equals("POO"));

            //vi)
            List<Horario> horariosJose= sistema.consultaHorariosDeAulaDoProfessor(111);
            assertEquals(2, horariosJose.size());
            Horario primeiroHorario = horariosJose.get(0);
            Horario segundoHorario = horariosJose.get(1);
            assertEquals(horarioAula1,primeiroHorario);
            assertEquals(horarioAula2,segundoHorario);

        } catch (ProfessorJaExisteException | DisciplinaJaExisteException | ProfessorInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada");
        }
    }


}
