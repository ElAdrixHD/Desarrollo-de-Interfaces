package es.adrianmmudarra.inventory.layout.dependency;

import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyListPresenter implements DependencyListContract.Presenter {

    private DependencyListContract.View view;

    public DependencyListPresenter(DependencyListContract.View view) {
        this.view = view;
    }

    @Override
    public void delete(Dependency dependency) {

    }

    @Override
    public void load() {

    }
}
