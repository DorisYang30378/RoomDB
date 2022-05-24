package com.example.roomdb

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Database
import com.example.roomdb.MyDatabase.MyDatabase.Companion.getInst
import com.example.roomdb.ui.theme.RoomDBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")

                }
            }
        }

        var db=MyDatabase.MyDatabase.getInst(applicationContext)
        try {
            db.getDao().insertProd(Product("test",1))
            var plist=db.getDao().getALL()
            var mypro=""
            for(pd in plist){
                mypro+=pd.pname+","
            }
            Toast.makeText(applicationContext,mypro,Toast.LENGTH_LONG).show()

        }catch(e: Exception){
            print(e.message)
        }


    }

}




@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomDBTheme {
        Greeting("Android")
    }
}