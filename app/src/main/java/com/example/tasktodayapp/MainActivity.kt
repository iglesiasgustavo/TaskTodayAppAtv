package com.example.tasktodayapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktodayapp.ui.theme.TaskTodayAppTheme
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "TaskTodayApp")},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Drawer Menu")

                }
            )
        },

        content = {
                paddingValues -> Log.i("paddingvalues", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color.Yellow)
                    .fillMaxSize()
            ){
                MySearchField(modificador = Modifier.fillMaxWidth())
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Tarefa 1",
                    taskDetails = "Este é um exemplo para realizacao de uma tarefa",
                    deadEndDate = Date()
                )
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth() ,
                    taskName= "Prova Matemática",
                    taskDetails = "Estudar Calculo pagina 1 e 2",
                    deadEndDate =  Date())
            }
        },

        bottomBar = {
            BottomAppBar(
                content = { Text("Gustavo Iglesias Santana Santos")}
            )
        }
    )//Scaffold
}//fun MAinScreenContent

@Composable
fun MySearchField(modificador: Modifier){
    TextField(
        value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = {Text(text = "Pesquisar tarefas")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        }
    )
}//fun MySearchField

@Composable
fun MyTaskWidget(
    modificador: Modifier,
    taskName: String,
    taskDetails: String,
    deadEndDate: Date
) {
    val dateFormatter = SimpleDateFormat("EEE, MMM dd, YYYY", Locale.getDefault())
    Row(modifier = modificador) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Icons of a pendent task"
        )
        Text(
            text = dateFormatter.format(deadEndDate),
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 12.sp

        )
    }
    Column(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Black)
            .padding(3.dp)
    ) {
        Text(
            text = taskName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = taskDetails,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}//fun MyTaskWidget

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    MainScreenContent()
}
