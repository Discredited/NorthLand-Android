package com.nl.room.source

import com.nl.lib.role.RoleEntity

object TestDataSource {

    fun mockRoles(): MutableList<RoleEntity> {
        return mutableListOf(
            RoleEntity(
                id = "00001",
                name = "林飞",
                avatar = "lin_fei.png",
                image = "lin_fei.png",
                desc = "林飞作为龙蝶的转世，必须提防被龙蝶吞噬，并寻找吞噬龙蝶的机会；作为天命之子，受天命的眷顾而成长迅速，历尽万难终于迈入知微。",
                faction = 1,
                race = 1,
                quality = 1,
                realm = 1,
                power = 1,
                intellect = 1,
                experience = 0,
                level = 1,
                expNextLevel = 0,
                expFactor = 20
            ),
            RoleEntity(
                id = "00002",
                name = "甘柠真",
                avatar = "gan_ning_zhen.png",
                image = "gan_ning_zhen.png",
                desc = "清丽绝尘，白衣似雪，人称“甘仙子”。来自清虚天第一名门碧落赋。人妖之身，其昔日天下第一高手、碧落赋掌门晏采子和魔刹天七窍雪莲妖独女。魂器为三千弱水剑，出手凌厉。",
                faction = 1,
                race = 1,
                quality = 1,
                realm = 1,
                power = 1,
                intellect = 1,
                experience = 0,
                level = 1,
                expNextLevel = 0,
                expFactor = 20
            ),
            RoleEntity(
                id = "00003",
                name = "海姬",
                avatar = "hai_ji.png",
                image = "hai_ji.png",
                desc = "罗生天脉经海殿首席女武神，同时也是脉经海殿掌门海妃的亲妹妹，生性单纯。曾一招将清虚天派来的高手代表击败而一战成名。",
                faction = 1,
                race = 1,
                quality = 1,
                realm = 1,
                power = 1,
                intellect = 1,
                experience = 0,
                level = 1,
                expNextLevel = 0,
                expFactor = 20
            ),
            RoleEntity(
                id = "00004",
                name = "鸠丹媚",
                avatar = "jiu_dan_mei.png",
                image = "jiu_dan_mei.png",
                desc = "魔刹天妖女，出场时已为九尾蝎妖，修为甚高。妖媚异常，敢爱敢恨。业障山中梵摩默认鸠丹媚干扰了天道，从而被刑天种下刺衣咒，男人不得近其身。",
                faction = 1,
                race = 1,
                quality = 1,
                realm = 1,
                power = 1,
                intellect = 1,
                experience = 0,
                level = 1,
                expNextLevel = 0,
                expFactor = 20
            ),
            RoleEntity(
                id = "00005",
                name = "无颜",
                avatar = "wu_yan.png",
                image = "wu_yan.png",
                desc = "罗生天沙盘静地无痕之子，为阿修罗岛顶层王族与人类女子之后，林飞的知己。北境防御第一魂器恒河沙数盾主人，会读心术、魂化等各种远古遗术，通读北境志怪，后来获得阿修罗王的传承印记却弃之如敝履。对世间的纷争毫无兴趣，只想逍遥自在，无拘无束。",
                faction = 1,
                race = 1,
                quality = 1,
                realm = 1,
                power = 1,
                intellect = 1,
                experience = 0,
                level = 1,
                expNextLevel = 0,
                expFactor = 20
            )
        )
    }
}