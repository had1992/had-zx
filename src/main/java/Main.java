/**
 * Created by had on 2017/6/2.
 */
import org.coach.tdd.template.*;

public class Main {
    public static void main(String[] args){
        Map map = new Map(10);
        map.setAliveCell(1,1);
        map.setAliveCell(1,2);
        map.setAliveCell(2,3);

        for (int i = 0; i < 10; i++){
            map.update();
            map.display();
        }
    }
}
