package ru.netology.nmedia

fun numFormat (
    numberOrig: String
): String
{
var number = numberOrig.toLong()
val result = number.toString()
if (number in 1000..1_099) {
    return "1K"
}
if (number in 1_000..9_999) {
    return result[0] + "." + result[1] + "K"
}
if (number in 10_000..999_999) {
    return result[0] + "" + result[1] + "K"
}
if (number > 1_000_000) {
    return result[0] + "." + result[1] + "M"
}
else return "0"
}