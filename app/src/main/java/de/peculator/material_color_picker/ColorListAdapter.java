package de.peculator.material_color_picker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sven on 27.03.16.
 */
public class ColorListAdapter extends ArrayAdapter<String> {

    private List<MaterialColorTheme> colors;
    private Context context;

    public ColorListAdapter(Context context, int resourceId,
                            List<MaterialColorTheme> colors) {
        super(context, resourceId);
        this.colors = colors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }

    public View getCustomView(int position, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, parent, false);
        TextView label = (TextView) row.findViewById(R.id.name);
        label.setText(colors.get(position).getColorName(position));

        View colorView = row.findViewById(R.id.color);
        colorView.setBackgroundColor(MaterialColorTheme.getColorResourceByName(getContext(), "colorPrimary" + colors.get(position).getPrimaryColorName()));

        return row;
    }

}