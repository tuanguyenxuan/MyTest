package adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by TuanJio on 11/24/2016.
 */

public class NameAdapter extends ArrayAdapter {
    public NameAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }
}
