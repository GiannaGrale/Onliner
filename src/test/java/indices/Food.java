package indices;

public enum Food {

    PIZZA("4"),
    SUSHI("8"),
    BURGERS_FASTFOOD("12"),
    GRILLE("16"),
    SHAWARMA("20"),
    PIES_BUNS("32"),
    FARMS_GOODS("36"),
    GROCERIES("40"),
    GOURMET_SEA_FOODS("44"),
    DESSERTS("48"),
    ALL_RESTAURANTS("52");

    private final String title;

    Food(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
