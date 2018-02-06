package sistema;

/**
 * Representação de uma aposta assegurada por taxa.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class TipoTaxa implements TipoSeguro {
    private final double taxa;

    /**
     * Construtor de TipoTaxa.
     * 
     * @param taxa taxa que foi definida pelo apostador para ser seu seguro.
     */
    public TipoTaxa(double taxa) {
        this.taxa = taxa;
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
        return (int)(Math.round(valorApostado * taxa));
    }

    /**
     * Sobrescrita do toString().
     * 
     * @return representação em string do tipo de seguro em taxa.
     */
    @Override
    public String toString() {
        return "ASSEGURADA (TAXA) - " + (taxa / 100) + "%";
    }
}
