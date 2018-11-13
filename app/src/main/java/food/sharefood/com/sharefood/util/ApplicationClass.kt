package food.sharefood.com.sharefood.util

import android.app.Application
import com.cloudinary.android.MediaManager

class ApplicationClass : Application()
{

    override fun onCreate() {
        super.onCreate()

        MediaManager.init(this);

    }
}