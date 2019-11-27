package es.adrianmmudarra.inventory.layout.dependency;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
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
import com.google.android.material.snackbar.Snackbar;

import java.util.Collection;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.adapter.DependencyAdapter;
import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.data.repository.DependencyRepository;

public class DependencyListView extends Fragment implements DependencyListContract.View{

    private RecyclerView recyclerDependency;
    private DependencyAdapter adapter;
    private FloatingActionButton fabAdd;

    private onManageDependencyListener listenerActivity;
    private DependencyListContract.Presenter listenerPresenter;
    private DependencyAdapter.onManageDependencyListener listenerAdapter;

    public static String TAG = "DependencyListView";

    public static Fragment newInstanced(Bundle bundle){
        DependencyListView fragment = new DependencyListView();
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
                new AlertDialog.Builder(getContext())
                        .setTitle("Borrar Dependencia")
                        .setMessage("¿Estas seguro que quieres borrar esta dependencia?\n\n"+d.getShortname())

                        .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                            DependencyRepository.getInstance().delete(d);
                            onManageSuccess("Depedencia Eliminada: "+d.getShortname());
                            adapter.notifyDataSetChanged();
                        })

                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(R.drawable.ic_action_warning)
                        .show();
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

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public void onManageSuccess(String message){
        Snackbar.make(getView(),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoadingProgress() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNoDependency() {

    }

    @Override
    public void showData(Collection<Dependency> dependencies) {

    }

    @Override
    public void setPresenter(DependencyListContract.Presenter presenter) {
        this.listenerPresenter = presenter;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void onSuccess(String message) {

    }

    interface onManageDependencyListener {
        void onManageDependency(Dependency dependency);
    }
}
