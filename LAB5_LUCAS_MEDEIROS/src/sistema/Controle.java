package sistema;

import java.util.ArrayList;

/**
 * Representação da classe controladora do sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Controle {
    private int caixa;
    private double taxa;
    private ArrayList<Cenario> cenarios;

    /**
     * Construtor de Controle.
     * 
     * @param caixa o valor de caixa inicial.
     * @param taxa o valor da taxa inicial.
     */
    public Controle(int caixa, double taxa) {
        if (caixa < 0 || taxa < 0)
            throw new IllegalArgumentException("Não são permitidos valores "
                    + "negativos nos campos de caixa inicial ou taxa.");
        
        this.caixa = caixa;
        this.taxa = taxa;
        cenarios = new ArrayList<>();
    }

    /**
     * Método acessório do valor de dinheiro disponível no caixa do sistema.
     * 
     * @return inteiro que representa o dinheiro disponível em centavos.
     */
    public int getCaixa() {
        return caixa;
    }
    
    /**
     * Método para cadastrar um novo cenário.
     * 
     * @param descricao descrição do cenário cadastrado.
     * @return numeração do novo cenário cadastrado, <tt>-1</tt> se não foi 
     * possível cadastrar.
     */
    public int cadastraCenario(String descricao) {
        int numeracao = (cenarios.size() + 1);
        if (cenarios.add(new Cenario(numeracao, descricao)))
            return numeracao;
        
        return -1;
    }
    
    /**
     * Método para buscar um cenário já cadastrado no sistema.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return representação em string do cenário, <tt>null</tt> se não existir
     * cenário cadastrado com essa numeração.
     */
    public String buscaCenario(int cenario) {
        for (Cenario c: cenarios) {
            if (c.getNumeracao() == cenario) {
                return c.toString();
            }
        }
        return null;
    }
    
    /**
     * Método para listar todos os cenários cadastrados no sistema.
     * 
     * @return representação em string de todos os cenários cadastrados.
     */
    public String todosCenarios() {
        String strCenarios = "Cenários: " + System.lineSeparator();
        for (Cenario cenario: cenarios) {
            strCenarios += cenario.toString() + System.lineSeparator();
        }
        
        return strCenarios;
    }
    
    /**
     * Método para cadastrar uma nova aposta.
     * 
     * @param cenario numeração do cenário a se cadastrar a aposta;.
     * @param apostador nome do apostador.
     * @param valor valor em centavos da aposta.
     * @param previsao previsão do apostador sobre o fim do cenário.
     * @return <tt>true</tt> se foi a aposta foi devidamente cadastrada no
     * sistema.
     */
    public boolean cadastrarAposta(int cenario, String apostador, int valor,
            String previsao) {
        if (buscaCenario(cenario) == null)
            return false;
        
        return cenarios.get(cenario - 1).
                adicionaAposta(apostador, previsao, valor);
    }
    
    /**
     * Método para mostrar, em centavos, quanto dinheiro foi apostado em um
     * cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return valor monetário, em centavos, total apostado em um cenário.
     */
    public int valorTotalDeApostas(int cenario) {
        if (buscaCenario(cenario) == null)
            return 0;
        
        return cenarios.get(cenario - 1).valorTotalApostas();
    }
    
    /**
     * Método para retornar a quantidade de apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return quantidade de apostas feitas em um cenário.
     */
    public int qtdApostas(int cenario) {
        if (buscaCenario(cenario) == null)
            return 0;
        
        return cenarios.get(cenario - 1).totalApostas();
    }
    
    /**
     * Método para exibir todas as apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return a representação em string das apostas feitas em um cenário.
     */
    public String exibeApostas(int cenario) {
        if (buscaCenario(cenario) == null)
            return "";
        
        return cenarios.get(cenario - 1).getTodasApostas();
    }
    
    // Em andamento...
    public void fecharAposta(int cenario, boolean ocorreu) {
        if (buscaCenario(cenario) != null) {
            Cenario c = cenarios.get(cenario -1);
            
            c.finalizaCenario(ocorreu);
            
            c.definirValorCaixa(taxa);
            
            this.caixa += getCaixaCenario(cenario);
        }
    }
    
    public int getCaixaCenario(int cenario) {
        if (buscaCenario(cenario) == null)
            return 0;
        
        return cenarios.get(cenario - 1).getCaixa();
    }
    
    public int getTotalRateio(int cenario) {
        if (buscaCenario(cenario) == null) 
            return 0;
        
        Cenario c = cenarios.get(cenario - 1);
        
        return (c.valorApostadoPerdedores() - c.getCaixa());
    }
}
