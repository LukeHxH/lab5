package sistema;


/**
 * Representação de uma aposta assegurada por valor feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ApostaAsseguradaPorValor extends Aposta{
    
    public ApostaAsseguradaPorValor(String apostador, String previsao, 
            int centavosAposta) {
        super(apostador, previsao, centavosAposta);
    }
    
}
