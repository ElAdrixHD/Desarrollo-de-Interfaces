package es.adrianmmudarra.inventory.layout.product;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.adrianmmudarra.inventory.R;

public class ProductView extends Fragment {
    public static String TAG = "ProductView";

    private ProductInfoView productInfoView;
    private ProductDescriptionView productDescriptionView;
    private ProductMapView productMapView;

    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton;

    public static Fragment newInstanced(Bundle bundle){
        ProductView fragment = new ProductView();
        if (bundle != null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        showProductInfo();
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        floatingActionButton = getActivity().findViewById(R.id.fabBaseActivity);
        floatingActionButton.hide();
        bottomNavigationView = view.findViewById(R.id.bottom_nav_menu_product);
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.bottom_menu_item_product_info:
                    showProductInfo();
                    return true;
                case R.id.bottom_menu_item_product_description:
                    showProductDescription();
                    return true;
                case R.id.bottom_menu_item_product_map:
                    showProductMap();
                    return true;
            }
            return false;
        });

    }

    private void showProductMap() {
        productMapView = (ProductMapView) getChildFragmentManager().findFragmentByTag(ProductInfoView.TAG);
        if (productMapView == null){
            productMapView = (ProductMapView) ProductMapView.newInstanced(null);
        }
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container_product, productMapView, ProductMapView.TAG)
                .commit();
    }

    private void showProductDescription() {
        productDescriptionView = (ProductDescriptionView) getChildFragmentManager().findFragmentByTag(ProductDescriptionView.TAG);
        if (productDescriptionView == null){
            productDescriptionView = (ProductDescriptionView) ProductDescriptionView.newInstanced(null);
        }
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container_product, productDescriptionView, ProductDescriptionView.TAG)
                .commit();
    }

    private void showProductInfo() {
        productInfoView = (ProductInfoView) getChildFragmentManager().findFragmentByTag(ProductInfoView.TAG);
        if (productInfoView == null){
            productInfoView = (ProductInfoView) ProductInfoView.newInstanced(null);
        }
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.container_product, productInfoView, ProductInfoView.TAG)
                .commit();
    }
}
