package com.dooan.fileservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dooan.model.ThietBi;
import com.dooan.repository.ThietBiRepository;
import com.dooan.utils.ExcelUtils;


@Service
public class FileService {
	@Autowired
	ThietBiRepository thietBiRepository;
	
	// Store File Data to Database
//	public void store(MultipartFile file){
//		try {
//			List<ThietBi> lstOfThietBi = ExcelUtils.parseExcelFile(file.getInputStream());
//    		// Save TB to DataBase
//			thietBiRepository.saveAll(lstOfThietBi);
//        } catch (IOException e) {
//        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
//        }
//	}
//	
//	//doc tieu de
//	public void docTieuDe(MultipartFile file){
//		try {
//			List<ThietBi> lstOfThietBi = ExcelUtils.parseExcelFile(file.getInputStream()); // k thay no goi?
//			
//        } catch (IOException e) {
//        	throw new RuntimeException("FAIL! -> message = " + e.getMessage());
//        }
//	}
	
	
	//
	
	// Load Data to Excel File
    public ByteArrayInputStream loadFile() {
    	List<ThietBi> listOfThietBi = (List<ThietBi>) thietBiRepository.findAll();
    	
    	try {
    		ByteArrayInputStream in = ExcelUtils.thietbiToExcel(listOfThietBi);
    		return in;
		} catch (IOException e) {}
    	
        return null;
    }
}
