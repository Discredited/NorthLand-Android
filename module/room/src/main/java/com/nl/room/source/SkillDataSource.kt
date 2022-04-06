package com.nl.room.source

import com.nl.lib.element.skill.SkillEntity
import com.nl.lib.element.skill.SkillEnum

object SkillDataSource {

    fun mockSkills(): MutableList<SkillEntity> {
        return mutableListOf(
            SkillEntity(
                "100011",
                "10001",
                SkillEnum.TYPE_PASSIVE,
                "术法无双",
                "chu_du/shu_fa_wu_shuang.png",
                "技能伤害提升15%，受到的技能伤害减少15%",
                1,
            ),
            SkillEntity(
                "100012",
                "10001",
                SkillEnum.TYPE_INITIATIVE,
                "镜花水月",
                "chu_du/jing_hua_shui_yue.png",
                "对全体敌人造成4段伤害，每段伤害为攻击力30%-60%",
                1,
            ),
            // 晏采子
            SkillEntity(
                "100021",
                "10002",
                SkillEnum.TYPE_PASSIVE,
                "共时交点",
                "yan_cai_zi/gong_shi_jiao_dian.png",
                "受到攻击时，有30%概率免疫本次伤害，免疫成功对方全体造成自身防御30%的真实伤害",
                1,
            ),
            SkillEntity(
                "100022",
                "10002",
                SkillEnum.TYPE_INITIATIVE,
                "超脱物外",
                "yan_cai_zi/chao_tuo_wu_wai.png",
                "对敌方单体造成自身防御70%的伤害，并给自身制造一个自身生命值20%的护盾",
                1,
            ),
            // 道轮
            SkillEntity(
                "100031",
                "10003",
                SkillEnum.TYPE_PASSIVE,
                "天地意志",
                "yan_cai_zi/tian_di_yi_zhi.png",
                "被攻击的目标有10%的概率禁止行动一回合",
                1,
            ),
            SkillEntity(
                "100032",
                "10003",
                SkillEnum.TYPE_INITIATIVE,
                "超脱物外",
                "yan_cai_zi/chao_tuo_wu_wai.png",
                "对敌方全体造成自身攻击力160%的伤害",
                1,
            ),
            // 公子樱
            SkillEntity(
                "200011",
                "20001",
                SkillEnum.TYPE_PASSIVE,
                "绕",
                "gong_zi_ying/rao.png",
                "敌方行动后，30%概率追加一次攻击，对敌方造成自身攻击110%的伤害",
                1,
            ),
            SkillEntity(
                "200012",
                "20001",
                SkillEnum.TYPE_INITIATIVE,
                "刀光",
                "gong_zi_ying/dao_guang.png",
                "对敌方全体造自身攻击95%的伤害",
                1,
            ),
            // 拓跋峰
            SkillEntity(
                "200021",
                "20002",
                SkillEnum.TYPE_PASSIVE,
                "豪放不羁",
                "tuo_ba_feng/hao_fang_bu_ji.png",
                "每回合增加自身2%攻击力",
                1,
            ),
            SkillEntity(
                "200022",
                "20002",
                SkillEnum.TYPE_INITIATIVE,
                "破坏真诀",
                "tuo_ba_feng/po_huai_zhen_jue.png",
                "对敌方单体造成自身攻击力50%的真实伤害",
                1,
            ),
            // 庄梦
            SkillEntity(
                "200031",
                "20003",
                SkillEnum.TYPE_PASSIVE,
                "星卜",
                "zhuang_meng/xing_bu.png",
                "首次被击败后利用星辰之力复活，并回复40%生命，每场战斗仅触发一次",
                1,
            ),
            SkillEntity(
                "200032",
                "20003",
                SkillEnum.TYPE_INITIATIVE,
                "星罗棋布",
                "zhuang_meng/xing_luo_qi_bu.png",
                "对敌方前排造成自身攻击160%的伤害",
                1,
            ),
            // 阿萝
            SkillEntity(
                "200041",
                "20004",
                SkillEnum.TYPE_PASSIVE,
                "宿命",
                "a_luo/su_ming.png",
                "命运之力缠绕使阿萝有30%几率闪避敌人的伤害",
                1,
            ),
            SkillEntity(
                "200042",
                "20004",
                SkillEnum.TYPE_INITIATIVE,
                "会心一击",
                "a_luo/hui_xin_yi_ji.png",
                "对敌方后排造成自身攻击120%的伤害",
                1,
            ),
            // 悲喜和尚
            SkillEntity(
                "200051",
                "20005",
                SkillEnum.TYPE_PASSIVE,
                "元力",
                "bei_xi_he_shang/yuan_li.png",
                "增加自身15%生命,15%防御",
                1,
            ),
            SkillEntity(
                "200052",
                "20005",
                SkillEnum.TYPE_INITIATIVE,
                "孤注一掷",
                "bei_xi_he_shang/gu_zhu_yi_zhi.png",
                "消耗10%自身生命值，敌方前排损失该生命消耗2倍的生命",
                1,
            ),
            // 碧潮戈
            SkillEntity(
                "200061",
                "20006",
                SkillEnum.TYPE_PASSIVE,
                "孤傲龙王",
                "bi_chao_ge/gu_ao_long_wang.png",
                "攻击增加30%伤害",
                1,
            ),
            SkillEntity(
                "200062",
                "20006",
                SkillEnum.TYPE_INITIATIVE,
                "刀气",
                "bi_chao_ge/dao_qi.png",
                "对敌方全体造成攻击115%伤害",
                1,
            ),
            // 珠穆朗玛
            SkillEntity(
                "200071",
                "20007",
                SkillEnum.TYPE_PASSIVE,
                "浮光掠影",
                "zhu_mu_lang_ma/fu_guang_lue_ying.png",
                "被攻击时有40%的几率闪避敌人的攻击",
                1,
            ),
            SkillEntity(
                "200072",
                "20007",
                SkillEnum.TYPE_INITIATIVE,
                "璀璨光华",
                "zhu_mu_lang_ma/cui_can_guang_hua.png",
                "对闪避值低于自身的敌人造成闪避差值*2的真实伤害",
                1,
            ),
            // 无痕
            SkillEntity(
                "200081",
                "20008",
                SkillEnum.TYPE_PASSIVE,
                "沙脉",
                "wu_hen/sha_mai.png",
                "受到攻击时有40%的概率减少70%的伤害",
                1,
            ),
            SkillEntity(
                "200082",
                "20008",
                SkillEnum.TYPE_INITIATIVE,
                "沙咒",
                "wu_hen/sha_zhou.png",
                "对敌人造成80%的伤害，并有20%概率使敌人无法行动一回合",
                1,
            ),
            // 海妃
            SkillEntity(
                "200091",
                "20009",
                SkillEnum.TYPE_PASSIVE,
                "脉经",
                "hai_fei/mai_jing.png",
                "增加自身10攻击和10%防御",
                1,
            ),
            SkillEntity(
                "200092",
                "20009",
                SkillEnum.TYPE_INITIATIVE,
                "海上明月",
                "hai_fei/hai_shang_ming_yue.png",
                "对敌方后排造成自身攻击140%的伤害",
                1,
            ),
            // 梵摩
            SkillEntity(
                "200101",
                "20010",
                SkillEnum.TYPE_PASSIVE,
                "易形残玄",
                "fan_mo/yi_xing_can_xuan.png",
                "每损失5%生命值提升对敌方造成的伤害增加10%",
                1,
            ),
            SkillEntity(
                "200102",
                "20010",
                SkillEnum.TYPE_INITIATIVE,
                "龙象般若",
                "fan_mo/long_xiang_bo_re.png",
                "对地方前排造成自身攻击150%的伤害",
                1,
            ),
            // 天刑
            SkillEntity(
                "200111",
                "20011",
                SkillEnum.TYPE_PASSIVE,
                "时光之咒",
                "tian_xing/shi_guang_zhi_zhou.png",
                "自身攻击、防御、生命提高10%",
                1,
            ),
            SkillEntity(
                "200112",
                "20011",
                SkillEnum.TYPE_INITIATIVE,
                "天道刑法",
                "tian_xing/tian_dao_xing_fa.png",
                "对敌方生命值最低的两名敌人造成自身攻击135%伤害",
                1,
            ),
            // 林飞
            SkillEntity(
                "300011",
                "30001",
                SkillEnum.TYPE_PASSIVE,
                "执念",
                "lin_fei/zhi_nian.png",
                "每损失5%生命值提升自身5%攻击力",
                1,
            ),
            SkillEntity(
                "300012",
                "30001",
                SkillEnum.TYPE_INITIATIVE,
                "弦线",
                "lin_fei/xuan_xian.png",
                "对敌方后排造成自身攻击150%伤害",
                1,
            ),
            // 甘柠真
            SkillEntity(
                "300021",
                "30002",
                SkillEnum.TYPE_PASSIVE,
                "莲心眼",
                "gan_ning_zhen/lian_xin_yan.png",
                "攻击无视敌方20%防御力",
                1,
            ),
            SkillEntity(
                "300022",
                "30002",
                SkillEnum.TYPE_INITIATIVE,
                "弱水出鞘",
                "gan_ning_zhen/ruo_shui_chu_qiao.png",
                "对敌方全体造成自身攻击105%伤害",
                1,
            ),
            // 海姬
            SkillEntity(
                "300031",
                "30003",
                SkillEnum.TYPE_PASSIVE,
                "流光金甲",
                "hai_ji/liu_guang_jin_jia.png",
                "受到攻击时，减少20%伤害，并将最终承受伤害的20%反弹给攻击者",
                1,
            ),
            SkillEntity(
                "300032",
                "30003",
                SkillEnum.TYPE_INITIATIVE,
                "脉经盾",
                "hai_ji/mai_jing_dun.png",
                "给同行队友(包括自身)制造一个自身生命值20%的护盾",
                1,
            ),
            // 鸠丹媚
            SkillEntity(
                "300041",
                "30004",
                SkillEnum.TYPE_PASSIVE,
                "天命蝎尾",
                "jiu_dan_mei/tian_ming_xie_wei.png",
                "对目标周围敌人造成自身攻击20%的溅射伤害",
                1,
            ),
            SkillEntity(
                "300042",
                "30004",
                SkillEnum.TYPE_INITIATIVE,
                "丹蝎九尾",
                "jiu_dan_mei/dan_xie_jiu_wei.png",
                "对敌方单体造成5段攻击，每段攻击造成自身攻击40%伤害",
                1,
            ),
            // 无颜
            SkillEntity(
                "300051",
                "30005",
                SkillEnum.TYPE_PASSIVE,
                "天生沙脉",
                "wu_yan/tian_sheng_sha_mai.png",
                "受到攻击时对攻击方造成自身防御力20%的伤害",
                1,
            ),
            SkillEntity(
                "300052",
                "30005",
                SkillEnum.TYPE_INITIATIVE,
                "时光之沙",
                "wu_yan/shi_guang_zhi_sha.png",
                "对敌方全体造成自身防御70%的伤害",
                1,
            ),
            // 龙碟
            SkillEntity(
                "300061",
                "30006",
                SkillEnum.TYPE_PASSIVE,
                "诡诈",
                "long_die/gui_zha.png",
                "受到攻击时50%几率减免80%伤害",
                1,
            ),
            SkillEntity(
                "300062",
                "30006",
                SkillEnum.TYPE_INITIATIVE,
                "垂死坚持",
                "long_die/chui_si_jian_chi.png",
                "对方后排造成自身生命值30%真实伤害",
                1,
            )
        )
    }
}