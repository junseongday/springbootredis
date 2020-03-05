package com.js.springbootredis;

import com.js.springbootredis.account.Account;
import com.js.springbootredis.account.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class RedisRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(RedisRunner.class);

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name", "junseong");
        opsForValue.set("age","36");
        opsForValue.set("job", "programmer");

        Account account = new Account();
        account.setEmail("junseongday@gmail.com");
        account.setUserName("junseong");

        accountRepository.save(account);
        Optional<Account> byId = accountRepository.findById(account.getId());

        logger.info(byId.get().getUserName());
        logger.info(byId.get().getEmail());

    }
}
