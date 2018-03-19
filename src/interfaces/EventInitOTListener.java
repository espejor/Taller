package interfaces;

import eventos.EventWorkShop;

import java.util.EventListener;

public interface EventInitOTListener extends EventListener {
    void onInitOT(EventWorkShop e);
}
