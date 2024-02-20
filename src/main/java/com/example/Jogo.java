package com.example;

public class Jogo {

    protected Monte monte = new Monte();
    protected Jogador jogador = new Jogador();
    protected Computador computador = new Computador();

    public Jogo() {
        monte.embaralhar();
    }

    public Carta darCartaJogador(Jogador jogador) {
        //early return
        if(jogador.Parou()) return null;

        var carta = monte.virar();
        jogador.receberCarta(carta);
        return carta;
    }

    public boolean acabou(){
        var osDoisPararam = jogador.Parou() && computador.Parou();
        return osDoisPararam || jogador.estourou() || computador.estourou(); 
    }

    public String resultado(){
        var pontuacaoIgual = jogador.getPontos() == computador.getPontos();
        var osDoisEstouraram = jogador.estourou() && computador.estourou();
        var jogadorTemMaisPontos = jogador.getPontos() > computador.getPontos();

        if(pontuacaoIgual || osDoisEstouraram) return "Empate";

        if(!jogador.estourou() && (jogadorTemMaisPontos || computador.estourou())) return "Você ganhou!";

        return "Você perdeu!";
    }
}
