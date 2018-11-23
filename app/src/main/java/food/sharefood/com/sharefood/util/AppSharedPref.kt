package food.sharefood.com.sharefood.util

import android.content.Context
import android.content.SharedPreferences
import food.sharefood.com.sharefood.network.VolleyClass.Companion.context

class AppSharedPref {


    companion object {

        private var PREFS_NAME = "FoodSharedData";

        val STRING = 100
        val INTEGER = 101
        val BOOLEAN = 102

        private lateinit var preferences: SharedPreferences

        private var isPrefsLoaded = false


        fun loadPrefs(context: Context) {
            preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            isPrefsLoaded = true
        }

        fun getData(key: String, context: Context): String {
            return getData(key, STRING, context) as String
        }

        @Throws(ClassCastException::class)
        fun saveData(key: String, type: Any, value: Any, context: Context) {
            if (!isPrefsLoaded) {
                loadPrefs(context)
            }

            if (type == STRING) {
                preferences.edit().putString(key, value as String).apply()
            } else if (type == INTEGER) {
                preferences.edit().putInt(key, value as Int).apply()
            } else if (type == BOOLEAN) {
                preferences.edit().putBoolean(key, value as Boolean).apply()
            }
        }

        @Throws(ClassCastException::class)
        fun getData(key: String, returnType: Int, context: Context): Any {
            if (!isPrefsLoaded) {
                loadPrefs(context)
            }

            when (returnType) {
                STRING -> return preferences.getString(key, "")
                INTEGER -> return preferences.getInt(key, -1)
                BOOLEAN -> return preferences.getBoolean(key, false)
                else -> throw RuntimeException("Invalid return type provided")
            }
        }

        fun clearAll() {
            preferences.edit().clear().apply()
        }
    }


    constructor() {
        throw IllegalAccessError("This class should not be initiated")
    }


}