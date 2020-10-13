/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsensor;

/**
 *
 * @author andrei.nichita0308
 */
public class SensorEvent {
    public enum SensorType{
        S_A,S_B,S_C;
    }
    
    private SensorType type;
     
    public SensorEvent(SensorType rep)
    {
        super();
        this.type=rep;
    }
    
    @Override
    public String toString()
    {
        return "SensorEvent [rep=" + type + "]";

    }

    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }
    
    
}
