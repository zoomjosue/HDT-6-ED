import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Manager {
    private Map<String, Pokemon> pokemonMap;
    private Set<String> userCollection;

    /**
     * Constructor
     * @param pokemonMap
     */
    public Manager(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.userCollection = new HashSet<>();  
    }

    /**
     * Constructor vacio para pruebas unitarias
     */
    public Manager() {
        this.pokemonMap = new HashMap<>();
        this.userCollection = new HashSet<>();
    }
    
    /**
     * Cargar los datos de los Pokémon desde un archivo CSV
     * @param filename
     * @throws FileNotFoundException
     */
    public void loadPokemon(String filename) throws FileNotFoundException {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line = br.readLine(); // Saltar la primera línea
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Expresión regular para manejar comas dentro de comillas

            if (data.length < 10) {
                System.out.println("Error: línea inválida en el archivo CSV.");
                continue;
            }

            try {
                String name = data[0].trim();
                int pokedexNumber = Integer.parseInt(data[1].trim());
                String type1 = data[2].trim();
                String type2 = data.length > 3 ? data[3].trim() : ""; 
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());

                List<String> abilities = Arrays.asList(data[7].replace("\"", "").trim().split(", ")); // Quitar comillas y dividir correctamente
                
                int generation = Integer.parseInt(data[8].trim());
                boolean isLegendary = data[9].trim().equalsIgnoreCase("Yes");

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, 
                                              height, weight, abilities, generation, isLegendary);
                pokemonMap.put(pokemon.getName(), pokemon);
            } catch (NumberFormatException e) {
                System.out.println("Error: formato inválido en el archivo CSV. Línea ignorada.");
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }
}

    /**
     * Agregar un Pokémon a la colección del usuario
     * @param name
     */
    public void addPokemonToCollection(String name) {
        if (pokemonMap.containsKey(name)) {
            if (userCollection.contains(name)) {
                System.out.println("El Pokémon ya está en tu colección.");
            } else {
                userCollection.add(name);
                System.out.println("Pokémon añadido a tu colección.");
            }
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    /**
     * Mostrar los datos de un Pokémon
     * @param name
     */
    public void pokemonData(String name) {
        if (pokemonMap.containsKey(name)) {
            System.out.println(pokemonMap.get(name));
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    /**
     * Mostrar la colección del usuario ordenada su tipo 1
     */
    public void collectionByType1() {
        List<Pokemon> userPokemon = new ArrayList<>();
        for (String name : userCollection) {
            userPokemon.add(pokemonMap.get(name));
        }
        userPokemon.sort(Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : userPokemon) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    /**
     * Mostrar todos los Pokémon ordenados su tipo 1
     */
    public void pokemonsByType1() {
        List<Pokemon> allPokemon = new ArrayList<>(pokemonMap.values());
        allPokemon.sort(Comparator.comparing(Pokemon::getType1));
        for (Pokemon pokemon : allPokemon) {
            System.out.println(pokemon.getName() + " - " + pokemon.getType1());
        }
    }

    /**
     * Mostrar todos los Pokémon que tienen una habilidad específica
     * @param ability
     */
    public void pokemonAbility(String ability) {
        for (Pokemon pokemon : pokemonMap.values()) {
            if (pokemon.getAbilities().contains(ability)) {
                System.out.println(pokemon.getName());
            }
        }
    }

    /**
     * Getters
     * @return
     */
    public Map<String, Pokemon> getPokemonMap() {
        return pokemonMap;
    }
}