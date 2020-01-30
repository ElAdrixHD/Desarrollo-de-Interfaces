package es.adrianmmudarra.inventory.layout.sector;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import es.adrianmmudarra.inventory.data.model.Sector;
import es.adrianmmudarra.inventory.data.repository.DependencyRepository;
import es.adrianmmudarra.inventory.data.repository.SectorRepository;

public class SectorListPresenter implements SectorListContract.Presenter {

    private SectorListContract.View view;

    public SectorListPresenter(SectorListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {

        view.showProgressBar();
        ArrayList<Sector> sectors = SectorRepository.getInstance().getSectors();
        if (sectors.isEmpty()){
            view.showNoSectors("NO HAY SECTORES");
        }else{
            view.refeshData(sectors);
        }
        view.hideProgressBar();
    }


    @Override
    public void deleteSector(Sector sector) {

        if (SectorRepository.getInstance().removeSector(sector)){
            if (SectorRepository.getInstance().getSectors().isEmpty()){
                view.showNoSectors("NO QUEDAN SECTORES");
            }
            view.onSuccessDelete(sector);
        }
        else {
            view.showError("No se ha podido eliminar el sector: "+sector.getShortname());
        }
    }

    @Override
    public void undoDelete(Sector sector) {

        if (SectorRepository.getInstance().addSector(sector) != -1 ){
            view.restore(sector);
        }else {
            view.showError("No se ha podido recuperar el sector");
        }
    }
}
