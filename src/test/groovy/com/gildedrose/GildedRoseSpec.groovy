package com.gildedrose

import spock.lang.Specification

/**
 * Spock unit tests.
 */
class GildedRoseSpec extends Specification {

    def "should update quality correctly"() {

        given: "some items"
        Item[] items = [new Item("+5 Dexterity Vest", 10, 20), //
                        new Item("Aged Brie", 2, 0)] //]

        and: "the application with these items"
        GildedRose app = new GildedRose(items)

        when: "updating quality"
        app.updateQuality()

        then: "The list is as expected"
        app.items[0].name == "+5 Dexterity Vest"
        app.items[1].name == "Aged Brie"

        and: "The items properties are as expected"
        app.items[0].quality == 19
        app.items[0].sellIn == 9
        app.items[1].quality == 1
        app.items[1].sellIn == 1

    }

}
