package com.glushkov.bike_wiki.ui.tools

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.glushkov.bike_wiki.data.models.ui.LineChartModel

@Composable
fun LineChart(data: LineChartModel) {
    Canvas(modifier = Modifier.fillMaxWidth().height(15.dp)) {
        this.drawRoundRect(Color.LightGray, size = size )
    }
}

@Preview
@Composable
fun PreviewView() {
    LineChart(LineChartModel(4f))
}