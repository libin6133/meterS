package io.metersphere.system.controller;

import base.BaseTest;
import io.metersphere.sdk.constants.PermissionConstants;
import io.metersphere.sdk.log.vo.OperationLogRequest;
import io.metersphere.system.controller.param.OperationLogRequestDefinition;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperationLogControllerTests extends BaseTest {

    public static final String OPERATION_LOG_LIST = "/operating/log/list";

    public static final String OPTIONS_LIST = "/operating/log/get/options";


    public static final String USER_LIST = "/system/user/list";

    public static final String SYSTEM = "system";
    public static final String ORGANIZATION = "organization";


    /**
     * 系统级别 查询 用例
     * @throws Exception
     */
    @Test
    @Order(1)
    @Sql(scripts = {"/dml/init_operation_log_test.sql"},
            config = @SqlConfig(encoding = "utf-8", transactionMode = SqlConfig.TransactionMode.ISOLATED),
            executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testSystemOperationLogList() throws Exception {
        //系统级别  全部
        OperationLogRequest request = buildParam(SYSTEM);
        this.requestPostWithOkAndReturn(OPERATION_LOG_LIST, request);

        // @@异常参数校验
        updatedGroupParamValidateTest(OperationLogRequestDefinition.class, OPERATION_LOG_LIST);
        // @@校验权限
        requestPostPermissionTest(PermissionConstants.SYSTEM_OPERATING_LOG_READ, OPERATION_LOG_LIST, request);

    }


    /**
     * 组织级别 查询 用例
     * @throws Exception
     */
    @Test
    @Order(3)
    public void testOrganizationOperationLogList() throws Exception {
        OperationLogRequest request = buildParam(ORGANIZATION);
        //组织级别 全部
        this.requestPostWithOkAndReturn(OPERATION_LOG_LIST, request);

        //组织级别 指定组织查询
        request.setOrganizationIds(Arrays.asList("organization_id_001","organization_id_002"));
        this.requestPostWithOkAndReturn(OPERATION_LOG_LIST, request);

        // @@异常参数校验
        updatedGroupParamValidateTest(OperationLogRequestDefinition.class, OPERATION_LOG_LIST);
        // @@校验权限
        requestPostPermissionTest(PermissionConstants.SYSTEM_OPERATING_LOG_READ, OPERATION_LOG_LIST, request);
    }


    //TODO 项目级别 查询 用例

    @Test
    @Order(2)
    public void testGetOptions() throws Exception {
        this.requestGetWithOkAndReturn(OPTIONS_LIST);

        // @@校验权限
        requestGetPermissionTest(PermissionConstants.SYSTEM_OPERATING_LOG_READ, OPTIONS_LIST);
    }

    @Test
    @Order(3)
    public void testUserList() throws Exception {
        this.requestGetWithOkAndReturn(USER_LIST);

        // @@校验权限
        requestGetPermissionTest(PermissionConstants.SYSTEM_OPERATING_LOG_READ, OPTIONS_LIST);
    }

    //TODO 异常用例补充


    private OperationLogRequest buildParam(String level) {
        OperationLogRequest request = new OperationLogRequest();
        request.setCurrent(1);
        request.setPageSize(10);
        request.setStartTime(1689131059000l);
        request.setEndTime(1689149059000l);
        request.setLevel(level);
        return request;
    }


}