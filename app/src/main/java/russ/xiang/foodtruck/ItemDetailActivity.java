package russ.xiang.foodtruck;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
// MenuDetailsActivity

public class ItemDetailsActivity extends Activity {
    ItemDetailFragment fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail); // correct R.layout?

        Item item = (Item) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null) {
            fragmentItemDetail = MenuDetailFragment.newInstance(item);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.details, fragmentItemDetail); 
            ft.commit();
        }
    }

}
