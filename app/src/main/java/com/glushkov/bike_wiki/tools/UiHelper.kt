package com.glushkov.bike_wiki.tools

import android.content.Context
import android.widget.ImageView
import com.glushkov.bike_wiki.R

class UiHelper {
    companion object {
        fun setIcon(context: Context, view: ImageView, resource: String?) {
            if (resource == null || resource.isEmpty()) {
                view.setImageResource(R.drawable.ic_unknown)
            }
            else {
                val drawableResourceId: Int = context.resources
                    .getIdentifier(resource, "drawable", context.packageName)
                view.setImageResource(drawableResourceId)
            }
        }
    }
}