package br.ufpb.dcx.diogo.lojaroupas;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProgramaGravação {
    public static void main(String[] args){

        Roupa r1 = new Roupa("111", "calça jeans",Tamanho.M,1);
        Roupa r2 = new Roupa("222", "bermuda bege", Tamanho.M,2);

        List <Roupa> roupas = new LinkedList<>();
        roupas.add(r1);
        roupas.add(r2);
        GravadorDeRoupas gravadorDeRoupas= new GravadorDeRoupas();
        System.out.println("Recuperando roupas...");
        try{
            gravadorDeRoupas.gravaRoupas(roupas);
            Collection<Roupa> roupasachadas = gravadorDeRoupas.recuperaRoupas();
            for(Roupa r: roupasachadas){
                System.out.println(r.toString());
            }
            gravadorDeRoupas.gravaRoupas(roupas);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
