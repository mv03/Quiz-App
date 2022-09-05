package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0




    private var currentPosition:Int=1
    private var questionlist:ArrayList<QuestionData>?=null
    private var selected_option:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(SetData.name)

        questionlist=SetData.getquestion()
        setQuestion()

        opt_1.setOnClickListener() {
            selectedoptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener(){
            selectedoptionStyle(opt_2,2)
        }
        opt_3.setOnClickListener(){
            selectedoptionStyle(opt_3,3)
        }
        opt_4.setOnClickListener(){
            selectedoptionStyle(opt_4,4)
        }
        submit.setOnClickListener{
            if(selected_option!=0){
                val question=questionlist!![currentPosition-1]
                if(selected_option!=question.correctAnswer){
                    setColor(selected_option,R.drawable.wrong)
                }
                else{
                    score++
                }
               setColor(question.correctAnswer,R.drawable.correct)
                if(currentPosition==questionlist!!.size){
                    submit.text="Finish"
                }else{
                    submit.text="Go to next"
                }
            }else{
                currentPosition++
                when{
                    currentPosition<=questionlist!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent= Intent(this,ResultActivity::class.java)
                        intent.putExtra(SetData.name,Name.toString())
                        intent.putExtra(SetData.score,score.toString())
                        intent.putExtra("total size",questionlist!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selected_option=0
        }
    }

    fun setColor(opt:Int,color: Int){
        when(opt){
            1->{
                opt_1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                opt_2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                opt_3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                opt_4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
    fun setQuestion(){
        val question=questionlist!![currentPosition-1]
        setoptionstyle()
        progress_bar.progress=currentPosition
        progress_bar.max=questionlist!!.size
        progress_text.text="${currentPosition}" + "/" + "${questionlist!!.size}"
        question_text.text=question.question
        opt_1.text=question.optionone
        opt_2.text=question.optiontwo
        opt_3.text=question.optionthree
        opt_4.text=question.optionfour

    }
    fun setoptionstyle(){
        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,opt_1)
        optionList.add(1,opt_2)
        optionList.add(2,opt_3)
        optionList.add(3,opt_4)

        for(op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.questions_option)
            op.typeface=Typeface.DEFAULT
        }

    }
    fun selectedoptionStyle(view:TextView,opt:Int){
        setoptionstyle()
        selected_option=opt
        view.background=ContextCompat.getDrawable(this,R.drawable.selected_questions_option)
        view.typeface=Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}