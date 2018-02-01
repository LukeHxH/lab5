package sistema;

/**
 *
 * @author lucasmnf
 */
public class CenarioBonus extends Cenario{
    
    private int bonus;
    
    public CenarioBonus(int numeracao, String descricao, int bonus) {
        super(numeracao, descricao);
        
        if (bonus <= 0)
            throw new IllegalArgumentException("Erro no cadastro de cenario: "
                    + "Bonus invalido.");
        
        this.bonus = bonus;
    }
    
}
