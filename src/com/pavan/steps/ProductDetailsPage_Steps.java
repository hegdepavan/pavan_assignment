package com.pavan.steps;

import org.hamcrest.Matchers;

import com.pavan.pages.Base_Template;
import com.pavan.pages.ProductDetailsPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import static com.qmetry.qaf.automation.util.Validator.*;

public class ProductDetailsPage_Steps extends ProductDetailsPage {

	@QAFTestStep(description = "verify product details page is displayed")
	public void verifyProductDetailsPageIsDisplayed() {

		Base_Template.waitForSeconds(5);
		getAddToBasketBtn().verifyPresent("Add to Basket");
		verifyThat(getProductName().getText(),
				Matchers.containsString(ConfigurationManager.getBundle().getString("selected.product.name")));
	}

	@QAFTestStep(description = "user add {0} quantity to cart")
	public void userAddQuantityToCart(String qty) {
		enterQty(qty);
		clickAddToBasketBtn();
		ConfigurationManager.getBundle().setProperty("selected.qty", qty);
	}
}
