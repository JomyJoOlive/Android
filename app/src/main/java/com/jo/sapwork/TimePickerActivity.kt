package com.jo.sapwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.PointerInputScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.Math.atan2
import java.lang.Math.cos
import java.lang.Math.sin
import java.util.*
import kotlin.math.atan2
import kotlin.math.roundToInt

//
//class TimePickerActivity : ComponentActivity() {
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyAppTheme {
//                MyApp()
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp() {
//    val context = LocalContext.current // Accessing context
//    var showDialog by remember { mutableStateOf(false) }
//    var time by remember { mutableStateOf(Calendar.getInstance()) }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        Button(
//            onClick = { showDialog = true },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.primary,
//                contentColor = MaterialTheme.colorScheme.onPrimary
//            )
//        ) {
//            Text("Select Time")
//        }
//
//        if (showDialog) {
//            val timeListener = TimePickerDialog.OnTimeSetListener { _: TimePicker, hour: Int, minute: Int ->
//                time.set(Calendar.HOUR_OF_DAY, hour)
//                time.set(Calendar.MINUTE, minute)
//                showDialog = false
//            }
//
//            // Creating TimePickerDialog with the context
//            TimePickerDialog(
//                context, // Using LocalContext.current
//                R.style.CustomTimePickerDialog,
//                timeListener,
//                time.get(Calendar.HOUR_OF_DAY),
//                time.get(Calendar.MINUTE),
//                true
//            ).show()
//        }
//    }
//}
//
//@Composable
//fun MyAppTheme(content: @Composable () -> Unit) {
//    val colorScheme = lightColorScheme(
//        primary = Color(0xFF87CEEB),
//        onPrimary = Color.White
//    )
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography(),
//        content = content
//    )
//}

/////////////
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyAppTheme {
//                CustomTimePicker()
//            }
//        }
//    }
//}
//
//@Composable
//fun CustomTimePicker() {
//    var showDialog by remember { mutableStateOf(false) }
//    var selectedHour by remember { mutableStateOf(12) }
//    val radius = 100.dp
//
//    Button(onClick = { showDialog = true }) {
//        Text("Select Time")
//    }
//
//    if (showDialog) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Canvas(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .pointerInput(Unit) {
//                        detectTapGestures { offset ->
//                            selectedHour = getSelectedHour(offset, radius, this)
//                        }
//                    }
//            ) {
//                drawClockFace(radius)
//            }
//            Text("Selected Hour: $selectedHour", modifier = Modifier.align(Alignment.BottomCenter))
//        }
//    }
//}
//
//fun DrawScope.drawClockFace(radius: Dp) {
//    val textPaint = Paint().apply {
//        color = android.graphics.Color.BLACK
//        textSize = 40f
//        typeface = Typeface.DEFAULT_BOLD
//    }
//
//    drawCircle(
//        color = Color.LightGray,
//        radius = radius.toPx(),
//        style = Stroke(width = 4.dp.toPx())
//    )
//    // Draw clock numbers
//    for (i in 1..12) {
//        val angle = Math.toRadians((i * 30 - 90).toDouble())
//        val x = center.x + radius.toPx() * cos(angle).toFloat() - 20 // Adjust for text width
//        val y = center.y + radius.toPx() * sin(angle).toFloat() + 20 // Adjust for text height
//        drawContext.canvas.nativeCanvas.drawText(
//            "$i",
//            x,
//            y,
//            textPaint
//        )
//    }
//}
//
//fun getSelectedHour(offset: Offset, radius: Dp, drawScope: PointerInputScope): Int {
//    val angle = atan2(
//        offset.y - drawScope.center.y,
//        offset.x - drawScope.center.x
//    ) * (180 / Math.PI)
//    return (((angle + 360) % 360) / 30).roundToInt().let { if (it == 0) 12 else it }
//}
//
//@Composable
//fun MyAppTheme(content: @Composable () -> Unit) {
//    MaterialTheme(
//        content = content
//    )
//}