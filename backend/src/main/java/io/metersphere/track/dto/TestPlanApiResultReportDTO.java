package io.metersphere.track.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TestPlanApiResultReportDTO implements Serializable {
    private List<TestCaseReportStatusResultDTO> apiCaseData;
    private List<TestCaseReportStatusResultDTO> apiScenarioData;
    private List<TestCaseReportStatusResultDTO> apiScenarioStepData;
}

