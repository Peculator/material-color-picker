package de.peculator.material_color_picker;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sven on 27.03.16.
 */
public class MaterialColorPickerDialog extends DialogFragment implements AdapterView.OnItemSelectedListener {
    private int primaryColorIndex = 0;
    private int accentColorIndex = 0;
    private ColorListAdapter dataAdapter;
    private TextView hintText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.material_color_picker, container, false);

        Spinner spinnerA = (Spinner) v.findViewById(R.id.spinnerPrimary);
        Spinner spinnerB = (Spinner) v.findViewById(R.id.spinnerAccent);

        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<MaterialColorTheme> colors = MaterialColorTheme.getAllColorThemes();

        // Creating adapter for spinner
        dataAdapter = new ColorListAdapter(getActivity(), R.layout.spinner_item, colors);

        // attaching both data adapter to spinner
        spinnerA.setAdapter(dataAdapter);
        spinnerB.setAdapter(dataAdapter);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialColorPickerHelper.update(getActivity(), getActivity().getIntent(), primaryColorIndex, accentColorIndex);
            }
        });

        hintText = (TextView) v.findViewById(R.id.hint);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinnerPrimary) {
            this.primaryColorIndex = position;
        } else if (parent.getId() == R.id.spinnerAccent) {
            this.accentColorIndex = position;
        }

        if(this.primaryColorIndex == this. accentColorIndex){
            hintText.setVisibility(View.VISIBLE);
        }else{
            hintText.setVisibility(View.GONE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

}
