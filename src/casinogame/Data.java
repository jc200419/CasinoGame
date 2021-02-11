package casinogame;


public class Data {
    private String name;
    private String password;
    private int coins;

    public Data(String name, String password, int coins) {
        this.name = name;
        this.password = password;
        this.coins = coins;
    }
    public String toString(){
        return name + ", " + password + ", " + coins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
    
    
    
    
}
