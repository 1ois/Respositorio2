package com.example.clase4

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clase4.ui.theme.Clase4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Clase4Theme {
                //Texto()
                  miboton()
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Texto() {

Box(modifier = Modifier.fillMaxSize()){
    val W1=150.dp
    val W2=230.dp
    val W3=250.dp

    var pass by remember{ mutableStateOf(true)}
    var valor1 by remember{ mutableStateOf("") }
    var valor2 by remember { mutableStateOf(0) }
    var width by remember{ mutableStateOf(W1)}
    Column(){
        OutlinedTextField(value = valor1,
            onValueChange = { val1->valor1=val1},
            label={ Text("Primer valor")},
            placeholder={Text("Solo valores numericos")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            leadingIcon={ Icon(imageVector= Icons.Default.,contentDescription= "Bloqueo") },
            visualTransformation=if (pass) PasswordVisualTransformation()else VisualTransformation.None,
            modifier= Modifier.width(300.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Button(onClick = {

            width = when(width){
                W1 -> W2
                W2 -> W3
                else ->W1 }
            valor2+=5
        },modifier=Modifier.width(width))
        {
            Text("Activar")
        }
        Spacer(modifier = Modifier.size(5.dp))
        Text("El valor es: $valor2")
    }

}

}
@Composable
fun miboton{
    var valor10 by remember {mutableStateOf(0)  }
        Row(){
            Button(onClick = { valor10++ }) {
                

            }
            
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Clase4Theme {
        //Texto()

        miboton()
    }
}