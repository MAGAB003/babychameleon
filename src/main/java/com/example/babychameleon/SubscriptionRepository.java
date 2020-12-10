package com.example.babychameleon;

import org.springframework.data.repository.CrudRepository;



public interface SubscriptionRepository extends CrudRepository<Subscription, String> {

    Iterable<Subscription> findBySubscriptionName(String subscriptionName);

}
