class ListaDuplamenteEncadeada {

	private Celula primeiro;
	private Celula ultimo;
	private int tamanho;
	
	public ListaDuplamenteEncadeada() {
		
		Celula sentinela;
		
		sentinela = new Celula();
		
		primeiro = sentinela;
		ultimo = sentinela;
		
		tamanho = 0;
	}
	
	public boolean listaVazia() {
		
		boolean resp;
		
		if (primeiro == ultimo)
			resp = true;
		else
			resp = false;
		
		return resp;
	}
	
	public void inserirFim(Jogador jogador) {
		
		Celula novaCelula;
		
		novaCelula = new Celula(jogador);
		
		ultimo.setProximo(novaCelula);
		novaCelula.setAnterior(ultimo);
		
		ultimo = novaCelula;
		
		tamanho++;		
	}
	
	public void inserir(Jogador jogador, int posicao) {
		if (posicao < 0 || posicao > tamanho) {
	        throw new IllegalArgumentException("Posição inválida");
	    }

	    if (posicao == 0) {
	        inserirInicio(jogador);
	    } else if (posicao == tamanho) {
	        inserirFim(jogador);
	    } else {
	        Celula novaCelula = new Celula(jogador);
	        Celula celulaAtual = primeiro;
	        int contador = 0;

	        while (contador < posicao - 1) {
	            celulaAtual = celulaAtual.getProximo();
	            contador++;
	        }

	        Celula proximaCelula = celulaAtual.getProximo();
	        novaCelula.setProximo(proximaCelula);
	        proximaCelula.setAnterior(novaCelula);
	        celulaAtual.setProximo(novaCelula);
	        novaCelula.setAnterior(celulaAtual);

	        tamanho++;
	    }
	}
	
	public void inserirInicio(Jogador jogador) {
		Celula novaCelula = new Celula(jogador);
	    if (primeiro == null) {
	        primeiro = novaCelula;
	        ultimo = novaCelula;
	    } else {
	        novaCelula.setProximo(primeiro);
	        primeiro.setAnterior(novaCelula);
	        primeiro = novaCelula;
	    }
	    tamanho++;	
	}
	
	public Jogador removerInicio() throws Exception {
		if (listaVazia()) {
	        throw new Exception("Não foi possível remover o primeiro item da lista: a lista está vazia!");
	    }
	    Celula removida = primeiro;
	    if (primeiro == ultimo) {
	        primeiro = null;
	        ultimo = null;
	    } else {
	        Celula proximaCelula = primeiro.getProximo();
	        proximaCelula.setAnterior(null);
	        primeiro.setProximo(null);
	        primeiro = proximaCelula;
	    }
	    tamanho--;
	    return removida.getItem();	
	}
	
	public Jogador remover(int posicao) throws Exception{
		if (posicao < 0 || posicao >= tamanho) {
	        throw new IllegalArgumentException("Posição inválida");
	    }

	    if (posicao == 0) {
	        return removerInicio();
	    } else if (posicao == tamanho - 1) {
	        return removerFinal();
	    } else {
	        Celula celulaRemovida;
	        Celula celulaAnterior = primeiro;
	        int contador = 0;

	        while (contador < posicao - 1) {
	            celulaAnterior = celulaAnterior.getProximo();
	            contador++;
	        }

	        celulaRemovida = celulaAnterior.getProximo();
	        Celula celulaProxima = celulaRemovida.getProximo();
	        celulaAnterior.setProximo(celulaProxima);
	        celulaProxima.setAnterior(celulaAnterior);

	        tamanho--;

	        return celulaRemovida.getItem();
	    }
	}
	public Jogador removerFinal() throws Exception {	
		Celula removida, penultima;
		if (! listaVazia()) {
			
			removida = ultimo;
			
			penultima = ultimo.getAnterior();
			penultima.setProximo(null);
			removida.setAnterior(null);
			
			ultimo = penultima;
			
			tamanho--;
			
			return (removida.getItem());
		} else
			throw new Exception("Não foi possível remover o último item da lista: a lista está vazia!");
	}
	
	public void imprimir() throws Exception {
		Celula aux;
		if (! listaVazia()) {
			System.out.println("Conteúdo da lista:");
			aux = primeiro.getProximo();
			while (aux != null) {
				aux.getItem().imprimir();
				aux = aux.getProximo();
			}	
		} else
			throw new Exception("Não foi possível imprimir o conteúdo da lista: a lista está vazia!");
	}
}