package food.sharefood.com.sharefood.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
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
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.io.ByteArrayOutputStream
import android.util.Base64
import com.cloudinary.android.MediaManager
import food.sharefood.com.sharefood.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.FileNotFoundException
import java.io.InputStream
import kotlin.collections.ArrayList


class Helper {


    companion object {
        val REQUEST_TAKE_PHOTO = 0
        val REQUEST_SELECT_IMAGE_IN_ALBUM = 1
        val REQUEST_LOCATION = 2
        val LOCATION_PERMISSION_REQUEST_CODE = 222
        val postAddMode = "add"
        val postEditMode = "edit"

        var foodPostImagesArray: ArrayList<String> = ArrayList()
        var displayList: java.util.ArrayList<String> = java.util.ArrayList()


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


        fun setDataInList(picPath: String): ArrayList<String> {
            var encryptedImagesList: ArrayList<String> = ArrayList()

            //var encodedString = Helper.encoder(picPath)
            var encodedString = MediaManager.get().url().secure(true).generate(picPath)

            encryptedImagesList.add(encodedString)

            return encryptedImagesList
        }


        @SuppressLint("NewApi")
        fun encoder(filePath: String): String {

            val baos = ByteArrayOutputStream()
            val bitmap = BitmapFactory.decodeFile(filePath)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val imageBytes = baos.toByteArray()
            val base64 = Base64.encodeToString(imageBytes, Base64.DEFAULT)

            /*     val baos = ByteArrayOutputStream()
                 val bitmap = BitmapFactory.decodeFile(filePath)
                 bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
                 val imageBytes = baos.toByteArray()

                 val bytes = File(filePath).readBytes()
                 val base64 = Base64.encodeToString(imageBytes)*/
            return base64
        }


        fun String.encrypt(password: String): String {
            val secretKeySpec = SecretKeySpec(password.toByteArray(), "AES")
            val iv = ByteArray(16)
            val charArray = password.toCharArray()
            for (i in 0 until charArray.size) {
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

        fun decrypt(data: String): String {
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

        fun checkNetworkConnectivity(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

            return isConnected
        }


        fun setUserData(rootObject: JSONObject): FoodSharer {
            var foodSharer = FoodSharer()

            if (rootObject.has(APIParams.LOGIN_ID) && !rootObject.isNull(APIParams.LOGIN_ID)) {
                foodSharer.loginId = rootObject.getString(APIParams.LOGIN_ID)
            }

            if (rootObject.has(APIParams.NAME) && !rootObject.isNull(APIParams.NAME)) {
                foodSharer.name = rootObject.getString(APIParams.NAME)
            }

            if (rootObject.has(APIParams.ADDRESS) && !rootObject.isNull(APIParams.ADDRESS)) {
                foodSharer.address = rootObject.getString(APIParams.ADDRESS)
            }

            if (rootObject.has(APIParams.REGISTERED_AS) && !rootObject.isNull(APIParams.REGISTERED_AS)) {
                foodSharer.registeredAs = rootObject.getString(APIParams.REGISTERED_AS)
            }

            if (rootObject.has(APIParams.PICTURE) && !rootObject.isNull(APIParams.PICTURE)) {
                foodSharer.picture = rootObject.getString(APIParams.PICTURE)
            }

            if (rootObject.has(APIParams.TOKEN) && !rootObject.isNull(APIParams.TOKEN)) {
                foodSharer.token = rootObject.getString(APIParams.TOKEN)

            }

            if (rootObject.has(APIParams.TOKEN_START) && !rootObject.isNull(APIParams.TOKEN_START)) {
                foodSharer.tokenStartTime = rootObject.getLong(APIParams.TOKEN_START)
            }

            if (rootObject.has(APIParams.TOKEN_END) && !rootObject.isNull(APIParams.TOKEN_END)) {
                foodSharer.tokenExpiryTime = rootObject.getLong(APIParams.TOKEN_END)
            }

            return foodSharer
        }


        fun setFoodPostData(rootArray: JSONArray): List<FoodSharePost> {
            var arrayFoodData: MutableList<FoodSharePost> = mutableListOf()
            (0..(rootArray.length() - 1)).forEach { i ->
                var rootObject = rootArray.getJSONObject(i)


                var foodSharePost = FoodSharePost()
                if (rootObject.has(APIParams._ID) && !rootObject.isNull(APIParams._ID)) {
                    foodSharePost._id = rootObject.getString(APIParams._ID)
                }


                if (rootObject.has(APIParams.EMAIL) && !rootObject.isNull(APIParams.EMAIL)) {
                    foodSharePost.email = rootObject.getString(APIParams.EMAIL)
                }

                if (rootObject.has(APIParams.NAME) && !rootObject.isNull(APIParams.NAME)) {
                    foodSharePost.name = rootObject.getString(APIParams.NAME)
                }

                if (rootObject.has(APIParams.SUFFICIENT_FOR) && !rootObject.isNull(APIParams.SUFFICIENT_FOR)) {
                    foodSharePost.sufficientFor = rootObject.getString(APIParams.SUFFICIENT_FOR)
                }

                if (rootObject.has(APIParams.PICKUP_TIME) && !rootObject.isNull(APIParams.PICKUP_TIME)) {
                    foodSharePost.pickUntilTime = rootObject.getString(APIParams.PICKUP_TIME)
                }

                if (rootObject.has(APIParams.PICKUP_LOCATION) && !rootObject.isNull(APIParams.PICKUP_LOCATION)) {
                    foodSharePost.foodPickupLocation = rootObject.getString(APIParams.PICKUP_LOCATION)
                }

                if (rootObject.has(APIParams.TOKEN) && !rootObject.isNull(APIParams.TOKEN)) {
                    foodSharePost.token = rootObject.getString(APIParams.TOKEN)

                }

                if (rootObject.has(APIParams.FOOD_ITEMS) && !rootObject.isNull(APIParams.FOOD_ITEMS)) {
                    foodSharePost.foodItems = rootObject.getString(APIParams.FOOD_ITEMS)
                }

                if (rootObject.has(APIParams.PHONE_NUMBER) && !rootObject.isNull(APIParams.PHONE_NUMBER)) {
                    foodSharePost.phone_number = rootObject.getString(APIParams.PHONE_NUMBER)
                }


                if (rootObject.has(APIParams.POST_PICTURES) && !rootObject.isNull(APIParams.POST_PICTURES)) {
                    var pixArray = rootObject.getJSONArray(APIParams.POST_PICTURES)
                    (0..(pixArray.length() - 1)).forEach { j ->
                        foodSharePost.postPictures?.add(pixArray.get(j).toString())
                    }
                }
                if (rootObject.has(APIParams.LATITUDE) && !rootObject.isNull(APIParams.LATITUDE)) {
                    foodSharePost.latitude = rootObject.getString(APIParams.LATITUDE)
                }
                if (rootObject.has(APIParams.LONGITUDE) && !rootObject.isNull(APIParams.LONGITUDE)) {
                    foodSharePost.longitude = rootObject.getString(APIParams.LONGITUDE)
                }

                arrayFoodData.add(foodSharePost)

            }
            return arrayFoodData
        }


        fun addFoodPostData(rootObject: JSONObject): FoodSharePost {
            // var arrayFoodData: MutableList<FoodSharePost> = mutableListOf()

            var foodSharePost = FoodSharePost()

            if (rootObject.has(APIParams._ID) && !rootObject.isNull(APIParams._ID)) {
                foodSharePost._id = rootObject.getString(APIParams._ID)
            }

            if (rootObject.has(APIParams.EMAIL) && !rootObject.isNull(APIParams.EMAIL)) {
                foodSharePost.email = rootObject.getString(APIParams.EMAIL)
            }

            if (rootObject.has(APIParams.NAME) && !rootObject.isNull(APIParams.NAME)) {
                foodSharePost.name = rootObject.getString(APIParams.NAME)
            }

            if (rootObject.has(APIParams.SUFFICIENT_FOR) && !rootObject.isNull(APIParams.SUFFICIENT_FOR)) {
                foodSharePost.sufficientFor = rootObject.getString(APIParams.SUFFICIENT_FOR)
            }

            if (rootObject.has(APIParams.PICKUP_TIME) && !rootObject.isNull(APIParams.PICKUP_TIME)) {
                foodSharePost.pickUntilTime = rootObject.getString(APIParams.PICKUP_TIME)
            }

            if (rootObject.has(APIParams.PICKUP_LOCATION) && !rootObject.isNull(APIParams.PICKUP_LOCATION)) {
                foodSharePost.foodPickupLocation = rootObject.getString(APIParams.PICKUP_LOCATION)

            }

            if (rootObject.has(APIParams.TOKEN) && !rootObject.isNull(APIParams.TOKEN)) {
                foodSharePost.token = rootObject.getString(APIParams.TOKEN)

            }

            if (rootObject.has(APIParams.FOOD_ITEMS) && !rootObject.isNull(APIParams.FOOD_ITEMS)) {
                foodSharePost.foodItems = rootObject.getString(APIParams.FOOD_ITEMS)
            }

            if (rootObject.has(APIParams.PHONE_NUMBER) && !rootObject.isNull(APIParams.PHONE_NUMBER)) {
                foodSharePost.phone_number = rootObject.getString(APIParams.PHONE_NUMBER)
            }

            if (rootObject.has(APIParams.LONGITUDE) && !rootObject.isNull(APIParams.LONGITUDE)) {
                foodSharePost.longitude = rootObject.getString(APIParams.LONGITUDE)
            }
            if (rootObject.has(APIParams.LATITUDE) && !rootObject.isNull(APIParams.LATITUDE)) {
                foodSharePost.latitude = rootObject.getString(APIParams.LATITUDE)
            }
            //arrayFoodData.add(foodSharePost)


            return foodSharePost
        }

        fun decodeUriToBitmap(mContext: Context, sendUri: Uri): Bitmap? {
            var getBitmap: Bitmap? = null
            try {
                val image_stream: InputStream?
                try {
                    image_stream = mContext.contentResolver.openInputStream(sendUri)
                    getBitmap = BitmapFactory.decodeStream(image_stream)
                } catch (e: FileNotFoundException) {
                    e.printStackTrace()
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return getBitmap
        }


        fun getURLForResource(resourceId: Int): String {
            return Uri.parse("android.resource://" + R::class.java!!.getPackage().getName() + "/" + resourceId).toString()
        }


        fun getImage(imageName: String, context: Context): Int {

            var drawableResourceId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());

            return drawableResourceId;

        }
    }


}