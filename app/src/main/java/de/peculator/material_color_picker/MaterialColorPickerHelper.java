package de.peculator.material_color_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Random;

/**
 * Created by sven on 27.03.16.
 */
public class MaterialColorPickerHelper {

    public static void init(Context context, Intent intent, int defaultTheme) {
        context.setTheme(intent.getIntExtra("colorTheme", defaultTheme));
    }

    public static void update(Activity activity, Intent intent, int primaryColor, int accentColor) {
        intent.putExtra("colorTheme", R.style.AppTheme_Purple_Amber_NoActionBar);
        if (activity != null) {
            activity.finish();
            activity.startActivity(intent);
        } else {
            Log.e("my", "activity is null");
        }
    }

    public static int getColorByName(String s) {
        return new Random().nextInt(Integer.MAX_VALUE);
    }
}
