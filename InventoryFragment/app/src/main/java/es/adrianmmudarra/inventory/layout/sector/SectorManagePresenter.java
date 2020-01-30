package es.adrianmmudarra.inventory.layout.sector;

import java.util.ArrayList;

import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.model.Sector;
import es.adrianmmudarra.inventory.data.repository.DependencyRepository;
import es.adrianmmudarra.inventory.data.repository.SectorRepository;

public class SectorManagePresenter implements SectorManageContract.Presenter {

    private SectorManageContract.View view;

    public SectorManagePresenter(SectorManageContract.View view) {
        this.view = view;
    }

    @Override
    public void loadSpinner() {
        if(DependencyRepository.getInstance().getDependencies().isEmpty()){
            view.onErrorLoadSpinner("No hay dependencias");
        }else {
            view.onSuccessLoadSpinner(DependencyRepository.getInstance().getDependencies());
        }
    }

    @Override
    public boolean validate(Sector sector) {
        return checkName(sector.getName()) & checkShortName(sector.getShortname()) & checkDescription(sector.getDescription());
    }

    @Override
    public void addSector(Sector sector) {
        if (SectorRepository.getInstance().addSector(sector) != -1) {
            view.onSuccess("Sector Añadido: "+sector.getShortname(), sector);
        }
        else {
            view.showError("No se ha podido añadir el sector");
        }
    }

    @Override
    public void editSector(Sector sector) {
        if (SectorRepository.getInstance().edit(sector)){
            view.onSuccess("Sector Editado: "+sector.getShortname(), sector);
        }
        else {
            view.showError("No se ha podido editar el sector");
        }
    }

    @Override
    public int getPositionDependency(String dependency) {
        return DependencyRepository.getInstance().getPositionDependency(dependency);

    }

    private boolean checkName(String name){
        if (name.isEmpty()){
            view.showNameEmptyError("El campo nombre no puede estar vacio");
            return false;
        }
        view.clearNameError();
        return true;
    }

    private  boolean checkShortName(String shortname){
        if (shortname.isEmpty()){
            view.showShortNameEmptyError("El campo nombre corto no puede estar vacio");
            return false;
        }
        view.clearShortnameError();
        return true;
    }

    private  boolean checkDescription(String desciption){
        if (desciption.isEmpty()){
            view.showDescriptionEmptyError("El campo descripcion no puede estar vacio");
            return false;
        }
        view.clearDescriptionError();
        return true;
    }
}
