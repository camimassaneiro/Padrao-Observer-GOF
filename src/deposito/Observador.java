/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deposito;

/**
 *
 * @author camil
 */
public interface Observador {
    
    void atualizar(String msg);
    
    void atualizarQntAtual(int qntAtual);
    
    void qntAdd(int qntAdd);
    
    void atualizarQntRetirada(int qntRetirada);
    
    
}
