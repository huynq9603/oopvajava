import java.util.*;

class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public int getHealth() {
        return health;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}

class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon p) {
        this.pokemons.add(p);
    }

    public void checkTournament(String element) {
        boolean hasElement = false;
        for (Pokemon p : pokemons) {
            if (p.getElement().equals(element)) {
                hasElement = true;
                break;
            }
        }
        if (hasElement) {
            numberOfBadges++;
        } else {
            for (Pokemon p : pokemons) {
                p.decreaseHealth(10);
            }
            pokemons.removeIf(p -> !p.isAlive());
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public int getNumberOfPokemons() {
        return pokemons.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Trainer> trainers = new LinkedHashMap<>();

        // Phase 1: Read trainer and Pokémon
        while (true) {
            String line = sc.nextLine();
            if (line.equals("Tournament")) break;

            String[] parts = line.split(" ");
            String trainerName = parts[0];
            String pokemonName = parts[1];
            String pokemonElement = parts[2];
            int pokemonHealth = Integer.parseInt(parts[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
        }

        // Phase 2: Handle tournaments
        while (true) {
            String element = sc.nextLine();
            if (element.equals("End")) break;

            for (Trainer trainer : trainers.values()) {
                trainer.checkTournament(element);
            }
        }

        // Phase 3: Sort and output
        List<Trainer> sorted = new ArrayList<>(trainers.values());
        sorted.sort((a, b) -> b.getNumberOfBadges() - a.getNumberOfBadges());

        for (Trainer t : sorted) {
            System.out.printf("%s %d %d\n", t.getName(), t.getNumberOfBadges(), t.getNumberOfPokemons());
        }
    }
}
