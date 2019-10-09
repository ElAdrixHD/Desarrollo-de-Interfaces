package es.adrianmmudarra.helloworldresources;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        tvText = findViewById(R.id.tvText);
        tvText.setTextColor(ContextCompat.getColor(this,android.R.color.white));
        tvText.setTypeface(Typeface.createFromAsset((getAssets()),"Raphtalia.otf"));
    }
}
