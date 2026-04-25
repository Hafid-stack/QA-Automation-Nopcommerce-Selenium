package utilitypages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LeftSideBarPage extends BasePage {
//.brands-name li a
//.brands-name ul li a
    private By listOfbrands=By.cssSelector(".brands-name ul li a");
    //---------------------------------
    private By leftSideBarCategoriesAndBramdsHeaderText = By.cssSelector(".left-sidebar h2");
    //Categories
    private By womenCategoryBtn= By.cssSelector("[id='accordian'] [href='#Women']");
    //Women sub categories
    private By womenDressCategory=By.cssSelector("[id='accordian'] [href='/category_products/1']");
    private By womenTopsCategory=By.cssSelector("[id='accordian'] [href='/category_products/2']");
    private By womenSareeCategory=By.cssSelector("[id='accordian'] [href='/category_products/7']");
    //Men category
    private By menCategoryBtn=By.cssSelector("[id='accordian'] [href='#Men']");
    //Men sub categories
    private By menTshirtsCategory=By.cssSelector("[id='accordian'] [href='/category_products/3']");
    private By menJeansCategory=By.cssSelector("[id='accordian'] [href='/category_products/6']");
    //Kids category
    private By kidsCategoryBtn=By.cssSelector("[id='accordian'] [href='#Kids']");
    //Kids sub categories
    private By kidsDressCategory=By.cssSelector("[id='accordian'] [href='/category_products/4']");
    private By kidsTopsAndTshirtsCategory=By.cssSelector("[id='accordian'] [href='/category_products/5']");

    public LeftSideBarPage(WebDriver driver) {
        super(driver);
    }

    //----------Categories------------------

    public void clickWomenCategoryBtn(){
        clickImproved(womenCategoryBtn);
    }
    public void clickWomenDressCategoryBtn(){
        clickImproved(womenDressCategory);
    }
    public void clickWomenTopsCategoryBtn(){
        clickImproved(womenTopsCategory);
    }
    public void clickWomenSareeCategoryBtn(){
        clickImproved(womenSareeCategory);
    }
    public void clickMenCategoryBtn(){
        clickImproved(menCategoryBtn);
    }
    public void clickMenTshirtsCategoryBtn(){
        clickImproved(menTshirtsCategory);
    }
    public void clickMenJeansCategoryBtn(){
        clickImproved(menJeansCategory);
    }
    public void clickKidsCategoryBtn(){
        clickImproved(kidsCategoryBtn);
    }
    public void clickKidsDressCategoryBtn(){
        clickImproved(kidsDressCategory);
    }
    public void clickKidsTopsAndTshirtsCategoryBtn(){
        clickImproved(kidsTopsAndTshirtsCategory);
    }


    public String getLeftSideBarCategoriesHeaderText(){
        List<WebElement> headerText=waitForVisibilityOfElements(leftSideBarCategoriesAndBramdsHeaderText);

        return headerText.get(0).getText();

    }

    public String getLeftSideBarBrandsHeaderText(){

        List<WebElement> headerText=waitForVisibilityOfElements(leftSideBarCategoriesAndBramdsHeaderText);

        return headerText.get(1).getText();
    }
    //-----------Brands-----------

public String clickRandomBrand() {

    List<WebElement> brands=waitForVisibilityOfElements(listOfbrands);
    int index = rand.nextInt(brands.size());

    WebElement selectedBrand = brands.get(index);

    String fullText = selectedBrand.getText().trim();

    String brandName =
            fullText.replaceAll("^\\(\\d+\\)\\s*", "");
    scrollToElement(brands.get(index));
    //selectedBrand.click();
    wait.until(ExpectedConditions.elementToBeClickable(selectedBrand)).click();

    return brandName;
}


}
