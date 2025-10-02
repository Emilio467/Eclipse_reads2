package com.example.projeto2

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "AppThemePrefs"
    private val KEY_BACKGROUND_COLOR = "backgroundColor"
    private val DEFAULT_BACKGROUND_COLOR = "#6A3D89"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    }
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        applyAppBackgroundColor()
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        applyAppBackgroundColor()
    }

    override fun setContentView(view: View?, params: android.view.ViewGroup.LayoutParams?) {
        super.setContentView(view, params)
        applyAppBackgroundColor()
    }

    protected fun applyAppBackgroundColor() {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        if (rootView != null) {
            val savedColorHex = sharedPreferences.getString(KEY_BACKGROUND_COLOR, DEFAULT_BACKGROUND_COLOR)
            try {
                rootView.setBackgroundColor(Color.parseColor(savedColorHex))
            } catch (e: IllegalArgumentException) {
                rootView.setBackgroundColor(Color.parseColor(DEFAULT_BACKGROUND_COLOR))
                e.printStackTrace()
            }
        }
    }
}
