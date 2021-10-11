import java.util.*;
import java.util.stream.Collectors;

public class League {

    private List<Team> teams = Arrays.asList(
            new Team("Chelsea", 5),
            new Team("Manchester City", 4),
            new Team("Arsenal", 3),
            new Team("Manchester United", 13),
            new Team("Tottenham Hotspur", 0),
            new Team("Blackburn Rovers", 1),
            new Team("Leicester City", 1)
    );

    public List<Team> getTeams() {
        return teams;
    }

    public List<Team> teamsSortedByVictories() {
        return teams.stream()
                // Den første er skrevet bare som en øvelse
                // .sorted((o2, o1) -> Integer.compare(o1.getVictories(), o2.getVictories()))
                .sorted(Comparator.comparing(Team::getVictories).reversed())
                .collect(Collectors.toList());
    }
}
