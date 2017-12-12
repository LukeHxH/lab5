package sistema;

/**
 * Representação da fachada do sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Fachada {
    
    private Controle controlador;
    
    /**
     * Construtor de Fachada.
     */
    public Fachada(){}
    
    /**
     * Inicializador do sistema.
     * 
     * @param caixa o valor de caixa inicial.
     * @param taxa o valor da taxa inicial.
     */
    public void inicializa(int caixa, double taxa) {
        controlador = new Controle(caixa, taxa);
    }
    
    /**
     * Método acessório do valor de dinheiro disponível no caixa do sistema.
     * 
     * @return inteiro que representa o dinheiro disponível em centavos.
     */
    public int getCaixa() {
        return controlador.getCaixa();
    }
    
    /**
     * Método para cadastrar um novo cenário.
     * 
     * @param descricao descrição do cenário cadastrado.
     * @return numeração do novo cenário cadastrado, <tt>-1</tt> se não foi 
     * possível cadastrar.
     */
    public int cadastraCenario(String descricao) {
        return controlador.cadastraCenario(descricao);
    }
    
    /**
     * Método para buscar um cenário já cadastrado no sistema.
     * 
     * @param numeracao numeração do cenário a ser pesquisado.
     * @return representação em string do cenário, <tt>null</tt> se não existir
     * cenário cadastrado com essa numeração.
     */
    public String exibirCenario(int numeracao) {
        return controlador.buscaCenario(numeracao);
    }
    
    /**
     * Método para listar todos os cenários cadastrados no sistema.
     * 
     * @return representação em string de todos os cenários cadastrados.
     */
    public String exibirCenarios() {
        return controlador.todosCenarios();
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
    public boolean cadastraAposta(int cenario, String apostador, int valor,
            String previsao) {
        return controlador.cadastrarAposta(cenario, apostador, valor, previsao);
    }
    
    /**
     * Método para mostrar, em centavos, quanto dinheiro foi apostado em um
     * cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return valor monetário, em centavos, total apostado em um cenário.
     */
    public int valorTotalDeApostas(int cenario) {
        return controlador.valorTotalDeApostas(cenario);
    }
    
    /**
     * Método para retornar a quantidade de apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return quantidade de apostas feitas em um cenário.
     */
    public int totalDeApostas(int cenario) {
        return controlador.qtdApostas(cenario);
    }
    
    /**
     * Método para exibir todas as apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return a representação em string das apostas feitas em um cenário.
     */
    public String exibeApostas(int cenario) {
        return controlador.exibeApostas(cenario);
    }
    
    
    public void fecharAposta(int cenario, boolean ocorreu) {
        controlador.fecharAposta(cenario, ocorreu);
    }
}
