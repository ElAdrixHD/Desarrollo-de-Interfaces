package es.adrianmmudarra.inventory.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.adrianmmudarra.inventory.data.model.Sector;

@Dao
public interface SectorDao {

    @Insert
    long insert(Sector sector);

    @Delete
    void delete(Sector sector);

    @Update
    void update(Sector sector);

    @Query("SELECT * FROM sector")
    List<Sector> getAll();

    @Query("SELECT * FROM sector WHERE shortname = :shortName")
    List<Sector> findByShortName(String shortName);
}
