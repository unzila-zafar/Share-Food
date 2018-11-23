package food.sharefood.com.sharefood.main


import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatDelegate
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.add_food_post.AddPostActivity
import food.sharefood.com.sharefood.databinding.ActivityMainBinding
import food.sharefood.com.sharefood.settings.FragmentSettings
import food.sharefood.com.sharefood.signup.SignupActivity

class MainActivity : FragmentActivity()
{

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    }

    private fun init()
    {
        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("Home"))
        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("Settings"))

        binding.tabsMain.getTabAt(0)?.select()

        binding.tabsMain.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                if(tab.position == 0)
                {
                    val fragment : MainFragment = MainFragment()
                    startFragment(fragment , "main_fragment")
                }
                else
                {
                    val settingsFragment: FragmentSettings = FragmentSettings()
                    startFragment(settingsFragment, "settings")
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

        binding.floatingActionButton.setOnClickListener {

            this@MainActivity.startActivity(Intent(this@MainActivity, AddPostActivity::class.java))

        }
    }

    fun startFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_frame, fragment, tag)
                .commit()
    }


}
