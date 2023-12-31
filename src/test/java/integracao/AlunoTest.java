package integracao;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void testConquistarStatusPremium() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 12; i++) {
            aluno.concluirCursoComMediaSuperiorASete();
        }
        assertTrue(aluno.isPremium());
    }

    @Test
    public void testBeneficiosStatusPremium() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            aluno.concluirCursoComMediaSuperiorASete();
        }

        int moedas = aluno.getMoedas();
        assertEquals(3, moedas);
    }

    @Test
    public void testUsoDasMoedas() {
        Aluno aluno = new Aluno();
        for (int i = 0; i < 13; i++) {
            aluno.concluirCursoComMediaSuperiorASete();
        }

        aluno.usarMoedas(2);
        assertEquals(1, aluno.getMoedas());
        assertTrue(aluno.podeTrocarPorCriptomoeda());
    }
    @Test
    public void testInicializaAluno() {
        Aluno aluno = new Aluno();

        assertEquals(0, aluno.getNumeroCursosConcluidos());
        assertFalse(aluno.isPremium());
        assertEquals(0, aluno.getMoedas());
    }

    @Test
    public void testUsoMoedasQuandoInsuficientes() {
        Aluno aluno = new Aluno();
        aluno.concluirCursoComMediaSuperiorASete();
        aluno.usarMoedas(2);

        assertEquals(0, aluno.getMoedas());
    }

    @Test
    public void testNaoPodeTrocarPorCriptomoeda() {
        Aluno aluno = new Aluno();
        aluno.concluirCursoComMediaSuperiorASete();

        assertFalse(aluno.podeTrocarPorCriptomoeda());
    }
    @Test
    public void testConcluirCursoAumentaNumeroCursosConcluidos() {
        Aluno aluno = new Aluno();
        assertEquals(0, aluno.getNumeroCursosConcluidos());

        aluno.concluirCursoComMediaSuperiorASete();
        assertEquals(1, aluno.getNumeroCursosConcluidos());

        aluno.concluirCursoComMediaSuperiorASete();
        assertEquals(2, aluno.getNumeroCursosConcluidos());
    }

}
