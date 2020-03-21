package nucc.BattleShip.Validators;

import java.awt.*;
import nucc.BattleShip.ImageFields.GameObjectField;

public abstract class Validator{
    public boolean validateInsideBoard(int x, int y, int size){
        return x <= size && x >= 0 && y <= size && y >= 0;
    }
    public boolean validateStartPoint(Point from, int length, boolean horizontal,char wildcard,GameObjectField[][] board){
        int x_diff = horizontal? 1 : 0;
        int y_diff = !horizontal? 1 : 0;

        int x = (int)from.getX();
        int y = (int)from.getY();

        boolean point_out_of_bounds = !validateInsideBoard(x, y,board[0].length),
                x_out_of_bounds = !validateInsideBoard(x + length, y,board[0].length) && horizontal,
                y_out_of_bounds = !validateInsideBoard(x, y + length,board[0].length) && !horizontal;
            
        if(point_out_of_bounds || x_out_of_bounds || y_out_of_bounds) 
            return false;
        
        for(int i = 0; i < length; i++){
            x = (int)from.getY() + i *y_diff;
            y = (int)from.getX() + i *x_diff;
            char icon = board[x][y].getIcon();
            if(icon != wildcard) return false;
        }
        return true;
    }
}