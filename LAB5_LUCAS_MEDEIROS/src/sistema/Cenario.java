package sistema;

import java.util.HashSet;

/**
 * Representação de um cenário disponível para aposta no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Cenario {
    private int numeracao;
    private String descricao;
    private String status;
    private HashSet<Aposta> apostas;
    private int caixaCenario;

    /**
     * Construtor de Cenario.
     * 
     * @param numeracao numeracao do cenário.
     * @param descricao descricao do cenário.
     */
    public Cenario(int numeracao, String descricao) {
        if (descricao.trim().isEmpty())
            throw new IllegalArgumentException("Erro no cadastro de cenario: "
                    + "Descricao nao pode ser vazia");
        
        this.descricao = descricao;
        this.numeracao = numeracao;
        this.status = "Nao finalizado";
        this.apostas = new HashSet<>();
        this.caixaCenario = 0;
    }

    /**
     * Método acessório da numeração de um cenário.
     * 
     * @return numeração do cenário.
     */
    public int getNumeracao() {
        return numeracao;
    }

    /**
     * Método acessório do status de um cenário.
     * 
     * @return status atual do cenário (finalizado ou não, e se ocorreu ou não).
     */
    public String getStatus() {
        return status;
    }

    /**
     * Método acessório do caixa final de um cenário.
     * 
     * @return total a ser adicionado ao caixa do sistema.
     */
    public int getCaixa() {
        return caixaCenario;
    }
    
    /**
     * Método para adicionar uma aposta no conjunto de apostas de um cenário.
     * 
     * @param apostador nome do apostador.
     * @param aposta previsão de aposta.
     * @param valor valor em centavos da aposta.
     * @return <tt>true</tt> se foi corretamente inserido.
     */
    public boolean adicionaAposta(String apostador, String aposta, int valor) {
        Aposta a = new Aposta(apostador, aposta, valor);
        
        return apostas.add(a);
    }
    
    /**
     * Método para mostrar, em centavos, quanto dinheiro foi apostado em um
     * cenário.
     * 
     * @return valor monetário, em centavos, total apostado em um cenário.
     */
    public int valorTotalApostas() {
        int soma = 0;
        
        for (Aposta a: apostas) {
            soma += a.getCentavosAposta();
        }
        
        return soma;
    }
    
    /**
     * Método para exibir todas as apostas feitas em um cenário.
     * 
     * @return a representação em string das apostas feitas em um cenário.
     */
    public String getTodasApostas() {
        String strApostas = "Apostas: " + System.lineSeparator();
        
        for (Aposta a: apostas) {
            strApostas += a.toString() + System.lineSeparator();
        }
        
        return strApostas;
    }
    
    /**
     * Método para retornar a quantidade de apostas feitas em um cenário.
     * 
     * @return tamanho do conjunto de apostas de um cenário.
     */
    public int totalApostas() {
        return apostas.size();
    }
    
    /**
     * Método para finalizar um cenário.
     * 
     * @param ocorreu booleano que representa se o evento representado pelo
     * cenário se concretizou na vida real ou não.
     */
    public void finalizaCenario(boolean ocorreu) {
        if (ocorreu)
            this.status = "Finalizado (ocorreu)";
        else
            this.status = "Finalizado (n ocorreu)";
        
        defineGanhadores(ocorreu);
    }
    
    /**
     * Método para definir as apostas vencedoras de um cenário.
     * 
     * @param ocorreu booleano que representa se o evento representado pelo
     * cenário se concretizou na vida real ou não.
     */
    private void defineGanhadores(boolean ocorreu) {
        for (Aposta a: apostas) {
            if (a.getPrevisao().trim().toUpperCase().equals("VAI ACONTECER"))
                a.setGanhou(ocorreu);
            else
                a.setGanhou(!ocorreu);
        }
    }
    
    /**
     * Retorna o quanto foi apostado pelos apostadores que perderam.
     * 
     * @return o valor, em centavos, apostado pelos apostadores perdedores.
     */
    public int valorApostadoPerdedores() {
        int soma = 0;
        for (Aposta a: apostas) {
            if (!(a.ganhou()))
                soma += a.getCentavosAposta();
        }
        return soma;
    }
    
    /**
     * Define o valor de caixa de um cenário, de acordo com os apostadores que
     * perderam.
     * 
     * @param taxa taxa do sistema.
     */
    public void definirValorCaixa(double taxa) {
        this.caixaCenario = (int) Math.floor(valorApostadoPerdedores() * taxa);
    }

    /**
     * Sobrescrição do método toString().
     * 
     * @return representação em string de um cenário (com numeração, descrição
     * e status do cenário).
     */
    @Override
    public String toString() {
        return numeracao + " - " + descricao + " - " + status;
    }

    /**
     * Sobrescrição do método hashCode().
     * 
     * @return hashCode da numeração.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.numeracao;
        return hash;
    }

    /**
     * Sobrescrição do método equals() de cenário.
     * 
     * @param obj objeto a ser comparado com essa instância.
     * @return <tt>true</tt> se os objetos forem iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cenario other = (Cenario) obj;
        return this.numeracao == other.numeracao;
    }    
}
