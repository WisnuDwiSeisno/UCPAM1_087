package com.example.ucp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun page(){

    // Variabel

    var email by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var noHP by rememberSaveable { mutableStateOf("") }
    var selectTahun by rememberSaveable { mutableStateOf("") }

//    Variabel untuk Radio Button
    val tahunmasuk = listOf("2021", "2022", "2023")

//    Variabel untuk Confirm
    var confirmemail by rememberSaveable { mutableStateOf("")}
    var confirmalamat by rememberSaveable { mutableStateOf("")}
    var confirmnoHP by rememberSaveable { mutableStateOf("")}
    var confirmselectTahun by rememberSaveable { mutableStateOf("")}

    Column {
        Box (
            Modifier
                .fillMaxWidth()
                .background(color = Color(0,0,150))) {
            Row (
                Modifier
                    .padding(10.dp)
                    .fillMaxWidth()) {
                Box (contentAlignment = Alignment.BottomEnd) {
                    Image(painter = painterResource(id = R.drawable.umylogo), contentDescription = null,
                        modifier = Modifier.size(90.dp))
                    Image(painter = painterResource(id = R.drawable.verif), contentDescription = null,
                        modifier = Modifier.size(30.dp))
                }
                Column (Modifier.padding(start = 20.dp, top = 20.dp, end = 70.dp)) {
                    Text(text = "Halo,", color = Color.White)
                    Text(text = "Wisnu Dwi Seisno", color = Color.White, fontWeight = FontWeight.Bold, style = TextStyle(fontSize = 20.sp))
                }

                Icon(
                    Icons.Filled.Notifications,
                    contentDescription = null,
                    Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically),
                    tint = Color.White)
            }
        }
        Column (modifier = Modifier.padding(5.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "Masukan Biodata Kamu!", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "Silahkan isi data dengan sebenar-benarnya", color = Color.Gray)
            Column (
                Modifier
                    .background(color = Color.LightGray, shape = RoundedCornerShape(20.dp))
                    .padding(5.dp)) {
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    placeholder = { Text(text = "Masukan Email")},
                    label = { Text(text = "Email")},
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {Icon(Icons.Filled.Email, contentDescription = null)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
                OutlinedTextField(
                    value = noHP,
                    onValueChange = {noHP = it},
                    placeholder = { Text(text = "Masukan Nomor Telepon")},
                    label = { Text(text = "Nomor Telephone")},
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {Icon(Icons.Filled.Call, contentDescription = null)},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                OutlinedTextField(
                    value = alamat,
                    onValueChange = {alamat = it},
                    placeholder = { Text(text = "Masukan Alamat Lengkap")},
                    label = { Text(text = "Alamat")},
                    shape = RoundedCornerShape(20.dp),
                    leadingIcon = {Icon(Icons.Filled.LocationOn, contentDescription = null)},
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(text = "Tahun Masuk :", modifier = Modifier.padding(5.dp))
                Row() {
                    tahunmasuk.forEach { item -> Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = selectTahun == item , onClick = { /*TODO*/
                            selectTahun = item})
                        Text(text = item)
                    } }
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Button(onClick = {
                confirmselectTahun = selectTahun
                confirmemail = email
                confirmalamat = alamat
                confirmnoHP = noHP
            }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Submit")
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column (
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .background(color = Color(0, 0, 150), shape = RoundedCornerShape(15.dp))) {
                Text(text = "Data Kamu", modifier = Modifier.align(Alignment.CenterHorizontally).padding(5.dp), color = Color.White)
                Card(modifier = Modifier.background(color = Color(0,0,128), shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()){
                    MainSection(judulParam = "Email", isipParam = confirmemail )
                    MainSection(judulParam = "Phone", isipParam = confirmnoHP )
                    MainSection(judulParam = "Address", isipParam = confirmalamat )
                    MainSection(judulParam = "Year", isipParam = confirmselectTahun )
                }
            }
        }
    }
}

@Composable
fun MainSection(judulParam:String, isipParam:String){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = judulParam, Modifier.weight(0.8f))
            Text(text = ":", Modifier.weight(0.2f))
            Text(text = isipParam, Modifier.weight(2f))
        }
    }
}