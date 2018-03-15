package com.gildedrose;

class GildedRose {
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final int MAXI_QUALITY = 50;
    private static final int ONE_AS_DIGIT = 1;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private static boolean hasQualityMinorFifty(Item item) {
        return item.quality < MAXI_QUALITY;
    }

    private static boolean isNotHandOfRagnaros(Item item) {
        return !item.name.equals(SULFURAS_HAND_OF_RAGNAROS);
    }

    private static boolean isBackstagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT);
    }

    private static boolean isNotAgedBrie(Item item) {
        return !item.name.equals(AGED_BRIE);
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!isNotHandOfRagnaros(item)) {
                continue;
            }
            if (isNotAgedBrie(item)
                    && !isBackstagePass(item)) {
                treatItemWithQualityGreaterZero(item);
            } else {
                if (hasQualityMinorFifty(item)) {
                    item.quality = increaseQuality(item);
                    treatBackstagePass(item);
                }
            }
            item.sellIn = reduceSellIn(item);

            treatExpiredItem(item);
        }
    }

    private int reduceSellIn(Item item) {
        return item.sellIn - 1;
    }

    private void treatItemWithQualityGreaterZero(Item item) {
        if (item.quality > 0) {
            if (isNotHandOfRagnaros(item)) {
                item.quality = reduceQuality(item);
            }
        }
    }

    private int reduceQuality(Item item) {
        return item.quality - 1;
    }

    private void treatExpiredItem(Item item) {
        if (isExpired(item)) {
            if (isNotAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    treatItemWithQualityGreaterZero(item);
                } else {
                    item.quality = 0;
                }
            } else {
                if (hasQualityMinorFifty(item)) {
                    item.quality = increaseQuality(item);
                }
            }
        }
    }

    private void treatBackstagePass(Item item) {
        if (isBackstagePass(item)) {
            if (item.sellIn < 11) {
                if (hasQualityMinorFifty(item)) {
                    item.quality = increaseQuality(item);
                }
            }

            if (item.sellIn < 6) {
                if (hasQualityMinorFifty(item)) {
                    item.quality = increaseQuality(item);
                }
            }
        }
    }

    private int increaseQuality(Item item) {
        return item.quality + ONE_AS_DIGIT;
    }
}
