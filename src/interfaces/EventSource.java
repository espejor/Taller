package interfaces;

import eventos.EventWorkShop;

import java.util.EventListener;

public interface EventSource {
    void addListener(EventListener listener);
    void removeListener(EventListener listener);
    boolean isRegister(EventListener listener);
}
