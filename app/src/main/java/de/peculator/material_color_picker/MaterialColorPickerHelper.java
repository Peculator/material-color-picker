package de.peculator.material_color_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Window;

/**
 * Created by sven on 27.03.16.
 */
public class MaterialColorPickerHelper {

    private static final String KEY_PRIMARY = "colorThemePrimaryIndex";
    private static final String KEY_ACCENT = "colorThemeAccentIndex";
    public static int primaryColorValue = -1;
    public static int primaryColorLightValue = -1;
    public static int accentColorValue = -1;

    public static int getPrimaryColor(){
        return primaryColorValue;
    }

    public static int getPrimaryLightColor(){
        return primaryColorLightValue;
    }
    public static int getAccentColor(){
        return accentColorValue;
    }

    public static void init(Context context, Intent intent, Window window, int defaultTheme) {
        Log.i("my", "init " + intent.getIntExtra(KEY_PRIMARY, -1));
        int primaryColor = intent.getIntExtra(KEY_PRIMARY, -1);
        int accentColor = intent.getIntExtra(KEY_ACCENT, -1);

        if (accentColor != -1 && primaryColor != -1) {

            String colorA = MaterialColorTheme.getAllColorNames().get(primaryColor);
            String colorB = MaterialColorTheme.getAllColorNames().get(accentColor);

            primaryColorValue = MaterialColorTheme.getColorResourceByName(context, "colorPrimary" + colorA.substring(0, 1).toUpperCase() + colorA.substring(1));
            accentColorValue = MaterialColorTheme.getColorResourceByName(context, "colorAccent" + colorB.substring(0, 1).toUpperCase() + colorB.substring(1));
            primaryColorLightValue = MaterialColorTheme.getColorResourceByName(context, "colorPrimaryLight" + colorA.substring(0, 1).toUpperCase() + colorA.substring(1));

            int res = MaterialColorTheme.getColorStyleByName(context, colorA + "." + colorB);

            if (res == 0) return;
            context.setTheme(res);
            context.getApplicationContext().setTheme(res);

            // Set the dark color
            // Build the name first
            String colorName = MaterialColorTheme.getAllColorNames().get(primaryColor);
            colorName = colorName.substring(0, 1).toUpperCase() + colorName.substring(1);
            String darkColorName = "colorPrimaryDark".concat(colorName);

            int darkColor = ContextCompat.getColor(context, context.getResources().getIdentifier(darkColorName,
                    "color", context.getPackageName()));

            window.setStatusBarColor(darkColor);
            window.setNavigationBarColor(darkColor);
        } else {
            context.setTheme(defaultTheme);
            context.getApplicationContext().setTheme(defaultTheme);

            primaryColorValue = MaterialColorTheme.getColorResourceByName(context, "colorPrimaryIndigo");
            accentColorValue = MaterialColorTheme.getColorResourceByName(context, "colorAccentPink");
            primaryColorLightValue = MaterialColorTheme.getColorResourceByName(context, "colorPrimaryLightIndigo");

        }
    }

    public static void update(Activity activity, Intent intent, int primaryColor, int accentColor) {

        intent.putExtra(KEY_PRIMARY, primaryColor);
        intent.putExtra(KEY_ACCENT, accentColor);

        if (activity != null) {
            activity.finish();
            activity.startActivity(intent);
        } else {
            Log.e("my", "activity is null");
        }
    }
}
