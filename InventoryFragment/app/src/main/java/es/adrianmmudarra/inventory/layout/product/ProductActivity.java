package es.adrianmmudarra.inventory.layout.product;

import android.os.Bundle;

import androidx.annotation.Nullable;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.layout.base.BaseActivity;

public class ProductActivity extends BaseActivity {

    private ProductView productView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialise();
    }

    private void initialise() {
        productView = (ProductView) getSupportFragmentManager().findFragmentByTag(ProductView.TAG);
        if (productView == null){
            productView = (ProductView) ProductView.newInstanced(null);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.myContent,productView,ProductView.TAG)
                .commit();
    }
}
