package com.glushkov.bike_wiki.data.models.ui

/**
 * Class that contains information for custom view
 * @constructor creates data object
 *
 * @param value
 * Actual value (By default range 0-10)
 * @param maxValue
 * Input of maximum range
 * @param minValue
 * Input of minimum value for range
 */
data class LineChartModel(val value: Float, val maxValue: Float = 10f, val minValue: Float = 0f)