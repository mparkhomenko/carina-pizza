/*
 * Copyright 2013-2019 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import java.util.List;

import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebSampleTest extends AbstractTest {
    @Test
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    @TestTag(name = "area test", value = "web")
    public void testOrder() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        List<ExtendedWebElement> pizza6 = homePage.findExtendedWebElements(By.className("goods__list__li"));

        pizza6.get(6).findExtendedWebElement(By.className("in-cart")).click();

        homePage.findExtendedWebElement(By.id("s2id_street-name")).click();

        homePage.findExtendedWebElements(By.id("s2id_autogen1_search")).get(0).type("Могилевская");
        homePage.findExtendedWebElement(By.className("select2-result-label")).click();

        homePage.findExtendedWebElement(By.id("s2id_home-number")).click();

        homePage.findExtendedWebElement(By.id("s2id_autogen2_search")).type("39/А");
        homePage.findExtendedWebElement(By.className("select2-result-label")).click();

        homePage.findExtendedWebElement(By.id("byaddress")).click();

        // 2 pizza

        List<ExtendedWebElement> pizza4 = homePage.findExtendedWebElements(By.className("goods__list__li"));

        pizza4.get(4).findExtendedWebElement(By.className("in-cart")).click();

        // sauces

        List<ExtendedWebElement> sauces = homePage.findExtendedWebElements(By.className("sauces"));

        sauces.get(0).findExtendedWebElement(By.className("minus-item")).click();

        sauces.get(2).findExtendedWebElement(By.className("in-cart")).click();

        sauces.get(4).findExtendedWebElement(By.className("minus-item")).click();

        sauces.get(5).findExtendedWebElement(By.className("in-cart")).click();

        // drinks

        List<ExtendedWebElement> drinks = homePage.findExtendedWebElements(By.className("drinks"));

        drinks.get(0).findExtendedWebElement(By.className("in-cart")).click();
        homePage.findExtendedWebElement(By.className("pzz-cart__goto")).click();

        // basket

        List<ExtendedWebElement> basketForms = homePage.findExtendedWebElements(By.className("ips"));

        basketForms.get(0).findExtendedWebElement(By.className("i-p")).type("Максим");
        basketForms.get(1).findExtendedWebElement(By.name("phoneNumber")).type("447882913");
        basketForms.get(2).findExtendedWebElement(By.name("flat")).type("30");
        basketForms.get(2).findExtendedWebElement(By.name("entrance")).type("1");
        basketForms.get(2).findExtendedWebElement(By.name("floor")).type("6");
        basketForms.get(2).findExtendedWebElement(By.name("intercom")).type("30");

        homePage.findExtendedWebElement(By.className("payment-charge-button")).click();

//        homePage.findElements(By.className("save-order")).get(0).click();
    }
}
