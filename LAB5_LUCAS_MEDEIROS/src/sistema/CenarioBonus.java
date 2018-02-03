package sistema;

/**
 * Representação de um cenário com bônus.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class CenarioBonus extends Cenario {
    
    private int bonus;
    
    /**
     * Construtor de CenarioBonus.
     * 
     * @param numeracao numeracao do cenário.
     * @param descricao descricao do cenário.
     * @param bonus bônus do cenário.
     */
    public CenarioBonus(int numeracao, String descricao, int bonus) {
        super(numeracao, descricao);
        
        if (bonus <= 0)
            throw new IllegalArgumentException("Erro no cadastro de cenario: "
                    + "Bonus deve ser maior que 0.");
        
        this.bonus = bonus;
    }

    /**
     * Sobrescrita do método toString().
     * 
     * @return representação em string de um cenário com bônus (com numeração, 
     * descrição, status do cenário e o valor em reais do bônus).
     */
    @Override
    public String toString() {
        String valorReais = String.format("%,.2f", bonus / 100.0);
        return super.toString() + " - R$ " + valorReais;
    }

    /**
     * Sobrescrita do método totalRateio().
     * 
     * @return o total a ser rateado somado ao bônus definido ao cenário.
     */
    @Override
    public int totalRateio() {
        return super.totalRateio() + bonus;
    }
}