package sistema;

/**
 * Representação de um cenário com bônus.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class CenarioBonus extends Cenario{
    
    private int bonus;
    
    public CenarioBonus(int numeracao, String descricao, int bonus) {
        super(numeracao, descricao);
        
        if (bonus <= 0)
            throw new IllegalArgumentException("Erro no cadastro de cenario: "
                    + "Bonus deve ser maior que 0.");
        
        this.bonus = bonus;
    }
    
    public void colocaBonusCaixa() {
        caixaCenario += bonus;
    }

    @Override
    public String toString() {
        String valorReais = String.format("%,.2f", bonus / 100.0);
        return getNumeracao() + " - " + getDescricao() + " - " + getStatus() 
                + " - R$ " + valorReais;
    }
    
    
}
