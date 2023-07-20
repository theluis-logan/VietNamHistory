package model.account;
public class AccountDTO {
    private int id ;
    private String username ;
    private String email ;
    private String password ;
    private int role ;
    private int score ;
    private int rank ;
    private boolean status ;

    public AccountDTO() {
    }

    public AccountDTO(int id, String username, String email, String password, int role, int score, int rank, boolean status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.score = score;
        this.rank = rank;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", role=" + role + ", score=" + score + ", rank=" + rank + ", status=" + status + '}';
    }
}
