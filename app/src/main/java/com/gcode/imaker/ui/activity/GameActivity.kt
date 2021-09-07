package com.gcode.imaker.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcode.tools.adapter.BaseUtilBindingAdapter
import com.gcode.imaker.BR
import com.gcode.imaker.R
import com.gcode.imaker.databinding.ActivityGameBinding
import com.gcode.imaker.ui.model.GameModel

class GameActivity : AppCompatActivity() {

    inner class GameModelAdapter(items: MutableList<GameModel>) : BaseUtilBindingAdapter<GameModel>(items){
        override fun setVariableId(): Int {
            return BR.game
        }
    }

    private val games:MutableList<GameModel> = ArrayList<GameModel>()

    private lateinit var myAdapter: GameModelAdapter

    private lateinit var binding:ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_game)

        games.apply {
            repeat(10){
                add(
                    GameModel(ContextCompat.getDrawable(this@GameActivity,R.drawable.ic_game),
                    "C语言算法大赛",
                    "本次比赛旨在培养你的算法能力,考察内容包括线性表 树 图",
                    4)
                )
            }
        }

        myAdapter = GameModelAdapter(games)

        binding.gameRv.apply {
            layoutManager = LinearLayoutManager(this@GameActivity)
            adapter = myAdapter
        }
    }
}