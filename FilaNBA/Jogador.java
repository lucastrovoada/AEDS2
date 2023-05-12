
import java.util.Scanner;

 class Jogador {
	   private String id;
	   private String nome;
	   private int altura;
	   private int peso;
	   private String universidade;
	   private String cidadeNascimento;
	   private String estadoNascimento;
	   private int anoNascimento;
	   public Jogador(String id, String nome, int altura, int peso, String universidade, String cidadeNascimento, String estadoNascimento, int anoNascimento) {	
		}
	   public Jogador() {
		   
	   }
		public String getId() {
	       return id;
	   }

	   public void setId(String id) {
	       this.id = id;
	   }

	   public String getNome() {
	       return nome;
	   }

	   public void setNome(String nome) {
	       this.nome = nome;
	   }

	   public int getAltura() {
	       return altura;
	   }

	   public void setAltura(int altura) {
	       this.altura = altura;
	   }

	   public int getPeso() {
	       return peso;
	   }

	   public void setPeso(int peso) {
	       this.peso = peso;
	   }

	   public String getUniversidade() {
	       return universidade;
	   }

	   public void setUniversidade(String universidade) {
	       this.universidade = universidade;
	   }

	   public String getCidadeNascimento() {
	       return cidadeNascimento;
	   }

	   public void setCidadeNascimento(String cidadeNascimento) {
	       this.cidadeNascimento = cidadeNascimento;
	   }

	   public String getEstadoNascimento() {
	       return estadoNascimento;
	   }

	   public void setEstadoNascimento(String estadoNascimento) {
	       this.estadoNascimento = estadoNascimento;
	   }

	   public int getAnoNascimento() {
	       return anoNascimento;
	   }

	   public void setAnoNascimento(int anoNascimento) {
	       this.anoNascimento = anoNascimento;
	   }
	   public Jogador clone() {
	       try {
	           return (Jogador) super.clone();
	       } catch (CloneNotSupportedException e) {
	           return null;
	       }
	   }

	   public static Jogador ler(Scanner entrada) {
	       String id = entrada.next();
	       if (id.equals("FIM")) {
	           return null;
	       }
	       String nome = entrada.next();
	       int altura = Integer.parseInt(entrada.next());
	       int peso = Integer.parseInt(entrada.next());
	       String universidade = entrada.next();
	       String cidadeNascimento = entrada.next();
	       String estadoNascimento = entrada.next();
	       int anoNascimento = Integer.parseInt(entrada.next());
	       return new Jogador(id, nome, altura, peso, universidade, cidadeNascimento, estadoNascimento, anoNascimento);
	   }

	   public void imprimir() {
	       System.out.printf("[%s ## %s ## %d ## %d ## %s ## %s ## %s ## %d]\n", id, nome, altura, peso, universidade,
	               cidadeNascimento, estadoNascimento, anoNascimento);
	   }
	}