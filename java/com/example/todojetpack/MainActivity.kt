package com.example.todojetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.todojetpack.taskManager.components.ProfileHeaderComponent
import com.example.todojetpack.taskManager.components.TaskComponent
import com.example.todojetpack.taskManager.components.WelcomeMessageComponent
import com.example.todojetpack.taskManager.data.taskList
import com.example.todojetpack.ui.theme.TodojetpackTheme

class MainActivity : ComponentActivity() {
    @SuppressWarnings("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /// 구성 가능한 함수들의 호출을 정의한다. -> Flutter BuildContext와 같은 역할을 한다.
        setContent {
            var selectedScreen by remember {
                mutableStateOf(1)
            }
            val screens = listOf("Calendar", "Home", "Notifications")

            TodojetpackTheme{
                Scaffold(
                    bottomBar = {
                    BottomNavigation(
                        modifier = Modifier.height(90.dp),
                        backgroundColor = Color.White,
                        elevation = 0.dp,
                    ) {
                        screens.forEachIndexed { index, _ ->
                            val icon: ImageVector = when(index){
                                0 -> Icons.Filled.CalendarMonth
                                1 -> Icons.Filled.Home
                                2 -> Icons.Filled.Mail
                                else -> Icons.Filled.Home
                            }
                            /// 하단 바텀 네비게이션 메뉴 설정
                            BottomNavigationItem(
                                selected = selectedScreen == index,
                                onClick = { selectedScreen = index},
                                icon = {
                                    Box(
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(CircleShape)
                                            .background(
                                                if (selectedScreen == index) {
                                                    Color.Black
                                                } else {
                                                    Color.White
                                                }
                                            ),
                                        contentAlignment = Alignment.Center /// 아이콘은 중앙으로 배치
                                    ){
                                        Icon(
                                            imageVector = icon, 
                                            contentDescription = "Calendar",
                                            modifier = Modifier
                                                .size(50.dp)
                                                .padding(12.dp),
                                            tint = if(selectedScreen == index){
                                                Color.White
                                            } else {
                                                Color.Black
                                            }
                                        )
                                    }
                                }
                            )
                        }
                    }
                }) {
                    LazyColumn(
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                    ){
                        item {
                            ProfileHeaderComponent()
                        }
                        item {
                            Spacer(
                                modifier = Modifier.height(30.dp)
                            )
                            WelcomeMessageComponent()
                            Spacer(modifier = Modifier.height(30.dp))
                        }
                        items(taskList){
                            task -> TaskComponent(task = task)
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}
