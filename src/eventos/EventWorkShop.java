package eventos;

import interfaces.EventSource;
import taller.Trabajo;

import java.util.EventObject;

public class EventWorkShop extends EventObject{
    private Trabajo trabajo;

    public EventWorkShop(EventSource source,Trabajo trabajo) {
        super(source);
        this.trabajo = trabajo;
    }

    /**
     * Getter de trabajo
     * @return trabajo
     */
    public Trabajo getTrabajo() {
        return trabajo;
    }

}
