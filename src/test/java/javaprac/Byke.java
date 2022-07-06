package javaprac;

public abstract class Byke {
    abstract void run();
}


class Honda extends Byke{

    void run() {
        System.out.println("honda is runing");
    }
}

class Test1{

    public static void main(String[] args){
        Byke honda = new Honda();
        honda.run();
    }
}