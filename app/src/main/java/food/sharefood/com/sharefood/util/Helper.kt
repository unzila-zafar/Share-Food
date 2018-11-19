package food.sharefood.com.sharefood.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.nio.ByteBuffer
import java.security.SecureRandom
import java.util.*
import javax.crypto.spec.GCMParameterSpec
import android.util.Base64.NO_WRAP
import android.graphics.Bitmap
import java.io.ByteArrayOutputStream


class Helper {


    companion object {
        val REQUEST_TAKE_PHOTO = 0
        val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
        val REQUEST_LOCATION = 2



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


        fun String.encrypt(password: String): String {
            val secretKeySpec = SecretKeySpec(password.toByteArray(), "AES")
            val iv = ByteArray(16)
            val charArray = password.toCharArray()
            for (i in 0 until charArray.size){
                iv[i] = charArray[i].toByte()
            }
            val ivParameterSpec = IvParameterSpec(iv)

            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec)

            val encryptedValue = cipher.doFinal(this.toByteArray())
            return encryptedValue.toString()
        }

        @SuppressLint("NewApi")
        @Throws(Exception::class)
        fun encrypt(Data: String): String {
            val secureRandom = SecureRandom()
            val key = ByteArray(16)
            secureRandom.nextBytes(key)
            val secretKey = SecretKeySpec(key, "AES")
            val iv = ByteArray(12) //NEVER REUSE THIS IV WITH SAME KEY
            secureRandom.nextBytes(iv)

            val cipher = Cipher.getInstance("AES/GCM/NoPadding")
            val parameterSpec = GCMParameterSpec(128, iv) //128 bit auth tag length
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec)
            val cipherText = cipher.doFinal(Data.toByteArray())

            var byteBuffer = ByteBuffer.allocate(4 + iv.size + cipherText.size);
            byteBuffer.putInt(iv.size)
            byteBuffer.put(iv)
            byteBuffer.put(cipherText)
            var cipherMessage = byteBuffer.array()

            return cipherMessage.toString()
        }

        fun decrypt(data:String) : String{
            val byteBuffer = ByteBuffer.wrap(data.toByteArray())
            val ivLength = byteBuffer.int
            if (ivLength < 12 || ivLength >= 16) { // check input parameter
                throw IllegalArgumentException("invalid iv length")
            }
            val iv = ByteArray(ivLength)
            byteBuffer.get(iv)
            val cipherText = ByteArray(byteBuffer.remaining())

            return byteBuffer.get(cipherText).toString()
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