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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.adapter.DependencyAdapter;

public class DependencyListFragment extends Fragment {

    private RecyclerView recyclerDependency;
    private DependencyAdapter adapter;
    private FloatingActionButton fabAdd;

    private onAddDependencyListener listener;

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
        listener = (onAddDependencyListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
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
                listener.onAddDependency();
            }
        });

        adapter = new DependencyAdapter();

        recyclerDependency.setAdapter(adapter);
        recyclerDependency.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    interface onAddDependencyListener{
        void onAddDependency();
    }
}
