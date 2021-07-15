package br.edu.ifpb;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

public class AplicaTaxasTest {
    
    @Test
    public void testTaxas() {
        Item item = new Eletronico("televisão", 4000.0);
        AplicaTaxas calculadora = new AplicaTaxas(item);
        LocalDate hoje = LocalDate.now();
        double valorEsperado = 800.00;
        double taxas = calculadora.taxas(hoje);
        assertEquals(valorEsperado,taxas, 0);
    }
    @Test
    public void testTaxasEmOutubro() {
        Item item = new Eletronico("televisão", 4000.0);
        AplicaTaxas calculadora = new AplicaTaxas(item);
        LocalDate outubro = LocalDate.of(
            2021,Month.OCTOBER,1
        );
        double valorEsperado = 400.00;
        double taxas = calculadora.taxas(outubro);
        assertEquals(valorEsperado,taxas, 0);
    }
    
    
}
