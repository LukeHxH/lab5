package sistema;

/**
 * Representação de uma aposta assegurada por taxa feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ApostaAsseguradaPorTaxa extends Aposta {
    
    public ApostaAsseguradaPorTaxa(String apostador, String previsao,
            int centavosAposta) {
        super(apostador, previsao, centavosAposta);
    }
    
}
