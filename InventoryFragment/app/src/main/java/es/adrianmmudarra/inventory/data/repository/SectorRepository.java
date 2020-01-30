package es.adrianmmudarra.inventory.data.repository;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import es.adrianmmudarra.inventory.data.InventoryDatabase;
import es.adrianmmudarra.inventory.data.dao.SectorDao;
import es.adrianmmudarra.inventory.data.model.Sector;

public class SectorRepository {
    private static SectorRepository INSTANCE;

    private SectorDao sectorDao;

    public static SectorRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SectorRepository();
        }
        return INSTANCE;
    }

    public SectorRepository() {
        sectorDao = InventoryDatabase.getDatabase().sectorDao();
    }

    public ArrayList<Sector> getSectors(){
        try {
            return (ArrayList<Sector>) InventoryDatabase.databaseWriteExecutor.submit(() -> sectorDao.getAll()).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long addSector(Sector sector){
        long result = 0;
        try {
            result = InventoryDatabase.databaseWriteExecutor.submit(()->sectorDao.insert(sector)).get();
        } catch (ExecutionException | InterruptedException e) {
            result = -1;
        }finally {
            return result;
        }
    }

    public boolean removeSector(Sector sector){
        InventoryDatabase.databaseWriteExecutor.execute(()->sectorDao.delete(sector));
        return true;
    }

    public boolean edit(Sector sector) {
        InventoryDatabase.databaseWriteExecutor.execute(()->sectorDao.update(sector));
        return true;
    }

}
