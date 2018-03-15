package com.gildedrose;

public class TexttestFixture {

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int AMOUNT_OF_DAYS_TO_SIMULATE = 10;
    private static final String STRING_FORMAT_TABLE = "%41s|%10s|%10s|\n";
    private static final String NAME = "name";
    private static final String SELL_IN = "sellIn";
    private static final String QUALITY = "quality";

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80), //
                new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80),
                new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20),
                new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 10, 49),
                new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = AMOUNT_OF_DAYS_TO_SIMULATE;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }


        for (int i = 0; i < days; i++) {
            System.out.format("%56s\n", "---------------- day " + i + " ----------------");
            displayStatus(items);
            app.updateQuality();

        }
    }

    private static void displayStatus(Item... items) {
        System.out.format(STRING_FORMAT_TABLE, NAME, SELL_IN, QUALITY);
        for (Item item : items) {
            System.out.format(STRING_FORMAT_TABLE, item.name, item.sellIn, item.quality);
        }
    }

}
