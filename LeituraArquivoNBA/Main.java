import java.io.*;
import java.sql.DatabaseMetaData;
import java.util.Objects;
import java.util.Scanner;

class ArquivoTextoLeitura {
    private BufferedReader entrada;
    ArquivoTextoLeitura(String nomeArquivo) {
        try {
            entrada = new BufferedReader(new InputStreamReader(
                    new FileInputStream(nomeArquivo), "UTF-8"));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado + " + nomeArquivo);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void fecharArquivo() {
        try {
            entrada.close();
        }
        catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " +
                    excecao);
        }
    }
    @SuppressWarnings("finally")
    public String ler() {
        String textoEntrada = "";
        try {
            textoEntrada = entrada.readLine();
        }
        catch (EOFException excecao) { //Excecao de final de arquivo.
            textoEntrada = null;
        }
        catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            textoEntrada = null;
        }
        finally {
            return textoEntrada;
        }
    }
}

class Player{
    private int id;
    private String name;
    private int height;
    private int weight;
    private String university;
    private int birthYear;
    private String birthCity;
    private String birthCountry;

    public Player(int id, String name, int height, int weight, String university, int birthYear, String birthCity, String birthCountry){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.university = university;
        this.birthYear = birthYear;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
    }

    Player() {}

    // GET
    public int getId(){return id;}
    public String getName(){return name;}
    public int getHeight(){return height;}
    public int getWeight(){return weight;}
    public String getUniversity(){return university;}
    public int getBirthYear(){return birthYear;}
    public String getBirthCity(){return birthCity;}
    public String getBirthCountry(){return birthCountry;}

    // SET
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setHeight(int height) {this.height = height;}
    public void setWeight(int weight) {this.weight = weight;}
    public void setUniversity(String university) {this.university = university;}
    public void setBirthYear(int birthYear) {this.birthYear = birthYear;}
    public void setBirthCity(String birthCity) {this.birthCity = birthCity;}
    public void setBirthCountry(String birthCountry) {this.birthCountry = birthCountry;}

    public Player clonePlayer(){
        return new Player(id, name, height, weight, university, birthYear, birthCity, birthCountry);
    }

    // ESCREVER EM ARQUIVO
    public void writeFile() {
        System.out.printf("[id %d ## nome %s ## altura %s ## peso %s ## anoN %s ## Uni %s ## CidadeN %s ## EstadoN %s]\n"
                ,getId(), getName(), getHeight(), getWeight(), getBirthYear(),
                getUniversity(), getBirthCity(), getBirthCountry());
    }

    public void lerPlayer(int id, String name, int height, int weight, String university, int birthYear, String birthCity, String birthCountry){
        setId(id);
        setName(name);
        setHeight(height);
        setWeight(weight);
        setUniversity(university);
        setBirthYear(birthYear);
        setBirthCity(birthCity);
        setBirthCountry(birthCountry);
    }


}

public class Main {
    static Player[] database = new Player[4000];

    public static Player createDatabase(String Line) {
        String[] arrOfPlayerData = Line.split(",", 8);

        Player player = new Player();

        player.lerPlayer(
                Integer.parseInt(arrOfPlayerData[0]), arrOfPlayerData[1], Integer.parseInt(arrOfPlayerData[2]),
                Integer.parseInt(arrOfPlayerData[3]), arrOfPlayerData[4], Integer.parseInt(arrOfPlayerData[5]),
                arrOfPlayerData[6], arrOfPlayerData[7]
        );

        for (int j = 0; j < arrOfPlayerData.length; j++) {
            if (arrOfPlayerData[j].isEmpty()) {
                arrOfPlayerData[j] = "não informado";
            }
        }

        return player;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productionFile = "/tmp/jogadores.txt";
        String devFile = "database.txt";

        ArquivoTextoLeitura file = new ArquivoTextoLeitura(devFile);
        String PlayerData = file.ler();

        // Realizar as buscas
        
        int numQueries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numQueries; i++) {
        	
            String playerId = scanner.nextLine();

            for (Player player : database) {
                PlayerData = file.ler();
                
                if (PlayerData == null || PlayerData.equals("FIM")) {
                    break;
                } else if (Objects.equals(player.getId(), playerId)) {
                    database[i] = createDatabase(PlayerData);
                }
                
            }
        }

        /**
         * for(int i = 0; i < database.length; i++) {
         *             PlayerData = file.ler();
         *             if(PlayerData == null || PlayerData.equals("FIM")){
         *                 break;
         *             }else {
         *                 database[i] = createDatabase(PlayerData);
         *             }
         *         }
         */
        
        scanner.close();
        file.fecharArquivo();

    }
}
