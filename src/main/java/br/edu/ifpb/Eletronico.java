package br.edu.ifpb;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 09:06:30
 */
public class Eletronico extends Item implements Taxavel{

    public Eletronico(String descricao,double preco) {
        super("eletrônico",descricao,preco);
    }

    @Override
    public double taxas(LocalDate date) {
        // BlackFriday
//        LocalDate localDate = LocalDate.now();
        if(Month.OCTOBER.equals(date.getMonth())){
            return this.preco() * 0.1;    
        }    
        return this.preco() * 0.2;
    }
}
