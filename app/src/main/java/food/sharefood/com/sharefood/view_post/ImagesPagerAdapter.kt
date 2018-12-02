package food.sharefood.com.sharefood.view_post


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ImagesPagerAdapter(fragmentManager: FragmentManager, private val images: ArrayList<Integer>) :
        FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /* // 2
     override fun getItem(position: Int): Fragment {
         return MovieFragment.newInstance(movies[position])
     }*/

    // 3
    override fun getCount(): Int {
        return images.size
    }
}