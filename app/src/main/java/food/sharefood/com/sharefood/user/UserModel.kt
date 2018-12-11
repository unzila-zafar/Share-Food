package food.sharefood.com.sharefood.user

import android.os.Parcel
import android.os.Parcelable
import food.sharefood.com.sharefood.R.string.user_name

data class UserModel(var user_name:String, var email:String , var userType: String, var address: String,
                     var picture : String) : Parcelable
{

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user_name)
        parcel.writeString(email)
        parcel.writeString(userType)
        parcel.writeString(address)
        parcel.writeString(picture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }

    }

    fun getName(): String
    {
        return user_name
    }

    fun getUserPicture() : String
    {
        return picture
    }


}