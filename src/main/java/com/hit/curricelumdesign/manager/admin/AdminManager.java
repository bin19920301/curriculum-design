package com.hit.curricelumdesign.manager.admin;

import com.hit.curricelumdesign.context.constant.Constants;
import com.hit.curricelumdesign.context.entity.Class;
import com.hit.curricelumdesign.context.entity.*;
import com.hit.curricelumdesign.context.enums.Error;
import com.hit.curricelumdesign.context.exception.BaseException;
import com.hit.curricelumdesign.context.param.admin.ImportParam;
import com.hit.curricelumdesign.context.response.Result;
import com.hit.curricelumdesign.dao.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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

    private static final Logger logger = LoggerFactory.getLogger(AdminManager.class);

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

    @Value("${hit.curricelumdesign.teacher.password.default}")
    private String teacherPasswordDefault;

    @Value("${hit.curricelumdesign.password.md5.pre}")
    private String md5Pre;


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

    public Result importTeacherData(ImportParam param) {
        MultipartFile file = param.getFile();
        String fileName = file.getOriginalFilename();
        //获取文件名
        if (!fileName.equals("教师模板.xls")) {
            throw new BaseException(Error.TEACHER_TEMPLATE_NAME_ERROR);
        }
        List<Teacher> errorList = new ArrayList<>();
        Integer loginAdminId = param.getLoginAdminId();
        try {
            //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            InputStream inputStream = file.getInputStream();
            XSSFWorkbook workbook = null;
            workbook = new XSSFWorkbook(inputStream);
            // 有多少个sheet
            int sheets = workbook.getNumberOfSheets();
            List<Teacher> teacherList = new ArrayList<>();
            for (int i = 0; i < sheets; i++) {
                //HSSFSheet sheet = workbook.getSheetAt(i);
                XSSFSheet sheet = workbook.getSheetAt(i);
                // 获取多少行
                int rows = sheet.getPhysicalNumberOfRows();
                if (rows < 2){
                    throw new BaseException(Error.TEACHER_TEMPLATE_IS_EMPTY);
                }
                // 遍历每一行，注意：第 0 行为标题
                for (int j = 1; j < rows; j++) {
                    // 获得第 j 行
                    //HSSFRow row = sheet.getRow(j);
                    XSSFRow row = sheet.getRow(j);

                    Teacher teacher = this.getTeacherByExcel(loginAdminId,row,j);
                    if (null == teacher){
                        continue;
                    }
                    teacherList.add(teacher);
                }
                teacherMapper.insertList(teacherList);
            }
        }catch (BaseException e){
            throw  e;
        } catch (Exception e) {
            logger.error("批量导入教师信息错误"+ ExceptionUtils.getStackTrace(e));
            throw new BaseException(Error.TEACHER_IMPORT_ERROR);
        }
        return Result.success();
    }

    public Result importStudentData(ImportParam param) {
        MultipartFile file = param.getFile();
        String fileName = file.getOriginalFilename(); //获取文件名
        if (!fileName.equals("学生模板.xls")) {
            throw new BaseException(Error.STUDENT_TEMPLATE_NAME_ERROR);
        }
        List<Student> errorList = new ArrayList<>();
        Integer loginAdminId = param.getLoginAdminId();

        try {
            InputStream inputStream = file.getInputStream();
            XSSFWorkbook workbook = null;
            //int sheetsNumber=book.getNumberOfSheets();

            //XSSFWorkbook workbook = new XSSFWorkbook(request.getInputStream());
            //HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            // 有多少个sheet
            workbook = new XSSFWorkbook(inputStream);
            int sheets = workbook.getNumberOfSheets();

            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < sheets; i++) {
                // HSSFSheet sheet = workbook.getSheetAt(i);
                XSSFSheet sheet = workbook.getSheetAt(i);
                // 获取多少行
                //Sheet sheet = workbook.getSheetAt(0);
                int rows = sheet.getPhysicalNumberOfRows();
                if (rows < 2){
                    throw new BaseException(Error.STUDENT_TEMPLATE_IS_EMPTY);
                }
                // 遍历每一行，注意：第 0 行为标题
                for (int j = 1; j < rows; j++) {
                    // 获得第 j 行
                    //Row row =  sheet.getRow(j);
                    // HSSFRow row = sheet.getRow(j);
                    XSSFRow row = sheet.getRow(j);

                    Student student = getStudentByExcel(errorList, loginAdminId, row, j);
                    if (student == null) continue;
                    studentList.add(student);
                }
            }

            studentMapper.insertList(studentList);
        } catch (BaseException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("批量导学学生信息错误"+ ExceptionUtils.getStackTrace(e));
            throw new BaseException(Error.STUDENT_IMPORT_ERROR);
        }
        return Result.success(errorList);
    }

    private Student getStudentByExcel(List<Student> errorList, Integer loginAdminId, XSSFRow row, int rowIndex) {
        Student student = new Student();
        Date now = new Date();
        //获取学号
        String number = row.getCell(0).toString();
        //获取学生姓名
        String name = row.getCell(1).toString();
        //获取学生入学年份
        String enrollmentYear = row.getCell(2).toString().substring(0, row.getCell(2).toString().lastIndexOf("."));
        //获取学生学院
        String academy = row.getCell(3).toString();
        //获取学生班级
        String clazz = row.getCell(4).toString();
        if (StringUtils.isBlank(number) || StringUtils.isBlank(name) || StringUtils.isBlank(enrollmentYear) || StringUtils.isBlank(academy) || StringUtils.isBlank(clazz)) {
            throw new BaseException(Error.STUDENT_TEMPLATE_HAS_EMPTY_CELL.getErrorCode(), String.format(Error.STUDENT_TEMPLATE_HAS_EMPTY_CELL.getErrorMsg(), rowIndex + 1));
        }
        Student sameNumberStudent = studentMapper.selectByNumber(number);

        student.setNumber(number);
        student.setName(name);

        if (null != sameNumberStudent) {
            throw new BaseException(Error.STUDENT_IMPORT_NUMBER_IS_EXIST.getErrorCode(), String.format(Error.STUDENT_IMPORT_NUMBER_IS_EXIST.getErrorMsg(), number));
        }
        //入学年份判断,学院，班级
        EnrollmentYear enrollmentYearByEnrollmentYear = enrollmentYearMapper.getEnrollmentYearByEnrollmentYear(Integer.parseInt(enrollmentYear));
        Academy academyByName = academyMapper.getAcademyByName(academy);
        Class classByName = classMapper.getClassByName(clazz);
        if (null == enrollmentYear) {
            throw new BaseException(Error.STUDENT_IMPORT_ENROLLMENT_YEAR_IS_NOT_EXIST.getErrorCode(), String.format(Error.STUDENT_IMPORT_ENROLLMENT_YEAR_IS_NOT_EXIST.getErrorMsg(), enrollmentYear));
        } else if (null == academyByName) {
            throw new BaseException(Error.STUDENT_IMPORT_ACADEMY_IS_NOT_EXIST.getErrorCode(), String.format(Error.STUDENT_IMPORT_ACADEMY_IS_NOT_EXIST.getErrorMsg(), academy));
        } else if (null == classByName) {
            throw new BaseException(Error.STUDENT_IMPORT_CLASS_IS_NOT_EXIST.getErrorCode(), String.format(Error.STUDENT_IMPORT_CLASS_IS_NOT_EXIST.getErrorMsg(), clazz));
        } else if (!classByName.getAcademyId().equals(academyByName.getId())) {
            throw new BaseException(Error.STUDENT_IMPORT_CLASS_IS_NOT_BELONG_ACADEMY.getErrorCode(), String.format(Error.STUDENT_IMPORT_CLASS_IS_NOT_BELONG_ACADEMY.getErrorMsg(), clazz, academy));
        }
        student.setEnrollmentId(enrollmentYearByEnrollmentYear.getId());
        student.setAcademyId(academyByName.getId());
        student.setClassId(classByName.getId());
        student.setCreatetime(now);
        student.setCreatorId(loginAdminId);
        //student.setCreatorId(1);
        student.setUpdaterId(0);
        student.setUpdatetime(now);
        student.setIsDelete((byte) 0);
        return student;
    }

    private Teacher getTeacherByExcel(Integer loginAdminId, XSSFRow row, int rowIndex) {
        Teacher teacher = new Teacher();
        Date now = new Date();

        //获取教师编号
        String number = row.getCell(0).toString();
        //获取教师姓名
        String name = row.getCell(1).toString();
        //获取教师学院
        String academy = row.getCell(2).toString();
        if (StringUtils.isBlank(number) || StringUtils.isBlank(name) || StringUtils.isBlank(academy)) {
            throw new BaseException(Error.TEACHER_TEMPLATE_HAS_EMPTY_CELL.getErrorCode(),String.format(Error.STUDENT_TEMPLATE_HAS_EMPTY_CELL.getErrorMsg(), rowIndex + 1));
        }

        teacher.setNumber(number);
        teacher.setName(name);

        Teacher teacherByNumber = teacherMapper.getTeacherByNumber(number);
        if (null != teacherByNumber) {
            throw new BaseException(Error.TEACHER_IMPORT_NUMBER_IS_EXIST.getErrorCode(), String.format(Error.TEACHER_IMPORT_NUMBER_IS_EXIST.getErrorMsg(), number));
        }
        //判断学院是否存在
        Academy academyByName = academyMapper.getAcademyByName(academy);
        if (null == academyByName) {
            throw new BaseException(Error.TEACHER_IMPORT_ACADEMY_IS_NOT_EXIST.getErrorCode(), String.format(Error.TEACHER_IMPORT_ACADEMY_IS_NOT_EXIST.getErrorMsg(), academy));
        }

        teacher.setAcademyId(academyByName.getId());
        teacher.setCreatetime(new Date());
        //teacher.setCreatorId(loginAdminId);
        teacher.setCreatorId(1);
        //teacher.setUpdaterId(loginAdminId);
        teacher.setUpdaterId(0);
        teacher.setUpdatetime(new Date());
        teacher.setIsDelete(Constants.Common.IS_NOT);
        teacher.setPassword(DigestUtils.md5Hex(md5Pre + teacherPasswordDefault));

        return teacher;
    }
}
