package sistema;


/**
 * Representação de uma aposta assegurada por valor feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ApostaAsseguradaPorValor extends Aposta{
    
    private int valor;
    
    public ApostaAsseguradaPorValor(String apostador, String previsao, 
            int centavosAposta, int valor) {
        super(apostador, previsao, centavosAposta);
        
        if (valor <= 0)
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Valor deve ser maior que 0.");
        
        this.valor = valor;
    }
    
    
    
}
