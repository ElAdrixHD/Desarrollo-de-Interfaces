package es.adrianmmudarra.inventory.layout.sector;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Sector;
import es.adrianmmudarra.inventory.layout.base.BaseView;

public interface SectorListContract{

    interface View extends BaseView<Presenter> {
        void showProgressBar();
        void hideProgressBar();
        void refeshData(ArrayList<Sector> sectors);
        void onSuccessDelete(Sector sector);
        void showNoSectors(String error);
        void showDeleteMessage(String message);
    }

    interface Presenter{
        void loadData();
        void deleteSector(Sector sector);
    }
}
