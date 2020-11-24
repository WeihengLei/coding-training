package com.hkm.ticket.core.utils

import com.google.gson.Gson
import com.gtk.training.entity.Info
import org.apache.commons.codec.digest.DigestUtils
import org.joda.time.DateTime
import java.io.Serializable
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.ZoneOffset
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


@Suppress("UsePropertyAccessSyntax")
fun main(args: Array<String>) {


    val systemTimeOffset = 9
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dateFormat2 = SimpleDateFormat("yyyy-MM-dd")
    println(Instant.now().toEpochMilli())
    println(dateFormat2.format(Instant.now().toEpochMilli()))

    var commercialTypeIds = arrayListOf<String>()
    var dde: List<String> = ArrayList()

    //commercialTypeIds.plus("123")
    //dde.plus("444")

    //commercialTypeIds += "123"

    dde += "444"
    val aa=OffsetDateTime.now().minusMinutes(31).toInstant().toEpochMilli()

    val dd = dateFormat.format(1592316991495)
    val cc = dateFormat.format(OffsetDateTime.now().toInstant().toEpochMilli())


    println("0======$dd")
    println("1======$cc")



    println("2======$commercialTypeIds")
    val ddd  = Math.random()
    println("21======$ddd")
    println("22======${(ddd *100000000).toInt()}")
    println("23======${(Math.random() * 89999999 + 10000000).toInt()}")

    println("1====="+dateFormat.parse("2020-08-01 00:01:00").toInstant().toEpochMilli())
    println("2====="+dateFormat.parse("2020-08-01 23:59:00").toInstant().toEpochMilli())


    val localDate = LocalDate.of(2020,8, 1)

    val startMilli = localDate.toThirtyHourSystem() // 大部分report 查询 2020-06-12 05:00:00
    val endMilli = localDate.plusDays(1).toThirtyHourSystem() // 大部分report 查询 2020-06-13 05:00:00
    val endMilli7 = localDate.plusDays(7).toThirtyHourSystem()// 2020-06-19 05:00:00

    /**
     1、localDate.atStartOfDay(ZoneOffset.ofHours(9))-------大部分show data 查询
     2、plus(21599800)----------加6个小时
     3、plus(107999000)----------加1天 + 6个小时
     */

    val taxRateMilli = localDate.atStartOfDay(ZoneOffset.ofHours(9)).toInstant().toEpochMilli()// 2020-06-11 23:00:00
    val taxRateMilli0 = localDate.atStartOfDay(ZoneOffset.ofHours(9)).plusDays(1).toInstant().toEpochMilli()// 2020-06-12 23:00:00
    val taxRateMilli1 = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli()// 2020-06-12 00:00:00
    val taxRateMilli2 = localDate.atStartOfDay(ZoneOffset.ofHours(3)).toInstant().toEpochMilli()// 2020-06-12 05:00:00
    val taxRateMilli3 = localDate.atStartOfDay(ZoneOffset.ofHours(0)).toInstant().toEpochMilli()// 2020-06-12 08:00:00
    val taxRateMilli4 = localDate.atStartOfDay().atOffset(ZoneOffset.UTC).toEpochSecond() * 1000 // 2020-06-12 08:00:00
    val taxRateMilli5 = localDate.atStartOfDay().atOffset(ZoneOffset.ofHours(9)).toEpochSecond() * 1000 // 2020-06-11 23:00:00
    val taxRateMilli6 = (localDate.atStartOfDay().atOffset(ZoneOffset.ofHours(9)).toEpochSecond() * 1000).plus(21599800) // 2020-06-12 04:59:59


    val dateStart = localDate.atStartOfDay( ZoneOffset.ofHours(9)).toInstant().toEpochMilli().plus(21599800)// 2020-06-12 04:59:59
    val dateEnd = localDate.atStartOfDay(ZoneOffset.ofHours(9)).toInstant().toEpochMilli().plus(107999000)// 2020-06-13 04:59:59

    val dateStart2 = localDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli() // 2020-06-12 08:00:00
    val dateStart3 = localDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli() // 2020-06-12 08:00:00


    // ZoneOffset.UTC 是时区
    println("localDate======${dateFormat.format(localDate.toEpochDay())}")
    println("startMilli======${dateFormat.format(startMilli)}")
    println("endMilli======${dateFormat.format(endMilli)}")
    println("endMilli7======${dateFormat.format(endMilli7)}")

    println("taxRateMilli======${dateFormat.format(taxRateMilli)}")
    println("taxRateMilli0======${dateFormat.format(taxRateMilli0)}")
    println("taxRateMilli1======${dateFormat.format(taxRateMilli1)}")
    println("taxRateMilli2======${dateFormat.format(taxRateMilli2)}")
    println("taxRateMilli3======${dateFormat.format(taxRateMilli3)}")
    println("taxRateMilli4======${dateFormat.format(taxRateMilli4)}")
    println("taxRateMilli5======${dateFormat.format(taxRateMilli5)}")
    println("taxRateMilli6======${dateFormat.format(taxRateMilli6)}")


    println("dateStart======${dateFormat.format(dateStart)}")
    println("dateEnd======${dateFormat.format(dateEnd)}")
    println("dateStart2======${dateFormat.format(dateStart2)}")
    println("dateStart3======${dateFormat.format(dateStart3)}")


    val dataList = mutableListOf<FieldInfo>()
    (1..2).forEach {
        dataList.add(FieldInfo(fieldName="standingCapacity", fieldAliasName="立見席", originalVal=30, updateVal=40))
    }
    val str = dataList.toJson()

    //var jsonString = formatJson(Gson().toJson(dataList))
    println("jsonString===="+str)

    //val str = "[FieldInfo(fieldName=standingCapacity, fieldAliasName=立見席, originalVal=30, updateVal=40)]"
    //val str = "["FieldInfo("fieldName=standingCapacity, fieldAliasName=立見席, originalVal=30, updateVal=40)]"

    val array: Array<FieldInfo> = Gson().fromJson(str, Array<FieldInfo>::class.java)
    val fieldInfos: List<FieldInfo> = array.toList()

    println("fieldInfos===="+fieldInfos)


    DigestUtils.sha1Hex("123456")
    DigestUtils.sha1Hex("90211e5ce95080ce3a58a642d27f648f06efca4b")
    println("1===="+DigestUtils.sha1Hex("ivy.chen123456~"))


    // set showtime limit
    val someDay: Date = DateTime().plusDays(3).toDate()

    println("new Date()===="+ Date())
    println("someDay===="+someDay)



    println("Price===="+createPriceResponse(1091.0, -0.0909090909092356, 0.1).toTransactionItem("ファーストデイ", 3))


    val c = Calendar.getInstance()
    c.add(Calendar.MONTH, 0)
    c[Calendar.DAY_OF_MONTH] = 1
    val start = c.time.toInstant().atOffset(ZoneOffset.ofHours(9))

    val startMilli1 = start.toLocalDate().atStartOfDay()

    println("本月第一天:${startMilli1}")



    println("paa:${startMilli1}")

    println("paa2:${Instant.now().toEpochMilli()}")

    val ss = listOf("1","2","3","4")
    (0..3).forEach {
        println("123=:${it}")
    }
   // println("ss:${ss[4]}")




    try {
        // 常用创建队列方式
        val blockingQueue: BlockingQueue<Map<String, String>> = LinkedBlockingQueue()
        val random = Random() // 随机函数
        for (i in 0..4) {
            val tempMap: MutableMap<String, String> = HashMap<String, String>()
            tempMap["key$i"] = random.nextInt(100).toString()// 创建队列map
            blockingQueue.add(tempMap) // 给队列添加信息
        }
        //             队列大小
        val blockingQueueSize = blockingQueue.size
        println("=========================")
        println(blockingQueueSize)
        println(blockingQueue) // 队列内容
        println("=========================")
        for (i in 0 until blockingQueueSize) {
            println("$i===++++++++++===")
            val tempMap = blockingQueue.take() // 取出队列值，取一次，就从队列中移除
            println(tempMap) // 打印内容
            // 打印队列是否还有东西
            println(blockingQueue)
        }
        println("=========game over================")
    } catch (e: java.lang.Exception) {
        e.printStackTrace()
    }



    val e1 = "a..a@a.com"
    val e2 = "umio15＠gmail.com"



    println("e1======="+e1.replace("＠","@", true))
    println("e2======="+e2.replace("＠","@", true))

    val paymentRel = " "
    val paymentRel2 = null
    println("1======="+(paymentRel == null))
    println("isNullOrEmpty======="+paymentRel.isNullOrEmpty())
    println("isNullOrBlank======="+paymentRel.isNullOrBlank())
    println("isBlank======="+paymentRel.isBlank())
    println("isEmpty======="+paymentRel.isEmpty())
    println("isNotBlank======="+paymentRel.isNotBlank())
    println("isNotEmpty======="+paymentRel.isNotEmpty())


    println("3======="+(paymentRel2 == null))
    println("isNullOrEmpty======="+paymentRel2.isNullOrEmpty())
    println("isNullOrBlank======="+paymentRel2.isNullOrBlank())
//    println("isBlank======="+paymentRel2.isBlank())
//    println("isEmpty======="+paymentRel2.isEmpty())
//    println("isNotBlank======="+paymentRel2.isNotBlank())
//    println("isNotEmpty======="+paymentRel2.isNotEmpty())

    val list: List<Info> = listOf()

    println("4======="+list)
    println("4======="+(list == null))
    println("5======="+list.isEmpty())
    println("5======="+list.isNotEmpty())

    val ticketTypeCouponCodes = arrayListOf<String>()

    println("6.1======="+ticketTypeCouponCodes)
    ticketTypeCouponCodes.add("001")
    println("6.2======="+ticketTypeCouponCodes)

    val cal = Calendar.getInstance()
    cal.time = Date(dateFormat.parse("2020-08-09 22:01:00").toInstant().toEpochMilli())

    println("7======="+cal.get(Calendar.DATE))
    Calendar.

    val monthDays = (1..31).map { it.toString() }

    val monthDays2 = (1..4).map { it.toString() }

    println("8======="+monthDays)


}
fun Any.toJson(): String = Gson().toJson(this)


