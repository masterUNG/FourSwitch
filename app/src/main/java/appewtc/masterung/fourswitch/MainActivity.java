package appewtc.masterung.fourswitch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity {

    //Explicit
    private ToggleButton firstToggleButton, secondToggleButton,
            thirdToggleButton, forthToggleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();


    }   // onCreate

    private void bindWidget() {

        firstToggleButton = (ToggleButton) findViewById(R.id.toggleButton);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class
