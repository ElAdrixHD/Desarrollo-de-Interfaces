package es.adrianmmudarra.inventory.layout.dependency;

import java.util.Collection;

import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.layout.base.BaseView;

public interface DependencyListContract {
    interface View extends BaseView<Presenter> {
        void showLoadingProgress();
        void hideLoading();
        void showNoDependency();
        void showData(Collection<Dependency> dependencies);
        void onSuccessDelete();

    }

    interface Presenter{
        void delete(Dependency dependency);
        void load();
        void restore(Dependency dependency);
    }
}
