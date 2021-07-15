package br.edu.ifpb;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 08:32:17
 */
public abstract class Item {

    private String categoria;
    private double preco;
    private String descricao;

    Item(String categoria,String descricao,double preco) {
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
    }

    public double preco() {
        return this.preco;
    }

    String categoria() {
        return this.categoria;
    }

//    public abstract double taxas();// {
//        if ("eletrônico".equals(this.categoria())) { //20%
//            return this.preco() * 0.2;
//        }
//        if ("comida".equals(this.categoria())) { //10%
//            return this.preco() * 0.1;
//        }
//        if ("bebida".equals(this.categoria())) { //0%
//            return this.preco() * 0.0;
//        }
//        return 0;
//    }

}
