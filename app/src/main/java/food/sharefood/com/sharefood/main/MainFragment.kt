package food.sharefood.com.sharefood.main

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.FragmentMainBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.Extras
import food.sharefood.com.sharefood.util.FoodSharePost


class MainFragment : Fragment(), MainView, MainActivity.ShowAlertDialogInterface {


    private lateinit var binding: FragmentMainBinding
    private lateinit var mainPresenter: MainPresenter
    private val PLACE_AUTOCOMPLETE_REQUEST_CODE = 188
    private lateinit var mContext: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)


        mainPresenter = MainPresenter(this, MainInteractor())
        mainPresenter.getListData(activity!!)

        MainActivity.setDialogInterface(this)

        LocalBroadcastManager.getInstance(mContext)
                .registerReceiver(broadCastReceiver, IntentFilter(Extras.REFRESH_POSTS_DATA))

        return binding.root

    }


    override fun showProgress() {
        DialogUtils.ShowProgressDialog(activity!!)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun setData(arrFood: List<FoodSharePost>) {

        if (arrFood.size != 0) {
            binding.foodList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)

            binding.foodList.adapter = FoodListAdapter(arrFood)
            {
                mainPresenter.onItemClick(it)
            }


        }
    }

    override fun setDataError(strError: String) {

    }

    override fun onItemClick(adapterPosition: Int) {
    }

    val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {

            when (intent?.action) {
                Extras.REFRESH_POSTS_DATA ->
                    mainPresenter.getListData(activity!!)

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LocalBroadcastManager.getInstance(activity!!)
                .unregisterReceiver(broadCastReceiver)
    }

    override fun showDialog(context: Context) {
        mainPresenter.showFilterDialog(context)
    }

    //show picker dialog for search
    override fun showLocationPicker() {
        val intent = PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                .build(activity)
        startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            PLACE_AUTOCOMPLETE_REQUEST_CODE -> {
                if (resultCode === Activity.RESULT_OK) {
                    val place = PlaceAutocomplete.getPlace(activity, data)
                    var longitude: Double = place.latLng.longitude
                    var latitude: Double = place.latLng.latitude
                    var placeName: String = place.name.toString()


                    mainPresenter.setLocationData(latitude, longitude, placeName)

                } else if (resultCode === PlaceAutocomplete.RESULT_ERROR) {
                    val status = PlaceAutocomplete.getStatus(activity, data)

                    Toast.makeText(activity, "No Location Found.", Toast.LENGTH_SHORT).show()

                } else if (resultCode === Activity.RESULT_CANCELED) {
                }
            }
        }
    }
}