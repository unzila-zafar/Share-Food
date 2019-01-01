package food.sharefood.com.sharefood.main


import android.content.Context
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

import android.support.v4.app.FragmentTransaction
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.Helper


class MainActivity : FragmentActivity() {

    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

    }

    private fun init() {

        val fragment: MainFragment = MainFragment()
        val settingsFragment: FragmentSettings = FragmentSettings()
        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("Home"))
        binding.tabsMain.addTab(binding.tabsMain.newTab().setText("Settings"))


        startFragment(fragment, "main_fragment")



        binding.tabsMain.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                if (tab.position == 0) {
                    //val fragment: MainFragment = MainFragment()
                    startFragment(fragment, "main_fragment")
                } else {
                    //val settingsFragment: FragmentSettings = FragmentSettings()
                    startFragment(settingsFragment, "settings")
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })

        binding.floatingActionButton.setOnClickListener {

            val intent = Intent(this@MainActivity, AddPostActivity::class.java)
            intent.putExtra(Extras.IS_FROM_HOME, true)
            this@MainActivity.startActivityForResult(intent, Extras.ADD_POST_DATA)

        }

        binding.mainToolbar.toolbar.title = getString(R.string.dashboard)

        binding.mainToolbar.imageSearch.setOnClickListener {

            if(showDialogInterface!= null)
            {
                showDialogInterface.showDialog(this)
            }
            //showFilterDialog()
            //startActivity(Intent(this@MainActivity, SearchActivity::class.java))
        }
    }

    fun startFragment(fragment: Fragment, tag: String) {

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.fragment_frame, fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        ft.commit()

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            Extras.ADD_POST_DATA -> {
                val intent = Intent()
                intent.setAction(Extras.REFRESH_POSTS_DATA)
                sendBroadcast(intent)
            }


        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Helper.displayList.clear()
        Helper.foodPostImagesArray.clear()
    }

    interface ShowAlertDialogInterface
    {
        fun showDialog(context: Context)
    }

    companion object {
        lateinit var showDialogInterface : ShowAlertDialogInterface


        fun setDialogInterface(showAlertDialogInterface: ShowAlertDialogInterface)
        {
            showDialogInterface = showAlertDialogInterface
        }


    }




}
