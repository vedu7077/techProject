package com.leadtechprimelab.controller;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leadtechprimelab.dto.ProjectDTO;
import com.leadtechprimelab.entity.ProjectCatogory;
import com.leadtechprimelab.entity.ProjectDept;
import com.leadtechprimelab.entity.ProjectDivision;
import com.leadtechprimelab.entity.ProjectInfo;
import com.leadtechprimelab.entity.ProjectLocation;
import com.leadtechprimelab.entity.ProjectPriority;
import com.leadtechprimelab.entity.ProjectReason;
import com.leadtechprimelab.entity.ProjectStatus;
import com.leadtechprimelab.entity.ProjectType;
import com.leadtechprimelab.service.ProjectCatagoryService;
import com.leadtechprimelab.service.ProjectDeptService;
import com.leadtechprimelab.service.ProjectDivisionService;
import com.leadtechprimelab.service.ProjectInfoService;
import com.leadtechprimelab.service.ProjectLocationService;
import com.leadtechprimelab.service.ProjectPriorityService;
import com.leadtechprimelab.service.ProjectReasonService;
import com.leadtechprimelab.service.ProjectStatusService;
import com.leadtechprimelab.service.ProjectTypeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/projectcatogory")
public class Controller {

	@Autowired
	private ProjectCatagoryService Cservice;

	@Autowired
	private ProjectInfoService pservice;

	@Autowired
	private ProjectReasonService reasonService; 

	@Autowired
	private ProjectTypeService typeService;

	@Autowired
	private ProjectDivisionService divisionService;

	@Autowired
	private ProjectPriorityService priorityService;

	@Autowired
	private ProjectDeptService deptService;

	@Autowired
	private ProjectLocationService locationService;

	@Autowired
	private ProjectStatusService statusService;

	@PostMapping("/save")
	public ProjectInfo getProjectCatogory(@RequestBody ProjectDTO data) {

		ProjectInfo pinfo = new ProjectInfo();
		pinfo.setProname(data.getProjectName());
		pinfo.setProstartdate(data.getProjectStartDate());
		pinfo.setProenddate(data.getProjectEndDate());

		ProjectReason pres = new ProjectReason();
		pres.setPrname(data.getReasonName());
		pinfo.setProjectReason(pres);
		reasonService.saveProjectReason(pres);

		ProjectType ptype = new ProjectType();
		ptype.setPtname(data.getTypeName());
		pinfo.setProjectType(ptype);
		typeService.saveProjectType(ptype);

		ProjectDivision pdev = new ProjectDivision();
		pdev.setPdivname(data.getDivisionName());
		pinfo.setProjectDivision(pdev);
		divisionService.saveProjectDivision(pdev);

		ProjectCatogory pc = new ProjectCatogory();
		pc.setPcname(data.getCategoryName());
		pinfo.setProjectCategory(pc);
		Cservice.saveProjectCategory(pc);

		ProjectPriority prio = new ProjectPriority();
		prio.setPpname(data.getPriorityName());
		pinfo.setProjectPriority(prio);
		priorityService.saveProjectPriority(prio);

		ProjectDept pd = new ProjectDept();
		pd.setPdname(data.getDeptName());
		pinfo.setProjectDept(pd);
		deptService.saveProjectDept(pd);

		ProjectLocation ploc = new ProjectLocation();
		ploc.setPlname(data.getLocationName());
		pinfo.setProjectLocation(ploc);

		ProjectStatus pstatus = new ProjectStatus();
		pstatus.setPsname(data.getStatusName());
		pinfo.setProjectStatus(pstatus);
		locationService.saveProjectLocation(ploc);
		statusService.saveProjectStatus(pstatus);

		return pservice.saveProjectInfo(pinfo);
	}

	@GetMapping("/getAllinfo")
	public List<ProjectInfo> getAllProjectInfos() {
		return pservice.getAllProjectInfos();
	}

	@PostMapping("/changeStatus")
	@Transactional
	public List<ProjectInfo> change_status(@RequestBody Map<String, String> data) {

		String status = data.get("psname");
		int projectId = Integer.parseInt(data.get("psid"));
		System.out.println(projectId);
		System.out.println(status);
		statusService.changeStatus(status, projectId);

		return pservice.getAllProjectInfos();
	}

	@GetMapping("/projectcount")
	public Map<String, String> getCount() {

		Map<String, String> countMap = new HashMap<String, String>();

		int totalProjects = statusService.getProjectCountByPsid();
		int totalRunningProject = statusService.getProjectCountByPsname("Running");
		int totalClosedProject = statusService.getProjectCountByPsname("Closed");
		int totalCancelledProject = statusService.getProjectCountByPsname("Cancelled");
		int totalRegisteredProject = statusService.getProjectCountByPsname("Registerd");

		countMap.put("TotalProjects", String.valueOf(totalProjects));
		countMap.put("TotalRunningProject", String.valueOf(totalRunningProject));
		countMap.put("TotalClosedProject", String.valueOf(totalClosedProject));
		countMap.put("TotalCancelledProject", String.valueOf(totalCancelledProject));
		countMap.put("TotalRegisteredProject", String.valueOf(totalRegisteredProject));

		return countMap;
	}

	@GetMapping("/summary")
	public ResponseEntity<List<Object>> getDepartmentProjectSummary() {

		return new ResponseEntity<>(pservice.getDepartmentProjectSummary(), HttpStatus.OK);
	}

}
