/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsensor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author andrei.nichita0308
 */
public class Dispatcher implements Runnable{
    private BlockingQueue<SensorEvent>queue;
    final Lock lock = new ReentrantLock();

    public Dispatcher(BlockingQueue<SensorEvent> queue) {
        this.queue = queue;
    }
    
    public void processEvents(SensorEvent p)
    {
         System.out.println("The proc begins for: " + p.toString());
        
        try{
            Thread.sleep(5000);
            
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("The proc end for: " + p.toString());
    }
    
    
    
    public void run()
    { System.out.println("Started the Builder"); 
    try
    { 
        Executor executor= Executors.newCachedThreadPool(); 
        while(queue.size() > 0) 
        { 
            SensorEvent event = queue.take(); 
            executor.execute(new Runnable() 
            { 
                @Override 
                public void run() 
                { 
                    if(event.getType() == SensorEvent.SensorType.S_B) 
                    { 
                        try 
                        { 
                            lock.lock(); 
                            processEvents(event); 
                        } finally 
                        { 
                            lock.unlock(); 
                        } 
                    } 
                    else 
                    { 
                        processEvents(event); 
                    }
                    System.out.printf("[%s] consumed event : %s %n", "Executor Thread", event.toString()); 
                }
            });

        } 
    } catch (InterruptedException e) 
    { 
        e.printStackTrace(); 
    } 
    }  
}
