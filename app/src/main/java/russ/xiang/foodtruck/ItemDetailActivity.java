package russ.xiang.foodtruck;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public class ItemDetailActivity extends Activity implements OnClickListener {
    private Item item; 
    Button button1;
    EditText new_quantity;
    private View view;
    TextView tvHeader; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail_layout);
    }
}


import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ItemDetailActivity extends Activity implements OnClickListener {

	CheckBox checkBox;
	EditText editText; // Edit current quantity of the menu item
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_detail_layout);

		checkBox = (CheckBox) findViewById(R.id.checkBox1);
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
		loadSavedPreferences();
	}

	private void loadSavedPreferences() {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean checkBoxValue = sharedPreferences.getBoolean("CheckBox_Value", false);
		String quantity = sharedPreferences.getString("storedQuantity", "Quantity");
		if (checkBoxValue) {
			checkBox.setChecked(true);
		} else {
			checkBox.setChecked(false);
		}

		editText.setText(quantity);
	}

	private void savePreferences(String key, boolean value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit(); // Edit value saved in SharedPreferences obj
		editor.putBoolean(key, value);
		editor.commit();
	}

	private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		savePreferences("CheckBox_Value", checkBox.isChecked());
		if (checkBox.isChecked())
			savePreferences("storedQuantity", editText.getText().toString());

		finish();
	}

}