package integracao;

public class Aluno {
    private int numeroCursosConcluidos;
    private boolean isPremium;
    private int moedas;

    public Aluno() {
        this.setNumeroCursosConcluidos(0);
        this.isPremium = false;
        this.moedas = 0;
    }

    public void concluirCursoComMediaSuperiorASete() {
        setNumeroCursosConcluidos(getNumeroCursosConcluidos() + 1);

        if (isPremium && getNumeroCursosConcluidos() % 1 == 0) {
            moedas += 3;
        }

        if (getNumeroCursosConcluidos() == 12) {
            isPremium = true;
        }
    }

    public boolean isPremium() {
        return isPremium;
    }

    public int getMoedas() {
        return moedas;
    }

    public void usarMoedas(int quantidade) {
        if (moedas >= quantidade) {
            moedas -= quantidade;
        } else {
            System.out.println("Moedas insuficientes.");
        }
    }

    public boolean podeTrocarPorCriptomoeda() {
        return moedas > 0;
    }

	public int getNumeroCursosConcluidos() {
		return numeroCursosConcluidos;
	}

	public void setNumeroCursosConcluidos(int numeroCursosConcluidos) {
		this.numeroCursosConcluidos = numeroCursosConcluidos;
	}
}
