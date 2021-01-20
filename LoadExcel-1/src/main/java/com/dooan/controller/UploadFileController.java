package com.dooan.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dooan.fileservice.FileService;
import com.dooan.model.ThietBi;
import com.dooan.repository.ThietBiRepository;
import com.dooan.utils.ExcelUtils;


@Controller
public class UploadFileController {
	
	@Autowired
	FileService fileServices;
	ExcelUtils excelUtils;
	
    @GetMapping("/admin/upload")
    public String index() {
        return "multipartfile/uploadform";
    }
    
    @PostMapping("/admin/upload")
    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file, Model model) throws IllegalStateException, IOException {
    	//String UPLOADED_FOLDER = "E:\\ky1_nam5\\do_an_tot_nghiep\\save\\";
		try {
			
			//fileServices.store(file);
		    model.addAttribute("file", file);
			model.addAttribute("message", "File uploaded successfully!");
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Fail! -> uploaded filename: " + file.getOriginalFilename());
		}
//    	fileServices.docTieuDe(file);
//    	model.addAttribute("numColumn", ExcelUtils.laySoCot());
//		model.addAttribute("tenCot", ExcelUtils.layTenCot());
//		model.addAttribute("toaDo", ExcelUtils.checkSTT(multipartToInputStream(file, "noname")));
		//Workbook workbook = new XSSFWorkbook(multipartToInputStream(file, "noname"));
		
		model.addAttribute("tieuDe", excelUtils.tenTieuDe(multipartToInputStream(file, "noname")));

		///tao bang thiet bi
//		List<ThietBi> lstThietBi = new ArrayList<ThietBi>();
//		thietBiRepository.saveAll(lstThietBi);

        return "multipartfile/uploadform";
    }

	@Autowired
	ThietBiRepository thietBiRepository;
	
    @PostMapping("/admin/GiaoDien")
    public String getTitleByClient(@RequestParam Map<String, String> map) {
    	
    	List<ThietBi> lstOfThietBi = excelUtils.parseExcelFile(map);
		thietBiRepository.saveAll(lstOfThietBi);
    	return "multipartfile/GiaoDien";
    }
    

    
    
    public  static InputStream multipartToInputStream(MultipartFile multipart, String fileName) throws IllegalStateException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        InputStream stream = null;
        try {
			multipart.transferTo(convFile);
	        stream = new FileInputStream(convFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return stream;
    }
    

    
    
}
