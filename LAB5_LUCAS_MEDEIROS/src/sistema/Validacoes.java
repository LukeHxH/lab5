package sistema;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Classe para realizar a validação de dados que serão utilizados no sistema.
 * 
 * @author Lucas de Medeiros Nunes Fernandes
 */
public class Validacoes {
    
    /**
     * Método para fazer validação de uma string.
     * 
     * @param string string a ser validada.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public void validaString(String string, String msg) {
        if (string == null || string.trim().isEmpty())
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
     */
    public void validaPrevisao(String previsao) {
        if (!(previsao.trim().toUpperCase().equals("VAI ACONTECER") ||
                previsao.trim().toUpperCase().equals("N VAI ACONTECER")))
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
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
    public String validaCenario(ArrayList<Cenario> cenarios, int cenario, 
            String msg) {
        validaNumeroMenorIgualZero(cenario, msg + ": Cenario invalido");
        
        for (Cenario c: cenarios) {
            if(c.getNumeracao() == cenario)
                return c.toString();
        }
        
        throw new NoSuchElementException(msg + ": Cenario nao cadastrado");
        
    }
}
