package com.gtk.training.util


import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


/**
 * MyBlockingQueue
 *
 * @author Weihang
 * @date 8/9/2020
 *
 */
class MyBlockingQueue {

    var queue: BlockingQueue<String> = LinkedBlockingQueue(5)
    private var index = 0

    fun MyBlockingQueue(i: Int) {
        this.index = i
    }

    fun run() {
        try {
            queue.put(index.toString())
            println("{" + index + "} in queue!")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //@JvmStatic
    fun main(args: Array<String>) {
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
    }


}