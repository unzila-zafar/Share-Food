package food.sharefood.com.sharefood.settings

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySettingsBinding
import food.sharefood.com.sharefood.user.UserModel
import android.support.v7.app.AlertDialog
import com.bumptech.glide.Glide

class FragmentSettings :Fragment()
{

    private lateinit var binding: ActivitySettingsBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_settings , container , false)

        var userModel = UserModel

        if(userModel != null)
        {
            //Glide.with(activity!!).load()
        }

        binding.passwordLayout.setOnClickListener {

        }



        return binding.root
    }



    private fun showLanguageDialog()
    {
        lateinit var dialogbuilder: AlertDialog
        var array = arrayOf(resources.getStringArray(R.array.language_array))
        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle(resources.getString(R.string.change_password))

/*

        builder.setSingleChoiceItems(array, 0, DialogInterface.OnClickListener { dialogInterface, i  ->

        })
        // Initialize the AlertDialog using builder object
        dialogbuilder = builder.create()

        // Finally, display the alert dialog
        dialogbuilder.show()*/
    }
}