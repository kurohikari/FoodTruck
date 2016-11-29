package russ.xiang.foodtruck;


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

// MenuDetailFragment

public class ItemDetailFragment extends Fragment implements View.OnClickListener {
    private Item item; 
    Button button1;// instead of btn
    EditText new_quantity;
    private View view;
    TextView tvHeader; // includes the item's itemID, name, and price
    
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		item = (Item) getArguments().getSerializable("item");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_item_detail, 
				container, false);
                
         new_quanity = (EditText) view.findViewById(R.id.new_quantity);
         tvHeader = (TextView) view.findViewById(R.id.header);
         
        button1 = (Button) view.findViewById(R.id.button1);
        if (item != null) {
            tvHeader.setText(item.getItemId() + ". "+ item.getName() +" $ " + item.getPrice());
            new_quanity.setText("0"); // quantity initialized to zero
            button1.setOnClickListener(this);
        }
        return view;
        
	}
    
    /* Crate a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ItemDetailFragment.
     */

    public static ItemDetailFragment newInstance(Item item) {
    	ItemDetailFragment fragmentDemo = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
    
    
   @Override
    public void onClick(View v) {
       int quantity = 0;
       if (new_quanity.getText().equals("") == false) {
           quantity = Integer.parseInt(new_quanity.getText().toString());
       }
       
       item.setQuantity(Integer.toString(quantity));
       Intent intent = this.getActivity().getIntent();
       intent.putExtra("modified_list",item);
       this.getActivity().setResult(1,intent);
       this.getActivity().finish();
       }

    public void modifyDetails(String title, String description, String price) {
        tvTitle.setText(title);
        tvdesc.setText(description);
    }

}
