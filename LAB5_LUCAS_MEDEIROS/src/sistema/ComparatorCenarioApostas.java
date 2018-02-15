package sistema;

import java.util.Comparator;

/**
 *
 * @author lucasmnf
 */
public class ComparatorCenarioApostas implements Comparator<Cenario> {

    @Override
    public int compare(Cenario c1, Cenario c2) {
        return c1.totalApostas() - c2.totalApostas();
    }
    
}
