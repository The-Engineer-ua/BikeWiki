package com.glushkov.bike_wiki.tools

import com.glushkov.bike_wiki.data.models.local.ManufacturerModel
import com.glushkov.bike_wiki.data.models.local.MotorcycleModel
import com.glushkov.bike_wiki.data.models.ui.CardViewModel

class ViewDataHelper {
    companion object {
        fun manufacturerToCardViewModel(item : ManufacturerModel) : CardViewModel {
            return CardViewModel(item.id, item.name, item.iconResourceName, item.shortDescription)
        }
        fun motorcycleToCardViewModel(item : MotorcycleModel) : CardViewModel {
            return CardViewModel(item.id, item.name, item.iconResourceName, item.shortDescription)
        }
    }
}