package food.sharefood.com.sharefood.main

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.DialogFilterBinding
import food.sharefood.com.sharefood.util.FoodSharePost
import java.text.SimpleDateFormat
import java.util.*

class MainPresenter(private var mainView: MainView, private val mainInteractor: MainInteractor)
    : MainInteractor.OnFinishedListener {

    private lateinit var foodSharePost: FoodSharePost
    private lateinit var binding: DialogFilterBinding

    fun getListData(context: Context) {
        mainView.showProgress()
        mainInteractor.requestData(context, this)
    }

    fun searchPost(context: Context) {
        mainView.showProgress()

        if(foodSharePost != null)
        {
            mainInteractor.requestSearch(context,foodSharePost, this)
        }
    }

    fun setSearchData(binding: DialogFilterBinding) {
        foodSharePost = FoodSharePost()

        if (!binding.searchNameEdit.text.isEmpty()) {
            foodSharePost.name = binding.searchNameEdit.text.toString()
        }

        if (!binding.searchEmailEdit.text.isEmpty()) {
            foodSharePost.email = binding.searchEmailEdit.text.toString() }

        if (!binding.searchSufficientEdit.text.isEmpty()) {
            foodSharePost.sufficientFor = binding.searchSufficientEdit.text.toString()
        }

        if (!binding.searchPicktimeEdit.text.isEmpty()) {
            foodSharePost.pickUntilTime = binding.searchPicktimeEdit.text.toString()
        }

        if (!binding.searchLocationEdit.text.isEmpty()) {
            foodSharePost.foodPickupLocation = binding.searchLocationEdit.text.toString()
        }

        if (!binding.searchSufficientEdit.text.isEmpty()) {
            foodSharePost.sufficientFor = binding.searchSufficientEdit.text.toString()
        }
        if (!binding.searchFooditemsEdit.text.isEmpty()) {
            foodSharePost.foodItems = binding.searchFooditemsEdit.text.toString()
        }
    }

    fun showFilterDialog(context: Context) {

        val dialogBuilder = AlertDialog.Builder(context)
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.dialog_filter, null, false)

        dialogBuilder!!.setView(binding.getRoot())
        dialogBuilder.setCancelable(false)

        val dialog: AlertDialog = dialogBuilder!!.create()

        binding.searchbutton.setOnClickListener {
            setSearchData(binding)
            searchPost(context)
            dialog.dismiss()
        }

        binding.cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        binding.searchPicktimeEdit.setOnClickListener {
            showDatePickerDialog(context)
        }

        binding.searchLocationEdit.setOnClickListener {
            mainView.showLocationPicker()
        }
        // Display the alert dialog on app interface
        dialog.show()
    }

    fun setLocationData(longitude: Double, latitude: Double, place: String)
    {
        foodSharePost.foodPickupLocation = latitude.toString() + "," + longitude.toString()
        if(binding != null)
        {
            binding.searchLocationEdit.setText(place)
        }
    }


    override fun onResultSuccess(arrFoodList: List<FoodSharePost>) {
        mainView.hideProgress()
        mainView.setData(arrFoodList)
    }

    override fun onResultFail(strError: String) {
        mainView.hideProgress()
    }

    fun onItemClick(adapterPosition: Int) {
        mainView.onItemClick(adapterPosition)
    }

    fun showDatePickerDialog(context: Context) {
        val c = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd")

        val datePickerStart = DatePickerDialog(context,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    Log.d("Date", "Selected date")
                    val picked_date = year.toString() + "-" + (monthOfYear + 1) + "-" + dayOfMonth

                    TimePickerDialog(context, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                        val AM_PM: String
                        if (hourOfDay < 12) {
                            AM_PM = "AM"
                        } else {
                            AM_PM = "PM"
                        }

                        var time = String.format("%2d", hourOfDay) + ":" + String.format("%2d", minute) + " " + AM_PM

                        foodSharePost.pickUntilTime = time
                    }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), false).show()

                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
        datePickerStart.show()
    }

}