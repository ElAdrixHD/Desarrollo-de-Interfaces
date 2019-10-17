package es.adrianmmudarra.inventory.layout.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.adrianmmudarra.inventory.R;
import es.adrianmmudarra.inventory.layout.dash.DashboardActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private Button btnRegister;
    private TextInputLayout tilUsername, tilEmail, tilPassword, tilPasswordConfirm;
    private TextInputEditText edtilPassword, edtilUsername, edtilPasswordConfirm, edtilEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initialize();

    }

    private void initialize() {
        btnRegister = findViewById(R.id.btnRegisterRegister);
        btnRegister.setOnClickListener(this);
        edtilEmail = findViewById(R.id.edtilRegisterEmail);
        edtilPassword = findViewById(R.id.edtilRegisterPassword);
        edtilUsername = findViewById(R.id.edtilRegisterUsername);
        edtilPasswordConfirm = findViewById(R.id.edtilRegisterPassportRepeat);
        tilEmail = findViewById(R.id.tilRegisterEmail);
        tilPassword = findViewById(R.id.tillRegisterPassword);
        tilUsername = findViewById(R.id.tilRegisterUsername);
        tilPasswordConfirm = findViewById(R.id.tilRegisterPassportRepeat);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegisterRegister:
                validate();
                break;
        }
    }

    private void validate() {
        if (validateUser() & validatePassword() & validateEmail()){
            startActivity(new Intent(RegisterActivity.this, DashboardActivity.class));
            finish();
        }
    }

    private boolean validateEmail() {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(edtilEmail.getText().toString());
        if(matcher.find()){
            return true;
        }else{
            tilEmail.setError("Email no válido");
            return false;
        }
    }

    private boolean validatePassword() {
        if (edtilPassword.getText().toString().equals(edtilPasswordConfirm.getText().toString())){
            return true;
        }else {
            tilPassword.setError("Las contraseñas no coinciden");
            tilPasswordConfirm.setError("Las contraseñas no coinciden");
            return false;
        }
    }

    private boolean validateUser() {
        return true;
    }
}
