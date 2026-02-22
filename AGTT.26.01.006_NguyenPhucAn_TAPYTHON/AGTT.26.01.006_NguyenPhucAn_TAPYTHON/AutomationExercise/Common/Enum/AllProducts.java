package Enum;

public enum AllProducts {
    BLUETOP("Blue Top"),
    MENTSHIRT("Men"),
    SLEEVELESSDRESS("Sleeveless "),
    STYLISHDRESS("Stylish Dress"),
    WINTERTOP("Winter Top"),
    SUMMERWHILETOP("Summer White Top"),
    MADAMTOPFORNUMBER("Madame Top For Women"),
    FANCYGREENTOP("Fancy Green Top"),
    SLEEVESPRINTEDTOP("Sleeves Printed Top - White"),
    HALFSLEEVES("Half Sleeves Top Schiffli Detailing - Pink"),
    FROZENTOPSFORKIDS("Frozen Tops For Kids"),
    FULLSLEEVESTOPCHERRY("Full Sleeves Top Cherry - Pink"),
    PRINTOFFSHOULDERTOP("Printed Off Shoulder Top - White"),
    SLEEVESTOPANDSHORT("Sleeves Top and Short - Blue & Pink"),
    LITTLEGIRLS("Little Girls Mr. Panda "),
    SLEEVESUNICORN("Sleeveless Unicorn Patch Gown - Pink"),
    COTTONMULL("Cotton Mull Embroidered Dress"),
    BLUECOTTON("Blue Cotton Indie Mickey Dress");

    private final String value;
    AllProducts(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
