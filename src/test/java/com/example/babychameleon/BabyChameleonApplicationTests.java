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
		Cart cart = new Cart();
		Subscription subscription = new Subscription("Name1", "Description1", "Img1", "Img2", "Img3", "Img4", "AgeGroup", "Theme", 299);
		cart.addToCart(new Child(subscription));
		Assert.assertEquals(299, cart.calculateSum());
	}

}
