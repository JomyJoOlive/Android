package com.jo.sapwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimePickerSpinner()
        }
    }
}
//@Composable
//fun TimePickerSpinner() {
//    val hours = (0..23).toList()
//    val minutes = listOf(0, 15, 30, 45)
//    var selectedHour by remember { mutableStateOf(hours.first()) }
//    var selectedMinute by remember { mutableStateOf(minutes.first()) }
//    var isAM by remember { mutableStateOf(true) }
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Text("Select Time", fontSize = 24.sp)
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center
//        ) {
//            NumberPicker(
//                numbers = hours,
//                selectedNumber = selectedHour,
//                onNumberSelected = { selectedHour = it }
//            )
//            Text(":", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 8.dp))
//            NumberPicker(
//                numbers = minutes,
//                selectedNumber = selectedMinute,
//                onNumberSelected = { selectedMinute = it }
//            )
//            AmPmSwitch(isAM) { isAM = it }
//        }
//        Text("Selected Time: ${selectedHour.format()}:${selectedMinute.format()} ${if (isAM) "AM" else "PM"}")
//    }
//}
//
//@Composable
//fun NumberPicker(
//    numbers: List<Int>,
//    selectedNumber: Int,
//    onNumberSelected: (Int) -> Unit
//) {
//    LazyColumn(
//        modifier = Modifier
//            .width(60.dp)
//            .height(120.dp)
//            .background(Color(0xFFEEEEEE))
//    ) {
//        items(numbers) { number ->
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(60.dp)
//                    .clickable { onNumberSelected(number) }
//                    .background(if (number == selectedNumber) Color.Cyan else Color.Transparent),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(text = number.format(), fontSize = 24.sp, color = Color.Black)
//            }
//        }
//    }
//}
//
//@Composable
//fun AmPmSwitch(
//    isAM: Boolean,
//    onToggle: (Boolean) -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .background(Color(0xFFEEEEEE))
//            .clickable { onToggle(!isAM) },
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            "AM",
//            modifier = Modifier.padding(16.dp),
//            fontSize = 18.sp,
//            color = if (isAM) Color.Black else Color.Gray
//        )
//        Switch(
//            checked = isAM,
//            onCheckedChange = onToggle,
//            colors = SwitchDefaults.colors(
//                checkedThumbColor = Color.Cyan
//            )
//        )
//        Text(
//            "PM",
//            modifier = Modifier.padding(16.dp),
//            fontSize = 18.sp,
//            color = if (!isAM) Color.Black else Color.Gray
//        )
//    }
//}
//
//fun Int.format(): String = this.toString().padStart(2, '0')



@Composable
fun TimePickerSpinner() {
    val hours = (0..23).toList()
    val minutes = listOf(0, 15, 30, 45)
    var selectedHour by remember { mutableStateOf(12) } // Initially centering on 12
    var selectedMinute by remember { mutableStateOf(30) } // Initially centering on 30
    var isAM by remember { mutableStateOf(true) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Select Time", fontSize = 24.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            NumberPicker(
                numbers = hours,
                selectedIndex = hours.indexOf(selectedHour),
                onNumberSelected = { selectedHour = it }
            )
            Text(":", fontSize = 24.sp, modifier = Modifier.padding(horizontal = 8.dp))
            NumberPicker(
                numbers = minutes,
                selectedIndex = minutes.indexOf(selectedMinute),
                onNumberSelected = { selectedMinute = it }
            )
            AmPmSwitch(isAM) { isAM = it }
        }
        Text("Selected Time: ${selectedHour.format()}:${selectedMinute.format()} ${if (isAM) "AM" else "PM"}")
    }
}

@Composable
fun NumberPicker(
    numbers: List<Int>,
    selectedIndex: Int,
    onNumberSelected: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .width(60.dp)
            .height(180.dp) // Enough height to show 3 items
    ) {
        itemsIndexed(numbers) { index, number ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(if (index == selectedIndex) Color.Cyan else Color.Transparent)
                    .clickable { onNumberSelected(number) },
                contentAlignment = Alignment.Center
            ) {
                Text(text = number.format(), fontSize = 24.sp, color = Color.Black)
            }
        }
    }
}

@Composable
fun AmPmSwitch(
    isAM: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "AM",
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            color = if (isAM) Color.Black else Color.Gray
        )
        Switch(
            checked = isAM,
            onCheckedChange = onToggle,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Cyan
            )
        )
        Text(
            "PM",
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp,
            color = if (!isAM) Color.Black else Color.Gray
        )
    }
}

fun Int.format(): String = this.toString().padStart(2, '0')