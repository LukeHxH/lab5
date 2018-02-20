package sistema;

import java.util.Comparator;

/**
 * Representação de uma ordanação do cenário pela numeração (cadastro).
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class ComparatorCenarioCadastro implements Comparator<Cenario> {

    @Override
    public int compare(Cenario c1, Cenario c2) {
        return c1.getNumeracao() - c2.getNumeracao();
    }
    
}
