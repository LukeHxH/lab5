package sistema;

import java.util.Comparator;

/**
 * Representação de uma ordanação do cenário pelo total de apostas.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ComparatorCenarioApostas implements Comparator<Cenario> {

    @Override
    public int compare(Cenario c1, Cenario c2) {
        
        if (c1.totalApostas() == c2.totalApostas()) {
            if (c1.getNumeracao() < c2.getNumeracao()) {
                return -1;
            } else {
                return 1;
            }
        }
        
        return -1 * (c1.totalApostas() - c2.totalApostas());
    }
    
}
