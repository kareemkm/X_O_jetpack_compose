package com.example.xogame

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xogame.ui.theme.Aqua
import com.example.xogame.ui.theme.BlueCustom
import com.example.xogame.ui.theme.GrayBackground
import com.example.xogame.ui.theme.GreenishYellow



@Composable
fun GameScreen(viewModel: GameViewModel){
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Player 'O' : 0" , fontSize = 16.sp)
            Text(text = "Draw: 0" , fontSize = 16.sp)
            Text(text = "Player 'X' : 0" , fontSize = 16.sp)
        }
        Text(
            text = "Tic Tac Toe",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            color = BlueCustom
            )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(20.dp))
                .clip(RoundedCornerShape(20.dp))
                .background(GrayBackground),
            contentAlignment = Alignment.Center

        ){
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize(0.9f)
                    .aspectRatio(1f)
                    .padding(5.dp),
                columns = GridCells.Fixed(3)
            ) {
                viewModel.boardItems.forEach{(cellNo, boardCellValue) ->
                    item{
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable {
                                           viewModel.onAction(UserActions.BoardTapped(cellNo))

                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            if (boardCellValue == BoardCallValue.CIRCLE){
                                Circle()
                            }else if (boardCellValue == BoardCallValue.CROSS){
                                Cross()
                            }

                        }
                    }

                }
            }


        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text ="Play '0' turn",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic
            )
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.buttonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueCustom,
                    contentColor = Color.White

                )
            ) {
                Text(text = "Play Again" , fontSize = 16.sp)

            }
        }

        

    }
}
@Composable
fun BoardBase(){
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/3, y = 0f),
            end = Offset(x = size.width*1/3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*2/3, y = 0f),
            end = Offset(x = size.width*2/3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.width*1/3),
            end = Offset(x = size.height, y = size.width*1/3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.width*2/3),
            end = Offset(x = size.height, y = size.width*2/3)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Cross(){
    Canvas(
        modifier = Modifier
            .padding(5.dp)
            .size(60.dp)
    ) {
        drawLine(
            start = Offset(x = 0f , y = 0f),
            end = Offset(x = size.width , y = size.height),
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round

        )
        drawLine(
            start = Offset(x = 0f , y = size.height),
            end = Offset(x = size.width , y = 0f),
            color = GreenishYellow,
            strokeWidth = 20f,
            cap = StrokeCap.Round

        )
    }
}
@Preview(showBackground = true)
@Composable
fun Circle(){
    Canvas(
        modifier = Modifier
            .padding(5.dp)
            .size(60.dp)
    ) {
        drawCircle(
            color = Aqua,
            style = Stroke(width = 20f)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun WinHorizontalLine1(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height*1/6),
            end = Offset(x = size.width , y = size.height*1/6)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height*1/2),
            end = Offset(x = size.width , y = size.height*1/2)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height*5/6),
            end = Offset(x = size.width , y = size.height*5/6)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/6 , y = 0f),
            end = Offset(x = size.width*1/6 , y = size.height)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*1/2 , y = 0f),
            end = Offset(x = size.width*1/2 , y = size.height)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width*5/6 , y = 0f),
            end = Offset(x = size.width*5/6 , y = size.height)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width ,y = size.height),
            end = Offset(x = 0f , y = 0f)
        )
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width ,y = 0f),
            end = Offset(x = 0f , y = size.height)
        )

        
    }

}

@Preview
@Composable
fun PreviewScreen(){
    GameScreen(viewModel = GameViewModel())

}

