package es.adrianmmudarra.inventory.layout.dependency;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.concurrent.atomic.AtomicInteger;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.data.model.Dependency;
import es.adrianmmudarra.inventory.layout.InventoryApplication;

public class DependencyManageView extends Fragment implements DependencyManageContract.View{

    private onSaveListener listener;
    private DependencyManageContract.Presenter presenter;

    private TextInputEditText tiledShortName, tiledName, tiledDescription;
    private TextInputLayout tilShortName, tilName, tilDescription;
    private Spinner spinner;
    private FloatingActionButton fabSave;
    private static final int ID_NOTIFICATION_CREATE = 329;
    private static final int ID_NOTIFICATION_EDIT = 328;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public DependencyManageView() {
        // Required empty public constructor
    }

    public static String TAG = "DependencyManageView";

    public static Fragment newInstance(Bundle bundle) {
        DependencyManageView fragment = new DependencyManageView();
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
    public void onResume() {
        super.onResume();
        fabSave.setImageResource(R.drawable.ic_action_save);
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
        tilName = view.findViewById(R.id.tilDependencyManageName);
        tilShortName = view.findViewById(R.id.tilDependencyManageShort);
        tilDescription = view.findViewById(R.id.tilDependencyManageDescription);
        spinner = view.findViewById(R.id.spinnerDependencyManageInventory);
        if (getArguments()!= null){
            tiledShortName.setEnabled(false);
        }
        fabSave = getActivity().findViewById(R.id.fabBaseActivity);
        fabSave.setOnClickListener(v -> {
            if (presenter.isValidDependency(tiledName.getText().toString(),tiledShortName.getText().toString(),tiledDescription.getText().toString())){
                Dependency d = getDependency();
                if (getArguments() != null){
                    presenter.edit(d);
                }else {
                    presenter.add(d);
                }
            }

        });


        if (getArguments() != null){
            Dependency d  = getArguments().getParcelable(Dependency.TAG);
            tiledShortName.setText(d.getShortName());
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

    private Dependency getDependency() {
        Dependency dependency = new Dependency();
        dependency.setName(tiledName.getText().toString());
        dependency.setShortName(tiledShortName.getText().toString());
        dependency.setDescription(tiledDescription.getText().toString());
        dependency.setInventory(spinner.getSelectedItem().toString());
        return dependency;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onSaveListener) {
            listener = (onSaveListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onSaveListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }



    @Override
    public void setPresenter(DependencyManageContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showError(String error) {
        Snackbar.make(getView(),error,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void onSuccess(Dependency dependency, String message) {

        Intent intent = new Intent(getActivity(), DependencyActivity.class);
        intent.putExtra("NOTIFICACION", true);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Bundle bundle = new Bundle();
        bundle.putParcelable(Dependency.TAG,dependency);
        intent.putExtras(bundle);

        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(),atomicInteger.getAndIncrement(),intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            if (message.equals("Dependencia Añadida: "+dependency.getShortName())){
                Notification.Builder builder = new Notification.Builder(getContext(),InventoryApplication.CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_inventory_launcher)
                        .setContentText(message)
                        .setContentTitle("INVENTORY")
                        .setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
                notificationManagerCompat.notify(ID_NOTIFICATION_CREATE, builder.build());
            }
            if (message.equals("Dependencia Editada: "+dependency.getShortName())){
                Notification.Builder builder = new Notification.Builder(getContext(),InventoryApplication.CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_inventory_launcher)
                        .setContentText(message)
                        .setContentTitle("INVENTORY")
                        .setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getContext());
                notificationManagerCompat.notify(ID_NOTIFICATION_EDIT, builder.build());
            }

        }
        listener.onSaveListener("Dependencia Creada: "+ dependency.getShortName());
    }

    @Override
    public void showNameEmptyError(String error) {
        tilName.setError(error);
    }

    @Override
    public void showShortNameEmptyError(String error) {
        tilShortName.setError(error);
    }

    @Override
    public void showDescriptionEmptyError(String error) {
        tilDescription.setError(error);
    }

    @Override
    public void clearNameError() {
        tilName.setError(null);
    }

    @Override
    public void clearShortnameError() {
        tilShortName.setError(null);
    }

    @Override
    public void clearDescriptionError() {
        tilDescription.setError(null);
    }

    public interface onSaveListener {
        // TODO: Update argument type and name
        void onSaveListener(String message);
    }
}
