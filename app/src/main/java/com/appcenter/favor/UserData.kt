package com.appcenter.favor

import android.content.Context
import android.content.SharedPreferences


class UserData(mContext: Context) {

    private val prefs = mContext.getSharedPreferences("prefs", Context.MODE_PRIVATE)


    private val Access_Token = "Access_Token"
    private val Refresh_Token = "Refresh_Token"
    fun setAccessToken(value: String?) {
        prefs.edit().putString(Access_Token, value).commit()
    }

    fun getAccessToken(defValue: String?): String? {
        return prefs.getString(Access_Token, defValue)
    }

    fun setRefreshToken(value: String?) {
        prefs.edit().putString(Refresh_Token, value).commit()
    }

    fun getRefreshToken(defValue: String?): String? {
        return prefs.getString(Refresh_Token, defValue)
    }

    fun clearToken() {
        prefs.edit().clear().apply()
    }
}

