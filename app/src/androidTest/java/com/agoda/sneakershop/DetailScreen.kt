package com.agoda.sneakershop

import com.agoda.kakao.KTextView
import com.agoda.kakao.Screen

class DetailScreen : Screen<DetailScreen>() {
    val name = KTextView { withId(R.id.tvSneakerDetailName) }
    val categoryName = KTextView { withId(R.id.tvSneakerDetailCategoryName) }
    val collectionName = KTextView { withId(R.id.tvSneakerDetailCollectiomName) }
    val price = KTextView { withId(R.id.tvSneakerDetailPrice) }
    val description = KTextView { withId(R.id.tvSneakerDetailDescription) }
}