package it.zzp.mall.security.config;

import it.zzp.mall.common.config.BaseRedisConfig;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Redis相关配置
 * .
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
