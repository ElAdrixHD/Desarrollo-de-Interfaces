package es.adrianmmudarra.staticfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.OnSetTextSizeListener{

    private Fragment fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialice();
    }

    private void initialice() {
        fragmentb = getSupportFragmentManager().findFragmentById(R.id.fragmentB);
    }

    @Override
    public void onSetTextSize(String text, int size) {
        ((FragmentB)fragmentb).setMessageSize(text, size);
    }
}
