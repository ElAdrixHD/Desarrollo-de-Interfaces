package es.adrianmmudarra.inventory.layout.dependency;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyActivity extends AppCompatActivity implements DependencyListFragment.onManageDependencyListener {

    private DependencyListFragment dependencyListFragment;
    private DependencyManage dependencyManage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        initialize();
    }

    private void initialize() {
        dependencyListFragment = (DependencyListFragment)getSupportFragmentManager().findFragmentByTag(DependencyListFragment.TAG);
        if (dependencyListFragment == null)
            dependencyListFragment = (DependencyListFragment)DependencyListFragment.newInstanced(null);

        getSupportFragmentManager()
                .beginTransaction()
                .add(android.R.id.content,dependencyListFragment,DependencyListFragment.TAG)
                .commit();
    }

    @Override
    public void onManageDependency(Dependency dependency) {
        Bundle b = null;
        dependencyManage = (DependencyManage)getSupportFragmentManager().findFragmentByTag(DependencyManage.TAG);
        if (dependencyManage == null){
            if (dependency != null){
                b = new Bundle();
                b.putParcelable(Dependency.TAG,dependency);
            }
            dependencyManage = (DependencyManage) DependencyManage.newInstance(b);

        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, dependencyManage, DependencyManage.TAG)
                .addToBackStack(null)
                .commit();
    }
}
