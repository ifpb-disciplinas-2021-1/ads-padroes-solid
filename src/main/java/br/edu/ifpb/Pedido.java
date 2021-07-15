package br.edu.ifpb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
//        double soma = 0;
//        for (Item item : itens) {
//            soma += item.preco();
//        }
//        return soma;
        return this.itens.stream()
            .mapToDouble(Item::preco)
            .sum();
    }

    public double taxas() {
//        double soma =0;
//        for (Item item : itens) {
//            if(item instanceof Taxavel){
//                Taxavel taxa = (Taxavel) item;
//                soma += taxa.taxas(this.criadoEm);
//            }
//                
//        }
//        return soma;

        return itens.stream()
            .filter(Pedido::taxavel)
            .map(Pedido::transformarItemEmTaxavel)
            .mapToDouble(item -> item.taxas(this.criadoEm))
            .sum();
    }

    
    void adicionar(Item item) {
        this.itens.add(item);
    }
    private static boolean taxavel(Item item) {
        return item instanceof Taxavel;
    }
    private static Taxavel transformarItemEmTaxavel(Item item) {
        return (Taxavel) item;
    }
}
