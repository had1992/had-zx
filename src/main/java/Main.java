/**
 * Created by had on 2017/6/2.
 */
import org.coach.tdd.template.*;

public class Main {
    public static void main(String[] args){
        Library library = new Library();

        if(library.someLibraryMethod()){
            System.out.println("hello Java");
        }
    }
}
