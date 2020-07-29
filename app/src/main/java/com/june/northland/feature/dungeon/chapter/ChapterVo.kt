package com.june.northland.feature.dungeon.chapter

import com.june.northland.R

class ChapterVo(
    val title: String,
    val subtitle: String = "",
    val icon: Int = R.drawable.img_practice_0,
    val currentProgress: Int = 0,
    val totalProgress: Int = 30,  //总进度
    val isUnlock: Boolean = true,  //是否解锁
    val progress: String = "$currentProgress/$totalProgress"  //当前进度
)