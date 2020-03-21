package nucc.BattleShip.Results;
/**
 * This is an enum object that stores the shoot events
 */
public enum State{
    MISS(-1), 
    DAMAGED(0), 
    DESTROYED(1);

    private String name;
    private char icon;
    private State(int type){
        switch(type){
            case 0: name = "Damaged"; icon = 'O'; break;
            case 1: name = "Destroyed"; icon = 'O'; break;
            default: name = "Miss"; icon = 'X'; break;
        }
    }
    public String getName(){return name;}
    public char getIcon(){return icon;}
}