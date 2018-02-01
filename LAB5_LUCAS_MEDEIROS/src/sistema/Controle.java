package sistema;

import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        if (caixa < 0)
            throw new IllegalArgumentException("Erro na inicializacao: Caixa "
                    + "nao pode ser inferior a 0");
        
        if (taxa < 0)
            throw new IllegalArgumentException("Erro na inicializacao: Taxa nao"
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
            cenarioBonus.colocaBonusCaixa();
            
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
        if (cenario <= 0)
            throw new IllegalArgumentException("Erro na consulta de cenario: "
                    + "Cenario invalido");
        
        for (Cenario c: cenarios) {
            if (c.getNumeracao() == cenario) {
                return c.toString();
            }
        }
        
        throw new NoSuchElementException("Erro na consulta de cenario: Cenario "
                + "nao cadastrado");
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
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro no cadastro de aposta: "
                    + "Cenario nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                    + "Cenario invalido");
        }
        
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
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro na consulta do valor total "
                    + "de apostas: Cenario nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro na consulta do valor total"
                    + " de apostas: Cenario invalido");
        }
        
        return cenarios.get(cenario - 1).valorTotalApostas();
    }
    
    /**
     * Método para retornar a quantidade de apostas feitas em um cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return quantidade de apostas feitas em um cenário.
     */
    public int qtdApostas(int cenario) {
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro na consulta do total de "
                    + "apostas: Cenario nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro na consulta do total de "
                    + "apostas: Cenario invalido");
        }
        
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
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro ao fechar aposta: Cenario "
                    + "nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro ao fechar aposta: Cenario "
                    + "invalido");
        }
        
        Cenario c = cenarios.get(cenario -1);
        
        if (!(c.getStatus().toLowerCase().equals("nao finalizado")))
            throw new IllegalArgumentException("Erro ao fechar aposta: Cenario "
                    + "ja esta fechado");

        c.finalizaCenario(ocorreu);

        c.definirValorCaixa(taxa);

        caixa += getCaixaCenario(cenario);
    }
    
    /**
     * Método para retornar o caixa do cenário.
     * 
     * @param cenario numeração do cenário a ser pesquisado.
     * @return o valor total, em centavos, do quanto que o caixa possui.
     */
    public int getCaixaCenario(int cenario) {
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro na consulta do caixa do "
                    + "cenario: Cenario nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro na consulta do caixa do "
                    + "cenario: Cenario invalido");
        }
        
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
        try {
            buscaCenario(cenario);
        } catch (NoSuchElementException nsee) {
            throw new NoSuchElementException("Erro na consulta do total de "
                    + "rateio do cenario: Cenario nao cadastrado");
            
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException("Erro na consulta do total de "
                    + "rateio do cenario: Cenario invalido");
        }
        
        Cenario c = cenarios.get(cenario - 1);

        if (c.getStatus().toLowerCase().equals("nao finalizado"))
            throw new IllegalArgumentException("Erro na consulta do total de "
                    + "rateio do cenario: Cenario ainda esta aberto");
        
        return (c.valorApostadoPerdedores() - c.getCaixa());
    }
}
