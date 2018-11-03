package food.sharefood.com.sharefood.user

import android.os.Parcel
import android.os.Parcelable

data class UserModel(var user_name:String, var email:String , var userType: String) : Parcelable
{
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user_name)
        parcel.writeString(email)
        parcel.writeString(userType)
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


}