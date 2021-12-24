package com.pb.levchenko.hw13;

import java.util.Queue;

class Producer implements Runnable{
    private final Queue<Double> listDouble;
    private final int size;

    public Producer(Queue<Double> listDouble, int size) {
        this.listDouble = listDouble;
        this.size = size;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Изготовлено: "+produce());
            }
            catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }

    }
    private double produce() throws InterruptedException{
       synchronized (listDouble){
           if (listDouble.size()==size){
       // ждем если очередь полная
               listDouble.wait();
           }
       // добавим элемент в очередь
           double newMeaning = Math.random();
           listDouble.add(newMeaning);


       // уведомляем другой поток
       listDouble.notifyAll();

       return newMeaning;
    }
 }
}
