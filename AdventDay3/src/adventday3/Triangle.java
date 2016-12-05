package adventday3;
/**
 * @author yasgur99
 **/

public class Triangle {

    private int a;
    private int b;
    private int c;
    
    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public boolean isTriangle(){
        if(a + b > c)
            if(b +c > a)
                if(a + c > b)
                    return true;
        return false;
    }
}
