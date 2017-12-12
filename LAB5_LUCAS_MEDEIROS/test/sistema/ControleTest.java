/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lukehxh
 */
public class ControleTest {
    
    public ControleTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getCaixa method, of class Controle.
     */
    @Test
    public void testGetCaixa() {
        System.out.println("getCaixa");
        Controle instance = null;
        int expResult = 0;
        int result = instance.getCaixa();
        assertEquals(expResult, result);
    }

    /**
     * Test of cadastraCenario method, of class Controle.
     */
    @Test
    public void testCadastraCenario() {
        System.out.println("cadastraCenario");
        String descricao = "";
        Controle instance = null;
        int expResult = 0;
        int result = instance.cadastraCenario(descricao);
        assertEquals(expResult, result);
    }

    /**
     * Test of buscaCenario method, of class Controle.
     */
    @Test
    public void testBuscaCenario() {
        System.out.println("buscaCenario");
        int cenario = 0;
        Controle instance = null;
        String expResult = "";
        String result = instance.buscaCenario(cenario);
        assertEquals(expResult, result);
    }

    /**
     * Test of todosCenarios method, of class Controle.
     */
    @Test
    public void testTodosCenarios() {
        System.out.println("todosCenarios");
        Controle instance = null;
        String expResult = "";
        String result = instance.todosCenarios();
        assertEquals(expResult, result);
    }

    /**
     * Test of cadastrarAposta method, of class Controle.
     */
    @Test
    public void testCadastrarAposta() {
        System.out.println("cadastrarAposta");
        int cenario = 0;
        String apostador = "";
        int valor = 0;
        String previsao = "";
        Controle instance = null;
        boolean expResult = false;
        boolean result = instance.cadastrarAposta(cenario, apostador, valor, previsao);
        assertEquals(expResult, result);
    }

    /**
     * Test of valorTotalDeApostas method, of class Controle.
     */
    @Test
    public void testValorTotalDeApostas() {
        System.out.println("valorTotalDeApostas");
        int cenario = 0;
        Controle instance = null;
        int expResult = 0;
        int result = instance.valorTotalDeApostas(cenario);
        assertEquals(expResult, result);
    }

    /**
     * Test of qtdApostas method, of class Controle.
     */
    @Test
    public void testQtdApostas() {
        System.out.println("qtdApostas");
        int cenario = 0;
        Controle instance = null;
        int expResult = 0;
        int result = instance.qtdApostas(cenario);
        assertEquals(expResult, result);
    }

    /**
     * Test of exibeApostas method, of class Controle.
     */
    @Test
    public void testExibeApostas() {
        System.out.println("exibeApostas");
        int cenario = 0;
        Controle instance = null;
        String expResult = "";
        String result = instance.exibeApostas(cenario);
        assertEquals(expResult, result);
    }

    /**
     * Test of fecharAposta method, of class Controle.
     */
    @Test
    public void testFecharAposta() {
        System.out.println("fecharAposta");
        int cenario = 0;
        boolean ocorreu = false;
        Controle instance = null;
        instance.fecharAposta(cenario, ocorreu);
    }

    /**
     * Test of getCaixaCenario method, of class Controle.
     */
    @Test
    public void testGetCaixaCenario() {
        System.out.println("getCaixaCenario");
        int cenario = 0;
        Controle instance = null;
        int expResult = 0;
        int result = instance.getCaixaCenario(cenario);
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalRateioCenario method, of class Controle.
     */
    @Test
    public void testGetTotalRateioCenario() {
        System.out.println("getTotalRateioCenario");
        int cenario = 0;
        Controle instance = null;
        int expResult = 0;
        int result = instance.getTotalRateioCenario(cenario);
        assertEquals(expResult, result);
    }
    
}
