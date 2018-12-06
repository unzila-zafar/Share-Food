package food.sharefood.com.sharefood.main

import android.os.Parcel
import android.os.Parcelable

data class FoodPostModel(var name: String, var time: String , var foodItems: String,
                         var foodQuantity: String, var foodLocation: String , var phoneNumber: Int, var foodPic: Int)
    : Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    public fun FoodPostModel()
    {

    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(time)
        parcel.writeString(foodItems)
        parcel.writeString(foodQuantity)
        parcel.writeString(foodLocation)
        parcel.writeInt(foodPic)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodPostModel> {
        override fun createFromParcel(parcel: Parcel): FoodPostModel {
            return FoodPostModel(parcel)
        }

        override fun newArray(size: Int): Array<FoodPostModel?> {
            return arrayOfNulls(size)
        }
    }

}