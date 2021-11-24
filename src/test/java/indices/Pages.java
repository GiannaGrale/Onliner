package indices;

import pages.*;

public enum Pages {

    APPLE("apple", ApplePage.class),
    ABOUT_COMPANY("about", AboutCompanyPage .class),
    CATALOGUE("catalogue", CataloguePage.class),
    DOMINO ("domino", DominoPage.class),
    MAIN("main", MainPage.class),
    PEPPERONI("pepperoni", PepperoniPage.class),
    REGISTRATION("registration", RegistrationPage.class),
    CART("cart", ShoppingCartPage.class),
    SMARTPHONE ("smartphone", SmartphonePage.class);


    private final Class myClass;
    private final String jsonType;

    Pages(String jsonType, Class myClass){
        this.myClass = myClass;
        this.jsonType = jsonType;
    }

    public static Pages get(String jsonType) {
        for (Pages ft : values())
            if (ft.getJsonType().equals(jsonType))
                return ft;
        return null;
    }

    public Class getMyClass() {
        return myClass;
    }

    public String getJsonType() {
        return jsonType;
    }
}
