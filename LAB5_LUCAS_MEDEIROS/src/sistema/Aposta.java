package sistema;

/**
 * Representação de uma aposta sem seguro feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Aposta {
    private String apostador;
    private String previsao;
    private int centavosAposta;
    private boolean ganhou;
    
    private Validator val = new Validator();
    
    private final int id;
    
    /**
     * Construtor de Aposta.
     * 
     * @param apostador nome do apostador.
     * @param previsao previsão de aposta.
     * @param centavosAposta valor, em centavos, da aposta.
     * @param id id da aposta
     */
    
    public Aposta(String apostador, String previsao, int centavosAposta, int id) {
        this.apostador = apostador;
        this.previsao = previsao;
        this.centavosAposta = centavosAposta;
        this.ganhou = false;
        this.id = id;
    }

    /**
     * Método acessório para o nome do apostador.
     * 
     * @return nome do apostador.
     */
    public String getApostador() {
        return apostador;
    }

    /**
     * Método acessório para o ID da aposta.
     * 
     * @return id da aposta.
     */
    public int getId() {
        return id;
    }

    /**
     * Método acessório para a previsão do apostador.
     * 
     * @return previsão do apostador.
     */
    public String getPrevisao() {
        return previsao;
    }

    /**
     * Método acessório para o valor da aposta.
     * 
     * @return valor da aposta.
     */
    public int getCentavosAposta() {
        return centavosAposta;
    }

    /**
     * Verifica se a aposta ganhou ou não.
     * 
     * @return <tt>true</tt> se foi uma aposta vencedora.
     */
    public boolean ganhou() {
        return ganhou;
    }

    /**
     * Método para definir se a aposta ganhou ou não (por padrão, todas iniciam
     * como false).
     * 
     * @param ganhou valor a ser setado ao atributo ganhou.
     */
    public void setGanhou(boolean ganhou) {
        this.ganhou = ganhou;
    }

    /**
     * Sobrescrita do método toString().
     * 
     * @return representação em string de uma aposta (com o nome do apostador, 
     * valor em reais do quanto foi apostado, e a previsão.)
     */
    @Override
    public String toString() {
        String valorReais = String.format("%,.2f", centavosAposta / 100.0);
        return apostador + " - R$" + valorReais + " - " + previsao;
    }
}