package es.adrianmmudarra.inventory.layout.dependency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.adapter.DependencyAdapter;

public class DependencyListActivity extends AppCompatActivity {

    private RecyclerView recyclerDependency;
    private DependencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency_list);
        initialize();
    }

    private void initialize() {
        recyclerDependency = findViewById(R.id.recyclerDependency);

        adapter = new DependencyAdapter();

        recyclerDependency.setAdapter(adapter);
        recyclerDependency.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));
    }
}
