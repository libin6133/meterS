package io.metersphere.track.dto;

import io.metersphere.base.domain.IssuesDao;
import io.metersphere.base.domain.TestCaseWithBLOBs;
import io.metersphere.dto.CustomFieldDao;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class TestPlanCaseDTO extends TestCaseWithBLOBs {
    private String executor;
    private String executorName;
    private String results;
    private String planId;
    private String planName;
    private String caseId;
    private String issues;
    private String reportId;
    private String model;
    private String projectName;
    private String actualResult;
    private String maintainerName;
    private Boolean isCustomNum;
    private int issuesCount;
    private String versionName;

    private List<TestCaseTestDTO> list;
    private List<IssuesDao> issueList;
    private List<CustomFieldDao> fields;
}
