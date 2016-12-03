package russ.xiang.foodtruck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create our item elements

        items.add(new Item("1","Steak Sirloin", "10","0", "item_image_1"));
        items.add(new Item("2","Smoked Chicken Wings", "10","0", "item_image_2"));
        items.add(new Item("3","Salmon", "10","0", "item_image_3"));
        items.add(new Item("4","Lasagna", "10","0", "item_image_4"));

        //create our new array adapter
        ArrayAdapter<Item> adapter = new itemArrayAdapter(this, 0, items);

        //Find list view and bind it with the custom adapter
        ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);


        //add event listener so we can handle clicks
        AdapterView.OnItemClickListener adapterViewListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item = items.get(position);

                Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
                
                intent.putExtra("image", item.getImage());

                startActivityForResult(intent, 1000);
            }
        };
        //set the listener to the list view
        listView.setOnItemClickListener(adapterViewListener);


    }

    //custom ArrayAdapater
    class itemArrayAdapter extends ArrayAdapter<item>{

        private Context context;
        private List<Item> items;

        //constructor, call on creation
        public propertyArrayAdapter(Context context, int resource, ArrayList<Item> objects) {
            super(context, resource, objects);

            this.context = context;
            this.items = objects;
        }

        //called when rendering the list
        public View getView(int position, View convertView, ViewGroup parent) {

            //get the property we are displaying
            Item item = getItem(position);

            //get the inflater and inflate the XML layout for each item
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            //conditionally inflate either standard or special template
            View view;
            view = inflater.inflate(R.layout.property_layout, null);// prop
           
            TextView header = (TextView) view.findViewById(R.id.header);
            TextView price = (TextView) view.findViewById(R.id.price);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            //set address and description
            String completeHeader = item.getItemId() + ". " + item.getName();
            header.setText(completeHeader);

            //set price and rental attributes
            price.setText("$" + String.valueOf(item.getPrice()));

            //get the image associated with this property
            int imageID = context.getResources().getIdentifier(item.getImage(), "drawable", context.getPackageName());
            image.setImageResource(imageID);

            return view;
        }
    }


}
