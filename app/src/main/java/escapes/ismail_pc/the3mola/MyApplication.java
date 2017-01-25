package escapes.ismail_pc.the3mola;

/**
 * Created by ismail-pc on 23 - 01 - 2017.
 */

import android.app.Application;
import com.pushbots.push.Pushbots;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize Pushbots Library
        Pushbots.sharedInstance().init(this);
    }
}