package br.edu.ifpb;

import java.time.LocalDate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 09:08:25
 */
public class Comida extends Item implements Taxavel{

    public Comida(String descricao,double preco) {
        super("comida",descricao,preco);
    }

    @Override
    public double taxas(LocalDate date) {
        return this.preco() * 0.1;
    }

}
