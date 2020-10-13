/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsensor;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author andrei.nichita0308
 */
public class Sensor implements Runnable {

    private BlockingQueue<SensorEvent> queue;
    private SensorEvent.SensorType SensorEventType;
    private Date date= new Date();
    
    public Date getDate()
    {
        return date;
    }

    public Sensor(BlockingQueue<SensorEvent> queue, SensorEvent.SensorType SensorEventType) {
        this.queue = queue;
        this.SensorEventType = SensorEventType;
    }
    
    public void run()
    {
        
      try{
          SensorEvent se=new SensorEvent(SensorEventType);
          queue.put(se);
        //quesstion
        System.out.printf("[%s] published sensorevent : %s %n", Thread.currentThread().getName(), se.toString() );
        System.out.printf(" %s %tB %<te, %<tY", " sensorevent date:", date);
      } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
   
}
