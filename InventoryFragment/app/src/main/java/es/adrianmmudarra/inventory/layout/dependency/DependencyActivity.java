package es.adrianmmudarra.inventory.layout.dependency;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.adapter.DependencyAdapter;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyActivity extends AppCompatActivity implements DependencyListFragment.onAddDependencyListener{

    private DependencyListFragment dependencyListFragment;
    private DependencyAddFragment dependencyAddFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        initialize();
    }

    private void initialize() {
        dependencyListFragment = (DependencyListFragment)getSupportFragmentManager().findFragmentByTag(DependencyListFragment.TAG);
        if (dependencyListFragment == null){
            dependencyListFragment = (DependencyListFragment)DependencyListFragment.newInstanced(null);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content,dependencyListFragment,DependencyListFragment.TAG)
                    .commit();
        }

    }

    @Override
    public void onAddDependency() {
        dependencyAddFragment = (DependencyAddFragment)getSupportFragmentManager().findFragmentByTag(DependencyAddFragment.TAG);
        if (dependencyAddFragment == null){
            dependencyAddFragment = (DependencyAddFragment)DependencyAddFragment.newInstance(null);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content,dependencyAddFragment,DependencyAddFragment.TAG)
                    .commit();
        }
    }
}
