package es.adrianmmudarra.inventory.layout.dependency;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Dependency;

public class DependencyManage extends Fragment {

    private OnFragmentInteractionListener listener;

    private TextInputEditText tiledShortName, tiledName, tiledDescription;
    private TextInputLayout tilShortName, tilName, tilDescription;
    private Spinner spinner;

    public DependencyManage() {
        // Required empty public constructor
    }

    public static String TAG = "DependencyManage";

    public static Fragment newInstance(Bundle bundle) {
        DependencyManage fragment = new DependencyManage();
        if (bundle != null)
            fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setRetainInstance(true);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dependency_manage, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tiledShortName = view.findViewById(R.id.tiledDependencyManageShort);
        tiledName = view.findViewById(R.id.tiledDependencyManageName);
        tiledDescription = view.findViewById(R.id.tiledDependencyManageDescription);
        spinner = view.findViewById(R.id.spinnerDependencyManageInventory);

        if (getArguments() != null){
            Dependency d  = getArguments().getParcelable(Dependency.TAG);
            tiledShortName.setText(d.getShortname());
            tiledName.setText(d.getName());
            tiledDescription.setText(d.getDescription());
            switch (d.getInventory()){
                case "2018":
                    spinner.setSelection(0,true);
                    break;
                case "2019":
                    spinner.setSelection(1,true);
                    break;
                case "2020":
                    spinner.setSelection(2,true);
                    break;
            }
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed() {
        if (listener != null) {
            listener.onFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
