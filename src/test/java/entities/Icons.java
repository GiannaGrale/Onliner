package entities;

/***
 * Catalogue of dropdown items
 */
public enum Icons {

    ELECTRONICS("1"),
    COMPUTERS("2"),
    HOUSEHOLD_APPLIANCES("3"),
    CONSTRUCTION("4"),
    HOUSE_GARDEN("5"),
    AUTO("6"),
    BEAUTY_SPORT("7"),
    CHILDREN_MOTHER("8"),
    WORK_OFFICE("9"),
    FOOD("16");

    private final String index;

    Icons(String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return index;
    }
}
