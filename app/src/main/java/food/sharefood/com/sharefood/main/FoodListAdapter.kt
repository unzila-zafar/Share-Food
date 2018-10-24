package food.sharefood.com.sharefood.main


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import food.sharefood.com.sharefood.R
import food.sharefood.com.sharefood.databinding.ItemFoodListBinding
import kotlinx.android.synthetic.main.item_food_list.view.*

class FoodListAdapter(private val foodDataList: List<FoodPostModel>, private val listener: (Int) -> Unit) : RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>() {

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) = holder.bind(foodDataList[position])


    override fun getItemCount(): Int {

        return foodDataList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        // var binding: ItemFoodListBinding =

        val inflater = LayoutInflater.from(parent.context)

        val binding = ItemFoodListBinding.inflate(inflater)

        //val view = inflater.inflate(R.layout.item_food_list, parent, false)
        return FoodViewHolder(binding)
        // return FoodViewHolder(View.inflate(parent.context , R.layout.item_food_list , parent))
    }


    inner class FoodViewHolder(itemBinding: ItemFoodListBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: FoodPostModel) {
            with(itemView) {
                text_time.text = item.time
                textLocation.text = item.foodLocation
                text_description.text = item.description
                image_food.setImageResource(item.foodPic)
                text_count_value.text = item.foodQuantity
                text_item_values.text = item.foodItems

            }
        }



    }
}