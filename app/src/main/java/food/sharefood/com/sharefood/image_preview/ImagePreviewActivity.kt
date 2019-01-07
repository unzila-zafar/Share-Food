package food.sharefood.com.sharefood.image_preview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ActivityImagePreviewBinding
import food.sharefood.com.sharefood.util.Extras

class ImagePreviewActivity : AppCompatActivity()
{

    private lateinit var binding : ActivityImagePreviewBinding
    private lateinit var  imagePath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_preview)


        if(intent != null)
        {
            imagePath = intent.getStringExtra(Extras.IMAGE_PATH)
        }

        if(imagePath != null)
        {
            Glide.with(this).load(imagePath).into(binding.imagePreview)
        }


        binding.imageBack.setOnClickListener {

            finish()
        }
    }
}