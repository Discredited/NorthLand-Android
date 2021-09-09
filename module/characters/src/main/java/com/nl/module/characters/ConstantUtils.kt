package com.nl.module.characters

object ConstantUtils {

    fun randomRealm(): Int {
        return (Math.random() * 33).toInt() % 5
    }

    fun characterList(): MutableList<CharacterVo> {
        return mutableListOf(
            CharacterVo(
                name = "林飞",
                avatar = "lin_fei.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "甘柠真",
                avatar = "gan_ning_zhen.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "海姬",
                avatar = "hai_ji.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "鸠丹媚",
                avatar = "jiu_dan_mei.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "无颜",
                avatar = "wu_yan.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "龙碟",
                avatar = "long_die.png",
                realm = randomRealm()
            ),

            CharacterVo(
                name = "楚度",
                avatar = "chu_du.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "阿萝",
                avatar = "a_luo.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "悲喜和尚",
                avatar = "bei_xi_he_shang.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "碧潮戈",
                avatar = "bi_chao_ge.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "龙眼雀",
                avatar = "long_yan_que.png",
                realm = randomRealm()
            ),

            CharacterVo(
                name = "夜流冰",
                avatar = "ye_liu_bing.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "阿凡提",
                avatar = "a_fan_ti.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "吐鲁番",
                avatar = "tu_lu_fan.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "公子樱",
                avatar = "gong_zi_ying.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "拓跋峰",
                avatar = "tuo_ba_feng.png",
                realm = randomRealm()
            ),

            CharacterVo(
                name = "庄梦",
                avatar = "zhuang_meng.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "无崖子",
                avatar = "wu_ya_zi.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "黄真",
                avatar = "huang_zhen.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "丁香愁",
                avatar = "ding_xiang_chou.png",
                realm = randomRealm()
            ),
            CharacterVo(
                name = "珠穆朗玛",
                avatar = "zhu_mu_lang_ma.png",
                realm = randomRealm()
            )
        )
    }

    /**
     * 随机生成人物列表
     */
    fun randomCharacterList(number: Int): MutableList<CharacterVo> {
        val list = characterList()
        if (number > list.size) return list
        return list.subList(0, number)
    }
}