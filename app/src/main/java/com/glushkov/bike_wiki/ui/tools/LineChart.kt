package com.glushkov.bike_wiki.ui.tools

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.tooling.preview.Preview
import com.glushkov.bike_wiki.data.models.ui.LineChartModel
import com.glushkov.bike_wiki.ui.values.Colors
import com.glushkov.bike_wiki.ui.values.Dimens

/**
 * Line chart diagram. Represents approx value
 * @param data
 * [LineChartModel] Data for configuring view
 */
@Composable
fun LineChart(data: LineChartModel) {
    Canvas(modifier = Modifier.fillMaxWidth().height(Dimens.LINE_CHART_HEIGHT)) {
        val actualFillerWidth = getActualFillerWidth(data, size)
        this.drawRoundRect(
            Colors.LINE_CHART_BACKGROUND,
            size = size,
            cornerRadius = CornerRadius(Dimens.LINE_CHART_CORNER_RADIUS.toPx(),
                Dimens.LINE_CHART_CORNER_RADIUS.toPx()) )

        this.drawRoundRect(
            Colors.LINE_CHART_FILLER,
            size = Size(actualFillerWidth, size.height),
            cornerRadius = CornerRadius(Dimens.LINE_CHART_CORNER_RADIUS.toPx(),
                Dimens.LINE_CHART_CORNER_RADIUS.toPx()) )
    }
}

/**
 * Calculation of width of canvas object in pixel by relation of range and value
 * @param data
 * [LineChartModel] Data for calculation
 * @param size
 * [Size] Actual dimensions of canvas, to calculate actual values
 * @return width in pixels
 */
private fun getActualFillerWidth(data: LineChartModel, size: Size): Float {
    val range = data.maxValue - data.minValue
    val ratio = range / data.value
    return size.width / ratio
}


/**
 * Preview
 */
@Preview
@Composable
fun PreviewView() {
    LineChart(LineChartModel(4f))
}