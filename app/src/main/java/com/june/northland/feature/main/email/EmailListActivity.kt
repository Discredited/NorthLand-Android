package com.june.northland.feature.main.email

import com.june.base.basic.ext.addLinearItemDecoration
import com.june.base.basic.ext.setLinearManager
import com.june.northland.databinding.ActivityEmailListBinding
import com.nl.component.NLBaseActivity

class EmailListActivity : NLBaseActivity<ActivityEmailListBinding>() {

    private val mAdapter = EmailAdapter()

    override fun initView() {
        mBinding.rvEmail.apply {
            setLinearManager()
            adapter = mAdapter
            setHasFixedSize(true)
            addLinearItemDecoration()
        }

        mBinding.iToolbar.toolbar.title = "邮件"
    }

    override fun loadData() {
        mAdapter.setNewInstance(
            mutableListOf(
                EmailVo(
                    "林飞",
                    "林飞的父亲是落魄的秀才，教会林飞许多道理的同时却不能给他一个无忧无虑的生活。被当做灵媒带入北境，遇到注定将牵绊他一身的三大美女：海姬，鸠丹媚，甘柠真"
                ),
                EmailVo(
                    "楚度",
                    "若你一出生，便得知此生被他人主宰，心中会是何等滋味？你不属于你，你只是一个附庸，你的存在只是为了另一个而存在。无论你怎样努力，无论你怎样挣扎，你的惊艳只是为了令一个人而盛开"
                ),
                EmailVo(
                    "龙蝶",
                    "林飞的前世，红尘天叱咤风云的一代妖王。耗尽心血，隐忍了无数不堪回首的痛苦折磨，设计从魔刹天格格巫处得到轮回妖术，借助黄泉天幽冥河的涨潮让无知的自己转生大唐，有知的自己则藏身黄泉天。待林飞长成，吞噬林飞之日，便是突破知微、逆天改命之时！但最终却被林飞的坚持所打动，放弃自我，与其融合，助其突破知微"
                ),
                EmailVo(
                    "碧潮戈",
                    "魔刹天十大妖王之一的海龙王。爱刀成痴，却忽视了身边的最爱，直到失去才追悔莫及。因为深爱强迫折磨自己疯狂痴癫以求片刻的内心慰藉。后被林飞无意言语所感化，正视自己的感情。在刀法和感情上更进一步。是林飞的大哥，林飞心中的父亲！魂器无量刀的主人，使无量刀由“器有大小，唯心难量”进化为“器无大小，唯心能量”。最后为了牵制林飞，被设计与公子樱决斗身死，无量刀亦殉主而死"
                ),
                EmailVo(
                    "海姬",
                    "罗生天脉经海殿首席女武神，同时也是脉经海殿掌门海妃的亲妹妹，生性单纯。曾一招将清虚天派来的高手代表击败而一战成名。同甘柠真有些小矛盾，但在生死关头却又默契异常。林飞从龙鲸体内脱困后与其确定感情，而后在罗生天道法会上罗生天陷落后容身吉祥天。最终随林飞回到大唐"
                ),
                EmailVo(
                    "鸠丹媚",
                    "魔刹天妖女，出场时已为九尾蝎妖，修为甚高。妖媚异常，敢爱敢恨。业障山中梵摩默认鸠丹媚干扰了天道，从而被刑天种下刺衣咒，男人不得近其身。后林飞学会千千咒结的解结咒而将刺衣咒解除。现鸠丹媚已生出第十根蝎尾，究竟与天道何干尚不得而知。受林飞以空城精华而提升法力，冲至末那态顶峰。离知微不远。结局中亦随林飞回到大唐"
                ),
                EmailVo(
                    "甘柠真",
                    "清丽绝尘，白衣似雪，人称“甘仙子”。来自清虚天第一名门碧落赋。人妖之身，其昔日天下第一高手、碧落赋掌门晏采子和魔刹天七窍雪莲妖独女。魂器为三千弱水剑，出手凌厉。深爱林飞，后因林飞利用她杀掉公子樱产生心结，在最终的“尾声与尾生”一章中洛水提供了开放式的结局，任由读者想象，但据洛水本人说其更加偏向的是二人同归于好"
                ),
                EmailVo(
                    "无颜",
                    "罗生天沙盘静地无痕之子，为阿修罗岛顶层王族与人类女子之后，林飞的知己。北境防御第一魂器恒河沙数盾主人，会读心术、魂化等各种远古遗术，通读北境志怪，后来获得阿修罗王的传承印记却弃之如敝履。对世间的纷争毫无兴趣，只想逍遥自在，无拘无束。结局中与屈玲珑双宿双飞"
                )
            )
        )
    }
}