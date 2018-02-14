package sistema;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe para realizar a validação de dados que serão utilizados no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Validator {
    
    /**
     * Método para fazer validação de uma string.
     * 
     * @param str string a ser validada.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaString(String str, String msg) {
        if (str == null || str.trim().isEmpty())
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método que valida um número menor ou igual a zero.
     * 
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaNumeroMenorIgualZero(int num, String msg) {
        if (num <= 0)
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método que valida um número menor do que zero.
     * 
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaNumeroMenorZero(double num, String msg) {
        if (num < 0)
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método para validar uma previsão feita por uma aposta em determinado 
     * cenário.
     * 
     * @param previsao previsão feita pela aposta.
     * @param msg mensagem de erro.
     */
    public void validaPrevisao(String previsao, String msg) {
        if (!(previsao.trim().toUpperCase().equals("VAI ACONTECER") ||
                previsao.trim().toUpperCase().equals("N VAI ACONTECER")))
            throw new IllegalArgumentException(msg + ": "
                        + "Previsao invalida");
    }
    
    /**
     * Método para validar um objeto, se ele é nulo ou não.
     * 
     * @param o objeto a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaObjetoNulo(Object o, String msg) {
        if (o == null)
            throw new NullPointerException(msg);
    }
    
    /**
     * Método para fazer verificações de cenário.
     * 
     * @param cenarios lista de cenarios.
     * @param cenario id do cenario.
     * @param msg mensagem de erro.
     * @return representação em string do cenario, caso exista.
     */
    public String verificaCenarioEhValido(ArrayList<Cenario> cenarios, int cenario, 
            String msg) {
        validaNumeroMenorIgualZero(cenario, msg + ": Cenario invalido");
        
        for (Cenario c: cenarios) {
            if(c.getNumeracao() == cenario)
                return c.toString();
        }
        
        throw new NoSuchElementException(msg + ": Cenario nao cadastrado");
        
    }
    
    /**
     * Método para fazer a validação do fechamento de um cenário.
     * 
     * @param c cenário a ser validado.
     * @param msg mensagem de erro.
     */
    public void verificaApostaFechada(Cenario c, String msg) {
        if (!estadoAposta(c))
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método para fazer a verificação se uma aposta é assegurada ou não.
     * 
     * @param a aposta a ser verificada.
     * @param msg mensagem de erro.
     */
    public void verificaApostaSegura(Aposta a, String msg) {
        if (!(a instanceof ApostaSegura))
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método para a validação de uma aposta (seja assegurada, ou não).
     * @param apostador nome do apostador.
     * @param previsao previsão de aposta.
     * @param centavosAposta valor, em centavos, da aposta.
     * @param cenarios lista dos cenários cadastrados no sistema.
     * @param cenario id do cenário.
     * @param msg mensagem de erro.
     */
    public void validacaoAposta(String apostador, String previsao, 
        int centavosAposta, ArrayList<Cenario> cenarios, int cenario, String msg) {
        
        verificaCenarioEhValido(cenarios, cenario, msg);
        
        validaString(apostador, msg +": " + "Apostador nao pode ser vazio ou nulo");
        
        validaString(previsao, msg +": " + "Previsao nao pode ser vazia ou nula");
        
        validaNumeroMenorIgualZero(centavosAposta, msg + ": Valor nao pode ser "
                + "menor ou igual a zero");
        
        validaPrevisao(previsao, msg);
    }
    
    /**
     * Métod para verificar o estado de um cenário.
     * @param c
     * @return 
     */
    private boolean estadoAposta(Cenario c) {
        return c.getStatus().toLowerCase().equals("nao finalizado");
    }
}
