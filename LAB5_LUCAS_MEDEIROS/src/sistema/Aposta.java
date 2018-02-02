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
    private ApostaSegura seguro;

    /**
     * Construtor de Aposta.
     * 
     * @param apostador nome do apostador.
     * @param previsao previsão de aposta.
     * @param centavosAposta valor, em centavos, da aposta.
     */
    public Aposta(String apostador, String previsao, int centavosAposta) {
        this(apostador, previsao, centavosAposta, null);
    }
    
    public Aposta(String apostador, String previsao, int centavosAposta, 
            ApostaSegura seguro) {
        if (apostador == null || apostador.trim().isEmpty())
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Apostador nao pode ser vazio ou nulo");
        
        if (centavosAposta <= 0)
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Valor nao pode ser menor ou igual a zero");
        
        if (previsao == null || previsao.trim().isEmpty())
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Previsao nao pode ser vazia ou nula");
        
        
        if (!(previsao.trim().toUpperCase().equals("VAI ACONTECER") ||
                previsao.trim().toUpperCase().equals("N VAI ACONTECER")))
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Previsao invalida");
        
        this.apostador = apostador;
        this.previsao = previsao;
        this.centavosAposta = centavosAposta;
        this.ganhou = false;
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
    
    public int perderAposta() {
        if (seguro == null) 
            return 0;
        
        return seguro.perderAposta(centavosAposta);
    }

    /**
     * Sobrescrição do método toString().
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
