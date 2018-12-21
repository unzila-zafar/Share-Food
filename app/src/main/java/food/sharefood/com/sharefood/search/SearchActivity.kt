package food.sharefood.com.sharefood.search

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivitySearchBinding
import food.sharefood.com.sharefood.network.VolleyClass.Companion.context

class SearchActivity : AppCompatActivity()
{
    private lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

        binding.filterBtn.setOnClickListener {
            showFilterDialog()
        }

    }


    private fun showFilterDialog()
    {

        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_filter, null)
        dialogBuilder!!.setView(dialogView)
        val dialog: AlertDialog = dialogBuilder!!.create()

        // Display the alert dialog on app interface
        dialog.show()
    }
}