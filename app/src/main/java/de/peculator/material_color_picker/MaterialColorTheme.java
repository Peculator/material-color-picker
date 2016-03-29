package de.peculator.material_color_picker;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sven on 29.03.16.
 */
public class MaterialColorTheme {
    private int index;

    public MaterialColorTheme(int index) {
        this.index = index;
    }

    private static List<MaterialColorTheme> allThemes;
    private static String[] allColors = new String[]{"red", "pink", "purple", "purpleDeep", "indigo", "blue",
            "blueLight", "cyan", "teal", "green", "greenLight", "lime", "yellow", "amber", "orange",
            "orangeDeep", "brown", "grey", "blueGrey"};


    public String getColorName(int index) {
        return allColors[index];
    }


    public static List<MaterialColorTheme> getAllColorThemes() {
        return allThemes;
    }

    public static List<String> getAllColorNames() {
        return Arrays.asList(allColors);
    }

    public String getPrimaryColorName() {
        return getColorName(this.index).substring(0, 1).toUpperCase() +
                getColorName(this.index).substring(1);
    }

    public static int getColorStyleByName(Context c, String name){
        return c.getResources().getIdentifier(name, "style", c.getPackageName());
    }

    public static int getColorResourceByName(Context c, String name) {
        return ContextCompat.getColor(c, c.getResources().getIdentifier(name, "color", c.getPackageName()));
    }

    static {
        allThemes = new ArrayList<>();
        for (int i = 0; i < allColors.length; i++) {
            allThemes.add(new MaterialColorTheme(i));
        }
    }
}
