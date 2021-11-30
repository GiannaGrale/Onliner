package indices;


public enum Pages {
    APPLE("pages.ApplePage"),
    ABOUT_COMPANY("pages.AboutCompanyPage"),
    CATALOGUE("pages.CataloguePage"),
    DOMINO ("pages.DominoPage"),
    MAIN("pages.MainPage"),
    PEPPERONI("pages.PepperoniPage"),
    REGISTRATION("page.RegistrationPage"),
    CART("pages.ShoppingCartPage"),
    SMARTPHONE ("pages.SmartphonePage");

    private final String pageName;

    Pages(String pageName){
        this.pageName = pageName;
    }

    public String getName() {
        return pageName;
    }
}
