import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

public class TestPokemonManager {
    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager();
    }

    @Test
    void testLoadPokemonFromFile() {
        try {
            manager.loadPokemon("pokemon_data_pokeapi.csv");
            assertFalse(manager.getPokemonMap().isEmpty(), "El mapa de Pokémon no debe estar vacío después de cargar los datos.");
        } catch (FileNotFoundException e) {
            fail("El archivo CSV no fue encontrado.");
        }
    }

    @Test
    void testFindPokemon() {
        try {
            manager.loadPokemon("pokemon_data_pokeapi.csv");
            Pokemon pikachu = manager.getPokemonMap().get("Pikachu");
            assertNotNull(pikachu, "Pikachu debería existir en el mapa después de cargar los datos.");
            assertEquals(25, pikachu.getPokedexNumber(), "El número de Pokédex de Pikachu debería ser 25.");
        } catch (FileNotFoundException e) {
            fail("El archivo CSV no fue encontrado.");
        }
    }
}
