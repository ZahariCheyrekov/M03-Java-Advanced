package M03_JavaAdvanced.L06_DefiningClasses.Exercises.T06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.numOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setNumOfBadges() {
        this.numOfBadges++;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }

    public int pokeCollectionSize() {
        return this.pokemons.size();
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

    public int getNumOfBadges() {
        return numOfBadges;
    }
}