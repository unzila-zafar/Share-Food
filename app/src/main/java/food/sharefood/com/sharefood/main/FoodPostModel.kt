package food.sharefood.com.sharefood.main

import android.os.Parcel
import android.os.Parcelable

data class FoodPostModel(var description: String, var time: String , var foodItems: String,
                         var foodQuantity: String, var foodLocation: String , var longitude: Double
                          , var latitude: Double , var foodPic: Int)
    : Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readDouble(),
            parcel.readInt()) {
    }

    public fun FoodPostModel()
    {

    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(description)
        parcel.writeString(time)
        parcel.writeString(foodItems)
        parcel.writeString(foodQuantity)
        parcel.writeString(foodLocation)
        parcel.writeInt(foodPic)
        parcel.writeDouble(longitude)
        parcel.writeDouble(latitude)
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