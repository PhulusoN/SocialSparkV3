package com.example.socialsparkv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.socialsparkv3.ui.theme.SocialSparkV3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SocialSparkV3Theme {
                var text by remember { mutableStateOf(value = "") }
                var results by remember {mutableStateOf(value="")}
                Column(){  
                 // name of the app displayed at the top of the screen
                    Text("Social Spark")
                     // Input-field to enter time of day
                    OutlinedTextField(
                        value = text,
                        onValueChange = {text =it},
                        label = {Text("Enter Time Of Day")}
                    )
                    
                      // suggestions fot the user's input depending on the time of day 
                    Row(){
                        Button(
                            onClick = {
                                results = when (text){
                                    "Morning" -> "Send a Good Morning Text To your family "
                                    "Mid morning" -> "Go Attend The Morning Metting With Your Supervisor"
                                    "Afternoon" -> "Take a Colleague out for  lunch"
                                    "Evening" -> "Go out for dinner your with partner "
                                    "Night" -> "Update family members on your day"
                                    else -> "Enter A Valid Time Of Day!!"
                                }
                            }
                        )

                        {
                            Text("Suggest")
                        }
                        // "Reset" button — clears both the input field and the result text
                        Button(
                            onClick = {
                                text = ""
                                results =""
                            }
                        ) {
                            Text("Reset")
                        }
                    }
                    // shows suggestion to user
                    Text(results)

                }

            }
        }
    }
}
