package com.hit.curricelumdesign.manager.admin;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.*;
import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.admin.ImportParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.javassist.util.proxy.ProxyObjectInputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xbr
 * @Date 2019-12-07
 * @ClassName AdminManager
 * @Description
 */
@Component
public class AdminManager {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AcademyMapper academyMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private EnrollmentYearMapper enrollmentYearMapper;
    @Autowired
    private ClassMapper classMapper;


    public Admin getAminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        if (null == admin) {
            throw new BaseException(Error.ADMIN_IS_NOT_EXIST);
        }
        return admin;
    }


    public List<Admin> getAdminList() {
        return adminMapper.getAdminList();
    }

    public Result importTeacherData (ImportParam param,String md5Pre,String teacherPasswordDefault){
        MultipartFile file = param.getFile();
        String fileName = file.getOriginalFilename();
        //获取文件名
        if (!fileName.equals("教师模板.xls")){
            throw new BaseException(Error.TEACHER_TEMPLATE_NAME_ERROR);
        }
        List<Teacher> errorList = new ArrayList<>();
        try {
            //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            InputStream inputStream = file.getInputStream();
            XSSFWorkbook workbook=null;
            workbook=new XSSFWorkbook(inputStream);
            // 有多少个sheet
            int sheets = workbook.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
                //HSSFSheet sheet = workbook.getSheetAt(i);
                XSSFSheet sheet = workbook.getSheetAt(i);
                // 获取多少行
                int rows = sheet.getPhysicalNumberOfRows();
                // 遍历每一行，注意：第 0 行为标题
                for (int j = 1; j < rows; j++) {
                    Teacher teacher = new Teacher();
                    // 获得第 j 行
                    //HSSFRow row = sheet.getRow(j);
                    XSSFRow row = sheet.getRow(j);
                    //获取教师编号
                    String number = row.getCell(0).toString();
                    //获取教师姓名
                    String name = row.getCell(1).toString();
                    //获取教师学院
                    String academy= row.getCell(2).toString();
                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name) ||  StringUtils.isBlank(academy)){
                        throw new BaseException(Error.TEACHER_TEMPLATE_HAS_EMPTY_CELL);
                    }

                    teacher.setNumber(number);
                    teacher.setName(name);

                    Teacher teacherByNumber = teacherMapper.getTeacherByNumber(number);
                    if (null != teacherByNumber){
                        errorList.add(teacher);
                        continue;
                    }
                    //入学年份判断,学院，班级
                    Academy academyByName = academyMapper.getAcademyByName(academy);
                    if ( null == academyByName ){
                        errorList.add(teacher);
                        continue;
                    }
                    teacher.setAcademyId(academyByName.getId());
                    teacher.setCreatetime(new Date());
                    teacher.setCreatorId(param.getLoginAdminId());
                    //teacher.setCreatorId(1);
                    teacher.setUpdaterId(0);
                    teacher.setUpdatetime(new Date());
                    teacher.setIsDelete(Constants.Common.IS_NOT);
                    teacher.setPassword(DigestUtils.md5Hex(md5Pre + teacherPasswordDefault));
                    teacherMapper.insert(teacher);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(errorList);
    }

    public Result importStudentData(ImportParam param){
        MultipartFile file = param.getFile();
        String fileName = file.getOriginalFilename(); //获取文件名
        if (!fileName.equals("学生模板.xls")){
            throw new BaseException(Error.STUDENT_TEMPLATE_NAME_ERROR);
        }
        List<Student> errorList = new ArrayList<>();
        try {
            InputStream inputStream = file.getInputStream();
            XSSFWorkbook workbook=null;
            //int sheetsNumber=book.getNumberOfSheets();

            //XSSFWorkbook workbook = new XSSFWorkbook(request.getInputStream());
            //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            // 有多少个sheet
            workbook=new XSSFWorkbook(inputStream);
            int sheets = workbook.getNumberOfSheets();
            for (int i = 0; i < sheets; i++) {
               // HSSFSheet sheet = workbook.getSheetAt(i);
              XSSFSheet sheet = workbook.getSheetAt(i);
                // 获取多少行
                //Sheet sheet = workbook.getSheetAt(0);
                int rows = sheet.getPhysicalNumberOfRows();
                // 遍历每一行，注意：第 0 行为标题
                for (int j = 1; j < rows; j++) {
                    Student student = new Student();
                    // 获得第 j 行
                    //Row row =  sheet.getRow(j);
                   // HSSFRow row = sheet.getRow(j);
                    XSSFRow row = sheet.getRow(j);
                    //获取学号
                    String number = row.getCell(0).toString();
                    //获取学生姓名
                    String name = row.getCell(1).toString();
                    //获取学生入学年份
                    String enrollmentYear = row.getCell(2).toString().substring(0,row.getCell(2).toString().lastIndexOf("."));
                    //获取学生学院
                    String  academy= row.getCell(3).toString();
                    //获取学生班级
                    String clazz = row.getCell(4).toString();
                    if (StringUtils.isBlank(number) || StringUtils.isBlank(name) || StringUtils.isBlank(enrollmentYear) || StringUtils.isBlank(academy) || StringUtils.isBlank(clazz)){
                        throw new BaseException(Error.STUDENT_TEMPLATE_HAS_EMPTY_CELL);
                    }
                    Student sameNumberStudent = studentMapper.selectByNumber(number);

                    student.setNumber(number);
                    student.setName(name);

                    if (null != sameNumberStudent){
                        errorList.add(student);
                        continue;
                    }
                    //入学年份判断,学院，班级
                    EnrollmentYear enrollmentYearByEnrollmentYear = enrollmentYearMapper.getEnrollmentYearByEnrollmentYear(Integer.parseInt(enrollmentYear));
                    Academy academyByName = academyMapper.getAcademyByName(academy);
                    Class classByName = classMapper.getClassByName(clazz);
                    if (null == enrollmentYear || null == academyByName || null == classByName){
                        errorList.add(student);
                        continue;
                    }
                    student.setEnrollmentId(enrollmentYearByEnrollmentYear.getId());
                    student.setAcademyId(academyByName.getId());
                    student.setClassId(classByName.getId());
                    student.setCreatetime(new Date());
                    student.setCreatorId(param.getLoginAdminId());
                    //student.setCreatorId(1);
                    student.setUpdaterId(0);
                    student.setUpdatetime(new Date());
                    student.setIsDelete((byte) 0);

                    studentMapper.insert(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(errorList);
    }
}
