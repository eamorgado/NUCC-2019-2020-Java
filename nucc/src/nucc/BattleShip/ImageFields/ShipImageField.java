package nucc.BattleShip.ImageFields;

import nucc.BattleShip.Ships.Ship;
import nucc.BattleShip.Results.State;
import nucc.BattleShip.ImageFields.GameObjectField;

public class ShipImageField implements GameObjectField{
    private final Ship ship;

    public ShipImageField(Ship ship){this.ship = ship;}

    @Override
    public char getIcon(){
        State state = ship.getState();
        return (state != null)? state.getIcon() : ' ';
    }
    @Override
    public State objectShotAt(){
        ship.hit();
        return ship.getState();
    }
}