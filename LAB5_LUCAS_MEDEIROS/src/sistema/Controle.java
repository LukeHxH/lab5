package sistema;

import java.util.ArrayList;

/**
 * Representação da classe que controla o sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Controle {
    private int caixa;
    private double taxa;
    private ArrayList<Cenario> cenarios;
    
    private Validator val = new Validator();

    /**
     * Construtor de Controle.
     * 
     * @param caixa o valor de caixa inicial.
     * @param taxa o valor da taxa inicial.
     */
    public Controle(int caixa, double taxa) {
        val.validaNumeroMenorZero(caixa, "Erro na inicializacao: Caixa "
                + "nao pode ser inferior a 0");
        
        val.validaNumeroMenorZero(taxa, "Erro na inicializacao: Taxa nao"
                + " pode ser inferior a 0");
        
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
        val.validaString(descricao, "Erro no cadastro de cenario: "
                + "Descricao nao pode ser vazia");
        
        int numeracao = (cenarios.size() + 1);
        if (cenarios.add(new Cenario(numeracao, descricao)))
            return numeracao;
        
        return -1;
    }
    
    /**
     * Método para cadastrar um novo cenário com bônus definido.
     * 
     * @param descricao descrição do cenário cadastrado.
     * @param bonus valor do bonus a ser aplicado ao cenário.
     * @return numeração do novo cenário cadastrado, <tt>-1</tt> se não foi 
     * possível cadastrar.
     */
    public int cadastraCenario(String descricao, int bonus) {
        int numeracao = (cenarios.size() + 1);
        
        CenarioBonus cenarioBonus = new CenarioBonus(numeracao, descricao, bonus);
        
        if (cenarios.add(cenarioBonus)){
            caixa -= bonus;
            
            return numeracao;
        }
        
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
        return val.verificaCenarioEhValido(cenarios, cenario, "Erro na consulta de "
                + "cenario");
    }
    
    /**
     * Método para listar todos os cenários cadastrados no sistema.
     * 
     * @return representação em string de todos os cenários cadastrados.
     */
    public String todosCenarios() {
        String strCenarios = "Cenarios: " + System.lineSeparator();
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
        val.validacaoAposta(apostador, previsao, valor, cenarios, cenario,
                "Erro no cadastro de aposta");
        
        return cenarios.get(cenario - 1).criaAposta(apostador, previsao, valor);
    }
    
    /**
     * Método para cadastrar uma nova aposta assegurada por valor.
     * 
     * @param cenario numeração do cenário a se cadastrar a aposta;.
     * @param apostador nome do apostador.
     * @param valor valor em centavos da aposta.
     * @param previsao previsão do apostador sobre o fim do cenário.
     * @param valorSeguro valor a ser assegurado.
     * @param custo custo do seguro.
     * @return <tt>true</tt> se foi a aposta foi devidamente cadastrada no
     * sistema.
     */
    public int cadastrarAposta(int cenario, String apostador, int valor,
            String previsao, int valorSeguro, int custo) {
        val.validacaoAposta(apostador, previsao, valor, cenarios, cenario,
                "Erro no cadastro de aposta assegurada por valor");
        
        caixa += custo;
        
        return cenarios.get(cenario - 1).criaAposta(apostador, previsao, valor,
                valorSeguro);
    }
    
    /**
     * Método para cadastrar uma nova aposta assegurada por taxa.
     * 
     * @param cenario numeração do cenário a se cadastrar a aposta;.
     * @param apostador nome do apostador.
     * @param valor valor em centavos da aposta.
     * @param previsao previsão do apostador sobre o fim do cenário.
     * @param taxaSeguro taxa a ser assegurada.
     * @param custo custo do seguro.
     * @return <tt>true</tt> se foi a aposta foi devidamente cadastrada no
     * sistema.
     */
    public int cadastrarAposta(int cenario, String apostador, int valor,
            String previsao, double taxaSeguro, int custo) {
        val.validacaoAposta(apostador, previsao, valor, cenarios, cenario,
                "Erro no cadastro de aposta assegurada por taxa");
        
        caixa += custo;
        
        return cenarios.get(cenario - 1).criaAposta(apostador, previsao, valor,
                taxaSeguro);
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
        val.validaNumeroMenorIgualZero(apostaAssegurada, 
                "Erro na alteraçao de seguro valor: Aposta invalida");
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na alteraçao de...");
        
        return cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
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
        val.validaNumeroMenorIgualZero(apostaAssegurada, 
                "Erro na alteraçao de seguro taxa: Aposta invalida");
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na alteraçao de...");
        
        return cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
    }
    
    /**
     * Método para mostrar, em centavos, quanto dinheiro foi apostado em um
     * cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return valor monetário, em centavos, total apostado em um cenário.
     */
    public int valorTotalDeApostas(int cenario) {
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na consulta do valor "
                + "total de apostas");
        
        return cenarios.get(cenario - 1).valorTotalApostas();
    }
    
    /**
     * Método para retornar a quantidade de apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return quantidade de apostas feitas em um cenário.
     */
    public int qtdApostas(int cenario) {
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na consulta do total "
                + "de apostas");
        
        return cenarios.get(cenario - 1).totalApostas();
    }
    
    /**
     * Método para exibir todas as apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return a representação em string das apostas feitas em um cenário.
     */
    public String exibeApostas(int cenario) {
        buscaCenario(cenario);
        
        return cenarios.get(cenario - 1).getTodasApostas();
    }
    
    /**
     * Método para finalizar um cenário, fechando uma aposta.
     * 
     * @param cenario numeração do cenário a ser finalizado.
     * @param ocorreu booleano que representa se o evento representado pelo
     * cenário ocorreu na vida real.
     */
    public void fecharAposta(int cenario, boolean ocorreu) {
        val.verificaCenarioEhValido(cenarios, cenario, "Erro ao fechar aposta");
        
        Cenario c = cenarios.get(cenario -1);
        
        val.verificaApostaFechada(c, "Erro ao fechar aposta: Cenario "
                    + "ja esta fechado");

        c.finalizaCenario(ocorreu);

        c.definirValorCaixa(taxa);

        caixa += getCaixaCenario(cenario);
        caixa -= c.valorApostasSeguras();
    }
    
    /**
     * Método para retornar o caixa do cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return o valor total, em centavos, do quanto que o caixa possui.
     */
    public int getCaixaCenario(int cenario) {
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na consulta do caixa do "
                + "cenario");
        
        Cenario c = cenarios.get(cenario - 1);

        if (c.getStatus().toLowerCase().equals("nao finalizado"))
            throw new IllegalArgumentException("Erro na consulta do caixa do "
                    + "cenario: Cenario ainda esta aberto");
        
        return c.getCaixa();
    }
    
    /**
     * Método para pegar o rateio total, que deve ser distribuído entre os
     * vencedores.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return o valor total, em centavos, do rateio que será distribuído.
     */
    public int getTotalRateioCenario(int cenario) {
        val.verificaCenarioEhValido(cenarios, cenario, "Erro na consulta do total de "
                + "rateio do cenario");
        
        Cenario c = cenarios.get(cenario - 1);

        if (c.getStatus().toLowerCase().equals("nao finalizado"))
            throw new IllegalArgumentException("Erro na consulta do total de "
                    + "rateio do cenario: Cenario ainda esta aberto");
        
        return (c.totalRateio());
    }
}