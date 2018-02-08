package app.listview.pedor.com.potato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public Map<String, Integer> visibility = new HashMap<String, Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Map<String, Integer> visibility = new HashMap<String, Integer>();
        String[] myints = {"arms", "ears", "eyebrows", "eyes", "glasses", "hat", "mouth", "mustache", "nose", "shoes"} ;
        for(String part : myints) {
            if (savedInstanceState != null) {
                visibility.put(part, savedInstanceState.getInt(part));
            } else {
                visibility.put(part, View.INVISIBLE);
            }
            System.out.println(visibility.get("eyes"));
            ImageView image = (ImageView) findViewById(getResources().getIdentifier(part, "id", getPackageName()));
            image.setVisibility(visibility.get(part));
        }
    }


    public void checkClicked(View v) {
        Log.d("potato", "checkClicked: ");
        CheckBox checkbox = (CheckBox) v;
        String bodyPart = checkbox.getText().toString().toLowerCase();
        ImageView image = (ImageView) findViewById(getResources().getIdentifier(bodyPart, "id", getPackageName()));
        if (checkbox.isChecked()) {
            image.setVisibility(View.VISIBLE);
            visibility.put(bodyPart, View.VISIBLE);
        } else {
            image.setVisibility(View.INVISIBLE);
            visibility.put(bodyPart, View.INVISIBLE);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        for (Map.Entry<String, Integer> combination : visibility.entrySet()) {
            outState.putInt(combination.getKey(), combination.getValue());
        }
    }
}
