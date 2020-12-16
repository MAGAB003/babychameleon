package com.example.babychameleon;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubscriptionRepositoryTests {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSizeRangeArrayForAgeGroupBABY() {
        Subscription subscription = new Subscription("Name1", "Description1", "Img1", "Img2", "Img3", "Img4", "BABY", "Theme", 99);
        String[] expectedOutput = {"68", "74", "80", "86", "92", "98", "104"};
        Assert.assertArrayEquals(expectedOutput, subscription.getSizeRange("BABY"));
    }

    @Test
    public void testSizeRangeArrayForAgeGroupKIDS() {
        Subscription subscription = new Subscription("Name1", "Description1", "Img1", "Img2", "Img3", "Img4", "KIDS", "Theme", 99);
        String[] expectedOutput = {"92", "98/104", "110/116", "122/138", "134/140"};
        Assert.assertArrayEquals(expectedOutput, subscription.getSizeRange("KIDS"));
    }


}
