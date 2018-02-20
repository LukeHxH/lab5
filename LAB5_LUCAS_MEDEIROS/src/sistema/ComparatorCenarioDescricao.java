package sistema;

import java.util.Comparator;

/**
 * Representação de uma ordanação do cenário pela descrição.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ComparatorCenarioDescricao implements Comparator<Cenario> {

    @Override
    public int compare(Cenario c1, Cenario c2) {
        return c1.getDescricao().compareTo(c2.getDescricao());
    }
    
}
