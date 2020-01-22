package es.adrianmmudarra.inventory.layout.dependency;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.repository.DependencyRepository;

public class DependencyListPresenter implements DependencyListContract.Presenter {

    private DependencyListContract.View view;

    public DependencyListPresenter(DependencyListContract.View view) {
        this.view = view;
    }

    @Override
    public void delete(Dependency dependency) {
        if (DependencyRepository.getInstance().delete(dependency)){
            if (!DependencyRepository.getInstance().getDependencies().isEmpty()){
                view.onSuccessDelete();
            }
            else{
                view.showNoDependency();
                view.onSuccessDelete();
            }
        }
        else {
            view.showError("No se ha podido eliminar la dependencia");
        }
    }

    @Override
    public void load() {
        view.showLoadingProgress();
        List<Dependency> dependencies = DependencyRepository.getInstance().getDependencies();
        if (dependencies.isEmpty()){
            view.showNoDependency();
        }else{
            view.showData(dependencies);
        }
        view.hideLoading();



    }

    @Override
    public List<Dependency> getRepo(){
        return DependencyRepository.getInstance().getDependencies();
    }

    @Override
    public void restore(Dependency dependency) {
        DependencyRepository.getInstance().add(dependency);
        view.showData(DependencyRepository.getInstance().getDependencies());
    }
}
