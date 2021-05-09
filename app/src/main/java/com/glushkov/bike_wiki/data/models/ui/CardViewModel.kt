package com.glushkov.bike_wiki.data.models.ui

/**
 * Class that contains information for custom view
 * @constructor creates data object
 *
 * @param title
 * Title of a card
 * @param icon
 * String name of resource
 * @param shortDescription
 * Short description of a card
 */
data class CardViewModel (val itemId: Int, val title: String, val icon: String?, val shortDescription: String)