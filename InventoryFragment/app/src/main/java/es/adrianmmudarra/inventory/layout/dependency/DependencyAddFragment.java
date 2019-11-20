package es.adrianmmudarra.inventory.layout.dependency;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.adrianmmudarra.inventory.R;

public class DependencyAddFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public DependencyAddFragment() {
        // Required empty public constructor
    }

    public static String TAG = "DependencyAddFragment";

    public static Fragment newInstance(Bundle bundle) {
        DependencyAddFragment fragment = new DependencyAddFragment();
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
        return inflater.inflate(R.layout.fragment_dependency_add, container, false);
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
