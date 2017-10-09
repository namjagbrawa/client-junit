package com.bingo.client.example.landlord;

import com.bingo.client.example.test.SuperTest;
import com.bingo.server.game.provider.landlord.LandlordProvider;
import com.bingo.server.msg.*;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhangGe on 2017/8/10.
 */
public class LandLordTest extends SuperTest {

    @Autowired
    private LandlordProvider landlordProvider;

    // 892347836832677888L  892601208240340992L    892601238925869056L
    // 建桌
    @Test
    public void MatchCreateGameRequestTest() throws InvalidProtocolBufferException {
        Entity.GameConfig.Builder gameConfig = Entity.GameConfig.newBuilder().setDi(3).setMoguai(false).setMingpai(false).setRound(12);
        Match.MatchCreateGameRequest.Builder createGame = Match.MatchCreateGameRequest.newBuilder().setGameConfig(gameConfig);
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setMatchCreateGameRequest(createGame);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892601238925869056L, 123456);
        System.err.println(ServerMessage.SC.parseFrom(process));
    }

    // 加入游戏
    @Test
    public void MatchJoinGameRequestTest() throws InvalidProtocolBufferException {
        Match.MatchJoinGameRequest.Builder join = Match.MatchJoinGameRequest.newBuilder().setLockString("111111");
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setMatchJoinGameRequest(join);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892347836832677888L, 123456789);
        byte[] process1 = landlordProvider.process(cs.build().toByteArray(), 892601208240340992L, 123456789);
        Match.MatchJoinGameRequest matchJoinGameRequest = Match.MatchJoinGameRequest.parseFrom(process);
        System.err.println(matchJoinGameRequest);
    }

    @Test
    public void MatchAIRequestTest() {

    }

    @Test
    public void MoneyExchangeRequestTest() {

    }

    @Test
    public void FightReadyRequestTest() throws InvalidProtocolBufferException {
        Fight.FightReadyRequest.Builder fightReady = Fight.FightReadyRequest.newBuilder();
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setFightReadyRequest(fightReady);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892601238925869056L, 123456789);
        byte[] process2 = landlordProvider.process(cs.build().toByteArray(), 892601208240340992L, 123456789);
        byte[] process3 = landlordProvider.process(cs.build().toByteArray(), 892347836832677888L, 123456789);
    }

    @Test
    public void FightMingPaiRequestTest() {

    }

    @Test
    public void FightSendCardRequestTest() {
        Fight.FightSendCardRequest.Builder fightSendCard = Fight.FightSendCardRequest.newBuilder().addPai(29);
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setFightSendCardRequest(fightSendCard);
        landlordProvider.process(cs.build().toByteArray(), 892347836832677888L, 12345678);
    }

    @Test
    public void FightGetlastRoundRequestTest() throws InvalidProtocolBufferException {
        Fight.FightGetlastRoundRequest fightGetlastRoundRequest = Fight.FightGetlastRoundRequest.newBuilder().build();
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setFightGetlastRoundRequest(fightGetlastRoundRequest);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892347836832677888L, 12345678);
        System.err.println(ServerMessage.SC.parseFrom(process));
    }

    @Test
    public void FightExitGameRequestTest() throws InvalidProtocolBufferException {
        Fight.FightExitGameRequest.Builder fightExitGame = Fight.FightExitGameRequest.newBuilder();
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setFightExitGameRequest(fightExitGame);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892347836832677888L, 123456);
        System.err.println(ServerMessage.SC.parseFrom(process));
    }

    @Test
    public void FightCallLandLordRequestTest() {
        Fight.FightCallLandLordRequest fightCallLandLordRequest = Fight.FightCallLandLordRequest.newBuilder().setFen(3).build();
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setFightCallLandLordRequest(fightCallLandLordRequest);
        landlordProvider.process(cs.build().toByteArray(), 892601238925869056L, 12345678);
    }

    @Test
    public void test() throws InvalidProtocolBufferException {
        ServerMessage.SC scFightReady = ServerMessage.SC
                .newBuilder()
                .setSCFightReady(
                        Fight.SCFightReady.newBuilder().setSeated(0))
                .build();
        byte[] bytes = scFightReady.toByteArray();
        ServerMessage.SC sc = ServerMessage.SC.parseFrom(bytes);
        System.err.println(sc.getSCFightReady().getSeated());
    }

    @Test
    public void MatchRoleRequestTest() throws InvalidProtocolBufferException {
        Match.MatchRoleRequest matchRole = Match.MatchRoleRequest.newBuilder().build();
        ClientMessage.CS.Builder cs = ClientMessage.CS.newBuilder().setMatchRoleRequest(matchRole);
        byte[] process = landlordProvider.process(cs.build().toByteArray(), 892601238925869056L, 12345678);
        Match.MatchRoleRequest.parseFrom(process);
    }

    @Test
    public void FightRecommandRequestTest() throws InvalidProtocolBufferException {
        Fight.FightRecommandRequest fightRecommandRequest = Fight.FightRecommandRequest.newBuilder().build();
        ClientMessage.CS.Builder sc = ClientMessage.CS.newBuilder().setFightRecommandRequest(fightRecommandRequest);
        byte[] process = landlordProvider.process(sc.build().toByteArray(), 892601238925869056L, 12345678);
        System.err.println(ServerMessage.SC.parseFrom(process));
    }


}
