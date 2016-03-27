package de.peculator.material_color_picker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sven on 27.03.16.
 */
public class CustomArrayAdapter extends ArrayAdapter<String> {

    private List<String> names;
    private Context context;

    public CustomArrayAdapter(Context context, int resourceId,
                              List<String> names) {
        super(context, resourceId, names);
        this.names = names;
        this.context = context;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, parent, false);
        TextView label = (TextView) row.findViewById(R.id.name);
        label.setText(names.get(position));

        View colorView = row.findViewById(R.id.color);
        colorView.setBackgroundColor(MaterialColorPickerHelper.getColorByName(names.get(position)));


        return row;
    }

}