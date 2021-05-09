package com.glushkov.bike_wiki.ui.tools

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.res.painterResource
import com.glushkov.bike_wiki.data.models.ui.CardViewModel
import com.glushkov.bike_wiki.tools.UiHelper
import com.glushkov.bike_wiki.ui.values.Colors.Companion.ALMOST_WHITE
import com.glushkov.bike_wiki.ui.values.Colors.Companion.CARD_VIEW_BACKGROUND
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.CARD_PADDING
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.CORNER_RADIUS
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.ELEVATION
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.IMAGE_SIZE
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.SHORT_DESCRIPTION_FONT_SIZE
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.TEXT_PADDING
import com.glushkov.bike_wiki.ui.values.Dimens.Companion.TITLE_FONT_SIZE

/**
 * Card view created specially for representing data objects in a grid
 * @param data
 * [CardViewModel] Data for configuring view
 */
@Composable
fun CardView(data: CardViewModel, onClick : (id: Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(CARD_PADDING)
            .clickable { onClick(data.itemId) },
        shape = RoundedCornerShape(CORNER_RADIUS),
        backgroundColor = CARD_VIEW_BACKGROUND,
        elevation = ELEVATION,

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painter =
                painterResource(id = UiHelper.getResourceId(LocalContext.current, data.icon))
            val textModifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = TEXT_PADDING)
            Image(
                painter = painter,
                contentDescription = data.title,
                modifier =
                Modifier
                    .width(IMAGE_SIZE)
                    .height(IMAGE_SIZE)
                    .align(Alignment.CenterHorizontally)
                    .padding(CARD_PADDING)
            )
            Text(
                text = data.title,
                modifier = textModifier,
                color = ALMOST_WHITE,
                fontSize = TITLE_FONT_SIZE
            )
            Text(
                text = data.shortDescription,
                modifier = textModifier
                    .padding(bottom = CARD_PADDING),
                color = ALMOST_WHITE,
                fontSize = SHORT_DESCRIPTION_FONT_SIZE
            )
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    CardView(
        CardViewModel( 1,"Test Title", "ic_bimota", "Description here")
    ) { }
}