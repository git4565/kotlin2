//1 задание
fun grammatics(time: Int): String
{
    var str: String = ""
    var retime = time/60
    var digit = retime % 10
    if(retime<20){
        when(retime) {
            1 -> str = "минуту"
            2, 3, 4 -> str = "минуты"
            in 5..19 -> str = "минут"
        }
    }
    else
    {
        when(digit)
        {
            1 -> str = "минуту"
            2, 3, 4 -> str = "минуты"
            5, 6, 7, 8, 9, 0 -> str = "минут"
        }
    }
    return "$retime $str назад."
}

fun grammaticsHours(time: Int): String
{
    var str: String = ""
    var retime = time/3600
    var digit = retime % 10

    when(digit)
    {
        1 -> str = "час"
        2, 3, 4 -> str = "часа"
        5, 6, 7, 8, 9, 0 -> str = "часов"
    }


    return "$retime $str назад."
}


fun agoToText(time: Int): String
{
    var timeStr: String = ""
    when(time)
    {
        in 0..60 -> timeStr = "только что."
        in 61..60*60 -> timeStr = grammatics(time)
        in 60*60+1..24*60*60 -> timeStr = grammaticsHours(time)
        in 24*60*60+1..24*60*60*2 -> timeStr = "вчера."
        in 24*60*60*2+1..24*60*60*3 -> timeStr = "позавчера."
        else -> timeStr = "давно."
    }
    return "был(а) $timeStr"
}
//2 задание

fun transaction(card: String = "vkpay", previousPayments: Double = 0.0, currentPayment: Double): String
{
    var commition: Double = 0.0
    when(card)
    {
        "maestro", "mastercard" -> if(previousPayments>75000.0) commition = currentPayment*0.006+2.0
        "visa", "мир" ->
            {
                commition = currentPayment*0.0075
                if(commition<35.0) commition = 35.0
        }
    }
    var payment: Double = currentPayment + commition
    return "Платёж: $payment, коммисия: $commition"
}
fun main() {
    val time = 18600
    val card = "visa"
    val previousPayments = 5600.0
    val payment = 7800.0
    println(agoToText(time))
    println(transaction(card, previousPayments, payment))
}