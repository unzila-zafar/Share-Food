package food.sharefood.com.sharefood.util

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import java.math.BigInteger
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.ArrayList

class Helper {


    companion object {
        val REQUEST_TAKE_PHOTO = 0
        val REQUEST_SELECT_IMAGE_IN_ALBUM = 1



        fun checkPermission(context: Context, permissions: Array<String>, requestCode: Int): Boolean {
            val currentAPIVersion = Build.VERSION.SDK_INT
            if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
                val requiredPermissions = ArrayList<String>()
                for (tempPermission in permissions) {
                    if (ContextCompat.checkSelfPermission(context, tempPermission) != PackageManager.PERMISSION_GRANTED) {
                        requiredPermissions.add(tempPermission)
                    }
                }

                if (requiredPermissions.size > 0) {

                    val trimmedPermissions = arrayOfNulls<String>(requiredPermissions.size)
                    var iCounter = 0
                    for (temp in requiredPermissions) {
                        trimmedPermissions[iCounter++] = temp
                    }
                    ActivityCompat.requestPermissions(context as Activity, trimmedPermissions, requestCode)
                    return false
                }
                return true
            } else {
                return true
            }
        }

        fun getMd5Base64(password: String): String? {
            val md5 = MessageDigest.getInstance("MD5")
            val hash = BigInteger(1, md5.digest(password.toByteArray(Charset.defaultCharset()))).toString(16)

            return hash
        }


        fun getRealPathFromURI(contentURI: Uri, context: Activity): String? {
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            val cursor = context.getContentResolver().query(contentURI, null, null, null, null)
                    ?: return null
            val column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            return if (cursor.moveToFirst()) {
                cursor.getString(column_index)
            } else null
        }

    }


}