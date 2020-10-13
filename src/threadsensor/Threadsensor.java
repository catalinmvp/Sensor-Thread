/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsensor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static threadsensor.SensorEvent.SensorType.S_A;

/**
 *
 * @author andrei.nichita0308
 */
public class Threadsensor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       final BlockingQueue<SensorEvent> queue= new LinkedBlockingQueue<SensorEvent>();
       
       new Thread(new Sensor(queue,S_A),"S_A").start();
       new Thread(new Dispatcher(queue),"Builder").start();
    }
    
}
