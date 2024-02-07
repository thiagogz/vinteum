package com.example;

public class Computador extends Jogador{

    @Override
    public boolean Parou() {
        return this.getPontos() > 16;
    }
    
}
