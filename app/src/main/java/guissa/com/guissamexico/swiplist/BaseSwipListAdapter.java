package guissa.com.guissamexico.swiplist;

/**
 * Created by Alfonso on 22/02/2018.
 */

import android.widget.BaseAdapter;


public abstract class BaseSwipListAdapter extends BaseAdapter {

    public boolean getSwipEnableByPosition(int position) {
        return true;
    }
}
