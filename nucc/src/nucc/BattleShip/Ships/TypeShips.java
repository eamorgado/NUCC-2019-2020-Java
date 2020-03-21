package nucc.BattleShip.Ships;

/**
 * This enum object will store the types of ships
 * An enum is a special type of object in java that stores constants (final),
 *      to separate the constants we can use the comma, we can access the 
 *      constant with the dot operator TypeShips.CARRIER
 *  
 * like any object, it has a default constructor that can be set manually, in
 *      this case, each constant will have two values, the name and the size,
 *      when we declare a new constant we add the constructor parameters, for
 *      instance, CONSTANT(String,int)
 */
public enum TypeShips{
    CARRIER("Carrier",5),
    BATTLESHIP("Battleship",4),
    SUBMARINE("Submarine",3),
    DESTROYER("Destroyer",2);

    private String name;
    private int size;

    private TypeShips(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName(){return this.name;}
    public int getSize(){return this.size;}
    
    @Override
    public String toString(){return "["+this.name+","+this.size+"]";}
}