package sistema;

/**
 * Representação abstrata de uma aposta assegurada feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ApostaSegura extends Aposta {
    
    private TipoSeguro tipo;
    
    private Validator val = new Validator();
    
    /**
     * Construtor de ApostaSegura.
     * 
     * @param apostador nome do apostador.
     * @param previsao previsão de aposta.
     * @param centavosAposta valor, em centavos, da aposta.
     * @param id id da aposta segura.
     * @param tipo tipo de seguro a ser aplicado na aposta.
     */
    public ApostaSegura(String apostador, String previsao, int centavosAposta,
            int id, TipoSeguro tipo) {
        super(apostador, previsao, centavosAposta, id);
        
        val.validaObjetoNulo(tipo, "Erro no cadastro de aposta segura: Tipo "
                + "nulo ou invalido.");
        
        this.tipo = tipo;
    }

    /**
     * Método setter para o tipo de seguro, que pode ser alterado.
     * 
     * @param tipo tipo de tipo realizado.
     */
    public void setSeguro(TipoSeguro tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método que define o quanto o usuário vai ganhar, caso perca a aposta
     * (varia de acordo com o tipo de aposta escolhida).
     * 
     * @return o quanto uma aposta perdedora deve ser reembolsada.
     */
    public int valorAsseguradoEmDerrota() {
        return tipo.valorAssegurado(getCentavosAposta());
    }
    
    /**
     * Sobrescrita do método toString().
     * 
     * @return representação em string de uma aposta assegurada(com o nome do 
     * apostador, valor em reais do quanto foi apostado, a previsão e o tipo de
     * seguro, com o valor assegurado.)
     */
    @Override
    public String toString() {
        return super.toString() + " - " + tipo.toString();
    }
    
    /**
     * Sobrescrita do método equals() de aposta segura.
     * 
     * @param obj objeto a ser comparado com essa instância.
     * @return <tt>true</tt> se os objetos forem iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApostaSegura other = (ApostaSegura) obj;
        return this.getId() == other.getId();
    }

    /**
     * Sobrescrita do método hashCode() de aposta segura.
     * 
     * @return hashCode do id.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.getId();
        return hash;
    }
}
