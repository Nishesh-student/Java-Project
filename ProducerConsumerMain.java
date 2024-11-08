package MultiThreading.ProducerConsumerProject;


class Company
{
    int item;
    boolean flag = false;
    synchronized public void produceItem(int item) throws InterruptedException
    {
        if(flag)
        {
            wait();
        }
        this.item = item;
        System.out.println(item+" Item Produced");
        flag = true;
        notify();
    }

    synchronized public void consumeItem() throws InterruptedException
    {
        if (!flag)
        {
            wait();
        }
        System.out.println(item+" Item Consumed");
        flag = false;
        notify();
    }
}

class Producer extends Thread
{
    Company c;

    Producer(Company c)
    {
        this.c = c;
    }

    public void run()
    {

        int i = 1;
        while(true)
        {
            try {
                this.c.produceItem(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            try{Thread.sleep(1000);}catch(InterruptedException e){}
        }
    }
}

class Consumer extends Thread
{
    Company c;

    Consumer(Company c)
    {
        this.c = c;
    }

    public void run()
    {
        while(true)
        {
            try {
                this.c.consumeItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{Thread.sleep(1000);}catch(InterruptedException e){}
        }
    }
}
public class ProducerConsumerMain
{
    public static void main(String[] args) {
       Company comp = new Company();

       Producer p = new Producer(comp);
       p.start();

       Consumer c = new Consumer(comp);
       c.start();
    }
}