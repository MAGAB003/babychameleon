package com.example.babychameleon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BabyChameleonApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test public void calculateSubscriptionSum(){
		SubscriptionCart cart = new SubscriptionCart();
		cart.addToCart(new Subscription("Name1", "Description1", "Img1", "Img2", "Img3", "Img4", "AgeGroup", "Theme", 299));
		cart.addToCart(new Subscription("Name2", "Description2", "Img1", "Img2", "Img3", "Img4", "AgeGroup", "Theme", 100));
		Assert.assertEquals(399, cart.calculateSum());
	}

}
