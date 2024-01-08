package org.quest94.demo.redisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

@Slf4j
class MainTest {


    private RedissonClient redissonClient;

    @Test
    void createOrder(String userId, String productId) {

        //  如果不加锁，必然超卖
        RLock lock = redissonClient.getLock("stock:" + productId);

        try {
            lock.lock();
            lock.lock(10, TimeUnit.SECONDS);
            lock.tryLock();
            lock.tryLock(10, TimeUnit.SECONDS);
            lock.tryLock(10, 10, TimeUnit.SECONDS);


        } catch (Exception ex) {
            log.error("下单失败", ex);
        } finally {
            lock.unlock();
        }

    }

}