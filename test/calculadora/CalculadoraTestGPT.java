package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTestGPT {

    private Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // Testes da soma
    @Test
    void testSoma() {
        Assertions.assertEquals(5, calc.soma(2, 3));
        Assertions.assertEquals(0, calc.soma(0, 0));
        Assertions.assertEquals(-1, calc.soma(-2, 1));
        Assertions.assertEquals(-5, calc.soma(-2, -3));
    }

    // Testes da subtração
    @Test
    void testSubtracao() {
        Assertions.assertEquals(1, calc.subtracao(3, 2));
        Assertions.assertEquals(0, calc.subtracao(0, 0));
        Assertions.assertEquals(-3, calc.subtracao(-2, 1));
        Assertions.assertEquals(1, calc.subtracao(-2, -3));
    }

    // Testes da multiplicação
    @Test
    void testMultiplicacao() {
        Assertions.assertEquals(6, calc.multiplicacao(2, 3));
        Assertions.assertEquals(0, calc.multiplicacao(0, 5));
        Assertions.assertEquals(-6, calc.multiplicacao(-2, 3));
        Assertions.assertEquals(6, calc.multiplicacao(-2, -3));
    }

    // Testes da divisão
    @Test
    void testDivisao() {
        Assertions.assertEquals(2, calc.divisao(6, 3));
        Assertions.assertEquals(0, calc.divisao(0, 5));
        Assertions.assertEquals(-2, calc.divisao(-6, 3));
        Assertions.assertEquals(2, calc.divisao(-6, -3));
    }

    @Test
    void testDivisaoPorZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    // Testes da somatória
    @Test
    void testSomatoria() {
        Assertions.assertEquals(15, calc.somatoria(5)); // 0+1+2+3+4+5
        Assertions.assertEquals(0, calc.somatoria(0));
        Assertions.assertEquals(1, calc.somatoria(1));
        Assertions.assertEquals(0, calc.somatoria(-5)); // Caso negativo retorna 0
    }

    // Testes do ehPositivo
    @Test
    void testEhPositivo() {
        Assertions.assertTrue(calc.ehPositivo(5));
        Assertions.assertTrue(calc.ehPositivo(0));
        Assertions.assertFalse(calc.ehPositivo(-1));
    }

    // Testes da comparação
    @Test
    void testCompara() {
        Assertions.assertEquals(0, calc.compara(5, 5));
        Assertions.assertEquals(1, calc.compara(10, 5));
        Assertions.assertEquals(-1, calc.compara(3, 7));
    }
}
