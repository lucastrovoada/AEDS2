class Celula {
    private Jogador jogador;
    private Celula anterior;
    private Celula proximo;

    public Celula(Jogador novo) {
        jogador = novo;
        anterior = null;
        proximo = null;
    }

    public Celula() {
        jogador = new Jogador();
        anterior = null;
        proximo = null;
    }

    public Jogador getItem() {
        return jogador;
    }

    public void setItem(Jogador jogador) {
        this.jogador = jogador;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
}
