package sistema;

import java.util.Comparator;

/**
 *
 * @author lucasmnf
 */
public class ComparatorCenarioCadastro implements Comparator<Cenario> {

    @Override
    public int compare(Cenario c1, Cenario c2) {
        return c1.getNumeracao() - c2.getNumeracao();
    }
    
}
