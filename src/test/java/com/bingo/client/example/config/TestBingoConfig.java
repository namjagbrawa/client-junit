package com.bingo.client.example.config;

import com.bingo.framework.config.ApplicationConfig;
import com.bingo.framework.config.ProtocolConfig;
import com.bingo.framework.config.RegistryConfig;
import com.bingo.server.game.provider.*;
import com.bingo.server.game.provider.landlord.LandlordProvider;
import com.bingo.server.hall.provider.BagProvider;
import com.bingo.server.user.provider.*;
import com.bingo.server.utils.BingoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBingoConfig {

    private static final Logger logger = LoggerFactory.getLogger(TestBingoConfig.class);

    private String applicationName = "client";

    private String zookeeper = "192.168.223.25:2181";

    private int port = 10000;

    @Bean
    public ApplicationConfig getApplicationConfig() {
        return BingoConfig.getApplication(applicationName);
    }

    @Bean
    public RegistryConfig getRegistryConfig() {
        return BingoConfig.getRegistry(zookeeper);
    }

    // User
    @Bean
    public CuBagProvider getCuBagProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuBagProvider.class, application, registry);
    }
    @Bean
    public CuFriendProvider getCuFriendProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuFriendProvider.class, application, registry);
    }
    @Bean
    public CuOnlineUserProvider getCuOnlineUserProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuOnlineUserProvider.class, application, registry);
    }
    @Bean
    public CuRoomTypeProvider getCuRoomTypeProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuRoomTypeProvider.class, application, registry);
    }
    @Bean
    public CuUserProvider getCuUserProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuUserProvider.class, application, registry);
    }
    @Bean
    public CuWalletProvider getCuWalletProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(CuWalletProvider.class, application, registry);
    }
    @Bean
    public ItemProvider getItemProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(ItemProvider.class, application, registry);
    }

    // Game
    @Bean
    public DdzDeskProvider getDdzDeskProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(DdzDeskProvider.class, application, registry);
    }
    @Bean
    public DdzGameHistoryProvider getDdzGameHistoryProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(DdzGameHistoryProvider.class, application, registry);
    }
    @Bean
    public DdzRuleProvider getDdzRuleProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(DdzRuleProvider.class, application, registry);
    }
    @Bean
    public DdzUserProvider getDdzUserProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(DdzUserProvider.class, application, registry);
    }
    @Bean
    public GameConnectProvider getGameConnectProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(GameConnectProvider.class, application, registry);
    }
    @Bean
    public GameInfoProvider getGameInfoProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(GameInfoProvider.class, application, registry);
    }
    @Bean
    public ScoreProvider getScoreProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(ScoreProvider.class, application, registry);
    }
    @Bean
    public StartGameProvider getStartGameProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(StartGameProvider.class, application, registry);
    }

    // Landlord
    @Bean
    public LandlordProvider getLandlordProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(LandlordProvider.class, application, registry);
    }

    // Hall
    @Bean
    public BagProvider getBagProvider(ApplicationConfig application, RegistryConfig registry) {
        return BingoConfig.reference(BagProvider.class, application, registry);
    }

}
