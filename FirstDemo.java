class Mythead implements Runnable {

    private String name ;
    public void Nythead()
    {
        this.name ="tom";
    }
    public void run() {
        System.out.print("this.is my thread"+this.name);
    }
}
public  class FirstDemo
        {
            public static void  main(String[] args) {
                Mythead the = new Mythead();
                Thread t1 = new Thread(the);
                t1.start();
            }
        }
