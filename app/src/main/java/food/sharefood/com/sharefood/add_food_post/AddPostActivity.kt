package food.sharefood.com.sharefood.add_food_post

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityAddPostBinding
import food.sharefood.com.sharefood.dialog.DialogUtils
import food.sharefood.com.sharefood.util.FoodSharePost

class AddPostActivity : AppCompatActivity(), AddPostView {


    private lateinit var binding: ActivityAddPostBinding
    private lateinit var presenter: AddPostPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_post)


        init()

    }


    private fun init() {

        setSupportActionBar(binding.toolbar.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);

        binding.toolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        presenter = AddPostPresenter(this, AddPostInteractor())

        binding.buttonAdd.setOnClickListener {

            presenter.addPost(this, binding)
            finish()
        }
    }


    override fun showProgress() {
        DialogUtils.ShowProgressDialog(this)
    }

    override fun hideProgress() {
        DialogUtils.HideProgressDialog()
    }

    override fun onSuccess(foodSharePost: FoodSharePost) {
    }

    override fun onFailure(message: String) {
    }
}