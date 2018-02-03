package sistema;

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
    public static void validaString(String string, String msg) {
        if (string == null || string.trim().isEmpty())
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método que valida um número menor ou igual a zero.
     * 
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public static void validaNumeroMenorIgualZero(int num, String msg) {
        if (num <= 0)
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método que valida um número menor do que zero.
     * 
     * @param num número a ser validado.
     * @param msg mensagem a ser exibida caso não passe na validação.
     */
    public static void validaNumeroMenorZero(double num, String msg) {
        if (num < 0)
            throw new IllegalArgumentException(msg);
    }
    
    /**
     * Método para validar uma previsão feita por uma aposta em determinado 
     * cenário.
     * 
     * @param previsao previsão feita pela aposta.
     */
    public static void validaPrevisao(String previsao) {
        if (!(previsao.trim().toUpperCase().equals("VAI ACONTECER") ||
                previsao.trim().toUpperCase().equals("N VAI ACONTECER")))
            throw new IllegalArgumentException("Erro no cadastro de aposta: "
                        + "Previsao invalida");
    }
}
