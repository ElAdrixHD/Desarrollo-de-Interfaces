package es.adrianmmudarra.inventory.data.repository;

import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;

import androidx.room.OnConflictStrategy;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import es.adrianmmudarra.inventory.data.InventoryDatabase;
import es.adrianmmudarra.inventory.data.dao.DependencyDao;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyRepository {
    private static DependencyRepository instance;
    private DependencyDao dependencyDao;

    /*static {
        instance = new DependencyRepository();
    }*/

    public DependencyRepository() {
        dependencyDao = InventoryDatabase.getDatabase().dependencyDao();
    }

    public static DependencyRepository getInstance(){
        if (instance == null){
            instance = new DependencyRepository();
        }
        return instance;
    }

    public List<Dependency> getDependencies(){
        try {
            return InventoryDatabase.databaseWriteExecutor.submit(() -> dependencyDao.getAll()).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(final Dependency dependency) throws ExecutionException, InterruptedException {
        InventoryDatabase.databaseWriteExecutor.submit(()-> dependencyDao.insert(dependency)).get();
    }

    public boolean edit(final Dependency dependency) {
        InventoryDatabase.databaseWriteExecutor.execute(()->dependencyDao.update(dependency));
        return true;

    }

    public boolean delete(final Dependency dependency) {
        InventoryDatabase.databaseWriteExecutor.execute(()->dependencyDao.delete(dependency));
        return true;
    }

    public boolean update(final Dependency dependency){
        InventoryDatabase.databaseWriteExecutor.execute(()->dependencyDao.update(dependency));
        return true;
    }

    public int getPositionDependency(Dependency dependency) {
        List<Dependency> list = dependencyDao.getAll();
        int pos = 0;
        for (Dependency d: list) {
            if (d.equals(dependency)){
                return pos;
            }
            pos++;
        }
        return -1;
    }

    private class QueryAsyncTask extends AsyncTask<Void,Void,List>{

        @Override
        protected List doInBackground(Void... voids) {
            return dependencyDao.getAll();
        }
    }

}
