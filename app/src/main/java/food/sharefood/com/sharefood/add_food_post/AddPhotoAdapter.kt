package food.sharefood.com.sharefood.add_food_post

import android.content.Context
import android.graphics.Bitmap
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


class AddPhotoAdapter(var context: Context, var presenter: AddPostPresenter, var photoList: ArrayList<Bitmap>) : RecyclerView.Adapter<AddPhotoAdapter.AddPhotoHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddPhotoHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemPhotoBinding.inflate(inflater)

        return AddPhotoAdapter.AddPhotoHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: AddPhotoHolder, position: Int) {

        if (position == 0) {
            Glide.with(context).load(R.drawable.ic_add).into(holder.binding.imageView)
        } else {
            Glide.with(context).load(photoList.get(position)).into(holder.binding.imageView)

        }

        holder.binding.imageView.setOnClickListener {
            if (position == 0) {
                presenter.alertDialog(context)
            }
        }

    }


    class AddPhotoHolder(itemPhotoBinding: ItemPhotoBinding) : RecyclerView.ViewHolder(itemPhotoBinding.root) {

        var binding = itemPhotoBinding
    }
}