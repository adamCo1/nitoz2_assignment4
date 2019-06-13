package Event;

public class User {
    private String username;
    private String force;
    private double rank;

    public User(String username, String force,double rank) {
        this.username = username;
        this.force = force;
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public boolean equals(Object o){

        if(!(o instanceof User)){
            return false;
        }

        return this.username.equals(((User) o).username);
    }

    public String getForce() {
        return force;
    }

    public double getRank() {
        return rank;
    }
}
