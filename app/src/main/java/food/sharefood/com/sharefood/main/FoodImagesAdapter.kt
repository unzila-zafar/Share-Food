package food.sharefood.com.sharefood.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

import food.sharefood.com.sharefood.databinding.ItemImagesFoodBinding

import kotlinx.android.synthetic.main.item_images_food.view.*


class FoodImagesAdapter(val context: Context, private val imagesList: ArrayList<String>?) : RecyclerView.Adapter<FoodImagesAdapter.FoodImagesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodImagesHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemImagesFoodBinding.inflate(inflater)

        //val view = inflater.inflate(R.layout.item_food_list, parent, false)
        return FoodImagesHolder(binding)
    }

    override fun getItemCount(): Int {

        return imagesList!!.size
    }

    override fun onBindViewHolder(holder: FoodImagesHolder, position: Int) = holder.bind(imagesList!!.get(position))


    inner class FoodImagesHolder(item: ItemImagesFoodBinding) : RecyclerView.ViewHolder(item.root) {
        fun bind(item: String) {
            with(itemView) {
                Glide.with(context).load(item).into(image_food)

            }

        }
    }
}