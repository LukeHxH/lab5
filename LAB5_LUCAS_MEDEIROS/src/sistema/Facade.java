package sistema;

import easyaccept.EasyAccept;

/**
 * Representação da fachada do sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Facade {
    
    private Controle controlador;
    
    /**
     * Método para o teste de aceitação.
     * 
     * @param args string com argumentos para o EasyAccept.
     */
    public static void main(String[] args) {
        args = new String[] {"sistema.Facade", "acceptance_tests/us1_test.txt",
        "acceptance_tests/us2_test.txt", "acceptance_tests/us3_test.txt",
        "acceptance_tests/us4_test.txt", "acceptance_tests/us5_test.txt",
        "acceptance_tests/us6_test.txt", "acceptance_tests/us7_test.txt"};
        EasyAccept.main(args);
    }
    
    /**
     * Inicializador do sistema, criando o controlador.
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
    public int cadastrarCenario(String descricao) {
        return controlador.cadastraCenario(descricao);
    }
    
    /**
     * Método para cadastrar um novo cenário com bonus.
     * 
     * @param descricao descrição do cenário cadastrado.
     * @param bonus valor do bonus a ser aplicado ao cenário.
     * @return numeração do novo cenário cadastrado, <tt>-1</tt> se não foi 
     * possível cadastrar.
     */
    public int cadastrarCenario(String descricao, int bonus) {
        return controlador.cadastraCenario(descricao, bonus);
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
    public boolean cadastrarAposta(int cenario, String apostador, int valor,
            String previsao) {
        return controlador.cadastrarAposta(cenario, apostador, valor, previsao);
    }
    
    /**
     * Método para cadastrar uma nova aposta assegurada por valor.
     * 
     * @param cenario numeração do cenário a se cadastrar a aposta;.
     * @param apostador nome do apostador.
     * @param valor valor em centavos da aposta.
     * @param previsao previsão do apostador sobre o fim do cenário.
     * @param valorAssegurado valor a ser assegurado.
     * @param custo custo do seguro.
     * @return <tt>true</tt> se foi a aposta foi devidamente cadastrada no
     * sistema.
     */
    public int cadastrarApostaSeguraValor(int cenario, String apostador,
            int valor, String previsao, int valorAssegurado, int custo) {
        return controlador.cadastrarAposta(cenario, apostador, valor, previsao, 
                valorAssegurado, custo);
    }
    
    /**
     * Método para cadastrar uma nova aposta assegurada por taxa.
     * 
     * @param cenario numeração do cenário a se cadastrar a aposta;.
     * @param apostador nome do apostador.
     * @param valor valor em centavos da aposta.
     * @param previsao previsão do apostador sobre o fim do cenário.
     * @param taxa taxa a ser assegurada.
     * @param custo custo do seguro.
     * @return <tt>true</tt> se foi a aposta foi devidamente cadastrada no
     * sistema.
     */
    public int cadastrarApostaSeguraTaxa(int cenario, String apostador,
            int valor, String previsao, double taxa, int custo) {
        return controlador.cadastrarAposta(cenario, apostador, valor, previsao, 
                taxa, custo);
    }
    
    /**
     * Método para alterar o tipo de aposta assegurada por taxa para valor.
     * 
     * @param cenario cenario que contém a aposta que será alterada.
     * @param apostaAssegurada id da aposta assegurada.
     * @param valor valor a ser passado.
     * @return id da aposta.
     */
    public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor){
        return controlador.alterarSeguroValor(cenario, apostaAssegurada, valor);
    }
    
    /**
     * Método para alterar o tipo de aposta assegurada por taxa para valor.
     * 
     * @param cenario cenario que contém a aposta que será alterada.
     * @param apostaAssegurada id da aposta assegurada.
     * @param taxa taxa a ser passada.
     * @return id da aposta.
     */
    public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa){
        return controlador.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
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
    
    /**
     * Método para alterar o método de ordenação dos cenários.
     * 
     * @param ordem string com a ordenação necessária.
     */
    public void alterarOrdem(String ordem) {
        controlador.alterarOrdem(ordem);
    }
    
    /**
     * Método para exibir o cenário ordenado de acordo com a última definição de
     * ordenação.
     * 
     * @param cenario posicao do cenario no array.
     * @return toString() do cenário procurado.
     */
    public String exibirCenarioOrdenado(int cenario) {
        return controlador.exibirCenarioOrdenado(cenario);
    }
    
    /**
     * Método para finalizar um cenário, fechando uma aposta.
     * 
     * @param cenario numeração do cenário a ser finalizado.
     * @param ocorreu booleano que representa se o evento representado pelo
     * cenário ocorreu na vida real.
     */
    public void fecharAposta(int cenario, boolean ocorreu) {
        controlador.fecharAposta(cenario, ocorreu);
    }
    
    /**
     * Método para retornar o caixa do cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return o valor total, em centavos, do quanto que o caixa possui.
     */
    public int getCaixaCenario(int cenario) {
        return controlador.getCaixaCenario(cenario);
    }
    
    /**
     * Método para pegar o rateio total, que deve ser distribuído entre os
     * vencedores.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return o valor total, em centavos, do rateio que será distribuído.
     */
    public int getTotalRateioCenario(int cenario) {
        return controlador.getTotalRateioCenario(cenario);
    }
}
