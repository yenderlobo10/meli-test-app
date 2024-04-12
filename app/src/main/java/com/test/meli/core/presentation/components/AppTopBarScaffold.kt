@file:OptIn(ExperimentalMaterial3Api::class)

package com.test.meli.core.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.meli.core.presentation.theme.AppTheme

@Composable
fun AppTopBarScaffold(
    modifier: Modifier = Modifier,
    title: String,
    onNavigationIconClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    actions: @Composable (RowScope.() -> Unit) = {},
    visible: Boolean = true,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            if (visible)
                TopAppBar(
                    title = title,
                    scrollBehavior = scrollBehavior,
                    onNavigationIconClick = onNavigationIconClick,
                    actions = actions,
                )
        }
    ) {
        content(it)
    }
}

@Composable
private fun TopAppBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior?,
    onNavigationIconClick: () -> Unit,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    MediumTopAppBar(
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                    contentDescription = "nav-back-icon"
                )
            }
        },
        title = {
            Text(
                text = title
            )
        },
        actions = actions,
        scrollBehavior = scrollBehavior
    )
}

@Preview
@Composable
private fun AppTopBarScaffoldPrev() {
    AppTheme {
        AppTopBarScaffold(
            title = "Title top bar",
            onNavigationIconClick = { /*TODO*/ }
        ) {
            Text(
                modifier = Modifier.padding(it),
                text = "Content"
            )
        }
    }
}