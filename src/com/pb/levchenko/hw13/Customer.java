package com.pb.levchenko.hw13;

import java.util.Queue;

class Customer implements Runnable{
    private final Queue<Double> listDouble;

    Customer(Queue<Double> listDouble) {
        this.listDouble = listDouble;
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
                System.out.println("Использовано: "+customer());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    private Double customer() throws InterruptedException{
        synchronized (listDouble){
            if (listDouble.isEmpty()){
                listDouble.wait();
            }
            listDouble.notifyAll();
            return listDouble.poll();
        }
    }
}
