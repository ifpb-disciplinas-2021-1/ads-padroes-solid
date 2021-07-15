package br.edu.ifpb;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Job
 */
public class PedidoTest {
    
    @Test
    public void testCalcularTotal() {
        Pedido pedido = new Pedido(
            LocalDate.now()
        );
        pedido.adicionar(new Eletronico("televisão", 3500.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        pedido.adicionar(new Comida("arroz", 2.65));
        double total = pedido.total(); //7802.91
        double esperado = 7802.91;
        assertEquals(total,esperado, 0.5);
    }
    @Test
    public void testCalcularTaxas() {
        Pedido pedido = new Pedido(
            LocalDate.now()
        );
        pedido.adicionar(new Eletronico("televisão", 3500.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        double total = pedido.taxas(); //1300.00
        double esperado = 1300.00;
        assertEquals(total,esperado, 0);
    }
    @Test
    public void testCalcularSubTotal() {
        Pedido pedido = new Pedido(
            LocalDate.now()
        );
        pedido.adicionar(new Eletronico("televisão", 3500.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        pedido.adicionar(new Comida("arroz", 2.65));
        double total = pedido.subTotal(); //6504.00
        double esperado = 6502.65;
        assertEquals(total,esperado, 0);
    }
    
     @Test
    public void testCalcularSubTotalComCategoria() {
        Pedido pedido = new Pedido(
            LocalDate.now()
        );
        pedido.adicionar(new Eletronico("televisão", 3500.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        pedido.adicionar(new Comida("arroz", 2.65));
//        pedido.adicionar(new Item("bebida","água", 1.35));
        pedido.adicionar(new Bebida("água", 1.35));
        double total = pedido.subTotal(); //6504.00
        double esperado = 6504.00; //6502.65
        assertEquals(total,esperado, 0);
    }
    @Test
    public void testCalcularTaxasComBebida() {
        Pedido pedido = new Pedido(
            LocalDate.now()
        );
        pedido.adicionar(new Eletronico("televisão", 3500.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        pedido.adicionar(new Comida("arroz", 2.65));
        pedido.adicionar(new Bebida("água", 1.35));
        double total = pedido.taxas(); //1300.00
        double esperado = 1300.26;
        assertEquals(total,esperado, 0.5);
    }
    
        @Test
    public void testCalcularTaxasComDesconto() {
        LocalDate october = LocalDate.of(2021,Month.OCTOBER,1);
        Pedido pedido = new Pedido(october);
        pedido.adicionar(new Eletronico("televisão", 4000.0));
        pedido.adicionar(new Eletronico("notebook", 3000.0));
        double total = pedido.taxas(); //700.00 - > 10%
        double esperado = 700.00;
        assertEquals(total,esperado, 0.5);
    }
}
