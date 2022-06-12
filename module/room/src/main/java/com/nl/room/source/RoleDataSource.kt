package com.nl.room.source

import com.nl.lib.element.enum.*
import com.nl.lib.element.role.RoleEntity

object RoleDataSource {

    fun mockRoles(): MutableList<RoleEntity> {
        return mutableListOf(
            RoleEntity(
                id = "00001",
                name = "机器人",
                avatar = "ji_qi_ren.png",
                image = "ji_qi_ren.png",
                desc = "输出测试机器人",
                faction = FactionEnum.SKY_UN_KNOW,
                race = RaceEnum.UN_KNOW,
                quality = QualityEnum.QUALITY_R,
                realm = RealmEnum.REALM_0,
                power = PowerEnum.POWER_0,
                intellect = 1,
                level = 999,
                attackInit = 1,
                defenseInit = -1,
                healthInit = -1,
                speedInit = 0
            ),
            RoleEntity(
                id = "10001",
                name = "楚度",
                avatar = "chu_du.png",
                image = "chu_du.png",
                desc = "本体是魔刹天鲲鹏山脉沙罗峰顶的沙罗铁树。不甘天命，抗逆天命。习得、并融会百家法术，更炼出身外身，北境最顶尖高手之一。",
                faction = FactionEnum.SKY_MO_SHA,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_UR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "10002",
                name = "晏采子",
                avatar = "yan_cai_zi.png",
                image = "yan_cai_zi.png",
                desc = "甘柠真的父亲，跟楚度一样可以为道舍身的人，法力高深莫测。昔日北境第一高手、碧落赋掌门，如今唯一可能以一己之力敌楚度之人。走的是身化万物，割断小我的道路。",
                faction = FactionEnum.SKY_QING_XU,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_UR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "10003",
                name = "道轮",
                avatar = "dao_lun.png",
                image = "dao_lun.png",
                desc = "北境意志的具象显化，吉祥天隐藏统治者，但从不参与各项管理事务，外表毫无特色，但实力深不见底，没有人的思维意识",
                faction = FactionEnum.SKY_JI_XIANG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_UR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20001",
                name = "公子樱",
                avatar = "gong_zi_ying.png",
                image = "gong_zi_ying.png",
                desc = "北境第一美男子，现任碧落赋掌门。北境刀术集大成者，海龙王碧朝戈亦无法望其项背。资质卓绝，弱冠之年已迈入知微，如今更是比拥有螭枪的林飞更快地领悟到宙的奥秘。",
                faction = FactionEnum.SKY_QING_XU,
                race = RaceEnum.SOUL_WEAPON,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20002",
                name = "拓跋峰",
                avatar = "tuo_ba_feng.png",
                image = "tuo_ba_feng.png",
                desc = "清虚天第二名门破坏岛门主。为人豪爽耿直，坚毅隐忍，是林飞的毕业导师之一。",
                faction = FactionEnum.SKY_QING_XU,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20003",
                name = "庄梦",
                avatar = "zhuang_meng.png",
                image = "zhuang_meng.png",
                desc = "清虚天第三名门星宿岛掌教。也是北境三大命师之一，城府极深，算计能力无双。",
                faction = FactionEnum.SKY_QING_XU,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20004",
                name = "阿萝",
                avatar = "a_luo.png",
                image = "a_luo.png",
                desc = "楚度的妻子，林飞的师傅，居住在龙鲸肚子里的老婆婆，学识和技能满分。在楚度和葳蕤琵琶的辅助下成就知微。",
                faction = FactionEnum.SKY_MO_SHA,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20005",
                name = "悲喜和尚",
                avatar = "bei_xi_he_shang.png",
                image = "bei_xi_he_shang.png",
                desc = "魔刹天四大妖王之一，装疯卖傻的和尚，在楚度崛起之前是当之无愧的魔刹天第一人。为成就知微肉生飞升而被困色欲天。",
                faction = FactionEnum.SKY_MO_SHA,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_4,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "20006",
                name = "碧潮戈",
                avatar = "bi_chao_ge.png",
                image = "bi_chao_ge.png",
                desc = "魔刹天四大妖王之一，东海海龙王，刀法无双，仗义耿直，是林飞的结拜大哥。",
                faction = FactionEnum.SKY_MO_SHA,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_3,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "20007",
                name = "珠穆朗玛",
                avatar = "zhu_mu_lang_ma.png",
                image = "zhu_mu_lang_ma.png",
                desc = "罗生天第一名门大光明境掌教，是个GAY....半步知微。",
                faction = FactionEnum.SKY_LUO_SHENG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_4,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "20008",
                name = "无痕",
                avatar = "wu_hen.png",
                image = "wu_hen.png",
                desc = "罗生天第二名门沙盘静地掌教，北境三大命师之一，城府深，实力强，精于算计。",
                faction = FactionEnum.SKY_LUO_SHENG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_4,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "20009",
                name = "海妃",
                avatar = "hai_fei.png",
                image = "hai_fei.png",
                desc = "罗生天第三名门脉经海殿掌教，emmmmm，海姬的姐姐，有点不讨喜。",
                faction = FactionEnum.SKY_LUO_SHENG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_4,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "20010",
                name = "梵摩",
                avatar = "fan_mo.png",
                image = "fan_mo.png",
                desc = "吉祥天菩提院首席长老，权掌北境的残疾人，据说修炼功法大成可恢复残疾。",
                faction = FactionEnum.SKY_JI_XIANG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "20011",
                name = "天刑",
                avatar = "tian_xing.png",
                image = "tian_xing.png",
                desc = "吉祥天天刑宫首席长老，权掌北境的刺客杀手，是个半妖，代天刑法。",
                faction = FactionEnum.SKY_JI_XIANG,
                race = RaceEnum.HALF_DEMON,
                quality = QualityEnum.QUALITY_SSR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "30001",
                name = "林飞",
                avatar = "lin_fei.png",
                image = "lin_fei.png",
                desc = "林飞作为龙蝶的转世，必须提防被龙蝶吞噬，并寻找吞噬龙蝶的机会；作为天命之子，受天命的眷顾而成长迅速，历尽万难终于迈入知微。",
                faction = FactionEnum.SKY_HONG_CHEN,
                race = RaceEnum.HALF_DEMON,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_5,
                power = PowerEnum.POWER_9
            ),
            RoleEntity(
                id = "30002",
                name = "甘柠真",
                avatar = "gan_ning_zhen.png",
                image = "gan_ning_zhen.png",
                desc = "清丽绝尘，白衣似雪，人称“甘仙子”。来自清虚天第一名门碧落赋。人妖之身，其昔日天下第一高手、碧落赋掌门晏采子和魔刹天七窍雪莲妖独女。魂器为三千弱水剑，出手凌厉。",
                faction = FactionEnum.SKY_QING_XU,
                race = RaceEnum.HALF_DEMON,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_3,
                power = PowerEnum.POWER_8
            ),
            RoleEntity(
                id = "30003",
                name = "海姬",
                avatar = "hai_ji.png",
                image = "hai_ji.png",
                desc = "罗生天脉经海殿首席女武神，同时也是脉经海殿掌门海妃的亲妹妹，生性单纯。曾一招将清虚天派来的高手代表击败而一战成名。",
                faction = FactionEnum.SKY_LUO_SHENG,
                race = RaceEnum.HUMAN,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_2,
                power = PowerEnum.POWER_1
            ),
            RoleEntity(
                id = "30004",
                name = "鸠丹媚",
                avatar = "jiu_dan_mei.png",
                image = "jiu_dan_mei.png",
                desc = "魔刹天妖女，出场时已为九尾蝎妖，修为甚高。妖媚异常，敢爱敢恨。业障山中梵摩默认鸠丹媚干扰了天道，从而被刑天种下刺衣咒，男人不得近其身。",
                faction = FactionEnum.SKY_MO_SHA,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_2,
                power = PowerEnum.POWER_1
            ),
            RoleEntity(
                id = "30005",
                name = "无颜",
                avatar = "wu_yan.png",
                image = "wu_yan.png",
                desc = "罗生天沙盘静地无痕之子，为阿修罗岛顶层王族与人类女子之后，林飞的知己。北境防御第一魂器恒河沙数盾主人，会读心术、魂化等各种远古遗术，通读北境志怪，后来获得阿修罗王的传承印记却弃之如敝履。对世间的纷争毫无兴趣，只想逍遥自在，无拘无束。",
                faction = FactionEnum.SKY_LUO_SHENG,
                race = RaceEnum.HALF_DEMON,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_3,
                power = PowerEnum.POWER_6
            ),
            RoleEntity(
                id = "30006",
                name = "龙碟",
                avatar = "long_die.png",
                image = "long_die.png",
                desc = "林飞的前世，红尘天叱咤风云的一代妖王。耗尽心血，隐忍了无数不堪回首的痛苦折磨，设计从魔刹天格格巫处得到轮回妖术，借助黄泉天幽冥河的涨潮让无知的自己转生大唐，有知的自己则藏身黄泉天。",
                faction = FactionEnum.SKY_HONG_CHEN,
                race = RaceEnum.DEMON,
                quality = QualityEnum.QUALITY_SR,
                realm = RealmEnum.REALM_2,
                power = PowerEnum.POWER_6
            ),
        )
    }
}