package com.test.meli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.test.meli.common.navigation.AppNavigationHost
import com.test.meli.common.navigation.AppNavigator
import com.test.meli.common.presentation.theme.AppTheme
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navigator = get<AppNavigator>()
                val navController = rememberNavController()
                AppNavigationHost(
                    navController = navController,
                    navigator = navigator
                )
            }
        }
    }
}