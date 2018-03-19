package interfaces;

import eventos.EventWorkShop;

import java.util.EventListener;

public interface EventCloseOTListener extends EventListener {
    void onCloseOT(EventWorkShop e);
}
