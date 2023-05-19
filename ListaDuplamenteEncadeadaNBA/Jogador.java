

class Jogador {
	private int id;
    private String name;
    private int height;
    private int weight;
    private String university;
    private int birthYear;
    private String birthCity;
    private String birthCountry;

    public Jogador(int id, String name, int height, int weight, String university, int birthYear, String birthCity, String birthCountry){
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.university = university;
        this.birthYear = birthYear;
        this.birthCity = birthCity;
        this.birthCountry = birthCountry;
    }

    Jogador() {}

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

    public Jogador clonePlayer(){
        return new Jogador(id, name, height, weight, university, birthYear, birthCity, birthCountry);
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
    
    
    public void imprimir() {
	       System.out.printf("[%d ## %s ## %d ## %d ## %s ## %d ## %s ## %s]\n", id, name, height, weight, university,
	               birthYear, birthCity, birthCountry);
	   }
    
    public void writeFile() {
        System.out.printf("[id %d ## nome %s ## altura %s ## peso %s ## anoN %s ## Uni %s ## CidadeN %s ## EstadoN %s]\n"
                ,getId(), getName(), getHeight(), getWeight(), getBirthYear(),
                getUniversity(), getBirthCity(), getBirthCountry());
    }
    
    
    
	

}
