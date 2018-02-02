package sistema;

/**
 *
 * @author lucasmnf
 */
public class TipoValor extends ApostaSegura {
    
    private final int valor;

    public TipoValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int perderAposta(int valorApostado) {
        return valorApostado - valor;
    }

}
