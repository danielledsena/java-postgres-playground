package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static com.example.MathUtil.mdc;

public class MathUtilTest {
    @Test
    void testMdcP1BImpar() {
        int a = 6, b = 3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP1BPar() {
        int a = 6, b = 2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP3Negativo() {
        int a = -6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP3Positivo() {
        int a = 6, b = 0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP4() {
        int m = 2, a = 6, b = 3;
        int esperado = 6;
        int obtido = m * MathUtil.mdc(a, b);

        assertEquals(MathUtil.mdc(m * a, m * b), obtido);
        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP5Decrescente() {
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP5Crecente() {
        int a = 2, b = 6;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP7() {
        int a = 6, b = 2;
        int esperado = MathUtil.mdc(-a, b);
        int obtido = MathUtil.mdc(-a, -b);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP8Positivo() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP8Negativo() {
        int a = -6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP9() {
        int a = 6, b = 3, c = 2;

        assertTrue(mdc(a, mdc(b, c)) == mdc(mdc(a, b), c) && mdc(mdc(a, b), c) == mdc(a, b, c));
    }

    @Test
    void testMdcP12DoisPrimos() {
        int p = 7, a = p;
        int esperado = p;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    }

    @Test
    void testMdcP12UmPrimo() {
        int p = 7, a = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    } 

    @Test
    void testMdcP12PrimoEUm() {
        int p = 7, a = 1;
        int esperado = 1;
        int obtido = MathUtil.mdc(p, a);

        assertEquals(esperado, obtido);
    } 

    @Test
    void testMdcCasoGeral() {
        int a = 30, b = 12;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado, obtido);
    } 

    @Test
    void testMdc3Valores() {
        int a = 12, b = 6, c = 4;
        int esperado = 2;
        int obtido = mdc(a, b, c);

        assertEquals(esperado, obtido);
    } 

    @Test
    void testMdcNenhumValor() {
        assertThrows(IllegalArgumentException.class, MathUtil::mdc);
    } 

    @Test
    void testMdcNull() {
        var exception = assertThrows(NullPointerException.class, () -> mdc(null));
        var msgEsperada = "É necessário passar um valor diferente de nulo.";
        assertEquals(msgEsperada, exception.getMessage());
    }
}