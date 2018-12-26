package food.sharefood.com.sharefood.add_food_post

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.support.constraint.solver.widgets.Helper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.R.id.action_menu_presenter
import food.sharefood.com.sharefood.R.id.image_food
import food.sharefood.com.sharefood.databinding.ItemPhotoBinding
import kotlinx.android.synthetic.main.item_food_list.view.*


class AddPhotoAdapter(var context: Context, var presenter: AddPostPresenter, var photoList: ArrayList<String>, var mode: String) : RecyclerView.Adapter<AddPhotoAdapter.AddPhotoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddPhotoHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemPhotoBinding.inflate(inflater)

        return AddPhotoAdapter.AddPhotoHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: AddPhotoHolder, position: Int) {

        if (mode.equals(food.sharefood.com.sharefood.util.Helper.postAddMode)) {

            if (isInteger(photoList.get(position))) {
                holder.binding.imageView.setImageResource(Integer.parseInt(photoList.get(position)))
                //Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
            } else {
                Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
            }
            //  if(position == 0)
            //  {
            // Glide.with(context).load(context.resources.getDrawable(R.drawable.ic_add, null)).into(holder.binding.imageView)
            //  }
            //   else
            // {
            // Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
            // }
        } else {
            Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
        }
        /*   if (isInteger(photoList.get(position))) {
               Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
           } else {
               Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)
           }*/
        //Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)


        /*  if (photoList.size != 10) {
              if (position == 0) {
                  Glide.with(context).load(R.drawable.ic_add).into(holder.binding.imageView)
              } else {
                  Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)


                  *//* Picasso.with(context).load(photoList.get(position)).into(object : com.squareup.picasso.Target {
                override fun onBitmapFailed(errorDrawable: Drawable?) {
                }

                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                    // loaded bitmap is here (bitmap)

                    holder.binding.imageView.setImageBitmap(bitmap)
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

            })*//*
            }
        } else {
            Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)

        }
*/
        holder.binding.imageView.setOnClickListener {
            if (position == 0) {
                presenter.alertDialog(context)
            }
        }

    }

    fun isInteger(s: String): Boolean {
        try {
            Integer.parseInt(s)
        } catch (e: NumberFormatException) {
            return false
        }

        // only got here if we didn't return false
        return true
    }


    class AddPhotoHolder(itemPhotoBinding: ItemPhotoBinding) : RecyclerView.ViewHolder(itemPhotoBinding.root) {

        var binding = itemPhotoBinding
    }
}