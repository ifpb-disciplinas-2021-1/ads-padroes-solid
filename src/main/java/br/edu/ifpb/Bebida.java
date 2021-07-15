package br.edu.ifpb;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 09:11:43
 */
public class Bebida extends Item{

    public Bebida(String descricao,double preco) {
        super("bebida",descricao,preco);
    }

//    @Override
//    public double taxas() {
////        return this.preco() * 0.0;
//        throw new IllegalArgumentException("Não tenho taxas.");
//    }

}
