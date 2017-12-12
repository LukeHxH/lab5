package sistema;

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

    @Test(expected = NullPointerException.class)
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
    
    @Test()
    public void testCadastraCenario() {
        Controle controle = new Controle(100000, 0.01);
        
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        
        int dois = 
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
                        
        assertEquals(2, dois);
    }
    
    @Test
    public void testBuscaCenario1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        assertEquals(null, controle.buscaCenario(0));
    }
    
    @Test
    public void testBuscaCenario2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        assertEquals(null, controle.buscaCenario(3));
    }
    
    @Test
    public void testBuscaCenario3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Lucas vai beber mais de 3 litros de água.");
        assertEquals("2 - Lucas vai beber mais de 3 litros de água. "
                + "- Não finalizado" , controle.buscaCenario(2));
    }

    @Test
    public void testTodosCenarios1() {
        Controle controle = new Controle(100000, 0.01);
        assertEquals("Cenários: \n", controle.todosCenarios());
    }
    
    @Test
    public void testTodosCenarios2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastraCenario("Nenhum aluno vai passar por média.");
        controle.cadastraCenario("Vão cantar alo alo marciano.");
        controle.fecharAposta(2, true);
        controle.fecharAposta(3, false);
        assertEquals("Cenários: \n"
                + "1 - Todos os alunos vão passar por média. - Não finalizado\n"
                + "2 - Nenhum aluno vai passar por média. - Finalizado (ocorreu)"
                + "\n3 - Vão cantar alo alo marciano. - Finalizado (n ocorreu)\n"
                , controle.todosCenarios());
    }
    
    @Test
    public void testCadastrarApostaCenarioNaoExiste() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertFalse(controle.cadastrarAposta
                        (0, "Lucas", 9000, "vai acontecer!"));
    }
    
    @Test(expected = NullPointerException.class)
    public void testCadastrarAposta1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, null, 9000, "vai acontecer!");
    }
    
    @Test(expected = NullPointerException.class)
    public void testCadastrarAposta2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 9000, null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCadastrarAposta3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 0, "vai acontecer!");
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
        controle.cadastrarAposta(1, "    ", 10, "vai acontecer!");
    }
    
    @Test
    public void testCadastrarAposta6() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertTrue(controle.cadastrarAposta(1, "Lucas", 10, "n vai acontecer!"));
    }
    
    @Test
    public void testCadastrarAposta7() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertTrue(controle.cadastrarAposta(1, "Lucas", 10, "vai acontecer!"));
    }
    
    @Test
    public void testValorTotalApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer!");
        controle.cadastrarAposta(1, "Lucas", 200, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 200, "n vai acontecer!");
        assertEquals(1400, controle.valorTotalDeApostas(1));
    }
    
    @Test
    public void testValorTotalApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.valorTotalDeApostas(1));
    }
    
    @Test
    public void testValorTotalApostas3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.valorTotalDeApostas(0));
    }
    
    @Test
    public void testQtdApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.qtdApostas(1));
    }
    
    @Test
    public void testQtdApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        assertEquals(0, controle.qtdApostas(0));
    }
    
    @Test
    public void testQtdApostas3() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer!");
        controle.cadastrarAposta(1, "Lucas", 200, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 200, "n vai acontecer!");
        assertEquals(4, controle.qtdApostas(1));
    }
    
    @Test
    public void exibeApostas1() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer!");
        assertNotNull(controle.exibeApostas(1));
    }
    
    @Test
    public void exibeApostas2() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("Todos os alunos vão passar por média.");
        controle.cadastrarAposta(1, "Lucas", 900, "vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 100, "n vai acontecer!");
        assertNull(controle.exibeApostas(0));
    }
    
    @Test
    public void testFechaApostaTodoMundoAcertou() {
        Controle controle = new Controle(100000, 0.01);
        controle.cadastraCenario("PUBG vai ganhar GOTY KKKKKKKKKKKKKKKKKKKKK.");
        controle.cadastrarAposta(1, "Lucas", 150000, "n vai acontecer!");
        controle.cadastrarAposta(1, "Matheus", 1000, "n vai acontecer!");
        controle.cadastrarAposta(1, "Pablo", 690, "n vai acontecer!");
        controle.cadastrarAposta(1, "Lucas", 698741, "n vai acontecer!");
        controle.fecharAposta(1, false);
        assertEquals(0, controle.getTotalRateioCenario(1));
        assertEquals(0, controle.getCaixaCenario(1));
    }
    
    @Test
    public void testFechaApostaTodoMundoErrou() {
        Controle controle = new Controle(100000, 0.05);
        controle.cadastraCenario("Hollow Knight vai ganhar melhor jogo indie.");
        controle.cadastrarAposta(1, "Matheus", 1000, "vai acontecer!");
        controle.cadastrarAposta(1, "Pablo", 690, "vai acontecer!");
        controle.cadastrarAposta(1, "Grace VanderWaal", 698, "vai acontecer!");
        controle.fecharAposta(1, false);
        assertEquals(2269, controle.getTotalRateioCenario(1));
        assertEquals(119, controle.getCaixaCenario(1));
    }
}
