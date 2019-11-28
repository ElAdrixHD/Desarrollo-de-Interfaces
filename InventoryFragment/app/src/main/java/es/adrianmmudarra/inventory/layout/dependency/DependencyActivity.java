package es.adrianmmudarra.inventory.layout.dependency;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyActivity extends AppCompatActivity implements DependencyListView.onManageDependencyListener, DependencyManageView.onSaveListener {

    private DependencyListView dependencyListView;
    private DependencyManageView dependencyManageView;

    private DependencyManagePresenter dependencyManagePresenter;
    private DependencyListPresenter dependencyListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        initialize();
    }

    private void initialize() {
        setTitle("Listado de dependencias");
        dependencyListView = (DependencyListView)getSupportFragmentManager().findFragmentByTag(DependencyListView.TAG);
        if (dependencyListView == null)
            dependencyListView = (DependencyListView) DependencyListView.newInstanced(null);

        dependencyListPresenter = new DependencyListPresenter(dependencyListView);
        dependencyListView.setPresenter(dependencyListPresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content, dependencyListView, DependencyListView.TAG)
                .commit();
    }

    @Override
    public void onManageDependency(Dependency dependency) {
        setTitle("Añadir dependencia");
        Bundle b = null;
        dependencyManageView = (DependencyManageView)getSupportFragmentManager().findFragmentByTag(DependencyManageView.TAG);
        if (dependencyManageView == null){
            if (dependency != null){
                setTitle("Modificar dependencia");
                b = new Bundle();
                b.putParcelable(Dependency.TAG,dependency);
            }
            dependencyManageView = (DependencyManageView) DependencyManageView.newInstance(b);
        }

        dependencyManagePresenter = new DependencyManagePresenter(dependencyManageView);
        dependencyManageView.setPresenter(dependencyManagePresenter);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, dependencyManageView, DependencyManageView.TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSaveListener(String message) {
        onBackPressed();
    }
}
