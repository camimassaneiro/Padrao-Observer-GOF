/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public abstract class Observado {
     
    protected List <Observador> observadores = new ArrayList<>();
    
    public void add(Observador obs){
        observadores.add(obs);
    }
    public void remove(Observador obs){
        observadores.remove(obs);
    }
    /*public void notificar(String msg){
        for (Observador obs:observadores)
            obs.atualizar(msg);
    }*/
    
}
