package food.sharefood.com.sharefood.settings

import android.annotation.SuppressLint
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySettingsBinding
import android.support.v7.app.AlertDialog
import com.bumptech.glide.Glide
import food.sharefood.com.sharefood.databinding.DialogPasswordBinding
import food.sharefood.com.sharefood.util.AppSharedPref
import food.sharefood.com.sharefood.util.SharedPrefKeys

class FragmentSettings : Fragment() {

    private lateinit var binding: ActivitySettingsBinding


    @SuppressLint("NewApi")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.activity_settings, container, false)

        AppSharedPref.loadPrefs(activity!!)

        var picture = AppSharedPref.getData(SharedPrefKeys.PROFILE_PIC, AppSharedPref.STRING, activity!!)
        var userName = AppSharedPref.getData(SharedPrefKeys.NAME, AppSharedPref.STRING, activity!!)

        //TODO: location

        if (picture != null) {
            Glide.with(activity!!).load(activity!!.resources.getDrawable(R.drawable.ic_launcher_background, null)).into(binding.profileImage)
        }

        if (userName != null) {
            binding.textUserName.text = userName.toString()
        }


        binding.passwordLayout.setOnClickListener {
            showChangePasswordDialog()
        }



        return binding.root
    }

    private fun showChangePasswordDialog() {
        val dialogBuilder = AlertDialog.Builder(activity!!)
        val binding: DialogPasswordBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_password, null, false)

        dialogBuilder!!.setView(binding.getRoot())
        dialogBuilder.setCancelable(false)

        dialogBuilder.setTitle("Change Password")

        dialogBuilder.setPositiveButton("Change") { dialog, which ->

            dialog.dismiss()
        }

        dialogBuilder.setNegativeButton("Cancel") { dialog, which ->

            dialog.dismiss()
        }

        val dialog: AlertDialog = dialogBuilder!!.create()
        // Display the alert dialog on app interface
        dialog.show()
    }

    private fun showLanguageDialog() {
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