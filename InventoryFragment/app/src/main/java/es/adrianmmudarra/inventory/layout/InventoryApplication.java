package es.adrianmmudarra.inventory.layout;

import android.app.Application;

import es.adrianmmudarra.inventory.data.InventoryDatabase;

public class InventoryApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InventoryDatabase.create(this);
    }
}
