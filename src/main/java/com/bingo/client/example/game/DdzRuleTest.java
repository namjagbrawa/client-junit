package com.bingo.client.example.game;

import com.bingo.client.example.test.SuperTest;
import com.bingo.server.database.model.DdzOption;
import com.bingo.server.database.model.DdzSubject;
import com.bingo.server.database.model.DdzType;
import com.bingo.server.game.provider.DdzRuleProvider;
import com.bingo.server.game.provider.bean.DdzRule;
import com.bingo.server.game.provider.bean.enums.Operation;
import com.bingo.server.game.provider.bean.enums.Relation;
import com.bingo.server.game.provider.bean.enums.Type;
import com.bingo.server.msg.BASE;
import com.bingo.server.msg.RESP;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGe on 2017/8/2.
 */
public class DdzRuleTest extends SuperTest {

    @Autowired
    DdzRuleProvider ddzRuleProvider;

    // 获取规则
    @Test
    public void testGetDdzRule() {
        List<Map> ddzRule = ddzRuleProvider.getDdzRule();
        System.err.println(ddzRule);
    }

    @Test
    public void testGetDdzGetRuleResponse() {
        byte[] bytes = ddzRuleProvider.getDdzGetRuleResponse();
        try {
            RESP.DdzGetRuleResponse ddzGetRuleResponse = RESP.DdzGetRuleResponse.parseFrom(bytes);
            System.err.println(ddzGetRuleResponse);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testParseRule() {
        DdzRule ddzRule = ddzRuleProvider.parseRule(new ArrayList<String>() {{
            add("1v1");
            add("6v2");
            add("20v3");
            add("135");
            add("132"); // 如果没有包括,则不报错,结果不包含
        }});
        System.err.println(ddzRule);
    }

    @Test
    public void testAddType() {
        ddzRuleProvider.addType(Type.classic, "经典玩法", "经典玩法tip", 3, new ArrayList<String>() {{
            add("number");
            add("roomCard");
            add("except");
        }});
    }

    @Test
    public void testAddSubject() {
        ddzRuleProvider.addSubject("number", "牌局数", "牌局数tip", new ArrayList<String>() {{
            add("1v1");
            add("6v2");
            add("20v3");
        }}, Relation.and);
        ddzRuleProvider.addSubject("except", "排除数", "排除tip", new ArrayList<String>() {{
            add("135");
            add("123456");
        }}, Relation.or);
        ddzRuleProvider.addSubject("roomCard", "房卡数", "房卡数tip", new ArrayList<String>() {{
            add("1");
        }}, Relation.or);
    }

    @Test
    public void testAddOption() {
        ddzRuleProvider.addOption("1v1", "1盘消耗1张", "1盘消耗1张tip", "1", "1", null, Operation.playNumber);
        ddzRuleProvider.addOption("6v2", "6盘消耗2张", "6盘消耗2张tip", "6", "2", null, Operation.playNumber);
        ddzRuleProvider.addOption("20v3", "20盘消耗3张", "20盘消耗3张tip", "20", "3", null, Operation.playNumber);
        ddzRuleProvider.addOption("135", "去除1,3,5", "去除1,3,5tip", "1,3,5", null, null, Operation.except);
        ddzRuleProvider.addOption("123456", "去除1,2,3,4,5,6", "去除1,2,3,4,5,6tip", "1,2,3,4,5,6", null, null, Operation.except);
        ddzRuleProvider.addOption("1", "房卡选项测试1", "房卡选项测试1tip", "1", null, null, Operation.playNumber);
    }

    @Test
    public void testDelDdzType() {
        ddzRuleProvider.delDdzType(892666110048993280L);
    }

    @Test
    public void testDelSubject() {
        ddzRuleProvider.delSubject(892672092099575808L);
    }

    @Test
    public void testDelOption() {
        ddzRuleProvider.delOption(892671993726369792L);
    }

    @Test
    public void testUpdateType() {
        DdzType ddzType = new DdzType();
        ddzType.setId(892675233629077504L);
        ddzRuleProvider.updateType(ddzType);
    }

    @Test
    public void testUpdateSubject() {
        DdzSubject ddzSubject = new DdzSubject();
        ddzSubject.setId(892675249877811200L);
        ddzRuleProvider.updateSubject(ddzSubject);
    }

    @Test
    public void testUpdateOption() {
        DdzOption ddzOption = new DdzOption();
        ddzOption.setId(892685381122654208L);
        ddzRuleProvider.updateOption(ddzOption);
    }
}
