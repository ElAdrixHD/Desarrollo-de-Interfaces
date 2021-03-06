package es.adrianmmudarra.inventory.layout.sector;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.model.Sector;
import es.adrianmmudarra.inventory.layout.base.BaseView;

public interface SectorManageContract {
    interface View extends BaseView<Presenter> {
        void onSuccessLoadSpinner(ArrayList<Dependency> dependencies);
        void onErrorLoadSpinner(String error);
        void onErrorValidate(String error);

        void showNameEmptyError(String s);

        void clearNameError();

        void showShortNameEmptyError(String s);

        void clearShortnameError();

        void showDescriptionEmptyError(String s);

        void clearDescriptionError();

    }

    interface Presenter{
        void loadSpinner();
        boolean validate(Sector sector);
        void addSector(Sector sector);
        void editSector(Sector sector);

        int getPositionDependency(Dependency dependency);
    }
}
