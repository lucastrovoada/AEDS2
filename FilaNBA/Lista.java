import java.util.Scanner;

class Lista {	
	private Jogador lista[];
	private int primeiro;
	private int ultimo;
	private int tamanho;	
	public Lista() {	
	}
	public Lista(int M) {
		lista = new Jogador[M];
		tamanho = 0;
		primeiro = 0;
		ultimo = 0;	
	}
	
	public boolean listaVazia() {
		boolean resp;
		if (primeiro == ultimo) {
			resp = true;				
			}else {
				resp = false;
			}
			return resp;
		}
	
	public boolean listaCheia() {
		boolean resp;
		if (ultimo == lista.length) {
			resp = true;				
			}else {
				resp = false;
			}
			return resp;
		}
	public void inserirInicio(Jogador jogador) {
		if(listaVazia() == true) {
			
			
			
			
		}
		
	}
	
	public void inserir(Jogador jogador, int posicao)throws Exception {
		if (! listaCheia()) {
			if ((posicao >= 0) && (posicao <= tamanho)) {
				for (int i = ultimo; i > posicao; i--)
					lista[i] = lista[i-1];	
				lista[posicao] = jogador;
				ultimo++;
				tamanho++;
			} else
				throw new Exception("Não foi possível inserir o item na lista: posição informada é inválida!");
		} else
			throw new Exception("Não foi possível inserir o item na lista: a lista está cheia!");
	}
		
	public void inserirFim(Jogador jogador) {
		
	}
	
	public Jogador removerInicio() {
		Jogador jogadorInicio = new Jogador();
		return jogadorInicio;	
	}
	
	public Jogador remover(int posicao) {
		Jogador jogadorPosicionado = new Jogador();
		return jogadorPosicionado;
		
	}
	
	public Jogador removerFim() {
		Jogador jogadorFinal = new Jogador();
		return jogadorFinal;	
	}
	public void mostrar() {	
		
		
	}
	
				}