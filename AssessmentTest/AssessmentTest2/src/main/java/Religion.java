public class Religion {
    private String name;
    private String origin;
    private int numberOfFollowers;

    public Religion(String name, String origin, int numberOfFollowers) {
        this.name = name;
        this.origin = origin;
        this.numberOfFollowers = numberOfFollowers;
    }

    public String describe() {
        String followers = String.format("%d million followers", numberOfFollowers/ 1000000);
        return name + " started in " + origin + " and has " + followers;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }
}
