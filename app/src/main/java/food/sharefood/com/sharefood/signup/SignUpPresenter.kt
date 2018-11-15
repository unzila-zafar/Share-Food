package food.sharefood.com.sharefood.signup

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AlertDialog
import food.sharefood.com.sharefood.databinding.ActivitySignupBinding
import food.sharefood.com.sharefood.user.UserModel
import food.sharefood.com.sharefood.util.FoodSharer
import food.sharefood.com.sharefood.util.Helper


class SignUpPresenter(var signUpView: SignUpView, var signUpInteractor: SignUpInteractor, var mContext: Context) : SignUpInteractor.onSignUpFinishedListener {

    private var spinnerPosition: Int = 0
    private var selectedImageUrl: String = ""
    private var currentLocation: String = ""
    private var locationManager: LocationManager? = null
    private lateinit var foodSharer: FoodSharer


    fun registerUser(context: Context, binding: ActivitySignupBinding) {
        signUpView.showProgress()

        if (checkData(binding)) {
            signUpInteractor.requestSignUpUser(context, this, foodSharer)
        }
    }

    fun checkData(binding: ActivitySignupBinding): Boolean {
        var checkValues: Boolean = false

        foodSharer = FoodSharer();

        foodSharer.loginId = binding.emailEdit.text.toString()
        foodSharer.name = binding.nameEdit.text.toString()
        foodSharer.password = binding.signupPassword.text.toString()

        //var confirmPassword: String = binding.confirmPwdEdit.text.toString()


        checkValues = !foodSharer.password.isEmpty()
        if (checkValues) {
            foodSharer.password = Helper.encrypt(foodSharer.password)

        } else {
            binding.passwordLayout.error = "Please enter password"
        }

        checkValues = !foodSharer.loginId.isEmpty()
        if (!checkValues) {
            foodSharer.loginId = Helper.encrypt(foodSharer.loginId)
            binding.emailLayout.error = "Please enter login id"
        }

        checkValues = !foodSharer.name.isEmpty()
        if (!checkValues) {
            foodSharer.name = Helper.encrypt(foodSharer.name)
            binding.nameLayout.error = "Please enter user name"
        }

        checkValues = spinnerPosition != 0
        if (checkValues) {
            foodSharer.registeredAs = Helper.encrypt(spinnerPosition.toString())
        }

        checkValues = !selectedImageUrl.isEmpty()

        if (checkValues) {
            foodSharer.picture = Helper.encrypt(selectedImageUrl)
        }

        checkValues = !currentLocation.isEmpty()

        if(checkValues)
        {
            foodSharer.address = Helper.encrypt(currentLocation)
        }

        return checkValues
    }

    fun setSpinnerSelectedPosition(position: Int) {
        spinnerPosition = position
    }


    override fun onSignUpSuccess(foodSharer: FoodSharer) {
        signUpView.registerUser()
    }

    override fun onSignUpFailure(message: String) {
        signUpView.hideProgress()
        signUpView.registerFailure(message)
    }

    override fun onSignUpSuccess() {
        signUpView.registerUser()
    }


    fun alertDialog(context: Context) {
        val builder = AlertDialog.Builder(context)

        val items = arrayOf<CharSequence>(
                "Camera",
                "Gallery",
                "Cancel")
        // Set the alert dialog title
        builder.setTitle("Choose image")
        builder.setItems(items, { _, which ->

            signUpView.selectImage(which)

        })

        // Create a new AlertDialog using builder object
        val dialog = builder.create()

        // Finally, display the alert dialog
        dialog.show()
    }

    fun saveSelectedImagePath(path: String) {
        selectedImageUrl = path
    }


    fun getCurrentLocation() {

        if (!isLocationEnabled())
            showAlert();

        //define the listener
        val locationListener: LocationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                currentLocation = location.latitude.toString() + "," + location.longitude.toString()
            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        if (Helper.checkPermission(mContext,
                        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                        , Helper.REQUEST_LOCATION)) {
            locationManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 0f, locationListener);
        }
    }


    private fun isLocationEnabled(): Boolean {
        locationManager = mContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        return locationManager!!.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }

    private fun showAlert() {
        val dialog = AlertDialog.Builder(mContext)
        dialog.setTitle("Enable Location")
                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " + "use this app")
                .setPositiveButton("Location Settings", DialogInterface.OnClickListener { paramDialogInterface, paramInt ->
                    val myIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    mContext.startActivity(myIntent)
                    paramDialogInterface.dismiss()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    paramDialogInterface, paramInt ->
                    paramDialogInterface.dismiss()
                })
        dialog.show()
    }


    /*  checkValues = !confirmPassword.isEmpty() && FoodSharer().password.equals(confirmPassword)

      if (!checkValues) {
          binding.confirmLayout.error = "Password doesn't match"
      } else {
          FoodSharer().password = getMd5Base64(FoodSharer().password).toString()
      }*/
}