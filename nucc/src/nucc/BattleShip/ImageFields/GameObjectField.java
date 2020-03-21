package nucc.BattleShip.ImageFields;

import nucc.BattleShip.Results.State;

public interface GameObjectField{
    char getIcon();
    State objectShotAt();
}