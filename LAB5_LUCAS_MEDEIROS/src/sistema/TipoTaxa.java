package sistema;

/**
 *
 * @author lucasmnf
 */
public class TipoTaxa extends ApostaSegura {
    
    private final double taxa;

    public TipoTaxa(double taxa) {
        this.taxa = taxa;
    }

    @Override
    public int perderAposta(int valorApostado) {
        return (int)(valorApostado * taxa);
    }

}
