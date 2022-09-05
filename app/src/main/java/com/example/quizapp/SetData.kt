package com.example.quizapp

object SetData {

    const val name:String="name"
    const val score:String="score"
    fun getquestion():ArrayList<QuestionData>{
        var que:ArrayList<QuestionData> = arrayListOf()
        var q1=QuestionData(
            "For which of the following Android is mainly developed?",
            1,
            "Servers",
            "Desktops",
            "Laptops",
            "Mobile devices",
            4
        )
        var q2=QuestionData(
            " APK stands for -",
            2,
            "Android Phone Kit",
            "Android Page Kit",
            "Android Package Kit",
            "None of the above",
            3

        )
        var q3=QuestionData(
            "What does API stand for?",
            3,
            "Application Programming Interface",
            "Android Programming Interface",
            "Android Page Interface",
            "Application Page Interface",
            1
        )
        var q4=QuestionData(
            "What is an activity in android?",
            4,
            "android class",
            "android package",
            "A single screen in an application with supporting java/kotlin code",
            "None of the above",
            3
        )
        var q5=QuestionData(
            "Which of the following is contained in the src folder?",
            5,
            "XML",
            "Java/kotlin source code",
            "Manifest",
            "None of the above",
            2
        )
        que.add(q1)
        que.add(q2)
        que.add(q3)
        que.add(q4)
        que.add(q5)


        return que


    }
}