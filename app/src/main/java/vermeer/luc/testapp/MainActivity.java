package vermeer.luc.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            String[] ids = {"arms", "ears", "eyebrows", "eyes", "glasses", "hat", "mouth", "mustache",
                    "nose", "shoes"};
            for (String id : ids){
                int r_id = getResources().getIdentifier(id, "id", getPackageName());
                ImageView image = (ImageView) findViewById(r_id);
                image.setVisibility(savedInstanceState.getInt(id));
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super
        String[] ids = {"arms", "ears", "eyebrows", "eyes", "glasses", "hat", "mouth", "mustache",
                "nose", "shoes"};
        for (String id : ids){
            int r_id = getResources().getIdentifier(id, "id", getPackageName());
            ImageView image = (ImageView) findViewById(r_id);
            outState.putInt(id, image.getVisibility());
        }
    }

    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        // The text is extracted from the checkbox and used as the id of the image.
        String stringId = checkbox.getText().toString();
        int r_id = getResources().getIdentifier(stringId, "id", getPackageName());
        ImageView image = (ImageView) findViewById(r_id);
        toggleVisibility(image);
    }

    private void toggleVisibility(ImageView image) {
        if (image.getVisibility() == View.VISIBLE) {
            image.setVisibility(View.INVISIBLE);
        } else {
            image.setVisibility(View.VISIBLE);
        }
    }
}