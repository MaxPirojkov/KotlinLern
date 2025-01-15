package org.example.kotlinlern.lesson15.additional

class Section(
    val type: String,
    val capacity: Int
){

    private val items = mutableListOf<Item>()

    fun addItem(item: Item): Boolean{
        if (getFreeSpace() >= convertWeightToVolume(item)){
            return items.add(item)
        }
            return false
    }

    fun findItemByName(name: String): Item?{
        return items.firstOrNull {it.name == name}
    }

    fun remove(item: Item): Boolean {
        return items.remove(item)
    }

    fun getFreeSpace(): Int {
        return capacity - items.sumOf { convertWeightToVolume(it) }
    }

    fun formatData(): String {
        return """
type: $type
   capacity: $capacity
   free: ${getFreeSpace()}
   items:
       ${items.joinToString("\n\t\t")}
       """.trimIndent()
    }

    private fun convertWeightToVolume(item: Item): Int {
        return (item.weight / conversionFactors.getValue(item.type)).toInt()
    }

    private val conversionFactors = mapOf(
        ItemType.LIQUIDS to 0.95,
        ItemType.ALCOHOL to 0.8,
        ItemType.FRUIT to 0.65,
        ItemType.VEGETABLE to 0.55
    )

}