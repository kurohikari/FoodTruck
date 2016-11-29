package russ.xiang.foodtruck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class OrderActivity extends Activity {
    public ArrayAdapter<String> itemsAdapter;
    public ListView listView;
    ArrayList<Item> selectedItems; // ArrayList<MenuItem> items which is the data source for the array
    double dblTotalValue=0;
    TextView tvtotal1; // TextView that displays the total value
    Button button;
    Activity cur;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);
        cur = this;
        Log.d("Create","creae");
        
        ArrayList<String> soldItems = new ArrayList<String>();
        tvtotal1 = (TextView)findViewById(R.id.total1);
        listView = (ListView)findViewById(R.id.orderlist);// R.id.lvitems
        // button = (Button)findViewById(R.id.checkout);
        
        if (getIntent()!= null) {
            selectedItems = (ArrayList<Item>) getIntent().getSerializableExtra("selectedItems");
            soldItems = Item.getSoldItems(soldItems);
            
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_activated_1, soldItems); // soldItems as 
            // data source used for ArrayAdapter
            listView.setAdapter(adapterItems); // connect adapter to listview
            
        } else {
            selectedItems = null;
        }
 // XML file insert the selectedItems array 
       
    }


}
