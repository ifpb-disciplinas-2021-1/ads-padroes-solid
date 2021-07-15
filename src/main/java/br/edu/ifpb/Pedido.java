package br.edu.ifpb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 08:25:29
 */
public class Pedido {

    private final List<Item> itens = new ArrayList<>();
    private final LocalDate criadoEm;

    public Pedido(LocalDate criadoEm) {
        this.criadoEm = criadoEm;
    }

    public double total() {
        return this.subTotal() + this.taxas();
    }

    public double subTotal() {
        return this.itens.stream()
            .mapToDouble(Item::preco)
            .sum();
    }

    public double taxas() {
        return itens.stream()
            .map(AplicaTaxas::new)
            .mapToDouble(item -> item.taxas(criadoEm))
            .sum();
    }
    
    void adicionar(Item item) {
        this.itens.add(item);
    }
}
