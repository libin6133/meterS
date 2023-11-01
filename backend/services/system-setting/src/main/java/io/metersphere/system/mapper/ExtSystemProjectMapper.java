package io.metersphere.system.mapper;

import io.metersphere.system.dto.user.UserExtendDTO;
import io.metersphere.system.dto.OrganizationProjectOptionsDTO;
import io.metersphere.system.dto.ProjectDTO;
import io.metersphere.system.dto.ProjectResourcePoolDTO;
import io.metersphere.system.dto.request.ProjectMemberRequest;
import io.metersphere.system.dto.request.ProjectRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtSystemProjectMapper {

    List<UserExtendDTO> getProjectMemberList(@Param("request") ProjectMemberRequest request);

    List<ProjectDTO> getProjectList(@Param("request") ProjectRequest request);

    List<UserExtendDTO> getProjectAdminList(@Param("projectIds") List<String> projectIds);

    List<OrganizationProjectOptionsDTO> selectProjectOptions(@Param("organizationId") String organizationId);

    List<UserExtendDTO> getUserAdminList(@Param("organizationId") String organizationId, @Param("keyword") String keyword);

    List<UserExtendDTO> getUserMemberList(@Param("userIds") List<String> userIds, @Param("projectId") String projectId, @Param("keyword") String keyword);

    List<ProjectDTO> getProjectExtendDTOList(@Param("projectIds") List<String> projectIds);

    List<ProjectResourcePoolDTO> getProjectResourcePoolDTOList(@Param("projectIds") List<String> projectIds);
}
