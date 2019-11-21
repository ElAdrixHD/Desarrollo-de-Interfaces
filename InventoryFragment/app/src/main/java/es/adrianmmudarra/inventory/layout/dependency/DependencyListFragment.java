package es.adrianmmudarra.inventory.layout.dependency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.adapter.DependencyAdapter;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyListFragment extends Fragment{

    private RecyclerView recyclerDependency;
    private DependencyAdapter adapter;
    private FloatingActionButton fabAdd;

    private onManageDependencyListener listenerActivity;
    private DependencyAdapter.onManageDependencyListener listenerAdapter;

    public static String TAG = "DependencyListFragment";

    public static Fragment newInstanced(Bundle bundle){
        DependencyListFragment fragment = new DependencyListFragment();
        if (bundle != null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerActivity = (onManageDependencyListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listenerActivity = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dependency_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerDependency = view.findViewById(R.id.recyclerDependency);
        fabAdd = view.findViewById(R.id.fabDependencyListAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerActivity.onManageDependency(null);
            }
        });

        listenerAdapter = new DependencyAdapter.onManageDependencyListener() {
            @Override
            public void onEditDependencyListener(Dependency dependency) {
                listenerActivity.onManageDependency(dependency);
            }

            @Override
            public void onDeleteDependencyListener(Dependency d) {
                Toast.makeText(getContext(),"Delete "+d.getName(),Toast.LENGTH_SHORT).show();
            }
        };

        adapter = new DependencyAdapter();
        adapter.setOnManageDependencyListener(listenerAdapter);

        recyclerDependency.setAdapter(adapter);
        recyclerDependency.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    interface onManageDependencyListener {
        void onManageDependency(Dependency dependency);
    }
}
