package activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tuanjio.mytest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview_name)
    ListView mNamesLv;

    private final static String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        // 1. Prepare data to binding for listView
        final List nameList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            nameList.add("Item " + i);
        }
        //2.Create adapter with data and row
        ArrayAdapter<String> adapterName = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameList);

        //3. Set Adapter for ListView
        mNamesLv.setAdapter(adapterName);

        mNamesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, nameList.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mNamesLv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, nameList.get(position).toString() + "onItemLongClick", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mNamesLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e(TAG, "onScrollStateChanged: " + scrollState);
                switch (scrollState) {
                    case SCROLL_STATE_FLING:
                        Log.i(TAG, "The user had previously been scrolling using touch and had performed a fling. ");
                        break;
                    case SCROLL_STATE_IDLE:
                        Log.i(TAG, "The view is not scrolling.");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        Log.i(TAG, "The user is scrolling using touch, and their finger is still on the screen");
                        break;
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e(TAG, "onScroll: " + "firstVisibleItem: " + firstVisibleItem + ", visibleItemCount: " + visibleItemCount + ", totalCount: " + totalItemCount);
            }
        });
    }
}
