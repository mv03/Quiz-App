package com.example.quizapp

data class QuestionData(
    var question:String,
    var id:Int,
    var optionone:String,
    var optiontwo:String,
    var optionthree:String,
    var optionfour:String,
    var correctAnswer:Int,
)