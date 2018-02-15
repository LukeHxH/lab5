package sistema;

/**
 * Representação em interface de um tipo de seguro em uma aposta assegurada 
 * feita no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public interface TipoSeguro {
    
    /**
     * Método que será implementado nas classes TipoTaxa e TipoValor, que vai
     * variar o cálculo de acordo com o tipo de aposta segura feita.
     * 
     * @param valorApostado valor apostado pelo apostador perdedor.
     * @return valor que deve retornar ao apostador perdedor.
     */
    public int valorAssegurado(int valorApostado);
}