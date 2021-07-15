package br.edu.ifpb;

import java.time.LocalDate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 11:09:59
 */
public class AplicaTaxas {

    private final Item item;

    public AplicaTaxas(Item item) {
        this.item = item;
    }

    public double calcula(LocalDate date) {
        if (taxavel(this.item)) {
            Taxavel taxavel = transformar(item);
            return taxavel.taxas(date);
        }
        return 0;
    }

    private boolean taxavel(Item item) {
        return item instanceof Taxavel;
    }

    private Taxavel transformar(Item item) {
        return (Taxavel) item;
    }
}
