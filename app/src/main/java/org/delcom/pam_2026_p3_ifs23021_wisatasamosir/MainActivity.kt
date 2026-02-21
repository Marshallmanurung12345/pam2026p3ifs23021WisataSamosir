package org.delcom.pam_2026_p3_ifs23021_wisatasamosir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.helper.ConstHelper
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.helper.RouteHelper
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.components.BottomNavComponent
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.components.TopAppBarComponent
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens.DestinationDetailScreen
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens.DestinationsScreen
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens.HomeScreen
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.screens.ProfileScreen
import org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.theme.WisataSamosirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WisataSamosirTheme {
                AppRoot()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppRoot() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBarComponent(ConstHelper.APP_NAME) },
        bottomBar = { BottomNavComponent(navController) }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = RouteHelper.home(),
            modifier = Modifier.padding(padding)
        ) {
            composable(RouteHelper.home()) { HomeScreen(navController) }

            composable(RouteHelper.destinations()) {
                DestinationsScreen(
                    onOpenDetail = { id ->
                        navController.navigate(RouteHelper.detail(id))
                    }
                )
            }

            composable(RouteHelper.profile()) { ProfileScreen() }

            composable(
                route = RouteHelper.detailPattern(),
                arguments = listOf(navArgument(ConstHelper.ARG_ID) { type = NavType.StringType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString(ConstHelper.ARG_ID).orEmpty()
                DestinationDetailScreen(
                    id = id,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}