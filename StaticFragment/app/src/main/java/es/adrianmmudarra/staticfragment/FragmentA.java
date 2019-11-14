package es.adrianmmudarra.staticfragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

    public interface OnSetTextSizeListener{
        void onSetTextSize(String text, int size);
    }

    private EditText editText;
    private Button button;
    private SeekBar seekBar;

    private OnSetTextSizeListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnSetTextSizeListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" no implementa la interfaz OnSetTextListener");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.ed_name_fragmentA);
        button = view.findViewById(R.id.btnchange_fragmentA);
        seekBar = view.findViewById(R.id.seekBar_fragmentA);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSetTextSize(editText.getText().toString(),seekBar.getProgress());
            }
        });
    }
}
