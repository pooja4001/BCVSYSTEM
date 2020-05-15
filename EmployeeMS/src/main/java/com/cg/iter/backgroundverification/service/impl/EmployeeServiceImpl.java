package com.cg.iter.backgroundverification.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cg.iter.backgroundverification.dto.EmployeeDocumentDto;
import com.cg.iter.backgroundverification.dto.VerficationDto;
import com.cg.iter.backgroundverification.repository.EmployeeDocumentRepository;
import com.cg.iter.backgroundverification.repository.VerificationDtoRepository;
import com.cg.iter.backgroundverification.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDocumentRepository employeeDocumentRepo;
	
	@Autowired
	VerificationDtoRepository verificationDtoRepo;

	@Override
	public void storeDocument(List<MultipartFile> files, String jsonDocTypeId, HttpServletRequest request)
			throws ParseException, IOException {

		HttpSession session = request.getSession();
		int empId = 0, counter = 0, requestId = 0;
		if (session.getAttribute("empId") != null) {
			empId = Integer.parseInt(session.getAttribute("empId").toString());
			System.out.println("Session is valid: and Id is:" + empId);
		} else {
			System.err.println("Session is Invalid ");
		}
		// retrive requestId
		VerficationDto verificationDto = new VerficationDto();
		verificationDto.setStatus("Pending");
		VerficationDto ReturnRequestId = verificationDtoRepo.save(verificationDto);
		if (ReturnRequestId != null) {
			System.out.println("request id is :" + ReturnRequestId.getVerId());
			requestId = ReturnRequestId.getVerId();
		} else {
			System.err.println("Failed to Save");
		}

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(jsonDocTypeId);
		String getJsonDocTypeId = obj.get("id").toString();
		String jsonDocTypeIdReplace = getJsonDocTypeId.replace("[", "").replace("]", "");
		System.err.println("data is" + jsonDocTypeIdReplace);
		String docTypeId[] = jsonDocTypeIdReplace.split(",");
		for (MultipartFile file : files) {
			System.out.println("Multipart data:" + (counter + 1));
			EmployeeDocumentDto empdto = new EmployeeDocumentDto();
			empdto.setEmpId(empId);
			empdto.setRequestId(requestId);
			if (file.isEmpty()) {
				continue;
			}
			byte[] bytes = file.getBytes();
			empdto.setDocData(bytes);
			empdto.setDocType(Integer.parseInt(docTypeId[counter]));
			// path = Paths.get("C://Test//" + file.getOriginalFilename());
			// Files.write(path, bytes);

			System.err.println("Employee details:  :: empId: " + empdto.getEmpId() + " :: doctypeId "
					+ empdto.getDocType() + ":: employee document " + empdto.getDocData());
			employeeDocumentRepo.save(empdto);
			counter++;
		}

	}

	@Override
	public  List<EmployeeDocumentDto> viewStatus(int empId) {

		return employeeDocumentRepo.findByEmpId(empId);
	}

}
