package sistema;

/**
 * Representação de uma aposta assegurada por valor.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class TipoValor extends TipoSeguro {
    private final int valor;

    /**
     * Construtor de TipoValor.
     * 
     * @param valor valor que foi definido pelo apostador para ser seu seguro.
     */
    public TipoValor(int valor) {
        this.valor = valor;
    }

    /**
     * Implementação do método de TipoSeguro, para calcular o valor que deve
     * retornar ao bolso do apostador, caso perca.
     * 
     * @param valorApostado valor apostado pelo apostador perdedor.
     * @return valor que deve retornar ao apostador perdedor.
     */
    @Override
    public int valorAssegurado(int valorApostado) {
        return valor;
    }
    
    /**
     * Sobrescrita do toString().
     * 
     * @return representação em string do tipo de seguro em valor.
     */
    @Override
    public String toString() {
        String valorReais = String.format("%,.2f", valor / 100.0);
        return "ASSEGURADA (VALOR) - R$" + valorReais;
    }
}
