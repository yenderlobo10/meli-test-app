package com.test.meli.search.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.test.meli.common.presentation.theme.AppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(searchViewModel: SearchViewModel) {

    Scaffold(Modifier) {

        SearchContent(
            onChangeFieldQuery = searchViewModel::updateQuery,
            onClickSearch = searchViewModel::navigateToCatalog
        )
    }
}

@Composable
fun SearchContent(
    onChangeFieldQuery: (String) -> Unit,
    onClickSearch: () -> Unit
) {
    Surface(Modifier.fillMaxSize()) {
        ConstraintLayout(
            Modifier.padding(16.dp)
        ) {
            val icon = createRef()
            val subTitle = createRef()
            val fieldQuery = createRef()
            val buttonSearch = createRef()
            var query by rememberSaveable { mutableStateOf("") }

            Icon(
                modifier = Modifier
                    .size(54.dp)
                    .constrainAs(icon) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top, margin = 36.dp)
                    },
                imageVector = Icons.Outlined.Search,
                contentDescription = "icon-search"
            )

            Text(
                modifier = Modifier.constrainAs(subTitle) {
                    top.linkTo(icon.bottom, margin = 16.dp)
                    start.linkTo(icon.start)
                    end.linkTo(icon.end)
                },
                text = "Buscar productos",
                style = MaterialTheme.typography.headlineSmall
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(fieldQuery) {
                        top.linkTo(subTitle.bottom, (-48).dp)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                value = query,
                label = { Text("Buscar") },
                placeholder = { Text("Buscar productos, marcas ...") },
                onValueChange = {
                    query = it
                    onChangeFieldQuery(it)
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .defaultMinSize(minHeight = 48.dp)
                    .constrainAs(buttonSearch) {
                        top.linkTo(fieldQuery.bottom, 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentPadding = ButtonDefaults.ContentPadding,
                onClick = onClickSearch
            ) {
                Text("Buscar")
            }
        }
    }
}

@Preview
@Composable
private fun SearchContentPrev() {
    AppTheme {
        SearchContent(
            onChangeFieldQuery = {},
            onClickSearch = {}
        )
    }
}