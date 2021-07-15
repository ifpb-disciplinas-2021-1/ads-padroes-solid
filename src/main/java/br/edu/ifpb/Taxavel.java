package br.edu.ifpb;

import java.time.LocalDate;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 15/07/2021, 09:23:01
 */
public interface Taxavel{
    public abstract double taxas(LocalDate date);
}
