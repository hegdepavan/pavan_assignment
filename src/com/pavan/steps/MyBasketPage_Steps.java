package com.pavan.steps;

import com.pavan.pages.MyBasketPage;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import static com.qmetry.qaf.automation.util.Validator.*;

import org.hamcrest.Matchers;

public class MyBasketPage_Steps extends MyBasketPage {

	@QAFTestStep(description = "user verify the added product in my basket")
	public void userVerifyTheAddedProductInMyBasket() {
		clickMyBasketIcon();
		String expectedQty = ConfigurationManager.getBundle().getString("selected.qty");
		String expectedProductName = ConfigurationManager.getBundle().getString("selected.product.name");
		verifyThat("QTY ", getProductQtyMBList().get(0).getText(), Matchers.equalTo(expectedQty));
		verifyThat("Product Name ", getProductNamesMBList().get(0).getText(),
				Matchers.containsString(expectedProductName));
	}

}
