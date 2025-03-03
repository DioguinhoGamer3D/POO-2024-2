package br.ufpb.dcx.diogo.lojaroupas;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProgramaGravacao {
    public static void main(String [] args){

        Roupa r1 = new Roupa("444", "calça rosa", Tamanho.G, 10);
        Roupa r2 = new Roupa("888", "bermuda azul", Tamanho.M, 2);

        List<Roupa> roupas = new LinkedList<>();
        roupas.add(r1);
        roupas.add(r2);

        GravadorDeRoupas gravadorDeRoupas = new GravadorDeRoupas();
        System.out.println("Recuperando roupas...");
        try {
            Collection<Roupa> roupasAchadas = gravadorDeRoupas.recuperaRoupas();
            System.out.println("Roupas achadas:");
            for (Roupa r: roupasAchadas){
                System.out.println(r.toString());
            }

            gravadorDeRoupas.gravaRoupas(roupas);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
