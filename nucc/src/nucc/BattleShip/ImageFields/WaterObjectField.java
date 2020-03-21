package nucc.BattleShip.ImageFields;

import nucc.BattleShip.Results.State;
import nucc.BattleShip.ImageFields.GameObjectField;

public class WaterObjectField implements GameObjectField{ //no constructor ==> default
    private boolean cell_hit = false;
    @Override
    public char getIcon(){return cell_hit? 'M' : '~';}

    @Override
    public State objectShotAt(){
        cell_hit = true;
        return State.MISS;
    }
}