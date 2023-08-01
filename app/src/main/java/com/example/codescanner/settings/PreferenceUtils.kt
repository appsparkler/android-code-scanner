package com.example.codescanner.settings

import android.content.Context
import android.preference.PreferenceManager
import androidx.annotation.StringRes
import com.example.codescanner.camera.CameraSizePair
import com.google.android.gms.common.images.Size

object PreferenceUtils {
    fun saveStringPreference(context: Context,  prefKeyId: String, value: String?) {
        PreferenceManager.getDefaultSharedPreferences(context)
            .edit()
            .putString(prefKeyId, value)
            .apply()
    }

    fun getUserSpecifiedPreviewSize(context: Context): CameraSizePair? {
        return try {
            val previewSizePrefKey = "rcpvs"
            val pictureSizePrefKey = "rcpts"
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            CameraSizePair(
                Size.parseSize(sharedPreferences.getString(previewSizePrefKey, null)!!),
                Size.parseSize(sharedPreferences.getString(pictureSizePrefKey, null)!!)
            )
        } catch (e: Exception) {
            null
        }
    }


}