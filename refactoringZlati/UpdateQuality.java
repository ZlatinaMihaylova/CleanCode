package refactoringZlati;

public class UpdateQuality {
    public static final int DAYS_BACKSTAGE_INCREASE_BY_2 = 10;
    public static final int DAYS_BACKSTAGE_INCREASE_BY_3 = 5;
    public static final int SELL_IN_DATE_HAS_PASSED = 0;
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    public void changeItemQuality(Item item){
        switch(item.name){
            case "Aged Brie":
                this.decreaseSellIn(item);
                this.increaseQuality(item);
                this.increaseQualityFaster(item, SELL_IN_DATE_HAS_PASSED);
                this.validateQuality(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                this.decreaseSellIn(item);
                this.increaseQuality(item);
                this.increaseQualityFaster(item, DAYS_BACKSTAGE_INCREASE_BY_2);
                this.increaseQualityFaster(item, DAYS_BACKSTAGE_INCREASE_BY_3);
                this.dropQuality(item);
                this.validateQuality(item);
                break;
            case "Conjured Mana Cake":
                this.decreaseSellIn(item);
                this.decreaseQuality(item);
                this.decreaseQuality(item);
                this.validateQuality(item);
                break;
            default:
                this.decreaseSellIn(item);
                this.decreaseQuality(item);
                this.decreaseQualityFaster(item, SELL_IN_DATE_HAS_PASSED);
                this.validateQuality(item);
        }
    }

    public void decreaseSellIn(Item item){
        item.sellIn--;
    }

    public void decreaseQuality(Item item){
        item.quality--;
    }

    public void increaseQuality(Item item){
        item.quality++;
    }

    public void decreaseQualityFaster(Item item, int days){
        if (item.sellIn < days){
            item.quality--;
        }
    }

    public void increaseQualityFaster(Item item, int days){
        if (item.sellIn < days){
            item.quality++;
        }
    }

    public void dropQuality(Item item){
        if ( item.sellIn < SELL_IN_DATE_HAS_PASSED){
            item.quality = MIN_QUALITY;
        }
    }

    public void validateQuality(Item item){
        if ( item.quality < MIN_QUALITY){
            item.quality = MIN_QUALITY;
        }
        if (item.quality > MAX_QUALITY){
            item.quality = MAX_QUALITY;
        }
    }
}
