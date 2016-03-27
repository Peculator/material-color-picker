package de.peculator.material_color_picker;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sven on 27.03.16.
 */
public class MaterialColorPickerDialog extends DialogFragment implements AdapterView.OnItemSelectedListener {
    private int primaryColorIndex = 0;
    private int AccentColorIndex = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.material_color_picker, container, false);

        Spinner spinnerA = (Spinner) v.findViewById(R.id.spinnerPrimary);
        Spinner spinnerB = (Spinner) v.findViewById(R.id.spinnerAccent);

        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new CustomArrayAdapter(getActivity(), R.layout.spinner_item, categories);//new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerA.setAdapter(dataAdapter);
        spinnerB.setAdapter(dataAdapter);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialColorPickerHelper.update(getActivity(), getActivity().getIntent(), 0, 0);
            }
        });

        return v;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
