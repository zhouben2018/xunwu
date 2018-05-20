package com.zben.web.controller.admin;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.zben.base.ApiResponse;
import com.zben.dto.HouseDTO;
import com.zben.dto.QiNiuPutRet;
import com.zben.dto.SupportAddressDTO;
import com.zben.entity.SupportAddress;
import com.zben.form.HouseForm;
import com.zben.service.ServiceResult;
import com.zben.service.house.IAddressService;
import com.zben.service.house.IHouseService;
import com.zben.service.house.IQiNiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @Author:zben
 * @Date: 2018/4/22/022 9:02
 */
@Controller
public class AdminController {

    private static String FILE_LOCATION = "D:\\mySoft\\idea-workspace\\test\\xunwu\\tmp";

    @Autowired
    private IQiNiuService qiNiuService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private Gson gson;

    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    @GetMapping("/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin/login";
    }

    @GetMapping("/admin/add/house")
    public String houseAdd() {
        return "admin/house-add";
    }

    /**
     * 房源列表页
     * @return
     */
    @GetMapping("/admin/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }

    @PostMapping(value = "admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ApiResponse uploadPhoto(@RequestParam("file")MultipartFile file) {
        if (file.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }
        String fileName = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream);
            if (response.isOK()) {
                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
                return ApiResponse.success(ret);
            } else {
                return ApiResponse.message(response.statusCode, response.getInfo());
            }
        } catch (QiniuException e) {
            Response response = e.response;
            try {
                return ApiResponse.message(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
            }
        } catch (IOException e) {
            return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/add/house")
    @ResponseBody
    public ApiResponse addHouse(@Valid @ModelAttribute("form-house-add") HouseForm houseForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ApiResponse(HttpStatus.BAD_REQUEST.value(),
                    bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
        }
        if (houseForm.getPhotos() == null || houseForm.getCover() == null) {
            return ApiResponse.message(HttpStatus.BAD_REQUEST.value(), "必须上传图片");
        }
        Map<SupportAddress.Level, SupportAddressDTO> addressMap =
                addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());
        if (addressMap.keySet().size() != 2) {
            return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
        }

        ServiceResult<HouseDTO> result = houseService.save(houseForm);
        if (result.isSuccess()) {
            return ApiResponse.success(result.getResult());
        }

        return ApiResponse.ofStatus(ApiResponse.Status.NOT_VALID_PARAM);
    }
}
