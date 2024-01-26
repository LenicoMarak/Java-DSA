package modifier;
 class Access {
    public int feet,inch;
    private int metre,centimetre;
    public final int gram=100;
    Access(int i,int f){
        metre=50;
        centimetre=30;
        inch=i;
        feet=f;
    }
    void display(){
        System.out.println("Metre: "+metre);
        System.out.println("Centimetre: "+centimetre);
        System.out.println("Inch: "+inch);
        System.out.println("feet: "+feet);
    }
    void AddAccess(Access d2){
        d2.inch=d2.inch+gram;
        d2.feet=d2.feet+gram;
    }
}

public class Main {
    
    public static void main(String[] args) {
        Access d1=new Access(20,10);
        Access d2=new Access(40,60);
        d1.display();
        d1.AddAccess(d2);
        d2.display();     
    }   
}
