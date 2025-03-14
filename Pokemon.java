import java.util.List;

/**
 * Clase Pokemon
 */
public class Pokemon {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean isLegendary;

    /**
     * Contructor 
     * @param name nombre del pokemon
     * @param pokedexNumber numero en la pokedex
     * @param type1 Tipo primario del pokemon
     * @param type2 Tipo secundario del pokemon
     * @param classification Clasificacion del pokemon
     * @param height Estarua del pokemon (metros)
     * @param weight Peso del pokemon (kilogramos)
     * @param abilities Lista de habilidades del pokemon
     * @param generation Generacion del pokemon
     * @param legendaryStatus Estado de que si el pokemon el legendario o no
     */
    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification, double height, double weight, List<String> abilities, int generation, boolean isLegendary) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }

    /**
     * Getters
     * @return
     */
    public String getName() {
        return name;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClassification() {
        return classification;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean getisLegendary() {
        return isLegendary;
    }

    /**
     * Metodo toString
     * @return
     */
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", pokedexNumber=" + pokedexNumber +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", classification='" + classification + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities='" + abilities + '\'' +
                ", generation=" + generation +
                ", isLegendary='" + isLegendary + '\'' +
                '}';
    }
}