package nucc.BattleShip.Ships;

import nucc.BattleShip.Results.State;
import nucc.BattleShip.Ships.TypeShips;


public class Ship{
    private TypeShips type;
    private int lives;
    
    public Ship(){}
    private Ship(TypeShips type){this.type = type;}
    public Ship(String name){
        switch(name){
            case "Carrier": type = TypeShips.CARRIER; break;
            case "Battleship": type = TypeShips.BATTLESHIP; break;
            case "Submarine": type = TypeShips.SUBMARINE; break;
            case "Destroyer": type = TypeShips.DESTROYER; break;
        }
        lives = type.getSize();
    }
    public String getName(){return type.getName();}
    public int getSize(){return type.getSize();}
    @Override
    public String toString() {return "{Ship: "+type+", Lives: "+lives+"}";}

    public void hit(){
        if(lives > 0){
            System.out.println("Nice! "+this.getName()+" was hit");
            lives--;
            return;
        }
        System.out.println("Ship destroyed");
    }
    public State getState(){
        return (lives == 0)? State.DESTROYED
                : (lives < this.getSize())? State.DAMAGED
                : State.MISS; 
    }

    public Ship[] generateStream(){
        Ship[] ships = new Ship[TypeShips.values().length]; int i = 0;
        for(TypeShips types: TypeShips.values())
            ships[i++] = new Ship(types);
        return ships;
    }
}