import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

/**
 * Clase Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de mapa:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        int mapType = scanner.nextInt();
        scanner.nextLine();

        Map<String, Pokemon> pokemonMap = MapFactory.createMap(mapType);
        Manager manager = new Manager(pokemonMap);

        try {
            manager.loadPokemon("pokemon_data_pokeapi.csv"); 
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            scanner.close();
            return;
        }

        int option = 0;
        while (option != 6) { 
            System.out.println("\nOperaciones disponibles:");
            System.out.println("1. Agregar un Pokémon a la colección");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar colección del usuario ordenada por tipo 1"); 
            System.out.println("4. Mostrar todos los Pokémon ordenados por tipo 1");
            System.out.println("5. Mostrar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String name = scanner.nextLine();
                    manager.addPokemonToCollection(name);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    name = scanner.nextLine();
                    manager.pokemonData(name);
                    break;
                case 3:
                    manager.collectionByType1();
                    break;
                case 4:
                    manager.pokemonsByType1();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = scanner.nextLine();
                    manager.pokemonAbility(ability);
                    break;
                case 6:
                    System.out.println("Adio :(.)");
                    break;
                default:
                    System.out.println("Opción no válida.");
                scanner.close();
            }
        }
    }
}