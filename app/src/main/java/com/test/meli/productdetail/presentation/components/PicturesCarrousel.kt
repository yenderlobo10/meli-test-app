@file:OptIn(ExperimentalFoundationApi::class)

package com.test.meli.productdetail.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.test.meli.R
import com.test.meli.core.presentation.theme.AppTheme
import com.test.meli.productdetail.presentation.common.urlOfPicturesPrev
import kotlin.random.Random

@Composable
internal fun PicturesCarrousel(
    modifier: Modifier = Modifier,
    urlOfPictures: List<String>
) {
    val pagerState = rememberPagerState(pageCount = { urlOfPictures.size })

    ConstraintLayout(
        modifier = modifier
    ) {
        val (label, indicator) = createRefs()

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.requiredHeight(200.dp)
        ) { page ->
            ItemImage(url = urlOfPictures[page])
        }

        LabelIndicator(
            modifier = Modifier.constrainAs(label) {
                start.linkTo(parent.start, margin = 12.dp)
                top.linkTo(parent.top, margin = 8.dp)
            },
            total = pagerState.pageCount,
            current = pagerState.currentPage
        )

        ItemIndicator(
            count = pagerState.pageCount,
            current = pagerState.currentPage,
            modifier = Modifier.constrainAs(indicator) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        )
    }
}

@Composable
private fun LabelIndicator(
    modifier: Modifier,
    total: Int,
    current: Int
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "${current + 1}/$total",
            style = MaterialTheme.typography.labelSmall.copy(
                letterSpacing = 2.sp,
                color = Color.Black
            ),
            modifier = Modifier.padding(
                horizontal = 6.dp,
                vertical = 2.dp
            )
        )
    }
}

@Composable
private fun ItemIndicator(
    modifier: Modifier,
    count: Int,
    current: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(count) { index ->
            val background =
                if (current == index) MaterialTheme.colorScheme.primary else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(background)
                    .size(12.dp)
            )
        }
    }
}

@Composable
private fun ItemImage(
    url: String
) {
    val description = "carrousel-item-image-${Random.nextInt()}"

    AsyncImage(
        model = url,
        contentDescription = description,
        placeholder = painterResource(id = R.drawable.img_placeholder),
        error = painterResource(id = R.drawable.img_placeholder),
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
private fun CarrouselPrev() {
    AppTheme {
        Scaffold {
            PicturesCarrousel(
                urlOfPictures = urlOfPicturesPrev
            )
        }
    }
}