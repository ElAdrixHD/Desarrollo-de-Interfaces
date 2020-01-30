package es.adrianmmudarra.inventory.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import es.adrianmmudarra.inventory.data.dao.DependencyDao;
import es.adrianmmudarra.inventory.data.dao.SectorDao;
import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.model.Sector;

@Database(entities = {Dependency.class, Sector.class}, version = 2, exportSchema = false)
public abstract class InventoryDatabase extends RoomDatabase {

    public abstract DependencyDao dependencyDao();
    public abstract SectorDao sectorDao();

    private static volatile InventoryDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static void create(final Context context) {
        if (INSTANCE == null) {
            synchronized (InventoryDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            InventoryDatabase.class, "inventory")
                            .build();
                }
            }
        }
    }

    public static InventoryDatabase getDatabase(){
        return INSTANCE;
    }
}
