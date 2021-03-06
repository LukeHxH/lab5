package sistema;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControleTest {
    
    public ControleTest() {}
    
    @Test(expected = IllegalArgumentException.class)
    public void testeInicializaCaixaInvalida() {
        Controle controle = new Controle(-30, 0.05);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testeInicializaTaxaInvalida() {
        Controle controle = new Controle(30000, -69);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCadastraCenarioDescricaoNula() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastraCenarioDescricaoInvalida1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("        ");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastraCenarioDescricaoInvalida2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("");
    }
    
    @Test
    public void testCadastraCenario1() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        
        int dois = 
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
                        
        assertEquals(2, dois);
    }
    
    @Test
    public void testCadastraCenario2() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
                        
        assertEquals("1 - Lucas vai beber mais de 3 litros de água. - Nao "
                + "finalizado", controle.buscaCenario(1));
    }
    
    @Test
    public void testCadastraCenarioBonus() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("O dado vai tirar mais que 3", 10000);
        
        assertEquals("1 - O dado vai tirar mais que 3 - Nao finalizado - "
                + "R$ 100,00", controle.buscaCenario(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBuscaCenario1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        controle.buscaCenario(0);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testBuscaCenario2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        controle.buscaCenario(3);
    }
    
    @Test
    public void testBuscaCenario3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        assertEquals("2 - Lucas vai beber mais de 3 litros de água. "
                + "- Nao finalizado" , controle.buscaCenario(2));
    }

    @Test
    public void testTodosCenarios1() {
        Controle controle = new Controle(100000, 0.01);
        assertEquals("Cenarios: \n", controle.todosCenarios());
    }
    
    @Test
    public void testTodosCenarios2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Nenhum aluno vai passar por média.");
        controle.cadastraCenario("Vão cantar alo alo marciano.");
        controle.fecharAposta(2, true);
        controle.fecharAposta(3, false);
        assertEquals("Cenarios: \n"
                + "1 - Todos os alunos vão passar por média. - Nao finalizado\n"
                + "2 - Nenhum aluno vai passar por média. - Finalizado (ocorreu)"
                + "\n3 - Vão cantar alo alo marciano. - Finalizado (n ocorreu)\n"
                , controle.todosCenarios());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testCadastrarApostaCenarioNaoExiste() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(2, "Lucas", 9000, "vai acontecer");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, null, 9000, "vai acontecer");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 9000, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 0, "vai acontecer");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta4() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 10, "aloka");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta5() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "    ", 10, "vai acontecer");
    }
    
    @Test
    public void testCadastrarAposta6() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertTrue(controle.cadastrarAposta(1, "Lucas", 10, "n vai acontecer"));
    }
    
    @Test
    public void testCadastrarAposta7() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertTrue(controle.cadastrarAposta(1, "Lucas", 10, "vai acontecer"));
    }
    
    @Test
    public void testValorTotalApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 200, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 200, "n vai acontecer");
        assertEquals(1400, controle.valorTotalDeApostas(1));
    }
    
    @Test
    public void testValorTotalApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.valorTotalDeApostas(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValorTotalApostas3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.valorTotalDeApostas(0);
    }
    
    @Test
    public void testQtdApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.qtdApostas(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testQtdApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.qtdApostas(0);
    }
    
    @Test
    public void testQtdApostas3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 200, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 200, "n vai acontecer");
        assertEquals(4, controle.qtdApostas(1));
    }
    
    @Test
    public void exibeApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer");
        assertNotNull(controle.exibeApostas(1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void exibeApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer");
        controle.exibeApostas(0);
    }
    
    @Test
    public void testFechaApostaTodoMundoAcertou() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        controle.fecharAposta(1, false);
        assertEquals(0, controle.getTotalRateioCenario(1));
        assertEquals(0, controle.getCaixaCenario(1));
    }
    
    @Test
    public void testFechaApostaTodoMundoErrou() {
        Controle controle = new Controle(100000, 0.05);
        controle.cadastraCenario("Hollow Knight vai ganhar melhor jogo indie.");
        controle.cadastrarAposta(1, "Matheus", 1000, "vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "vai acontecer");
        controle.cadastrarAposta(1, "Grace VanderWaal", 698, "vai acontecer");
        controle.fecharAposta(1, false); // mas merecia.
        assertEquals(2269, controle.getTotalRateioCenario(1));
        assertEquals(119, controle.getCaixaCenario(1));
    }
    
    @Test
    public void testCriaCenarioBonus() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        assertEquals(99000, controle.getCaixa());
    }
    
    @Test
    public void testCriaCenarioBonusComApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(1, "José", 1000, "n vai acontecer", 0.05, 500);
        controle.cadastrarAposta(1, "Maciel", 2000, "n vai acontecer");
        assertEquals(100400, controle.getCaixa());
    }
    
    @Test
    public void testCriaCenarioBonusComApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(1, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(1, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(1, "Maciel", 2000, "n vai acontecer");
        controle.fecharAposta(1, true);
        assertEquals(100330, controle.getCaixa());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAlteraApostaValor1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer");
        controle.alterarSeguroValor(1, 1, 100);
    }
    
    @Test
    public void testAlteraApostaValor2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer", 0.1, 6000);
        controle.alterarSeguroValor(1, 1, 100);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAlteraApostaTaxa1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer");
        controle.alterarSeguroTaxa(1, 1, 0.05);
    }
    
    @Test
    public void testAlteraApostaTaxa2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(1, "Lucas", 1981, "vai acontecer", 100, 6000);
        controle.alterarSeguroTaxa(1, 1, 0.05);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testOrdenacaoInvalida1() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.exibirCenarioOrdenado(0);
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testOrdenacaoInvalida2() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.exibirCenarioOrdenado(2);
    }
    
    @Test
    public void testOrdenacaoInicial1() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        assertEquals("1 - PUBG vai ganhar GOTY kkkkkkkkk. - Nao finalizado", 
                controle.exibirCenarioOrdenado(1));
    }
    
    @Test
    public void testOrdenacaoInicial2() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        assertEquals("2 - Flamengo vai passar da fase de grupos da "
                + "libertadores. - Nao finalizado - R$ 10,00", 
                controle.exibirCenarioOrdenado(2));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void alteraOrdenacaoInvalida() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        controle.alterarOrdem("alo jujuba");
    }
    
    @Test
    public void alteraOrdenacao1() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        controle.alterarOrdem("apostas");
        assertEquals("1 - PUBG vai ganhar GOTY kkkkkkkkk. - Nao finalizado", 
                controle.exibirCenarioOrdenado(1));
    }
    
    @Test
    public void alteraOrdenacao2() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        controle.alterarOrdem("apostas");
        assertEquals("2 - Flamengo vai passar da fase de grupos da "
                + "libertadores. - Nao finalizado - R$ 10,00", 
                controle.exibirCenarioOrdenado(2));
    }
    
    @Test
    public void alteraOrdenacao3() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        controle.alterarOrdem("nome");
        assertEquals("2 - Flamengo vai passar da fase de grupos da "
                + "libertadores. - Nao finalizado - R$ 10,00", 
                controle.exibirCenarioOrdenado(1));
    }
    
    @Test
    public void alteraOrdenacao4() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("PUBG vai ganhar GOTY kkkkkkkkk.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer");
        controle.cadastrarAposta(1, "Escobar", 1000, "n vai acontecer");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer");
        controle.cadastrarAposta(1, "Lucas", 72000, "n vai acontecer");
        
        controle.cadastraCenario("Flamengo vai passar da fase de grupos da "
                + "libertadores.", 1000);
        controle.cadastrarAposta(2, "Lucas", 1981, "vai acontecer");
        controle.cadastrarAposta(2, "Matheus", 6000, "vai acontecer", 1000, 900);
        controle.cadastrarAposta(2, "José", 1000, "n vai acontecer", 0.1, 500);
        controle.cadastrarAposta(2, "Maciel", 2000, "n vai acontecer");
        
        controle.alterarOrdem("nome");
        assertEquals("1 - PUBG vai ganhar GOTY kkkkkkkkk. - Nao finalizado", 
                controle.exibirCenarioOrdenado(2));
    }
}
