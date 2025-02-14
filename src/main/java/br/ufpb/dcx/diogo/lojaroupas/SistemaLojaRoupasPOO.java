package br.ufpb.dcx.diogo.lojaroupas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas{

    private Map<String, Roupa> roupasMap;

    public SistemaLojaRoupasPOO(){
        this.roupasMap= new HashMap<>();
    }

    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        List<Roupa> RoupasTamanho = new ArrayList<>();
            for(Roupa r:roupasMap.values()){
                if(r.getTamanho()==tamanhoRoupa){
                    RoupasTamanho.add(r);
                }
            }
            return RoupasTamanho;
    }

    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao) {
        List<Roupa> RoupaDescricao=new ArrayList<>();
        for (Roupa r:roupasMap.values()){
            if(r.getDescricao().contains(prefixoDescricao)){
                RoupaDescricao.add(r);
            }
        }
        return RoupaDescricao;
    }

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if(roupasMap.containsKey(codigoRoupa)){
            Roupa t= this.roupasMap.get(codigoRoupa);
            return t.getTamanho();
        } else{
            throw new RoupaInexistenteException(("Não existe roupa com código"+codigoRoupa));
        }
    }

    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {
        if(this.roupasMap.containsKey(codigoRoupa)){
            throw new RoupaJaExisteException("Roupa já cadastrada: "+codigoRoupa);
        } else{
            Roupa roupa = new Roupa(codigoRoupa, descricao, tamanho, quantidade);
            this.roupasMap.put(codigoRoupa,roupa);
        }
    }

    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, String novaQuantidade) throws RoupaInexistenteException {
        if(roupasMap.containsKey(codigoRoupa)){
            Roupa qt= this.roupasMap.get(codigoRoupa);
            qt.setQuantidade(Integer.parseInt(novaQuantidade));
        } else{
            throw new RoupaInexistenteException("Não existe roupa com código"+codigoRoupa);
        }
    }

    public Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        if (roupasMap.containsKey(codigoRoupa)){
            for(Roupa r:roupasMap.values()){
                return r;
            }
        }
        throw new RoupaInexistenteException("Não existe roupa com código"+codigoRoupa);
    }
}
