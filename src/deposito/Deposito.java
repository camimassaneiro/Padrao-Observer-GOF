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
public class Deposito extends Observado {

    private int qtdadeAtual;
    private int qtdadeCritica;
    private int qtdadeMax;
    private String mensagem;
    //private List <Observador> observadores = new ArrayList<>();

    public Deposito() {

    }
    private static Deposito INSTANCE;

    // Lazy initialization
    public static Deposito getINSTANCE() {
        if (INSTANCE == null) { // Double check, melhor desempenho
            synchronized (Deposito.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Deposito();
                }
            }
        }
        return INSTANCE;
    }

    public Deposito(int qtdadeCritica, int qtdadeMax) {
        this.qtdadeCritica = qtdadeCritica;
        this.qtdadeMax = qtdadeMax;
    }

    private int qntAdicionada;

    public void add(int qtdade) throws Exception {

        if ((qtdade + qtdadeAtual) > qtdadeMax) {
            this.qtdadeAtual = qtdadeMax;
            mensagem = "Armazenado " + (qtdade - qtdadeMax) + " de armazenar mais que o permitido";
            throw new Exception(mensagem);
        } else {
            qtdadeAtual += qtdade;
            mensagem = "Adicionado";
        }
        qntAdicionada = qtdade;

        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
            obs.atualizarQntAtual(qtdadeAtual);
        }
    }

    private int qntRetirada;

    public int retirar(int qtdade) throws Exception {

        if (qtdade > qtdadeAtual) {
            if (qtdadeAtual == 0) {
                mensagem = "Sem estoque";
            } else {
                qntRetirada = qtdadeAtual;
                qtdadeAtual -= qtdadeAtual;
                mensagem = "Retirado " + qntRetirada + " Cuidado sem estoque";                
            }
            throw new Exception(mensagem);

        } else {
            
            qtdadeAtual -= qtdade;
            qntRetirada = qtdade;
            if(qtdadeAtual < qtdadeCritica){
                throw new Exception("Retirado " + qntRetirada + " mas chegou no estado critico");
            }
            
            mensagem = "Retirado, quantidade atual: " + qtdadeAtual;

        }
        for (Observador obs : observadores) {
            obs.atualizar(mensagem);
            obs.atualizarQntRetirada(qtdadeAtual);
        }
        return qntRetirada;
    }

    public int getQtdadeAtual() {
        return qtdadeAtual;
    }

    public void setQtdadeAtual(int qtdadeAtual) {
        this.qtdadeAtual = qtdadeAtual;
    }

    public int getQtdadeCritica() {
        return qtdadeCritica;
    }

    public void setQtdadeCritica(int qtdadeCritica) {
        this.qtdadeCritica = qtdadeCritica;
    }

    public int getQtdadeMax() {
        return qtdadeMax;
    }

    public void setQtdadeMax(int qtdadeMax) {
        this.qtdadeMax = qtdadeMax;
    }

    public int getQntAdicionada() {
        return qntAdicionada;
    }

    public int getQntRetirada() {
        return qntRetirada;
    }

}
