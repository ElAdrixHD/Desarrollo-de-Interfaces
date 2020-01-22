package es.adrianmmudarra.inventory.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import es.adrianmmudarra.inventory.data.model.Dependency;

@Dao
public interface DependencyDao {
    @Insert
    void insert(Dependency dependency);

    @Delete
    void delete(Dependency dependency);

    @Update
    void update(Dependency dependency);

    @Query("SELECT * FROM dependency")
    List<Dependency> getAll();

    @Query("SELECT * FROM dependency WHERE shortName = :shortName")
    List<Dependency> findByShortName(String shortName);
}
