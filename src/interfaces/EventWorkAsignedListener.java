package interfaces;

import eventos.EventWorkShop;

import java.util.EventListener;

public interface EventWorkAsignedListener extends EventListener {
    void onWorkAsigned(EventWorkShop e);
}
