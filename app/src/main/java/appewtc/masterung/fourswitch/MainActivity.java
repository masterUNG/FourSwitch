package appewtc.masterung.fourswitch;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
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

    class Looper extends BaseIOIOLooper {

        //Explicit
        private DigitalOutput firstDigitalOutput, secondDigitalOutput,
                            thirdDigitalOutput, fourthDigitalOutput;


        @Override
        protected void setup() throws ConnectionLostException, InterruptedException {

            //Assign Signal to pin
            firstDigitalOutput = ioio_.openDigitalOutput(1, false);
            secondDigitalOutput = ioio_.openDigitalOutput(3, false);
            thirdDigitalOutput = ioio_.openDigitalOutput(5, false);
            fourthDigitalOutput = ioio_.openDigitalOutput(7, false);

            //ตรวจสอบว่า เชื่อมต่อกับ IOIO Board หรือยัง?
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "เชื่อมต่อ ได้แว้วววว", 5000).show();
                }
            });



            //super.setup();
        }   // setup

        @Override
        public void loop() throws ConnectionLostException, InterruptedException {

            //Assign Action
            firstDigitalOutput.write(firstToggleButton.isChecked());
            secondDigitalOutput.write(secondToggleButton.isChecked());
            thirdDigitalOutput.write(thirdToggleButton.isChecked());
            fourthDigitalOutput.write(forthToggleButton.isChecked());

            //ยอมให้มีการหายของสัญญาณ
            try {

                Thread.sleep(100);

            } catch (Exception e) {
                e.printStackTrace();
            }



            //super.loop();
        }   // loop
    }   // Looper class

    protected IOIOLooper createIOIOLooper() {

        return new Looper();
    }


    private void bindWidget() {

        firstToggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        secondToggleButton = (ToggleButton) findViewById(R.id.toggleButton2);
        thirdToggleButton = (ToggleButton) findViewById(R.id.toggleButton3);
        forthToggleButton = (ToggleButton) findViewById(R.id.toggleButton4);

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
