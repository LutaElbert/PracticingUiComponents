package com.example.applyinguicomponents.presentation.sharedcomponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponents(content: @Composable (PaddingValues) -> Unit) {
    val selectedItem by rememberSaveable { mutableStateOf<DrawerItem?>(null) }
    var drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(selectedItem = selectedItem) {
                scope.launch {
                    drawerState.close()
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBarComponent(
                    onClickDrawerIcon = {
                        scope.launch {
                            if (drawerState.isClosed) drawerState.open()
                            else drawerState.close()
                        }
                    },
                    onSwitchChecked = {}
                )
            },
            bottomBar = {
                BottomAppBarComponent {

                }
            }
        ) {
            content.invoke(it)
        }
    }
}

data class DrawerItem(val name: String, val icon: ImageVector)
