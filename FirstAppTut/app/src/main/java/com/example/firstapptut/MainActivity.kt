package com.example.firstapptut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                textView_progress.text = p1.toString()  // p1 = progress

                val translationDistance = (initialTextViewTranslationY +
                        p1 * resources.getDimension(R.dimen.text_anim_step) * -1)

                textView_progress.animate().translationY(translationDistance)
                if (!p2) {  // p2 = fromUser or isFromUser
                    textView_progress.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        button_reset.setOnClickListener { v ->
            seekBar.progress = 0
        }
    }
}