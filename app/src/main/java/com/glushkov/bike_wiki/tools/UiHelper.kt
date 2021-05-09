package com.glushkov.bike_wiki.tools

import android.content.Context
import com.glushkov.bike_wiki.R

/**
 * Class that helps to manipulate with visual data presented in a text representation
 */
class UiHelper {
    companion object {
        /**
         * Method returning id by string name
         * @param context Current context
         * @param resource String name of a resource from folder
         * @return [Int] Resource ID
         */
        fun getResourceId(context: Context, resource: String?) : Int {
            return if (resource == null || resource.isEmpty()) {
                R.drawable.ic_unknown
            } else {
                context.resources
                    .getIdentifier(resource, "drawable", context.packageName)
            }
        }
    }
}