data class FieldInfo (
        val fieldName: String = "",
        val fieldAliasName: String = "",
        val originalVal: Any? = null,
        val updateVal: Any? = null

): Serializable

//fun <T> compare(obj1: T, Obj2: T): Map<String, String>? {
//    val result: MutableMap<String, String> = HashMap()
//
//    val fs: List<Field> = obj1!!.javaClass.declaredFields.toList()
//    for (f in fs) {
//        f.setAccessible(true)
//        val v1: Any = f.get(obj1)
//        val v2: Any = f.get(Obj2)
//        if (!equalsA(v1, v2)) {
//            result[f.getName()] = equalsA(v1, v2).toString()
//        }
//    }
//    return result
//}

fun equalsA(obj1: Any?, obj2: Any?): Boolean {
    if (obj1 === obj2) {
        return true
    }
    return if (obj1 == null || obj2 == null) {
        false
    } else obj1 == obj2
}

fun LocalDate.toThirtyHourSystem() = this.atStartOfDay(ZoneOffset.ofHours(3)).toInstant().toEpochMilli()


private fun createPriceResponse(unitPrice: Double, unitRounding: Double, tax: Double, modifierValue: Double = 0.0): Price {
    val taxedPrice = Math.round((unitPrice + unitRounding) * (1 + tax)).toDouble()
    val tempTax = Math.round((unitPrice + unitRounding) * tax).toDouble()
    val unitTax = if (taxedPrice < unitPrice + tempTax) taxedPrice - unitPrice else tempTax
    val _unitRounding = unitPrice * tax - unitTax /*if (unitRounding > 0.0) unitRounding else unitPrice * tax - unitTax*/
    val unitTotal = unitPrice + unitTax + modifierValue

    return Price(
            unitPrice = unitPrice + modifierValue,
            unitTax = unitTax,
            unitRounding = _unitRounding,
            unitTotal = unitTotal
    )
}

data class Price(
        val unitPrice: Double = 0.0,
        val unitTax: Double = 0.0,
        val unitRounding: Double = 0.0,
        val unitTotal: Double = 0.0
): Serializable
private fun Price.toTransactionItem(name: String, qty: Int) =
        TransactionItem(
                name = name,
                unitPrice = unitPrice,
                unitTax = unitTax,
                unitRounding = unitRounding,
                unitTotal = unitTotal,
                qty = qty,
                totalTax = unitTax * qty,
                totalPrice = unitPrice * qty,
                totalRounding = unitRounding * qty,
                total = unitTotal * qty
        )
data class TransactionItem(
        var name: String = "",
        var unitPrice: Double = 0.0,
        var unitTax: Double = 0.0,
        var unitRounding: Double = 0.0,
        var unitTotal: Double = 0.0,
        var qty: Int = 0,
        var totalTax: Double = 0.0,
        var totalPrice: Double = 0.0,
        var totalRounding: Double = 0.0,
        var total: Double = 0.0,
        var id: Long? = null,
        var uuid: String = UUID.randomUUID().toString()
)