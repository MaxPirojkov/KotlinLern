package org.example.kotlinlern.lesson15.additional

class Fridge(private val capacity: Int) {

    private val sections = mutableListOf<Section>()

    fun addSection(section: Section): Boolean {
        return capacity > sections.size && sections.add(section)
    }

    fun removeSectionsByType(type: String): Boolean {
        return sections.removeIf { it.type == type }
    }

    fun addItem(item: Item): Boolean {
        return sections.filter { it.type == item.type }
            .sortedBy { it.capacity }
            .any { it.addItem(item) }
    }

    fun findItemByNameAndType(name: String, type: String): Item? {
        return sections.filter { it.type == type }
            .map { it.findItemByName(name) }
            .firstOrNull()
    }

    fun removeItem(item: Item): Boolean {
        return sections.any { it.remove(item) }
    }

    fun removeAllItemsByName(name: String): Int {
        var counter = 0
        sections.forEach { section ->
            while (true) {
                val item = section.findItemByName(name)
                if (item != null) {
                    section.remove(item)
                    counter++
                } else {
                    break
                }
            }
        }
        return counter
    }

    fun viewFridge() {
        println(sections.joinToString("\n\n") { it.formatData() })
    }
}
