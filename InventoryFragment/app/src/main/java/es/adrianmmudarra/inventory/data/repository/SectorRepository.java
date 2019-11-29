package es.adrianmmudarra.inventory.data.repository;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Sector;

public class SectorRepository {
    private static SectorRepository INSTANCE;

    private ArrayList<Sector> sectors;

    public static SectorRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SectorRepository();
        }
        return INSTANCE;
    }

    public SectorRepository() {
        sectors = new ArrayList<>();
        initialiceData();
    }

    private void initialiceData() {
        this.sectors.add(new Sector("Sector 1", "SC_1", "Sector_Desc_1",DependencyRepository.getInstance().get(1),"1"));
        this.sectors.add(new Sector("Sector 2", "SC_2", "Sector_Desc_2",DependencyRepository.getInstance().get(2),"2"));
        this.sectors.add(new Sector("Sector 3", "SC_3", "Sector_Desc_3",DependencyRepository.getInstance().get(3),"3"));
        this.sectors.add(new Sector("Sector 4", "SC_4", "Sector_Desc_4",DependencyRepository.getInstance().get(4),"4"));
        this.sectors.add(new Sector("Sector 5", "SC_5", "Sector_Desc_5",DependencyRepository.getInstance().get(5),"5"));
    }

    public ArrayList<Sector> getSectors(){
        return this.sectors;
    }

    public boolean addSector(Sector sector){
        return this.sectors.add(sector);
    }

    public boolean removeSector(Sector sector){
        return this.sectors.remove(sector);
    }
}
