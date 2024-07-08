import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import composemphelloworld.composeapp.generated.resources.Res
import composemphelloworld.composeapp.generated.resources.compose_multiplatform
import composemphelloworld.composeapp.generated.resources.hello_world
import composemphelloworld.composeapp.generated.resources.ic_android_black_24dp
import dependencies.DbClient
import dependencies.MyViewModel
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App(
    batteryManager: BatteryManager
) {
    MaterialTheme {
        KoinContext {
//            val dbClient = koinInject<DbClient>()

            NavHost(
                navController = rememberNavController(),
                startDestination = "home"
            ) {
                composable(route = "home") {
                    val viewModel = koinViewModel<MyViewModel>()
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.getHelloWorldString()
                        )
                    }
                }
            }

//            var showContent by remember { mutableStateOf(false) }
//            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                Button(onClick = { showContent = !showContent }) {
//                    Text("Click me!")
//                }
////            AnimatedVisibility(showContent) {
////                val greeting = remember { Greeting().greet() }
//                val greeting = remember { batteryManager.getBatteryLevel() }
//                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//                    Image(painterResource(Res.drawable.ic_android_black_24dp), null)
//                    Text("Compose ${stringResource(Res.string.hello_world)} : $greeting")
//                }
////            }
//            }
        }
    }
}