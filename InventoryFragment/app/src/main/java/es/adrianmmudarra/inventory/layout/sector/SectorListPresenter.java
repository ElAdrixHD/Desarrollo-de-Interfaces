package es.adrianmmudarra.inventory.layout.sector;

import android.os.AsyncTask;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Sector;
import es.adrianmmudarra.inventory.data.repository.SectorRepository;

public class SectorListPresenter implements SectorListContract.Presenter {

    private SectorListContract.View view;

    public SectorListPresenter(SectorListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        new AsyncTask<Void,Void, ArrayList<Sector>>(){

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                view.showProgressBar();
            }

            @Override
            protected ArrayList<Sector> doInBackground(Void... voids) {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    return SectorRepository.getInstance().getSectors();
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Sector> sectors) {
                super.onPostExecute(sectors);
                view.hideProgressBar();
                if (sectors.isEmpty()){
                    view.showNoSectors("NO HAY SECTORES");
                }else {
                    view.refeshData(sectors);
                }
            }
        }.execute();
    }


    @Override
    public void deleteSector(Sector sector) {
        if (SectorRepository.getInstance().removeSector(sector)){
            view.onSuccessDelete(sector);
            view.showDeleteMessage("Sector Eliminado: "+sector.getShortname());
        }else {
            view.showError("No se ha podido eliminar el sector: "+sector.getShortname());
        }
    }
}
